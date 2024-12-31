package com.qa.sstaiframework.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    Properties prop;
    
    public Page initBrowser(Properties prop) {

    	String browserName = prop.getProperty("browser").trim();
        System.out.println("Browser name is : " + browserName);

        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
//        page.setDefaultTimeout(60000); // Increase timeout globally
	    page.waitForLoadState(LoadState.NETWORKIDLE);
        page.navigate(prop.getProperty("url").trim(), new Page.NavigateOptions().setTimeout(60000));

        return page;
    }
    
    
    
    /**
     * this method is used to initilize the properties fron sonfig file
     */
    public Properties init_prop() {
    	
    	try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return prop;
    	
    }
    
}


