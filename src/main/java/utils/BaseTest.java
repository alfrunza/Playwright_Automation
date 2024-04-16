package utils;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import pages.HomePage;
import pages.LoginPage;



public class BaseTest {
    PageFactory pf;
    Page page;
    BrowserContext context;
    protected LoginPage loginPage;
    protected HomePage homePage;
    @BeforeSuite
    public void setupBrowserState() throws Exception {
        PageFactory pageFactory = new PageFactory();
        Page headlessPage;
        File file;
        System.out.println("BeforeSuite");
        try {
            file = new File("status.json");
            if(!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("File issue");
        }
        headlessPage = pageFactory.initBrowser(false, false);
        loginPage = new LoginPage(headlessPage);
        loginPage.logIn(ConfigurationData.getUsername(), ConfigurationData.getPassword());
        headlessPage.context().close();
    }

    @BeforeMethod
    public void setupBrowser() {
        pf = new PageFactory();
        String currentTestClass = getClass().getName();
        if(!currentTestClass.equals("LoginPageTest")) {
            page = pf.initBrowser(ConfigurationData.getHeadlessValue(), true);
        } else {
            page = pf.initBrowser(ConfigurationData.getHeadlessValue(), false);
        }
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
    }

    @AfterSuite
    public void tearDown() {
        page.context().browser().close();
    }
}
