

import models.HomePage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestExample {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    HomePage homePage;

    @BeforeClass
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterClass
    void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod
    void createBrowserContext() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterMethod
    void closeContext() {
        context.close();
    }

    @Test
    void verifyLogoIsVisible() {
        homePage = new HomePage(page);
        homePage.navigate();
        System.out.println("Test has been run");
        assertThat(homePage.getDemoQaLogo()).isVisible();
    }

//    @Test
//    void verifyLinks() {
//        homePage = new HomePage(page);
//        homePage.navigate();
//
//    }
}
