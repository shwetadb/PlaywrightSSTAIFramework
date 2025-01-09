package com.qa.sstaiframework.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class LoginProcess  {
	
	protected Page page;
	
	
	
	//1. String Locators - OR
	public String logintoMicrosoftBtn = "//button[normalize-space()='Log in with Microsoft']";
	private String emailIdField = "//input[@id='i0116']";
	private String nextBtn = "//input[@id='idSIButton9']";
	private String backBtn = "//input[@id='idBtn_Back']";
	private String passwordField = "//input[@id='i0118']";
	private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	private String signInBtn = "//input[@id='idSIButton9']";
	private String yesBtn = "//input[@id='idSIButton9']";
	private String noBtn = "//input[@id='idBtn_Back']";
	private String chatHeading = "//h3[normalize-space()='SSTAI FRAMEWORK']";
	
	
	//2. page constructor:
	public LoginProcess(Page page) {
		this.page = page;
	}

	
	//3. page action/methods:
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public String getHomePageURL() {
		String url = page.url();
		System.out.println("page url : " + url);
		return url;
	}
	
	//valid login
	public boolean doLogin(String appUserName, String appPassword) throws InterruptedException {
	    System.out.println("App credentials : " + appUserName + " → " + appPassword);
	    page.click(logintoMicrosoftBtn);
	    page.waitForSelector(emailIdField);
	    page.fill(emailIdField, appUserName);
	    page.click(nextBtn);
	    page.fill(passwordField, appPassword);
	    page.click(signInBtn);
	    page.click(yesBtn);

	    // Wait for network idle state
	    page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(60000));


	    if (page.isVisible(chatHeading)) {
	        System.out.println("Logged in Successfully........");
	        return true;
	    }
	    return false;
	}

	
	public boolean isLoginSuccessful() {
		// TODO Auto-generated method stub
		return false;
	}


	
    public String getchatHeading() {
        page.waitForSelector(chatHeading, new Page.WaitForSelectorOptions().setTimeout(10000)); // Wait for visibility
        return page.innerText(chatHeading); // Fetch inner text
    }



	

}



//package com.qa.sstaiframework.pages;
//
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.options.LoadState;
//
//public class LoginProcess {
//
//    protected Page page;
//
//    // Locators
//    private String logintoMicrosoftBtn = "//button[normalize-space()='Log in with Microsoft']";
//    private String emailIdField = "//input[@id='i0116']";
//    private String nextBtn = "//input[@id='idSIButton9']";
//    private String passwordField = "//input[@id='i0118']";
//    private String signInBtn = "//input[@id='idSIButton9']";
//    private String yesBtn = "//input[@id='idSIButton9']";
//    private String chatHeading = "//h3[normalize-space()='SSTAI FRAMEWORK']";
//
//    public LoginProcess(Page page) {
//        this.page = page;
//    }
//
//    public void openApp(String appUrl) {
//        System.out.println("Navigating to URL: " + appUrl);
//        page.navigate(appUrl);
//        page.waitForLoadState(LoadState.LOAD);
//    }
//
//    public String getLoginPageTitle() {
//        return page.title();
//    }
//
//    public boolean doLogin(String appUserName, String appPassword) {
//        try {
//            System.out.println("App credentials: " + appUserName + " → " + appPassword);
//            page.click(logintoMicrosoftBtn);
//            page.waitForSelector(emailIdField);
//            page.fill(emailIdField, appUserName);
//            page.click(nextBtn);
//            page.fill(passwordField, appPassword);
//            page.click(signInBtn);
//            page.click(yesBtn);
//
//            page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(60000));
//
//            if (page.isVisible(chatHeading)) {
//                System.out.println("Logged in successfully!");
//                return true;
//            }
//        } catch (Exception e) {
//            System.err.println("Login failed: " + e.getMessage());
//        }
//        return false;
//    }
//
//    public String getChatHeading() {
//        page.waitForSelector(chatHeading, new Page.WaitForSelectorOptions().setTimeout(10000));
//        return page.innerText(chatHeading);
//    }
//}
