package com.qa.sstaiframework.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.pages.Agents_Page;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class Agent_EditTest extends BaseTest {

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
    public void editAgentTest() throws InterruptedException {
        agentsPage.selectCreatedAgent();
        System.out.println("Select Created Agent");

        // Profile
        agentsPage.editProfileDetails(
            prop.getProperty("editAgentName"),
            prop.getProperty("editPurpose"),
            prop.getProperty("editManagedIntents"),
            prop.getProperty("editPersonality"),
            prop.getProperty("editDescription"),
            prop.getProperty("editSpecializedActivities"),
            prop.getProperty("editPreInstruction"),
            prop.getProperty("editMainInstruction"),
            prop.getProperty("editPostInstruction"),
            prop.getProperty("editVaaInstruction")
        );

        agentsPage.clickSaveBtn();
        System.out.println("Profile details edited successfully.");

        // Config
        agentsPage.editConfig(prop.getProperty("editModelName"));
        agentsPage.clickSaveBtn();
        System.out.println("Configuration details edited successfully.");
    }

    
    
}
