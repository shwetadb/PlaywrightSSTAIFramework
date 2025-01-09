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
    private String createModelsScreenHeading = "(//h4[normalize-space()='Create New Model'])[1]";
    private String modelsScreenHeading = "(//h4[normalize-space()='Models'])[1]";
    private String editModelsScreenHeading = "(//h4[normalize-space()='Edit Model'])[1]";

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
    
    public String isCreateModelScreenVisible() {
     	 page.waitForSelector(createModelsScreenHeading, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
        return page.innerText(createModelsScreenHeading); 
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

    public String isModelsScreenVisible() {
    	 page.waitForSelector(modelsScreenHeading, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
       return page.innerText(modelsScreenHeading); 
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
        page.waitForLoadState();
        Thread.sleep(10000);
        return page;
    }
    
    
    public String isEditModelsScreenVisible() {
   	 page.waitForSelector(editModelsScreenHeading, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
      return page.innerText(editModelsScreenHeading); 
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
