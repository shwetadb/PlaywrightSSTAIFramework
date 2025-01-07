package com.qa.sstaiframework.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.constants.AppConstants;
import com.qa.sstaiframework.pages.Agents_Page;
import com.qa.sstaiframework.pages.SubAgent_Create;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class SubAgent_ValidationTest extends BaseTest {
    private Navigate_Modules modulesNavigation;
    private Agents_Page agentsPage;
    private SubAgent_Create createSubAgent;

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
        // Initialize Create Agent
        agentsPage.selectExistingAgent();
        // Initialize CreateSubAgent
        createSubAgent = new SubAgent_Create(page);
        System.out.println("Setup completed for Creating Sub Agent");
    }

    
    
    @Test(priority = 1)
    public void checkProfileValidationTest() {
        createSubAgent.clickNewSubAgentBtn();
        System.out.println("Sub Agent Create Btn clicked");

        createSubAgent.clickProfileNextBtn();

        // Verify all alert messages
        List<String> actualAlertMessages = createSubAgent.getAllAlertMessages();
        Assert.assertTrue(actualAlertMessages.contains(AppConstants.AGENT_NAME_ALERT),
                "Agent Name alert is missing!");
        Assert.assertTrue(actualAlertMessages.contains(AppConstants.PURPOSE_ALERT),
                "Purpose alert is missing!");
        Assert.assertTrue(actualAlertMessages.contains(AppConstants.DESCRIPTION_ALERT),
                "Description alert is missing!");
        Assert.assertTrue(actualAlertMessages.contains(AppConstants.MAIN_INSTRUCTION_ALERT),
                "Main Instruction alert is missing!");
        System.out.println("Profile validation completed successfully.");
    }

    
    
    
    @Test(priority = 2)
    public void checkConfigValidationTest() throws InterruptedException {
        System.out.println("Starting Config Validation Test.");

        createSubAgent.enterProfileDetails(
                prop.getProperty("subAgentName"),
                prop.getProperty("subAgentPurpose"),
                prop.getProperty("subAgentManagedIntents"),
                prop.getProperty("subAgentPersonality"),
                prop.getProperty("subAgentDescription"),
                prop.getProperty("subAgentSpecializedActivities"),
                prop.getProperty("subAgentPreInstruction"),
                prop.getProperty("subAgentMainInstruction"),
                prop.getProperty("subAgentPostInstruction"),
                prop.getProperty("agentInstruction"));

        System.out.println("Profile details entered");
        createSubAgent.clickConfigNextBtn();

        // Verify all config alert messages
        List<String> configAlertMessages = createSubAgent.getConfigAlertMessages();
        Assert.assertTrue(configAlertMessages.contains(AppConstants.AGENT_MODEL_ALERT),
                "Agent Model alert is missing!");
        Assert.assertTrue(configAlertMessages.contains(AppConstants.STOP_SEQUENCE_ALERT),
                "Stop Sequence alert is missing!");

        System.out.println("Config validation completed successfully.");
    }
}
