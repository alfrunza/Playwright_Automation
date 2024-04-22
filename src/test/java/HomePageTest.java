import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import utils.BaseTest;


public class HomePageTest extends BaseTest {

    Page page;

    @Test(description = "Header and Page title are \"Swag Labs\"")
    public void verifyHeaderAndTitle() {
        homePage.navigateToPage();
        Assert.assertEquals(homePage.getTitleHeader().textContent(), "Swag Labs", "Page header is wrong...");
        Assert.assertEquals(homePage.getTitle(), "Swag Labs", "Page title is wrong...");
        Assert.assertEquals(homePage.getURL(), "https://www.saucedemo.com/inventory.html", "Wrong URL...");
    }

    @Test(description = "Hamburger menu can be opened and closed")
    public void verifyHamburgerMenu() {
        homePage.navigateToPage();
        homePage.openHamburger();
        Assert.assertTrue(homePage.areHamburgerButtonsVisible());
        homePage.closeHamburger();
        Assert.assertFalse(homePage.areHamburgerButtonsVisible());
    }
}
