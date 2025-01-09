package com.qa.sstaiframework.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.pages.Models_CreatePage;
import com.qa.sstaiframework.pages.Models_Page;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class Models_CreateTest extends BaseTest {

    private Navigate_Modules modulesNavigation;
    private Models_Page modelsPage;
    private Models_CreatePage createModel;

    @BeforeClass
    public void setUpAgentTest() throws InterruptedException {
        System.out.println("Starting setup for Models Creation Test...");

        // Perform login
        loginProcess.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        System.out.println("Logged in Successfully...");

        // Navigate to Models
        modulesNavigation = new Navigate_Modules(page);
        modulesNavigation.clickModels();
        System.out.println("Navigated to Models...");

        // Initialize ModelsPage and navigate to Create Model screen
        modelsPage = new Models_Page(page, prop);
        modelsPage.clickCreateNewModelBtn();
        System.out.println("Navigated to Create Model Screen...");

//         Initialize Models_CreatePage
        createModel = new Models_CreatePage(page, prop);
        System.out.println("Initialized CreateModel Page...");
    }

    @Test(priority = 1)
    public void createModelTest() throws InterruptedException {
        System.out.println("Starting Create Model Test...");
        createModel.createModel(prop.getProperty("createModelName").trim());
        System.out.println("Model Created Successfully...");
        modelsPage.clickGoToModels();
    }

    @Test(priority = 2)
    public void checkCreatedModelTest() {
        System.out.println("Starting Check Created Model Test...");
        createModel.checkCreatedModel();
        System.out.println("Model Checked Successfully...");
    }
}
