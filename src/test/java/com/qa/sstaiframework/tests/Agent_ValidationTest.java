package com.qa.sstaiframework.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.constants.AppConstants;
import com.qa.sstaiframework.pages.Agent_Create;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class Agent_ValidationTest extends BaseTest {

    private Navigate_Modules modulesNavigation;
    private Agent_Create createAgent;

    @BeforeClass
    public void setUpAgentValidation() throws InterruptedException {
        System.out.println("Starting setup for Agent Validation Test.");

        // Perform login
        loginProcess.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

        // Initialize ModulesNavigation
        System.out.println("Initializing Modules Navigation.");
        modulesNavigation = new Navigate_Modules(page);

        // Navigate to Agent Module
        System.out.println("Navigating to Agent Module.");
        modulesNavigation.clickAgent();

        // Initialize CreateAgent page
        System.out.println("Initializing CreateAgent Page.");
        createAgent = new Agent_Create(page);

        System.out.println("Setup completed for Agent Validation Test.");
    }


    @Test(priority = 1)
    public void checkProfileValidationTest() {
        // Click "Create New Agent" and Next without entering required fields
        createAgent.clickCreateNewAgentBtn();
        createAgent.clickProfileNextBtn();

        // Verify all alert messages
        List<String> actualAlertMessages = createAgent.getAllAlertMessages();
        Assert.assertTrue(actualAlertMessages.contains(AppConstants.AGENT_NAME_ALERT), 
                "Agent Name alert is missing!");
//        Assert.assertTrue(actualAlertMessages.contains(AppConstants.EXISTING_AGENT_NAME_ALERT), 
//                "Agent Name does not exist");
//        Assert.assertTrue(actualAlertMessages.contains(AppConstants.ASCII_ALERT), 
//                "ASCII alert is missing!");
        Assert.assertTrue(actualAlertMessages.contains(AppConstants.PURPOSE_ALERT), 
                "Purpose alert is missing!");
        Assert.assertTrue(actualAlertMessages.contains(AppConstants.DESCRIPTION_ALERT), 
                "Description alert is missing!");
        Assert.assertTrue(actualAlertMessages.contains(AppConstants.MAIN_INSTRUCTION_ALERT), 
                "Main Instruction alert is missing!");
    }
    
    @Test(priority = 2)
    public void checkConfigValidationTest() throws InterruptedException {
        System.out.println("Starting Config Validation Test.");

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

        System.out.println("Profile details entered");
        createAgent.clickConfigNextBtn();


        // Verify all alert messages
        List<String> configAlertMessages = createAgent.getConfigAlertMessages();
        Assert.assertTrue(configAlertMessages.contains(AppConstants.AGENT_MODEL_ALERT),
                "Agent Model alert is missing!");
        Assert.assertTrue(configAlertMessages.contains(AppConstants.STOP_SEQUENCE_ALERT),
                "Stop Sequence alert is missing!");
        System.out.println("Done");
    }
}


