package com.qa.sstaiframework.pages;

import java.util.List;
import java.util.Properties;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

public class SubAgent_Create {
	private Page page;
	public Properties prop;
	
	
	
	//1. Locators
		    private String createSubAgentBtn = "//button[normalize-space()='Create Sub-Agent']";
		    private String cloneSubAgentRadioBtn = "//input[@value='clone']";
		    private String subAgentDropdown = "(//select[@class='Agents_custom_select__CiLmN '])";
		    private String cloneProfileNextBtn = "(//button[@type='button'][normalize-space()='Next'])[1]";
		    private String cloneConfigNextBtn = "(//button[@type='button'][normalize-space()='Next'])[2]";
		    private String cloneSubmitBtn = "(//button[normalize-space()='Submit'])[1]";
		    private String cloneOKBtn = "(//button[normalize-space()='OK'])[1]";
		    private String createNewSubAgentRadioBtn = "//input[@value='create']";
    //Profile Tab
		    private String profileTab = "//button[@id='controlled-tab-tab-agentProfile']";
			private String subAgentNameField = "//input[@name='agentName']";
			private String purposeField = "//input[@name='agentPurpose']";
			private String manageIntentsField = "//input[@name='agentManagedIntents']";
			private String personalityDropdown = "//select[@name='agentPersonality']";
			private String descriptionField = "//input[@name='agentDescription']";
			private String specializedActivitiesField = "//input[@name='agentSpecializedActivities']";
			private String agentToolsDropdown = "//div[@class=' css-1xc3v61-indicatorContainer']";
			private String typeReadRadioBtn = "//input[@id='read']";
			private String typeWriteRadioBtn = "//input[@id='write']";
			private String typeBothRadioBtn = "//input[@id='both1']";
			private String defaultAgentYesRadioBtn = "//input[@id='default-yes']";
			private String defaultAgentNoRadioBtn = "//input[@id='default-no']";
			private String preInstructionsField = "//textarea[@placeholder='Enter Pre-Instruction']";
			private String mainInstructionField = "//textarea[@name='instructionsToAgent']";
			private String postInstructionField = "//textarea[@placeholder='Enter Post-Instruction']";
			private String agentInstructionsField = "//textarea[@name='instructionToAgent']";
			private String profileNextBtn = "//div[@class='AgentProfile_buttonContainerStyle__Qforc']//button[@type='button'][normalize-space()='Next']";
			private String profileCancelBtn = "//div[@class='AgentProfile_buttonContainerStyle__Qforc']//button[@type='button'][normalize-space()='Cancel']";
	//Profile Assertions
			private String agentAlertMsg = "//div[normalize-space()='Agent Name is required.']";
			private String existingAgentNameAlertMsg = "//div[normalize-space()='Agent name already exists.']";
			private String spaceAgentNameAlertMsg = "//div[contains(text(),'Agent names cannot contain spaces. Please enter a ')]";
			private String asciiAlertMsg = "//div[contains(text(),'Agent Description must contain only readable alpha')]";
			private String purposeAlertMsg = "//div[normalize-space()='Agent Purpose is required.']";
			private String descriptionAlertMsg = "//div[normalize-space()='Agent Description is required.']";
			private String mainInstructionAlertMsg = "//div[normalize-space()='Instructions To Main is required.']";
	//Configuration
			private String checkInherateVAACheckbox = "//*[@id=\"controlled-tab-tabpane-agentDetails\"]/div/div/div[1]/div[1]/div/input";
			private String useDefaultConfigCheckbox = "//*[@id=\"controlled-tab-tabpane-agentDetails\"]/div/div/div[1]/div[2]/div/input";
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
			private String configNextBtn = "//div[@class='p-3 NewAgentDetail_fullColumnStyle__3mzo9 col']//button[@type='button'][normalize-space()='Next']";
			private String configCancelBtn = "//div[@class='p-3 NewAgentDetail_fullColumnStyle__3mzo9 col']//button[@type='button'][normalize-space()='Cancel']";
			private String configBackBtn = "//div[@class='p-3 NewAgentDetail_fullColumnStyle__3mzo9 col']//button[@type='button'][normalize-space()='Back']";
	//Config Alerts
			private String agentModelAlertMsg = "//span[normalize-space()='Model is required']";
			private String stopSeqAlertMsg = "//span[normalize-space()='Stop Sequence is required']";
	//knowledgebase
			private String uploadDocumentBtn = "//button[normalize-space()='Upload New Document']";
			private String submitBtn = "//button[@type='submit']";
			private String knwBaseCancelBtn = "//div[contains(@class,'AgentProfileKnowledgeBase_buttonContainerStyle__PInry')]//button[contains(@type,'button')][normalize-space()='Cancel']";
			private String knwBaseBackBtn = "//div[contains(@class,'AgentProfileKnowledgeBase_buttonContainerStyle__PInry')]//button[contains(@type,'button')][normalize-space()='Back']";		
	//Agent Screen
			private String selectAgentDropdown = "//select[contains(@class,'form-select form-select-m')]";
   


	
    
