package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;


public class PageFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    public Page initBrowser(boolean headless, boolean hasContext) {
        String browserName = ConfigurationData.getBrowser();
        System.out.println("Browser is: " + browserName);
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium" -> browser = playwright
                    .chromium()
                    .launch(new BrowserType
                            .LaunchOptions()
                            .setHeadless(headless));
            case "firefox" -> browser = playwright
                    .firefox()
                    .launch(new BrowserType
                            .LaunchOptions()
                            .setHeadless(headless));
            case "safari" -> browser = playwright
                    .webkit()
                    .launch(new BrowserType
                            .LaunchOptions()
                            .setHeadless(headless));
            case "chrome" -> browser = playwright
                    .chromium()
                    .launch(new BrowserType
                            .LaunchOptions()
                            .setChannel("chrome")
                            .setHeadless(headless));
        }

        if(!hasContext) {
            context = browser
                    .newContext(new Browser
                            .NewContextOptions()
                            .setViewportSize(1920, 1080));
            context.cookies().clear();
        } else {
            context = browser
                    .newContext(new Browser
                    .NewContextOptions()
                    .setStorageStatePath(Paths.get("status.json"))
                    .setViewportSize(1920, 1080));
        }

        page = context.newPage();
        playwright.selectors().setTestIdAttribute("data-test");
        return page;
    }
}
