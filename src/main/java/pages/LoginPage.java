package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import utils.ConfigurationData;

public class LoginPage {
    private final Page page;
    private final Locator usernameField;
    private final Locator passwordField;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameField = page.getByTestId("username");
        this.passwordField = page.getByTestId("password");
        this.loginButton = page.getByTestId("login-button");
    }

    public void navigateToPage() {
        page.navigate(ConfigurationData.getBaseUrl());
    }

    public void fillUsername() {
        usernameField.fill(ConfigurationData.getUsername());
    }

    public void fillPassword() {
        passwordField.fill(ConfigurationData.getPassword());
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void logIn() {
        navigateToPage();
        fillUsername();
        fillPassword();
        clickLoginButton();
        page.waitForLoadState(LoadState.LOAD);
    }
}
