//package com.qa.sstaiframework.base;
//
//import java.util.Properties;
//
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import com.microsoft.playwright.Page;
//import com.qa.sstaiframework.factory.PlaywrightFactory;
//import com.qa.sstaiframework.pages.LoginProcess;
//
//public class BaseTest {
//	
//	
//	
//    PlaywrightFactory pf;
//    protected Page page;
//    protected Properties prop;
//
//    protected LoginProcess loginProcess;
//
//    @BeforeTest
//    public void setUp() {
//        pf = new PlaywrightFactory();
//        prop = pf.init_prop();
//        page = pf.initBrowser(prop);  // You can change to 'firefox' or 'chrome' as needed
//        loginProcess = new LoginProcess(page);
//    }
//    
//    @AfterTest
//    public void tearDown() {
//        page.context().browser().close();
//    }
//	
//    
//	
//	
//
//}
//
//
//



package com.qa.sstaiframework.base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.qa.sstaiframework.factory.PlaywrightFactory;
import com.qa.sstaiframework.pages.LoginProcess;

public class BaseTest {

    PlaywrightFactory pf;
    protected Page page;
    protected Properties prop;
    protected BrowserContext browserContext; // Declare browserContext

    protected LoginProcess loginProcess;

    @BeforeTest
    public void setUp() {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop); // You can change to 'firefox' or 'chrome' as needed
        browserContext = page.context(); // Get the browser context from the page
        loginProcess = new LoginProcess(page);

        // Start tracing before creating or navigating a page
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
    }

    @AfterTest
    public void tearDown() {
        // Define the custom folder and file path for tracing
        String traceFolderPath = "D:\\eclipse-workspace\\PlaywrightSSTAIFramework\\src\\main\\resources";
        String traceFileName = "traceTests.zip";
        Path traceDirPath = Paths.get(traceFolderPath);

        try {
            // Create the directory if it doesn't exist
            if (!Files.exists(traceDirPath)) {
                Files.createDirectories(traceDirPath);
                System.out.println("Created directory: " + traceDirPath.toAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Failed to create trace directory: " + e.getMessage());
        }

        // Stop tracing and save it to the custom path
        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get(traceFolderPath, traceFileName)));

        System.out.println("Trace saved to: " + Paths.get(traceFolderPath, traceFileName).toAbsolutePath());

        // Close the browser
        if (page != null) {
            page.context().browser().close();
        }
    }
}

