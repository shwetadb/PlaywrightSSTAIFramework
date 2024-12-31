package com.qa.sstaiframework.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.sstaiframework.factory.PlaywrightFactory;
import com.qa.sstaiframework.pages.LoginProcess;

public class BaseTest {
	
	
	
    PlaywrightFactory pf;
    protected Page page;
    protected Properties prop;

    protected LoginProcess loginProcess;

    @BeforeTest
    public void setUp() {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);  // You can change to 'firefox' or 'chrome' as needed
        loginProcess = new LoginProcess(page);
    }
    
    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
	
    
	
	

}



