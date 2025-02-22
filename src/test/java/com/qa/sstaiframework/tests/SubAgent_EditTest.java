package com.qa.sstaiframework.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.pages.Agents_Page;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class SubAgent_EditTest extends BaseTest {

    private Navigate_Modules modulesNavigation;
    private Agents_Page agentsPage;

    @BeforeClass
    public void setUpAgentTest() throws InterruptedException {
        System.out.println("Starting setup for Edit Agents Test...");

        // Perform login
        loginProcess.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

        // Initialize ModulesNavigation and AgentsPage
        modulesNavigation = new Navigate_Modules(page);
        agentsPage = new Agents_Page(page, prop);

        // Navigate to Agents module
        modulesNavigation.clickAgent();
        System.out.println("Setup completed for Edit Sub Agents Test.");
    }
    
    
    @Test(priority = 1)
    public void editSAAgentTest() throws InterruptedException {
//        agentsPage.selectCreatedAgent();
        agentsPage.selectExistingAgent();
        System.out.println("Selected Edited Agent");
        agentsPage.selectSA();
        agentsPage.retryClickEditButton(3, 2000);


        // Profile
        agentsPage.editSAProfileDetails(
            prop.getProperty("editSubAgentName"),
            prop.getProperty("editSubAgentPurpose"),
            prop.getProperty("editSubAgentManagedIntents"),
            prop.getProperty("editSubAgentPersonality"),
            prop.getProperty("editSubAgentDescription"),
            prop.getProperty("editSubAgentSpecializedActivities"),
            prop.getProperty("editSubAgentPreInstruction"),
            prop.getProperty("editSubAgentMainInstruction"),
            prop.getProperty("editSubAgentPostInstruction")
        );
        System.out.println("SA Profile details edited successfully.");

        // Config
        agentsPage.editSAConfig(prop.getProperty("editModelName"));
        System.out.println("SA Configuration details edited successfully.");
    }

    
    
}
