package utils;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Selectors;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    PageFactory pf;
    Page page;
    BrowserContext context;
    protected LoginPage loginPage;
    @BeforeSuite
    public void setupBrowser() throws Exception {
        PageFactory pageFactory = new PageFactory();
        Page headlessPage;
        File file;
        System.out.println("BeforeSuite");
        try {
            file = new File("/src/main/resources/status.json");
            if(!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("File issue");
        }
        headlessPage = pageFactory.initBrowser(false, false);
    }

    @BeforeMethod

    @AfterSuite
}
