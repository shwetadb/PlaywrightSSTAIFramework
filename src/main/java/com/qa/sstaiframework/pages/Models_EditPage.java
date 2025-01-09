package com.qa.sstaiframework.pages;

import java.util.Properties;
import java.util.Scanner;

import com.microsoft.playwright.Page;

public class Models_EditPage {
    private Page page;
    private Properties prop;

    // Locators
    public String editBtn = "(//button[normalize-space()='Edit'])[1]";
    public String saveBtn = "(//button[normalize-space()='Save'])[1]";
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
    
    
    
    // Constructor
    public Models_EditPage(Page page, Properties prop) {
        this.page = page;
        this.prop = prop;
    }
    
    
    // Methods
    public void clickEditBtn() {
    	page.click(editBtn);
    	System.out.println("Clicked Edit Btn");
    }
    
    
    
 /**
     * Edit the model details with user input for URL and API key.
     */
    public void editModelDetails(String stopSequence, String bias, String maximumTokenLength, String temperature, String topP, String frequencyPenalty, 
    		String presencePenalty, String sensitivity, String costLimitPerMonth, String inputTokensBaseCost, String outputTokensBaseCost ) {
    	page.fill(stopSequenceField, stopSequence);
    	page.fill(biasField, bias);
    	page.fill(maxTokenField, maximumTokenLength);
    	page.fill(tempField, temperature);
    	page.fill(topPField, topP);
    	page.fill(freqPenaltyField, frequencyPenalty);
    	page.fill(presPenaltyField, presencePenalty);
    	page.fill(sensitivityField, sensitivity);
    	page.fill(costLimitField, costLimitPerMonth);
//    	page.fill(inputBaseCostField, inputTokensBaseCost);
//    	page.fill(outputBaseCostField, outputTokensBaseCost);
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt the user to enter the URL
            System.out.print("Enter the URL for the selected model: ");
            String url = scanner.nextLine().trim();
            page.fill(urlField, url);
            System.out.println("URL entered successfully.");

//            // Prompt the user to enter the API key
//            System.out.print("Enter the API key for the selected model: ");
//            String apiKey = scanner.nextLine().trim();
//            page.fill(apiKeyField, apiKey);
//            System.out.println("API key entered successfully.");
        }
    }
    
    
    
    
    public void clickSaveBtn() {
    	page.click(saveBtn);
    	System.out.println("Clicled Save Btn");
    	page.click(okBtn);
    	System.out.println("Clicked OK Btn");
    }
    

}
