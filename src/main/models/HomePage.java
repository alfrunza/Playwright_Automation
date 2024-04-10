package models;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;
    private final Locator demoQaLogo;
    private final Locator joinNowButton;
    private final Locator elementsButton;
    private final Locator formsButton;
    private final Locator alertsButton;
    private final Locator widgetsButton;
    private final Locator interactionsButton;
    private final Locator bookStoreButton;

    public HomePage(Page page) {
        this.page = page;
        this.demoQaLogo = page.locator("//div[@id='app']/header//img");
        this.joinNowButton = page.getByAltText("Selenium Online Training");
        this.elementsButton = page.getByText("Elements");
        this.formsButton = page.getByText("Forms");
        this.alertsButton = page.getByText("Alerts, Frame & Windows");
        this.widgetsButton = page.getByText("Widgets");
        this.interactionsButton = page.getByText("Interactions");
        this.bookStoreButton = page.getByText("Book Store Application");
    }

    public Locator getDemoQaLogo() {
        return demoQaLogo;
    }

    public Locator getJoinNowButton() {
        return joinNowButton;
    }

    public Locator getElementsButton() {
        return elementsButton;
    }

    public Locator getFormsButton() {
        return formsButton;
    }

    public Locator getAlertsButton() {
        return alertsButton;
    }

    public Locator getWidgetsButton() {
        return widgetsButton;
    }

    public Locator getInteractionsButton() {
        return interactionsButton;
    }

    public Locator getBookStoreButton() {
        return bookStoreButton;
    }
    public void navigate() {
        page.navigate("https://demoqa.com/");
    }

    public void click(Locator locator) {
        locator.click();
    }


}
