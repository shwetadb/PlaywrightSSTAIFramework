package com.qa.sstaiframework.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.pages.Agents_Page;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class Navigate_AgentTabsTest extends BaseTest {
	
    private Navigate_Modules modulesNavigation;
    private Agents_Page agentsPage;

    @BeforeClass
    public void setUpAgentTest() throws InterruptedException {
        System.out.println("Starting setup for Check Agents Test...");

        // Perform login
        loginProcess.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

        // Initialize ModulesNavigation and AgentsPage
        modulesNavigation = new Navigate_Modules(page);
        agentsPage = new Agents_Page(page, prop);

        // Navigate to Agents module
        modulesNavigation.clickAgent();
        
        // Select Agent
//        agentsPage.selectCreatedAgent();
        agentsPage.selectExistingAgent();
        System.out.println("clicked create subagent");
        System.out.println("Setup completed for Navigate Between Agents Tabs.");
    }
    
    
    @Test(priority = 1)
    public void switchBtwnSubAgentTabs() throws InterruptedException {
    	agentsPage.switchBtwnSubAgentTabs();
    	System.out.println("Completed → switchBtwnSubAgentTabs");
    	
    }
    
    
//    @Test(priority = 2)
//    public void NextBtnSwitchTabsTest() throws InterruptedException {
//    	agentsPage.NextBtnSwitchTabs();
//    	System.out.println("Completed → NextBtnSwitchTabsTest");
//    }
    
    
    

}
