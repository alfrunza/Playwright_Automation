import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import utils.BaseTest;
import utils.ConfigurationData;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPageTest extends BaseTest {
    Page page;

    @Test(description = "Login with valid credentials")
    void verifyValidLogin() {
        loginPage.logIn(ConfigurationData.getUsername(), ConfigurationData.getPassword());
        assertThat(homePage.getTitleHeader()).containsText("Swag Labs");
    }

    @Test(description = "Login with invalid username")
    void verifyInvalidUsername() {
        loginPage.logIn("invalid", ConfigurationData.getPassword());
        assertThat(loginPage.getError()).isVisible();
        assertThat(loginPage.getLoginButton()).isVisible();
        Assert.assertTrue(loginPage.verifyErrorMessage());
    }

    @Test(description = "Login with invalid password")
    void verifyInvalidPassword() {
        loginPage.logIn(ConfigurationData.getUsername(), "invalid");
        assertThat(loginPage.getError()).isVisible();
        assertThat(loginPage.getLoginButton()).isVisible();
        Assert.assertTrue(loginPage.verifyErrorMessage());
    }
}