    //2. Constructor
    public SubAgent_Create(Page page, Properties prop) {
        this.page = page;
        this.prop = prop;
            }

    // 3. Methods
    // a) Click on Create New Sub Agent Button
    public Page clickNewSubAgentBtn() {
    	page.click(createSubAgentBtn);
    	return page;
    }
    
    
    // b) Profile
    public void clickProfileNextBtn() {
    	page.click(profileNextBtn);
        try {
            Thread.sleep(5000); 
            System.out.println("Clicked → Sub Agent Profile Next Button");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void clickProfileCancelBtn() {
    	page.click(profileCancelBtn);
        try {
            Thread.sleep(5000); 
            System.out.println("Clicked →Sub Agent  Profile Next Button");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//Profile Details
    public void enterProfileDetails(String subAgentName, String subAgentPurpose, String subAgentManagedIntents, String subAgentPersonality, String subAgentDescription, 
    		String subAgentSpecializedActivities, String subAgentPreInstruction, String subAgentMainInstruction, String subAgentPostInstruction, String agentInstruction) {
    	page.fill(subAgentNameField, subAgentName);
    	page.fill(purposeField, subAgentPurpose);
    	page.fill(manageIntentsField, subAgentManagedIntents);
    	
    	//personality dropdown
    	page.click(personalityDropdown);
    	Locator personalityOptions = page.locator("select[name=\"agentPersonality\"]");
		System.out.println(personalityOptions.count());
		List<String> optionsTextList = personalityOptions.allTextContents();
		optionsTextList.forEach(ele -> System.out.println(ele));
		page.locator("select[name=\"agentPersonality\"]").selectOption(subAgentPersonality);
		System.out.println("Selected → Personality");
		
		page.fill(descriptionField, subAgentDescription);
		page.fill(specializedActivitiesField, subAgentSpecializedActivities);
		

//		
        //type Radio button
        page.click(typeBothRadioBtn);
    	page.fill(preInstructionsField, subAgentPreInstruction);
    	page.fill(mainInstructionField, subAgentMainInstruction);
    	page.fill(postInstructionField, subAgentPostInstruction);
    	page.fill(agentInstructionsField, agentInstruction);
    	page.click(profileNextBtn);
    	System.out.println("Clicked → Profile Next Button");
    	
    	
    }


 // New method to get the alert message
    public List<String> getAllAlertMessages() {
        List<String> alertMessages = page.locator(agentAlertMsg).allInnerTexts(); // Agent Name alert
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
   
// //d)check created agent
//    public boolean checkCreatedAgent() {
//    	page.click(selectAgentDropdown);
//    	Locator selectAgentOptions = page.locator(selectAgentDropdown);
//		System.out.println(selectAgentOptions.count());
//		List<String> agentOptionsList = selectAgentOptions.allTextContents();
//		agentOptionsList.forEach(ele -> System.out.println(ele));
//		if(agentOptionsList.contains(prop.getProperty("agentName"))) {
//			System.out.println("Agent Created........");
//			return true;
//		}
//		return false;
//    	
//    }


    
/*
 * clone Sub Agent
 *   
 */
    
    public void cloneSubAgent() throws InterruptedException {
        try {
            // Fetch subAgentName from config.properties
            String subAgentName = prop.getProperty("cloneSubAgentName").trim();

            // Validate subAgentName
            if (subAgentName == null || subAgentName.isEmpty()) {
                throw new IllegalArgumentException("Sub-agent name is not specified in config.properties.");
            }

            // Click the "Clone Sub-Agent" radio button
            page.click(cloneSubAgentRadioBtn);
            System.out.println("Clicked clone radio button");

            // Wait for the dropdown to become visible
            Locator dropdown = page.locator(subAgentDropdown);
            dropdown.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            System.out.println("Dropdown is visible.");

            // Fetch all options from the dropdown
            List<String> optionsText = dropdown.locator("option").allTextContents();
            System.out.println("Available dropdown options: " + optionsText);

            // Check if the desired sub-agent exists
            if (!optionsText.contains(subAgentName)) {
                throw new IllegalArgumentException(
                    "Sub-agent '" + subAgentName + "' not found in the dropdown. Available options: " + optionsText
                );
            }

            // Select the desired sub-agent
            dropdown.selectOption(new SelectOption().setLabel(subAgentName));
            System.out.println("Successfully selected sub-agent: " + subAgentName);

            // Navigate through the cloning process
            page.click(cloneProfileNextBtn);
            System.out.println("Clicked 'Next' on Profile step");

            page.click(cloneConfigNextBtn);
            System.out.println("Clicked 'Next' on Configuration step");

            page.click(cloneSubmitBtn);
            System.out.println("Clicked 'Submit' on Cloning step");

            page.click(cloneOKBtn);
            System.out.println("Cloned sub-agent successfully.");
        } catch (TimeoutError e) {
            System.err.println("Timeout occurred: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            throw e;
        }
    }




    	



}
    
    
    

