package com.qa.sstaiframework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.pages.Agent_Create;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class Agent_CreateTest extends BaseTest {

    private Navigate_Modules modulesNavigation;
    private Agent_Create createAgent;

    @BeforeClass
    public void setUpAgentCreation() throws InterruptedException {
        System.out.println("Starting setup for Agent Creation Test.");

        try {
            System.out.println("Logging in...");
            loginProcess.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
//            loginProcess.doLogin(getUsername(), getPassword());
            System.out.println("Login successful.");

            System.out.println("Initializing Modules Navigation.");
            modulesNavigation = new Navigate_Modules(page);

            System.out.println("Navigating to Agent Module.");
            modulesNavigation.clickAgent();

            System.out.println("Initializing CreateAgent Page.");
            createAgent = new Agent_Create(page);

            System.out.println("Setup completed for Create New Agent Test.");
        } catch (Exception e) {
            System.err.println("Setup failed: " + e.getMessage());
            throw e;
        }
    }


    @Test(priority = 1, timeOut = 120000)
    public void testCreateAgent() throws InterruptedException {
        System.out.println("Starting agent creation process...");

        // Create New Agent
        createAgent.clickCreateNewAgentBtn();
        createAgent.enterProfileDetails(
                prop.getProperty("agentName"),
                prop.getProperty("purpose"),
                prop.getProperty("managedIntents"),
                prop.getProperty("personality"),
                prop.getProperty("description"),
                prop.getProperty("specializedActivities"),
                prop.getProperty("preInstruction"),
                prop.getProperty("mainInstruction"),
                prop.getProperty("postInstruction"),
                prop.getProperty("vaaInstruction"));

        System.out.println("Profile details entered successfully.");

        // Configure Model
        createAgent.selectConfig(prop.getProperty("modelName"));
        
        createAgent.clickConfigNextBtn();
        System.out.println("Configuration completed.");

        // Submit Knowledge Base
        createAgent.clickSubmitBtn();
        System.out.println("Agent creation submitted.");

        // Verify Agent Creation
        Assert.assertTrue(createAgent.checkCreatedAgent(), "Agent creation failed. Agent not found in the dropdown.");
        System.out.println("Agent creation test completed successfully.");
    }
}
