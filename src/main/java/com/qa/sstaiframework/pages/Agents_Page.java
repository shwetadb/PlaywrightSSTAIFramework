package com.qa.sstaiframework.pages;

import java.util.List;
import java.util.Properties;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

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
	private String createdSubAgent = "//tbody";
    //Profile Tab
    private String profileBackBtn = "(//button[contains(@fdprocessedid,'hvwjx')])[1]";
    private String profileEditBtn = "(//button[contains(@fdprocessedid,'jwfwmu')])[1]";
    private String profileNextBtn = "(//button[@type='button'][normalize-space()='Next'])[2]";
    private String profileTab = "//div[@class='Agents_tabs_wrapper__osUlE ']//button[@id='controlled-tab-tab-agentProfile']";
    //Config Tab
    private String configBackBtn = "(//button[contains(@type,'button')][normalize-space()='Back'])[2]";
    private String configEditBtn = "(//button[contains(@type,'submit')][normalize-space()='Edit'])[2]";
    private String configNextBtn = "(//button[contains(@type,'button')][normalize-space()='Next'])[3]";
    private String configTab = "//div[@class='Agents_tabs_wrapper__osUlE ']//button[@id='controlled-tab-tab-agentDetails']";
    //Knowledge Base Tab
    private String KBbackBtn = "(//button[contains(@type,'button')][normalize-space()='Back'])[3]";
    private String KBeditBtn = "(//button[contains(@type,'submit')][normalize-space()='Edit'])[3]";
    private String KnwBaseTab = "//div[@class='Agents_tabs_wrapper__osUlE ']//button[@id='controlled-tab-tab-agentKnowledge']";
    //Logs Tab
    private String logsTab = "//div[@class='Agents_tabs_wrapper__osUlE ']//button[@id='controlled-tab-tab-logs']";
    //Costing Tab
    private String costingTab = "//div[@class='Agents_tabs_wrapper__osUlE ']//button[@id='controlled-tab-tab-costing']";

//Subagent
    //profile tab
    private String subAgentProfileTab = "(//button[@id='controlled-tab-tab-agentProfile'])[2]";
    private String subAgentConfigTab = "(//button[@id='controlled-tab-tab-agentDetails'])[2]";
    private String subAgentKnwBaseTab = "(//button[@role='tab'][normalize-space()='Knowledge Base'])[2]";
    
    
    

    //2. Constructor
    public Agents_Page(Page page, Properties prop) {
        this.page = page;
        this.prop = prop;
    }

    // 3. Methods
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
		    
		    
	// e) Navigate to Create Sub Agent Screen
		    public String navigateToSubAgentScreen() throws InterruptedException {
		    	page.click(createSubAgentBtn);
		    	page.waitForLoadState();
		    	System.out.println("Navigated → Create Sub Agent Screen");
//		    	return page;
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
		    	System.out.println("Configuration Tab");
		    	page.click(subAgentKnwBaseTab);
		    	System.out.println("Knowledge Base Tab");
		    	page.click(subAgentProfileTab);
		    	System.out.println("Profile Tab");
//		    	page.click(logsTab);
//		    	System.out.println("Logs Tab");
//		    	page.click(costingTab);
//		    	System.out.println("Costing Tab");
//		    	page.click(subAgentTab);
//		    	System.out.println("Sub-Agent Tab");
		    	Thread.sleep(5000);

		    }

		    
		    


}