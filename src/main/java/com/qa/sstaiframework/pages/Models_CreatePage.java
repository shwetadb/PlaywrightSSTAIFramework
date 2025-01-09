package com.qa.sstaiframework.pages;

import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Models_CreatePage {
    private Page page;
    private Properties prop;

    // Locators
    public String paidRadioBtn = "(//label[normalize-space()='Paid'])[1]";
    public String openSourceRadioBtn = "(//label[normalize-space()='Open Source'])[1]";
    public String modelsDropdown = "(//button[normalize-space()='Select Model'])[1]";
    public String stopSequenceField = "(//input[@placeholder='stopSequence data'])[1]";
    public String biasField = "(//input[@placeholder='bias data'])[1]";
    public String maxTokenField = "(//input[@name='maxTokenLen'])[1]";
    public String tempField = "(//input[@name='temprature'])[1]";
    public String topPField = "(//input[@name='topP'])[1]";
    public String freqPenaltyField = "(//input[@name='frequencyPenalty'])[1]";
    public String presPenaltyField = "(//input[@name='presencePenalty'])[1]";
    public String sensitivityField = "(//input[@name='sensitivity'])[1]";
    public String costLimitField = "(//input[@name='costLimit'])[1]";
    public String inputBaseCostField = "(//input[@name='baseCostInputTokens'])[1]";
    public String outputBaseCostField = "(//input[@name='baseCostOutputTokens'])[1]";
    public String urlField = "(//input[@placeholder='Model URL'])[1]";
    public String apiKeyField = "(//input[@placeholder='API Key'])[1]";
    public String testBtn = "(//button[normalize-space()='Test'])[1]";
    public String okBtn = "(//button[normalize-space()='OK'])[1]";
    public String saveModelBtn = "(//button[normalize-space()='Save Model'])[1]";
//    public String proDeptKeyCheckbox = "(//input[@type='checkbox'])[1]";
//    public String projDeptSwitch = "(//input[@id='project-department-switch-0'])[1]";
//    public String projDeptOptions= "(//button[normalize-space()='Select'])[1]";
//    public String addNewProjBtn = "(//button[normalize-space()='Add New Project'])[1]";
    
    
    
    // Constructor
    public Models_CreatePage(Page page, Properties prop) {
        this.page = page;
        this.prop = prop;
    }
    
    
    // Methods
    public void createModel(String createModelName) throws InterruptedException {
        System.out.println("Selecting model: " + createModelName);

        // Click the dropdown to open it
        page.click(modelsDropdown);

        // Construct the locator for the desired model
        String optionLocator = "//a[@class='dropdown-item' and text()='" + createModelName + "']";

        // Wait for the dropdown options to become visible
        page.waitForSelector(optionLocator, new Page.WaitForSelectorOptions().setTimeout(10000));

        // Click the desired option
        page.click(optionLocator);
        System.out.println("Model selected successfully: " + createModelName);

        // Prompt the user to enter the API key
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the API key for the selected model: ");
        String apiKey = scanner.nextLine().trim();

        // Fill in the API key
        page.fill(apiKeyField, apiKey);
        System.out.println("API key entered successfully.");

        // Continue with the rest of the flow
        page.click(testBtn);
        System.out.println("Test button Clicked");
        Thread.sleep(3000);
        page.click(okBtn);
        System.out.println("OK Test button Clicked");
        page.click(saveModelBtn);
        System.out.println("Save button Clicked");
        page.click(okBtn);
        System.out.println("OK button Clicked");
    }


    public Page checkCreatedModel() {
        try {
            String modelName = prop.getProperty("createModelName").trim();
            if (modelName.isEmpty()) {
                throw new IllegalArgumentException("Model name not provided in properties.");
            }

            String escapedModelName = modelName.replace("\"", "\\\"");
            String rowLocator = "//div[@data-column-id='1' and .//span[text()=\"" + escapedModelName + "\"]]";

            Locator tableBody = page.locator("//div[contains(@class, 'rdt_TableBody')]");
            tableBody.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(120000));

            Locator modelRow = page.locator(rowLocator);
            modelRow.scrollIntoViewIfNeeded();
            modelRow.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(60000));

            System.out.println("Model row found: " + modelRow.innerText());
        } catch (Exception e) {
            System.err.println("Error occurred while checking the model: " + e.getMessage());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("error_model_selection.png")));
            throw e;
        }
        return page;
    }
}