package com.qa.sstaiframework.pages;

import java.util.List;
import java.util.Properties;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class Agents_Page {
    private Page page;
    private Properties prop;

    //1.  Locators
    private String selectAgentDropdown = "//select[contains(@class,'form-select form-select-m')]";
    private String selectedAgentName = "body div h6 span:nth-child(3)";
    //Sub Agent Tab
    private String createSubAgentBtn = "//button[normalize-space()='Create Sub-Agent']";
    private String subAgentNextBtn = "//button[@class='SubAgents_custom_button__MI24n ']";
    private String subAgentTab = "//button[@id='controlled-tab-tab-subAgent']";
    private String createSubAgentHead = "//h4[@class='Agents_heading_custom__Busaw ']";
	private String createdSubAgent = "xpath=//table/tbody/tr[1]/td[1]";
/*
 * Agent
 */
    //Profile Tab
    private String profileBackBtn = "(//button[contains(@fdprocessedid,'hvwjx')])[1]";
    private String profileEditBtn = "(//button[contains(@type,'submit')][normalize-space()='Edit'])[1]";
    private String profileSaveBtn = "(//button[normalize-space()='Save'])[1]";
    private String OKBtn = "(//button[normalize-space()='OK'])[1]";
    private String profileNextBtn = "(//button[@type='button'][normalize-space()='Next'])[2]";
    private String profileTab = "//div[@class='Agents_tabs_wrapper__osUlE ']//button[@id='controlled-tab-tab-agentProfile']";
	private String agentNameField = "//input[@name='agentName']";
	private String purposeField = "//input[@name='agentPurpose']";
	private String manageIntentsField = "//input[@name='agentManagedIntents']";
	private String personalityDropdown = "(//select[contains(@name,'agentPersonality')])[1]";
	private String descriptionField = "//input[@name='agentDescription']";
	private String specializedActivitiesField = "//input[@name='agentSpecializedActivities']";
	private String preInstructionsField = "//textarea[@placeholder='Enter Pre-Instruction']";
	private String mainInstructionField = "//textarea[@name='instructionsToAgent']";
	private String postInstructionField = "//textarea[@placeholder='Enter Post-Instruction']";
	private String VAAInstructionsField = "//textarea[@name='instructionToVaa']";
	private String typeReadRadioBtn = "//input[@id='read']";
	private String typeWriteRadioBtn = "//input[@id='write']";
	private String typeBothRadioBtn = "//input[@id='both']";
    //Config Tab
    private String configBackBtn = "(//button[contains(@type,'button')][normalize-space()='Back'])[2]";
    private String configEditBtn = "(//button[contains(@type,'submit')][normalize-space()='Edit'])[2]";
    private String configSaveBtn = "(//button[contains(@type,'submit')][normalize-space()='Save'])[1]";
    private String configNextBtn = "(//button[contains(@type,'button')][normalize-space()='Next'])[3]";
    private String configTab = "//div[@class='Agents_tabs_wrapper__osUlE ']//button[@id='controlled-tab-tab-agentDetails']";
    private String agentModelSelectDropdown = "(//select[contains(@name,'modelName')])[1]";
    private String testBtn = "//button[normalize-space()='Test']";
	private String okBtn = "//button[contains(@class, 'swal2-confirm') and text()='OK']";
    //Knowledge Base Tab
    private String KBbackBtn = "(//button[contains(@type,'button')][normalize-space()='Back'])[3]";
    private String KBeditBtn = "(//button[contains(@type,'submit')][normalize-space()='Edit'])[3]";
    private String KBSaveBtn = "(//button[contains(@type,'submit')][normalize-space()='Save'])[2]";
    private String KnwBaseTab = "//div[@class='Agents_tabs_wrapper__osUlE ']//button[@id='controlled-tab-tab-agentKnowledge']";
    //Logs Tab
    private String logsTab = "//div[@class='Agents_tabs_wrapper__osUlE ']//button[@id='controlled-tab-tab-logs']";
    //Costing Tab
    private String costingTab = "//div[@class='Agents_tabs_wrapper__osUlE ']//button[@id='controlled-tab-tab-costing']";

/*
 * Sub Agent
 */
    //profile tab
    private String subAgentProfileTab = "(//button[@id='controlled-tab-tab-agentProfile'])[2]";
 // Locator updated to specifically match the "Edit" button within a unique class
     private String subAgentOKBtn = "(//button[normalize-space()='OK'])[1]";
    private String subAgentProfileNextBtn = "(//button[contains(@type,'button')][normalize-space()='Next'])[4]";
   
	private String subAgentAgentToolsDropdown = "//div[@class=' css-1xc3v61-indicatorContainer']";
	private String subAgentTypeReadRadioBtn = "//input[@id='read']";
	private String subAgentTypeWriteRadioBtn = "//input[@id='write']";
	private String subAgentTypeBothRadioBtn = "//input[@id='both1']";
	private String defaultAgentYesRadioBtn = "//input[@id='default-yes']";
	private String defaultAgentNoRadioBtn = "//input[@id='default-no']";
		private String agentInstructionsField = "//textarea[@name='instructionToAgent']";
	
    // Locators
    private String specificEditButton = "(//button[contains(@type,'submit')][normalize-space()='Edit'])[4]";
    private String subAgentNameField = "input[name=\"agentName\"]";
    private String subAgentPurposeField = "input[name=\"agentPurpose\"]";
    private String subAgentManagedIntentsField = "input[name=\"agentManagedIntents\"]";
    private String subAgentDescriptionField = "input[name=\"agentDescription\"]";
    private String subAgentPersonalityDropdown = "input[name=\"agentPersonality\"]";
    private String subAgentSpecializedActivitiesField = "input[name=\"agentSpecializedActivities\"]";
    private String subAgentPreInstructionsField = "//div[@id='subAgentContainer']//textarea[@placeholder='Enter Pre-Instruction']";
    private String subAgentMainInstructionField = "//div[@id='subAgentContainer']//textarea[@name='instructionsToAgent']";
    private String subAgentPostInstructionField = "//div[@id='subAgentContainer']//textarea[@placeholder='Enter Post-Instruction']";
    private String subAgentSaveProfileBtn = "//button[normalize-space()='Save']";

    //Config Tab
    private String subAgentConfigTab = "(//button[@id='controlled-tab-tab-agentDetails'])[2]";
    private String subAgentEditConfigBtn = "(//button[contains(@type,'submit')][normalize-space()='Edit'])[5]";
    private String subAgentSaveConfigBtn = "(//button[contains(@type,'submit')][normalize-space()='Save'])[3]";
    private String subAgentConfigNextBtn = "(//button[contains(@type,'button')][normalize-space()='Next'])[5]";
    private String subAgentCheckInherateVAACheckbox = "//*[@id=\"controlled-tab-tabpane-agentDetails\"]/div/div/div[1]/div[1]/div/input";
	private String subAgentUseDefaultConfigCheckbox = "//*[@id=\"controlled-tab-tabpane-agentDetails\"]/div/div/div[1]/div[2]/div/input";
	private String subAgentModelSelectDropdown = "select[name='modelName']";
	private String subAgentTestBtn = "//button[normalize-space()='Test']";
	private String subAgentOkBtn = "//button[contains(@class, 'swal2-confirm') and text()='OK']";
    //KB Tab
    private String subAgentKnwBaseTab = "(//button[@role='tab'][normalize-space()='Knowledge Base'])[2]";
    private String subAgentEditKnwBaseBtn = "(//button[contains(@fdprocessedid,'jwuvhg')])[1]";
    private String subAgentSaveKnwBaseBtn = "(//button[contains(@fdprocessedid,'jwuvhg')])[1]";
    
    
    

    //2. Constructor
    public Agents_Page(Page page, Properties prop) {
        this.page = page;
        this.prop = prop;
    }

// 3. Methods

    
/*
 * 
 * Agent
 * 
 */
    
    // a) Check if the created agent is displayed
		    public boolean checkCreatedAgent() {
		    // Wait for the dropdown to load
		        page.waitForSelector(selectAgentDropdown, new Page.WaitForSelectorOptions().setTimeout(10000));
		    // Corrected XPath with escaped quotes
		        String optionXPath = "//select[contains(@class,\"form-select form-select-m\")]//option";
		    // Get dropdown options
		        Locator selectAgentOptions = page.locator(optionXPath);
		        System.out.println("Dropdown options count: " + selectAgentOptions.count());
		    // Retrieve and log all dropdown options
		        List<String> agentOptionsList = selectAgentOptions.allInnerTexts();
		        System.out.println("Dropdown options: " + agentOptionsList);
		    // Compare with the expected agent name
		        String agentNameSelect = prop.getProperty("agentName").trim();
		        System.out.println("Expected agent name: " + agentNameSelect);
		
		        if (agentOptionsList.contains(agentNameSelect)) {
		            System.out.println("Agent found: " + agentNameSelect);
		            return true;
		        }
		        System.out.println("Agent not found: " + agentNameSelect);
		        return false;
		    }

	// b) Select the created agent from the dropdown
		    public void selectCreatedAgent() throws InterruptedException {
		    	page.selectOption(selectAgentDropdown, prop.getProperty("agentName"));
		        System.out.println("Selected Agent : " + prop.getProperty("agentName") );
		        page.keyboard().press("Enter");
		        Thread.sleep(5000);
		        
		    }
		    
			// b) Select the created agent from the dropdown
		    public void selectExistingAgent() throws InterruptedException {
		    	page.selectOption(selectAgentDropdown, prop.getProperty("existingAgentName"));
		        System.out.println("Selected Agent : " + prop.getProperty("existingAgentName") );
		        page.keyboard().press("Enter");
		        Thread.sleep(5000);
		        
		    }
	
	// c) Switch between tabs
		    public void switchBtwnAgentTabs() throws InterruptedException {
		    	page.click(profileTab);
		    	System.out.println("Profile Tab");
		    	page.click(configTab);
		    	System.out.println("Configuration Tab");
		    	page.click(KnwBaseTab);
		    	System.out.println("Knowledge Base Tab");
		    	page.click(logsTab);
		    	System.out.println("Logs Tab");
		    	page.click(costingTab);
		    	System.out.println("Costing Tab");
		    	page.click(subAgentTab);
		    	System.out.println("Sub-Agent Tab");
		    	Thread.sleep(5000);

		    }
		    
	
	// d) Next Btn Switch Tabs
		    public void NextBtnSwitchTabs() throws InterruptedException {
		    	page.click(subAgentNextBtn);
		    	System.out.println("Profile Tab");
		    	page.click(profileNextBtn);
		    	System.out.println("Configuration Tab");
		    	page.click(configNextBtn);
		    	System.out.println("Knowledge Base Tab");
		    	Thread.sleep(5000);		    	
		    }
		    
		    
/*
 * 
 * Sub Agent
 * 
 */
		    
	// e) Navigate to Create Sub Agent Screen
		    public String navigateToSubAgentScreen() throws InterruptedException {
		    	page.click(createSubAgentBtn);
		    	page.waitForLoadState();
		    	System.out.println("Navigated → Create Sub Agent Screen");
		    	Thread.sleep(5000);
		    	page.waitForSelector(createSubAgentHead, new Page.WaitForSelectorOptions().setTimeout(10000)); // Wait for visibility
		         return page.innerText(createSubAgentHead); 
		    	
		    }
		    
	
	// f) Create SubAgent heading
		    public Page selectCreatedSubagent() throws InterruptedException {
		    	page.selectOption(selectAgentDropdown, prop.getProperty("agentName"));
		        System.out.println("Selected Agent : " + prop.getProperty("agentName") );
		        page.keyboard().press("Enter");
		        Thread.sleep(5000);
		        page.click(createdSubAgent);		    	
				return page;		      	 
		    }

		    
	// g) Switch between tabs
		    public void switchBtwnSubAgentTabs() throws InterruptedException {
		    	page.click(subAgentConfigTab);
		    	System.out.println("SubAgent Configuration Tab");
		    	page.click(subAgentKnwBaseTab);
		    	System.out.println("SubAgent Knowledge Base Tab");
		    	page.click(subAgentProfileTab);
		    	System.out.println("Sub Agent Profile Tab");
//		    	page.click(logsTab);
//		    	System.out.println("Logs Tab");
//		    	page.click(costingTab);
//		    	System.out.println("Costing Tab");
//		    	page.click(subAgentTab);
//		    	System.out.println("Sub-Agent Tab");
		    	Thread.sleep(5000);

		    }

		    

/*
 * 
 * Edit Agent
 * 
 */
	public void editProfileDetails(String editAgentName, String editPurpose, String editManagedIntents, String editPersonality,  String editDescription,
		    String editSpecializedActivities,  String editPreInstruction,  String editMainInstruction,  String editPostInstruction, String editVaaInstruction) {
		    		page.click(subAgentNextBtn);
		    	    System.out.println("Profile Tab");

		    	    page.click(profileEditBtn);
			    	    try {
			    	        page.waitForLoadState(LoadState.NETWORKIDLE);
			    	        Thread.sleep(5000);
			    	        System.out.println("Clicked → Edit Button");
			    	    } catch (InterruptedException e) {
			    	        e.printStackTrace();
			    	    }

		    	    page.fill(agentNameField, editAgentName);
		    	    page.fill(purposeField, editPurpose);
		    	    page.fill(manageIntentsField, editManagedIntents);

		    	    // Select personality from dropdown
		    	    Locator personalityOptions = page.locator("select[name='agentPersonality']:not([disabled])");
		    	    System.out.println("Dropdown Options Count: " + personalityOptions.count());
		    	    List<String> optionsTextList = personalityOptions.allTextContents();
		    	    optionsTextList.forEach(option -> System.out.println(option));
		    	    personalityOptions.selectOption(editPersonality);
		    	    System.out.println("Selected → Personality");

		    	    page.fill(descriptionField, editDescription);
		    	    page.fill(specializedActivitiesField, editSpecializedActivities);
		    	    page.click(typeBothRadioBtn);
		    	    page.fill(preInstructionsField, editPreInstruction);
		    	    page.fill(mainInstructionField, editMainInstruction);
		    	    page.fill(postInstructionField, editPostInstruction);
		    	    page.fill(VAAInstructionsField, editVaaInstruction);
		    	    System.out.println("Filled → Profile Edit Details");
		    	}

		    
		    
	public Page clickSaveBtn() {
		    	page.click(profileSaveBtn);
			    	try {
			    	    page.waitForLoadState(LoadState.NETWORKIDLE);
			            Thread.sleep(5000); 
			            System.out.println("Clicked → Save Button");
			            page.click(OKBtn);;
			        } catch (InterruptedException e) {
			            e.printStackTrace();
			        }
		        return page;
		    }
		    

	// Config Tab Select the model from dropdown
	public void editConfig(String editModelName) throws InterruptedException {
		        page.click(profileNextBtn);
		        	System.out.println("Config Tab");
		        page.click(configEditBtn);
			        try {
			            page.waitForLoadState(LoadState.NETWORKIDLE);
			            Thread.sleep(5000);
			            System.out.println("Clicked → Edit Button");
			        } catch (InterruptedException e) {
			            e.printStackTrace();
			        }
			        System.out.println("Selecting model: " + editModelName);

		// Agent Model Selection
		        page.locator(agentModelSelectDropdown).selectOption(editModelName);
		        String selectedValue = page.locator(agentModelSelectDropdown).inputValue();
			        if (selectedValue.equals(editModelName)) {
			            System.out.println("Model selected successfully: " + editModelName);
			        } else {
			            System.err.println("Failed to select model: " + editModelName + ". Selected: " + selectedValue);
			        }

		        page.click(testBtn);
		        	System.out.println("Test button Clicked");
		        Thread.sleep(3000);
		        page.click(okBtn);
		        	System.out.println("OK button Clicked");
		    }
	
	//page Reload
	public void pageReload() {
			page.reload();
	}
		    
		    
		    
/*
 * 
 * Edit Sub Agent
 * 
 */
	
	

	
	public void selectEditedAgent() throws InterruptedException {
		page.selectOption(selectAgentDropdown, prop.getProperty("editAgentName"));
        System.out.println("Selected Agent : " + prop.getProperty("editAgentName") );
        page.keyboard().press("Enter");
        Thread.sleep(5000);
	}
	
	public void selectSA() {
//        page.locator(createdSubAgent).click();
        page.click(createdSubAgent);
    		System.out.println("Clicked SA");
	}
	
	
	
	   // Retry mechanism for clicking elements
    public void retryClickEditButton(int maxRetries, int waitTimeMillis) {
        Locator editButton = page.locator(specificEditButton);
        for (int i = 0; i < maxRetries; i++) {
            try {
                if (!editButton.isVisible()) {
                    System.out.println("Scrolling to Edit button...");
                    editButton.scrollIntoViewIfNeeded();
                }
                editButton.click();
                System.out.println("Edit button clicked successfully.");
                return;
            } catch (Exception e) {
                System.err.println("Attempt " + (i + 1) + " failed. Retrying...");
                try {
                    Thread.sleep(waitTimeMillis);
                } catch (InterruptedException ignored) {
                }
            }
        }
        throw new RuntimeException("Edit button not clickable after " + maxRetries + " attempts.");
    }

    // Debugging locator issues
    public void debugLocator(String locator) {
        Locator elements = page.locator(locator);
        List<String> texts = elements.allInnerTexts();
        System.out.println("Matched Elements: " + texts.size());
        for (int i = 0; i < texts.size(); i++) {
            System.out.println("Element " + i + ": " + texts.get(i));
        }
    }
    
    
    
    //edit Profile

    public void editSAProfileDetails(String editSubAgentName, String editSubAgentPurpose, String editSubAgentManagedIntents,
            String editSubAgentPersonality, String editSubAgentDescription,
            String editSubAgentSpecializedActivities, String editSubAgentPreInstruction,
            String editSubAgentMainInstruction, String editSubAgentPostInstruction) {
    	try {
            System.out.println("Clicking Edit button...");
            page.click(profileEditBtn);

            // Wait for the Sub-Agent Name field to become visible
            page.waitForSelector(subAgentNameField, new Page.WaitForSelectorOptions().setTimeout(10000));
            System.out.println("Input fields are visible.");

            // Ensure the fields are enabled before interacting
            if (page.locator(subAgentNameField).isEnabled()) {
                // Fill fields with updated values
                page.fill(subAgentNameField, editSubAgentName);
                System.out.println("Updated Sub-Agent Name: " + editSubAgentName);

                page.fill(subAgentPurposeField, editSubAgentPurpose);
                System.out.println("Updated Sub-Agent Purpose: " + editSubAgentPurpose);

                page.fill(subAgentManagedIntentsField, editSubAgentManagedIntents);
                System.out.println("Updated Managed Intents: " + editSubAgentManagedIntents);

                // Select Personality from dropdown
                Locator personalityDropdownLocator = page.locator(subAgentPersonalityDropdown);
                personalityDropdownLocator.selectOption(editSubAgentPersonality);
                System.out.println("Updated Personality: " + editSubAgentPersonality);

                page.fill(subAgentDescriptionField, editSubAgentDescription);
                System.out.println("Updated Description: " + editSubAgentDescription);

                page.fill(subAgentSpecializedActivitiesField, editSubAgentSpecializedActivities);
                System.out.println("Updated Specialized Activities: " + editSubAgentSpecializedActivities);

                page.fill(subAgentPreInstructionsField, editSubAgentPreInstruction);
                System.out.println("Updated Pre-Instruction: " + editSubAgentPreInstruction);

                page.fill(subAgentMainInstructionField, editSubAgentMainInstruction);
                System.out.println("Updated Main Instruction: " + editSubAgentMainInstruction);

                page.fill(subAgentPostInstructionField, editSubAgentPostInstruction);
                System.out.println("Updated Post-Instruction: " + editSubAgentPostInstruction);

                // Save changes
                page.click(subAgentSaveProfileBtn);
                System.out.println("Clicked Save Button.");

                // Wait for the success confirmation
                page.waitForSelector("//div[contains(text(),'Success')]", new Page.WaitForSelectorOptions().setTimeout(10000));
                System.out.println("Sub-Agent profile details saved successfully.");
            } else {
                System.err.println("Input fields are not enabled for editing.");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while editing Sub-Agent details: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    


    // Edit SubAgent Config
    public void editSAConfig(String editModelName) throws InterruptedException {
        page.locator(subAgentEditConfigBtn).click();
        page.locator(subAgentModelSelectDropdown).selectOption(editModelName);
        String selectedValue = page.locator(subAgentModelSelectDropdown + " option:checked").innerText();
        if (selectedValue.equals(editModelName)) {
            System.out.println("Model selected successfully: " + editModelName);
        } else {
            System.err.println("Failed to select model: " + editModelName);
        }
        page.locator(subAgentTestBtn).click();
        Thread.sleep(3000);
        page.locator(subAgentOKBtn).click();
        System.out.println("SubAgent Config Edited Successfully");
    }
	 
	 
	 
	 
	 

}