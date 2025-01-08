package com.qa.sstaiframework.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.pages.Models_Page;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class Models_PageTest extends BaseTest {

    private Navigate_Modules modulesNavigation;
    private Models_Page modelsPage;

    @BeforeClass
    public void setUpAgentTest() throws InterruptedException {
        System.out.println("Starting setup for Check Agents Test...");

        // Perform login
        loginProcess.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

        // Initialize ModulesNavigation and navigate to Models
        modulesNavigation = new Navigate_Modules(page);
        modulesNavigation.clickModels();

        // Initialize ModelsPage
        modelsPage = new Models_Page(page, prop); // Ensure 'page' and 'prop' are available in the BaseTest
        Thread.sleep(5000);
    }

//    @Test (priority = 1)
//    public void searchModelTest() throws InterruptedException {
//        modelsPage.searchModel();
//        Thread.sleep(8000);
//    }
//    
//    
//    @Test (priority = 2)
//    public void clickCreteModelTest() throws InterruptedException {
//    	modelsPage.clickCreateNewModelBtn();
//        Thread.sleep(8000);
//
//    }
//    
//    
//    @Test (priority = 3)
//    public void goToModelsTest() {
//    	modelsPage.clickGoToModels();
//    }
    
    
    @Test(priority = 4)
    public void selectModelTest() throws Exception {
        modelsPage.selectExistingModel();
        
    }
}
