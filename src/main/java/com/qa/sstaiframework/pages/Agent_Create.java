package com.qa.sstaiframework.pages;

import java.util.List;
import java.util.Properties;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Agent_Create extends LoginProcess{
	private Properties prop;
	
	
	
    //1.  Locators
	private String CreateNewAgentBtn = "//button[normalize-space()='Create New Agent']";
	private String CreateAgentPageTitle = "//h6[normalize-space()='Create New Agent']";
	
	//Profile
		private String profileTab = "//button[@id='controlled-tab-tab-agentProfile']";
		private String agentNameField = "//input[@name='agentName']";
		private String purposeField = "//input[@name='agentPurpose']";
		private String manageIntentsField = "//input[@name='agentManagedIntents']";
		private String personalityDropdown = "//select[@name='agentPersonality']";
		private String descriptionField = "//input[@name='agentDescription']";
		private String specializedActivitiesField = "//input[@name='agentSpecializedActivities']";
		private String agentToolsDropdown = "//div[@class=' css-1xc3v61-indicatorContainer']";
		private String typeReadRadioBtn = "//input[@id='read']";
		private String typeWriteRadioBtn = "//input[@id='write']";
		private String typeBothRadioBtn = "//input[@id='both']";
		private String defaultAgentYesRadioBtn = "//input[@id='default-yes']";
		private String defaultAgentNoRadioBtn = "//input[@id='default-no']";
		private String preInstructionsField = "//textarea[@placeholder='Enter Pre-Instruction']";
		private String mainInstructionField = "//textarea[@name='instructionsToAgent']";
		private String postInstructionField = "//textarea[@placeholder='Enter Post-Instruction']";
		private String VAAInstructionsField = "//textarea[@name='instructionToVaa']";
		private String profileNextBtn = "//div[@class='AgentProfile_buttonContainerStyle__Qforc']//button[@type='button'][normalize-space()='Next']";
		private String profileCancelBtn = "//div[contains(@class,'AgentProfile_buttonContainerStyle__Qforc')]//button[contains(@type,'button')][normalize-space()='Cancel']";
	//Profile Assertions
		private String agentAlertMsg = "//div[normalize-space()='Agent Name is required.']";
		private String existingAgentNameAlertMsg = "//div[normalize-space()='Agent name already exists.']";
		private String spaceAgentNameAlertMsg = "//div[contains(text(),'Agent names cannot contain spaces. Please enter a ')]";
		private String asciiAlertMsg = "//div[contains(text(),'Agent Description must contain only readable alpha')]";
		private String purposeAlertMsg = "//div[normalize-space()='Agent Purpose is required.']";
		private String descriptionAlertMsg = "//div[normalize-space()='Agent Description is required.']";
		private String mainInstructionAlertMsg = "//div[normalize-space()='Instructions To Main is required.']";
	//Configuration
		private String checkInherateVAACheckbox = "//div[contains(@class,'form-check')]//input[contains(@type,'checkbox')]";
		private String useDefaultConfigCheckbox = "//div[1]//input[2]";
		private String agentModelSelectDropdown = "select[name='modelName']";
		private String stopSequenceField = "//input[@name='stopSequence']";
		private String biasField = "//input[@name='bias']";
		private String maxTokenField = "//input[@type='number']";
		private String tempField = "(//input[@name='temprature'])[1]";
		private String topPField = "input[name='topP'][type='text']";
		private String frequencyPenaltyField = "//label[normalize-space()='Frequency Penalty']";
		private String presensePenaltyField ="(//input[@name='presencePenalty'])[1]";
		private String penaltyField = "(//input[@name='sensitivity'])[1]";
		private String testBtn = "//button[normalize-space()='Test']";
		private String okBtn = "//button[contains(@class, 'swal2-confirm') and text()='OK']";
		private String configNextBtn = "//div[contains(@class,'p-3 NewAgentDetail_fullColumnStyle__3mzo9 col')]//button[contains(@type,'button')][normalize-space()='Next']";
		private String configCancelBtn = "//div[contains(@class,'p-3 NewAgentDetail_fullColumnStyle__3mzo9 col')]//button[contains(@type,'button')][normalize-space()='Cancel']";
		private String configBackBtn = "//div[contains(@class,'p-3 NewAgentDetail_fullColumnStyle__3mzo9 col')]//button[contains(@type,'button')][normalize-space()='Back']";
	//Config Alerts
		private String agentModelAlertMsg = "//span[normalize-space()='Model is required']";
		private String stopSeqAlertMsg = "//span[normalize-space()='Stop Sequence is required']";
	//knowledgebase
		private String uploadDocumentBtn = "//button[normalize-space()='Upload New Document']";
		private String submitBtn = "button[type='submit']";
		private String knwBaseCancelBtn = "//div[@class='AgentProfileKnowledgeBase_buttonContainerStyle__PInry']//button[@type='button'][normalize-space()='Cancel']";
		private String knwBaseBackBtn = "//*[@id=\"controlled-tab-tabpane-agentKnowledge\"]/div/div/div[2]/button[1]";		
	//Agent Screen
		private String selectAgentDropdown = "//select[contains(@class,'form-select form-select-m')]";
		
		
	
	
    //2. Constructor
    public Agent_Create(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}
    
    
   //3. Methods
    //Agent Methods
    public String clickCreateNewAgentBtn() {
        page.click(CreateNewAgentBtn); // Click the "Create New Agent" button
        try {
            Thread.sleep(5000); // Wait for 1 second
            System.out.println("Clicked → Create New Agent");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return page.innerText(CreateAgentPageTitle); 

    }

    
    //a) Profile
	    public void clickProfileNextBtn() {
	    	page.click(profileNextBtn);
	        try {
	            Thread.sleep(5000); 
	            System.out.println("Clicked → Profile Next Button");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void clickProfileCancelBtn() {
	    	page.click(profileCancelBtn);
	        try {
	            Thread.sleep(5000); 
	            System.out.println("Clicked → Profile Next Button");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	
	//Profile Details
	    public void enterProfileDetails(String agentName, String purpose, String managedIntents, String personality, String description, 
	    		String specializedActivities, String preInstruction, String mainInstruction, String postInstruction, String vaaInstruction) {
	    	page.fill(agentNameField, agentName);
	    	page.fill(purposeField, purpose);
	    	page.fill(manageIntentsField, managedIntents);
	    	
	    	//personality dropdown
	    	page.click(personalityDropdown);
	    	Locator personalityOptions = page.locator("select[name=\"agentPersonality\"]");
    		System.out.println(personalityOptions.count());
    		List<String> optionsTextList = personalityOptions.allTextContents();
    		optionsTextList.forEach(ele -> System.out.println(ele));
    		page.locator("select[name=\"agentPersonality\"]").selectOption(personality);
    		System.out.println("Selected → Personality");
    		
    		page.fill(descriptionField, description);
    		page.fill(specializedActivitiesField, specializedActivities);
    		
////    		//agent tools dropdown
//    		page.click(agentToolsDropdown);
//    		System.out.println("Clicked dropdown trigger.");
//            // Wait for the input field to become visible
//            page.waitForSelector("input#react-select-4-input", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
//            // Click on the input field
//            page.locator("input#react-select-4-input").click();
//            System.out.println("Clicked on the input field.");
//            // Wait for options to load
//            page.waitForSelector("div[role='option']", new Page.WaitForSelectorOptions().setTimeout(30000));
//            // Get all options
//            List<String> options = page.locator("div[role='option']").allInnerTexts();
//            options.forEach(option -> System.out.println("Option: " + option));
//            // Select a specific option
//            String targetOption = "PDFExtractor";
//            page.locator("div[role='option']:has-text('" + targetOption + "')").click();
//            System.out.println("Selected: " + targetOption);
//    		
            //type Radio button
            page.click(typeBothRadioBtn);
	    	page.fill(preInstructionsField, preInstruction);
	    	page.fill(mainInstructionField, mainInstruction);
	    	page.fill(postInstructionField, postInstruction);
	    	page.fill(VAAInstructionsField, vaaInstruction);
	    	page.click(profileNextBtn);
	    	System.out.println("Clicked → Profile Next Button");
	    	
	    	
	    }


	 // New method to get the alert message
	    public List<String> getAllAlertMessages() {
	        List<String> alertMessages = page.locator(agentAlertMsg).allInnerTexts(); // Agent Name alert
//	        alertMessages = page.locator(existingAgentNameAlertMsg).allInnerTexts();
//	        alertMessages = page.locator(asciiAlertMsg).allInnerTexts();
	        alertMessages.addAll(page.locator(purposeAlertMsg).allInnerTexts());      // Purpose alert
	        alertMessages.addAll(page.locator(descriptionAlertMsg).allInnerTexts()); // Description alert
	        alertMessages.addAll(page.locator(mainInstructionAlertMsg).allInnerTexts()); // Main Instruction alert
	        return alertMessages;
	    }

    
    //b) Configuration
	    public void clickConfigCancelBtn() {
	    	page.click(configCancelBtn);
	        try {
	            Thread.sleep(5000); 
	            System.out.println("Clicked → Config Next Button");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void clickConfigBackBtn() {
	    	page.click(configBackBtn);
	        try {
	            Thread.sleep(5000); 
	            System.out.println("Clicked → Config Back Button");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // Click "Next" in Configuration
	    public void clickConfigNextBtn() throws InterruptedException {
	        Thread.sleep(3000);
	        page.click(configNextBtn);
	        try {
	            Thread.sleep(5000); 
            System.out.println("Clicked → Config Next Button");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    // Get All Config Alert Messages
	    public List<String> getConfigAlertMessages() {
	        return List.of(
	                page.locator(agentModelAlertMsg).innerText(),
	                page.locator(stopSeqAlertMsg).innerText());
	    }
	    
	    
//	    // Select the model from dropdown
//	    public void selectConfig(String modelName) {
//		    System.out.println("Selecting model: " + modelName);
//		    page.click(agentModelSelectDropdown);
//		    page.locator("//option[text()='" + modelName + "']").click(); // Select the model by name
//		    System.out.println("Model selected: " + modelName);
//	    }
	    
	 // Select the model from dropdown
	    public void selectConfig(String modelName) throws InterruptedException {
			
	        System.out.println("Selecting model: " + modelName);

	        // Use Playwright's selectOption for <select> elements
	        page.locator(agentModelSelectDropdown).selectOption(modelName);

	        // Verify the selected option
	        String selectedValue = page.locator(agentModelSelectDropdown + " option:checked").innerText();
	        if (selectedValue.equals(modelName)) {
	            System.out.println("Model selected successfully: " + modelName);
	        } else {
	            System.err.println("Failed to select model: " + modelName + ". Selected: " + selectedValue);
	        }
	        page.click(testBtn);
	        System.out.println("Test button Clicked");
	        Thread.sleep(3000);
	        page.click(okBtn);
	        System.out.println("OK button Clicked");
	        
	    }

	    
    
    //c) Knowledge Base
	    // Click "Submit" in Knowledgebase
	    public Page clickSubmitBtn() {
	        page.click(submitBtn);
	        try {
	    	    page.waitForLoadState(LoadState.NETWORKIDLE);
	            Thread.sleep(5000); 
	            System.out.println("Clicked → Submit Button");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return page;
	    }
	   
	 //d)check created agent
	    public boolean checkCreatedAgent() {
	    	page.click(selectAgentDropdown);
	    	Locator selectAgentOptions = page.locator(selectAgentDropdown);
    		System.out.println(selectAgentOptions.count());
    		List<String> agentOptionsList = selectAgentOptions.allTextContents();
    		agentOptionsList.forEach(ele -> System.out.println(ele));
    		if(agentOptionsList.contains(prop.getProperty("agentName"))) {
    			System.out.println("Agent Created........");
    			return true;
    		}
    		return false;
	    	
	    }
    

}
