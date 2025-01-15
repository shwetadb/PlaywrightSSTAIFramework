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

//
//package com.qa.sstaiframework.base;
//
//import com.microsoft.playwright.BrowserContext;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Tracing;
//import com.qa.sstaiframework.factory.PlaywrightFactory;
//import com.qa.sstaiframework.pages.LoginProcess;
//
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Properties;
//import java.util.Scanner;
//
//public class BaseTest {
//
//    PlaywrightFactory pf;
//    protected Page page;
//    protected BrowserContext browserContext;
//    protected LoginProcess loginProcess;
//  protected Properties prop;
//
//    private String appUrl;
//    private String username;
//    private String password;
//
//    @BeforeTest
//    public void setUp() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter Application URL: ");
//        appUrl = scanner.nextLine().trim();
//
//        System.out.print("Enter Username: ");
//        username = scanner.nextLine().trim();
//
//        System.out.print("Enter Password: ");
//        password = scanner.nextLine().trim();
//
//        pf = new PlaywrightFactory();
//        prop = pf.init_prop();
//        pf = new PlaywrightFactory();
//        page = pf.initBrowserWithInputs(appUrl);
//        browserContext = page.context();
//        loginProcess = new LoginProcess(page);
//
//        browserContext.tracing().start(new Tracing.StartOptions()
//                .setScreenshots(true)
//                .setSnapshots(true)
//                .setSources(true));
//    }
//
//    @AfterTest
//    public void tearDown() {
//        String traceFolderPath = "D:\\eclipse-workspace\\PlaywrightSSTAIFramework\\src\\main\\resources";
//        String traceFileName = "traceTests.zip";
//        Path tracePath = Paths.get(traceFolderPath, traceFileName);
//
//        try {
//            if (!Files.exists(tracePath.getParent())) {
//                Files.createDirectories(tracePath.getParent());
//            }
//
//            browserContext.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
//            System.out.println("Trace saved to: " + tracePath.toAbsolutePath());
//        } catch (Exception e) {
//            System.err.println("Failed to save trace: " + e.getMessage());
//        }
//
//        if (page != null) {
//            page.context().browser().close();
//        }
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//}
