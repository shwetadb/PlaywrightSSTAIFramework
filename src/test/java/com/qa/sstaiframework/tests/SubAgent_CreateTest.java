package com.qa.sstaiframework.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.pages.Agents_Page;
import com.qa.sstaiframework.pages.SubAgent_Create;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class SubAgent_CreateTest extends BaseTest {

	
    private Navigate_Modules modulesNavigation;
    private Agents_Page agentsPage;
    private SubAgent_Create createSubAgent;


    @BeforeClass
    public void setUpSubAgentTest() throws InterruptedException {
        System.out.println("Starting setup for Check Agents Test...");

        // Perform login
        loginProcess.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        // Initialize ModulesNavigation and AgentsPage
        modulesNavigation = new Navigate_Modules(page);
        agentsPage = new Agents_Page(page, prop);
        // Navigate to Agents module
        modulesNavigation.clickAgent();
        // Select Agent0.
        agentsPage.selectCreatedAgent();
        // Initialize CreateSubAgent
        createSubAgent = new SubAgent_Create(page, prop);
        System.out.println("Setup completed for Creating Sub Agent");
    }
    
    
    
    
    
//    @Test(priority = 1, timeOut = 120000)
//    public void testCreateSubAgent() throws InterruptedException {
//        System.out.println("Starting agent creation process...");
//
//        // Create New Agent
//        createSubAgent.clickNewSubAgentBtn();
//        System.out.println("Sub Agent Create Btn clicked");
//        createSubAgent.enterProfileDetails(
//                prop.getProperty("subAgentName"),
//                prop.getProperty("subAgentPurpose"),
//                prop.getProperty("subAgentManagedIntents"),
//                prop.getProperty("subAgentPersonality"),
//                prop.getProperty("subAgentDescription"),
//                prop.getProperty("subAgentSpecializedActivities"),
//                prop.getProperty("subAgentPreInstruction"),
//                prop.getProperty("subAgentMainInstruction"),
//                prop.getProperty("subAgentPostInstruction"),
//                prop.getProperty("agentInstruction"));
//
//        System.out.println("Profile details entered successfully.");
//
//        // Configure Model
//        createSubAgent.selectConfig(prop.getProperty("modelName"));
//        
//        createSubAgent.clickConfigNextBtn();
//        System.out.println("Configuration completed.");
//
//        // Submit Knowledge Base
//        createSubAgent.clickSubmitBtn();
//        System.out.println("Sub Agent creation submitted.");
//    }
    
    
    @Test(priority = 2, timeOut = 120000)
    public void cloneSubAgentTest() throws InterruptedException {
        createSubAgent.clickNewSubAgentBtn();
        Thread.sleep(10000);
        createSubAgent.cloneSubAgent();
    }

    
    
    
    
    
    
}
