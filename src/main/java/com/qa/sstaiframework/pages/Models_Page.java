package com.qa.sstaiframework.pages;

import java.nio.file.Paths;
import java.util.Properties;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Models_Page {
    private Page page;
    private Properties prop;

    // Locators
    private String searchModelField = "//input[@placeholder='Search model']";
    private String createNewModelBtn = "//button[normalize-space()='Create New Model']";
    private String confirmYesBtn = "//button[normalize-space()='Yes']";
    private String goToModelsBtn = "//button[normalize-space()='Go to Models']";
    private String OKBtn = "//button[normalize-space()='OK']";
    private String testBtn = "//button[normalize-space()='Test']";
    private String yesBtn = "//button[normalize-space()='Yes']";
    private String noBtn = "(//button[@class='swal2-cancel swal2-styled'])[1]";

    // Constructor
    public Models_Page(Page page, Properties prop) {
        this.page = page;
        this.prop = prop;
    }

    // Methods
    public void searchModel() {
        try {
            String modelName = prop.getProperty("modelName");
            if (modelName != null && !modelName.isEmpty()) {
                page.fill(searchModelField, modelName);
                System.out.println("Searched for model: " + modelName);
            } else {
                System.err.println("Model name not provided in properties.");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while searching for the model: " + e.getMessage());
        }
    }

    public void clickCreateNewModelBtn() {
        try {
            page.click(createNewModelBtn);
            page.click(confirmYesBtn);
            page.waitForLoadState(); // Wait for network idle state
            System.out.println("Navigated → Create Model Screen");
        } catch (Exception e) {
            System.err.println("Error occurred while navigating to Create Model Screen: " + e.getMessage());
        }
    }

    public void clickGoToModels() {
        try {
            page.click(goToModelsBtn);
            page.click(confirmYesBtn);
            System.out.println("Navigated to Models Page");
        } catch (Exception e) {
            System.err.println("Error occurred while going back to the Models page: " + e.getMessage());
        }
    }

    
    


    public Page selectExistingModel() throws Exception {
        try {
            String modelName = prop.getProperty("modelName");
            if (modelName == null || modelName.isEmpty()) {
                throw new IllegalArgumentException("Model name not provided in properties.");
            }

            // Escape single quotes in modelName for XPath
            String escapedModelName = modelName.replace("'", "\\'");

            // Corrected and escaped XPath
            String rowLocator = "//div[@data-column-id='1' and .//span[text()=\"" + escapedModelName + "\"]]";

            System.out.println("Waiting for table to load...");
            page.waitForSelector("//div[contains(@class, 'rdt_TableBody')]", 
                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(120000));

            Locator modelRow = page.locator(rowLocator);

            if (!modelRow.isVisible()) {
                System.out.println("Row not visible. Scrolling into view...");
                modelRow.scrollIntoViewIfNeeded(new Locator.ScrollIntoViewIfNeededOptions().setTimeout(60000));
            }

            System.out.println("Waiting for row visibility...");
            modelRow.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(60000));
            
            modelRow.click();
            System.out.println("Successfully clicked the model: " + modelName);
        } catch (Exception e) {
            System.err.println("Error occurred while selecting the model: " + e.getMessage());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("error_model_selection.png")));
            throw e;
        }
        
        page.click(yesBtn);
        return page;
    }









    

    public void clickTestBtn(String modelName) {
        try {
            Locator modelRow = page.locator("//div[@class='sc-kOHUsU dTGFaE rdt_TableBody']//div[text()='" + modelName + "']/following-sibling::div//button[normalize-space()='Test']");
            if (modelRow.isVisible()) {
                modelRow.click();
                System.out.println("Clicked Test button for model: " + modelName);
                page.click(OKBtn);
                System.out.println("Clicked OK button after test.");
            } else {
                System.err.println("Test button not found for model: " + modelName);
            }
        } catch (Exception e) {
            System.err.println("Error occurred while clicking Test button: " + e.getMessage());
        }
    }
}
