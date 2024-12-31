package com.qa.sstaiframework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.constants.AppConstants;
import com.qa.sstaiframework.pages.Agents_Page;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class Agent_CheckAgentsTest extends BaseTest {

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
        System.out.println("Setup completed for Check Agents Test.");
    }

    @Test(priority = 1)
    public void testCheckCreatedAgent() {
        System.out.println("Starting Check Created Agent Test...");

        // Log the expected agent name
        String expectedAgent = prop.getProperty("agentName");
        System.out.println("Expected agent name: " + expectedAgent);

        // Perform the check
        boolean isAgentPresent = agentsPage.checkCreatedAgent();

        // Assert that the agent is found
        Assert.assertTrue(isAgentPresent, "Agent creation failed. Agent not found in dropdown.");
        System.out.println("Check Created Agent Test passed.");
    }

    @Test(priority = 2, dependsOnMethods = "testCheckCreatedAgent")
    public void testSelectCreatedAgent() throws InterruptedException {
          // Select the created agent
        agentsPage.selectCreatedAgent();
        System.out.println("Select Created Agent Test passed.");
    }
    
    
    
    @Test(priority = 3)
    public void navigateToSubAgentScreenTest() throws InterruptedException {
    	agentsPage.navigateToSubAgentScreen();
    	Thread.sleep(5000);
    	
    }
    
//    @Test(priority = 4)
//    public void createSubAgentHeadingTest() {
//        String actualHeading = agentsPage.isCreateSubAgentScreenVisible();
//        Assert.assertEquals(actualHeading, AppConstants.CREATE_NEW_SUB_AGENT_TITLE,
//                "Create Sub Agent screen title mismatch!");
//    }
//    
    
    
}
