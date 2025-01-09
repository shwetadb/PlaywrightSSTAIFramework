package com.qa.sstaiframework.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.pages.Models_EditPage;
import com.qa.sstaiframework.pages.Models_Page;
import com.qa.sstaiframework.pages.Navigate_Modules;

public class Models_EditTest extends BaseTest {

    private Navigate_Modules modulesNavigation;
    private Models_Page modelsPage;
    private Models_EditPage editModel;

    @BeforeClass
    public void setUpAgentTest() throws Exception {
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
        modelsPage.selectExistingModel();
        System.out.println("Navigated to Edit Model Screen...");

//         Initialize Models_CreatePage
        editModel = new Models_EditPage(page, prop);
        System.out.println("Initialized CreateModel Page...");
    }
    
    @Test (priority = 1)
    public void editModelTest() {
    	editModel.clickEditBtn();
    	editModel.editModelDetails(
    			prop.getProperty("stopSequence"), 
    			prop.getProperty("bias"), 
    			prop.getProperty("maximumTokenLength"), 
    			prop.getProperty("temperature"), 
    			prop.getProperty("topP"), 
    			prop.getProperty("frequencyPenalty"), 
    			prop.getProperty("presencePenalty"), 
    			prop.getProperty("sensitivity"), 
    			prop.getProperty("costLimitPerMonth"), 
    			prop.getProperty("inputTokensBaseCost"), 
    			prop.getProperty("outputTokensBaseCost"));
    	editModel.clickSaveBtn();
    }

}
