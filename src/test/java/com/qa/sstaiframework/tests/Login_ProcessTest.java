package com.qa.sstaiframework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.sstaiframework.base.BaseTest;
import com.qa.sstaiframework.constants.AppConstants;

public class Login_ProcessTest extends BaseTest {

    @BeforeClass
    public void appLoginSetup() throws InterruptedException {
        loginProcess.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

    @Test(priority = 1)
    public void getLoginPageTitleTest() {
        loginProcess.getLoginPageTitle();
        System.out.println("Expected Title: " + AppConstants.LOGIN_PAGE_TITLE);
        System.out.println("Actual Title: " + loginProcess.getLoginPageTitle());
    }

    @Test(priority = 2)
    public void getchatHeadingTest() throws InterruptedException {
        String chatHeading = loginProcess.getchatHeading();
        System.out.println("Framework Title : " + chatHeading);
        Assert.assertEquals(chatHeading, AppConstants.CHAT_PAGE_TITLE);
    }
}


//package com.qa.sstaiframework.tests;
//
//import com.qa.sstaiframework.base.BaseTest;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class Login_ProcessTest extends BaseTest {
//
//    @BeforeClass
//    public void appLoginSetup() {
//        String username = getUsername();
//        String password = getPassword();
//
//        boolean isLoggedIn = loginProcess.doLogin(username, password);
//        Assert.assertTrue(isLoggedIn, "Login failed!");
//    }
//
//    @Test(priority = 1)
//    public void getLoginPageTitleTest() {
//        String title = loginProcess.getLoginPageTitle();
//        System.out.println("Page Title: " + title);
//        Assert.assertNotNull(title, "Page title is null!");
//    }
//
//    @Test(priority = 2)
//    public void getChatHeadingTest() {
//        String chatHeading = loginProcess.getChatHeading();
//        System.out.println("Chat Heading: " + chatHeading);
//        Assert.assertEquals(chatHeading, "SSTAI FRAMEWORK");
//    }
//}
