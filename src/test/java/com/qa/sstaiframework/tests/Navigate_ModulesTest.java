package com.qa.sstaiframework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.constants.AppConstants;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class Navigate_ModulesTest extends BaseTest {

    private Navigate_Modules modulesNavigation;

    @BeforeClass
    public void setUpModulesNavigation() throws InterruptedException {
        // Perform login
        loginProcess.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        // Ensure login is successful
//        Assert.assertTrue(loginProcess.isLoginSuccessful(), "Login failed! Cannot proceed to module navigation setup.");
        // Initialize ModulesNavigation
        modulesNavigation = new Navigate_Modules(page);
    }

    @Test(priority = 1)
    public void createNewProjectTest() {
        modulesNavigation.clickCreateNewProject();
        String createNewProjectHeading = modulesNavigation.isCreateNewProjectVisible();
        System.out.println("Title : " + createNewProjectHeading);
        Assert.assertEquals(createNewProjectHeading,  AppConstants.CREATE_NEW_PROJECT_PAGE_TITLE,
                "Page title mismatch for Create New Project!");
    }

    @Test(priority = 2)
    public void agentScreenNavigationTest() {
        modulesNavigation.clickAgent();
        String agentScreenHeading = modulesNavigation.isAgentScreenVisible();
        System.out.println("Title : " + agentScreenHeading);
        Assert.assertEquals(agentScreenHeading, AppConstants.AGENT_SCREEN_TITLE,
                "Page title mismatch for Agent screen!");
    }

    @Test(priority = 3)
    public void modelsScreenNavigationTest() {
        modulesNavigation.clickModels();
        String modelScreenHeading = modulesNavigation.isModelsScreenVisible();
        System.out.println("Title : " + modelScreenHeading);
        Assert.assertEquals(modelScreenHeading, AppConstants.MODELS_SCREEN_TITLE,
                "Page title mismatch for Models screen!");
    }

    @Test(priority = 4)
    public void costingScreenNavigationTest() {
        modulesNavigation.clickCosting();
        String costingScreenHeading = modulesNavigation.isCostingScreenVisible();
        System.out.println("Title : " + costingScreenHeading);
        Assert.assertEquals(costingScreenHeading, AppConstants.COSTING_SCREEN_TITLE,
                "Page title mismatch for Costing screen!");
    }

    @Test(priority = 5)
    public void policyScreenNavigationTest() {
        modulesNavigation.clickPolicy();
        String policyScreenHeading = modulesNavigation.isPolicyScreenVisible();
        System.out.println("Title : " + policyScreenHeading);
        Assert.assertEquals(policyScreenHeading, AppConstants.POLICY_SCREEN_TITLE,
                "Page title mismatch for Policy screen!");
    }

    @Test(priority = 6)
    public void containerServicesScreenNavigationTest() {
        modulesNavigation.clickContainerServices();
        String containerServiceScreenHeading = modulesNavigation.isContainerServicesScreenVisible();
        System.out.println("Title : " + containerServiceScreenHeading);
        Assert.assertEquals(containerServiceScreenHeading, AppConstants.CONTAINER_SERVICE_SCREEN_TITLE,
                "Page title mismatch for Container Services screen!");
    }

    @Test(priority = 7)
    public void trainAgentsScreenNavigationTest() {
        modulesNavigation.clickTrainAgents();
        String trainAgentScreenHeading = modulesNavigation.isTrainAgentsScreenVisible();
        System.out.println("Title : " + trainAgentScreenHeading);
        Assert.assertEquals(trainAgentScreenHeading, AppConstants.TRAIN_AGENT_SCREEN_TITLE,
                "Page title mismatch for Train Agents screen!");
    }

    @Test(priority = 8)
    public void chatScreenNavigationTest() {
        modulesNavigation.clickChat();
        String chatScreenHeading = modulesNavigation.isChatScreenVisible();
        System.out.println("Title : " + chatScreenHeading);
        Assert.assertEquals(chatScreenHeading, AppConstants.CHAT_SCREEN_TITLE,
                "Page title mismatch for Chat screen!");
    }

    @Test(priority = 9)
    public void logoutTest() {
        System.out.println("Clicking Logout button...");
        modulesNavigation.clickLogout();
             
        System.out.println("Clicking account to confirm logout...");
        modulesNavigation.clickAccount();
        
        System.out.println("Logout was successful!");
    }


}
