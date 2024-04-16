package pages;

import java.nio.file.Paths;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.ConfigurationData;

public class LoginPage {
    private final Page page;
    private final Locator usernameField;
    private final Locator passwordField;
    private final Locator loginButton;
    private final Locator error;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameField = page.getByTestId("username");
        this.passwordField = page.getByTestId("password");
        this.loginButton = page.getByTestId("login-button");
        this.error = page.getByTestId("error");
    }

    public void navigateToPage() {
        page.navigate(ConfigurationData.getBaseUrl());
    }

    public void fillUsername(String username) {
        usernameField.click();
        usernameField.clear();
        usernameField.fill(username);
    }

    public void fillPassword(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.fill(password);
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(page);
    }

    public void saveStorage() {
        try {
            page
                    .context()
                    .storageState(new BrowserContext
                            .StorageStateOptions()
                            .setPath(Paths.get("/src/main/resources/status.json")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void logIn(String username, String password) {
        navigateToPage();
        fillUsername(username);
        fillPassword(password);
        HomePage homePage = clickLoginButton();
        homePage.waitForHeader(30*1000);
    }

    public boolean verifyErrorMessage() {
        return getErrorMessage().contains(ConfigurationData.getErrorMessageInvalid());
    }

    public Locator getError() {
        error.waitFor();
        return error;
    }

    public Locator getLoginButton() {
        loginButton.waitFor();
        return loginButton;
    }

    public String getErrorMessage() {
        return getError().textContent();
    }
}
