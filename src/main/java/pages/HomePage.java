package pages;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import utils.ConfigurationData;

public class HomePage {
    private final Page page;
    private final Locator titleHeader;
    private final Locator hamburgerMenu;
    private final Locator itemCard;
    private final Locator backpackItemCard;
    private final Locator bikeLightItemCard;
    private final Locator tShirtItemCard;
    private final Locator jacketItemCard;
    private final Locator onesieItemCard;
    private final Locator longSleeveItemCard;

    public HomePage(Page page) {
        this.page = page;
        this.titleHeader = page.getByText("Swag Labs");
        this.hamburgerMenu = page.getByText("Open Menu");
        this.itemCard = page.getByTestId("inventory-item");
        this.backpackItemCard = page.getByText("Sauce Labs Backpack");
        this.bikeLightItemCard = page.getByText("Sauce Labs Bike Light");
        this.tShirtItemCard = page.getByText("Sauce Labs Bolt T-Shirt");
        this.jacketItemCard = page.getByText("Sauce Labs Fleece Jacket");
        this.onesieItemCard = page.getByText("Sauce Labs Onesie");
        this.longSleeveItemCard = page.getByText("Test.allTheThings() T-Shirt (Red)");
    }

    public Locator getTitleHeader() {
        titleHeader.waitFor();
        return titleHeader;
    }

    public Locator getHamburgerMenu() {
        hamburgerMenu.waitFor();
        return hamburgerMenu;
    }

    public Locator getItemCard() {
        itemCard.waitFor();
        return itemCard;
    }

    public Locator getBackpackItemCard() {
        backpackItemCard.waitFor();
        return backpackItemCard;
    }

    public Locator getBikeLightItemCard() {
        bikeLightItemCard.waitFor();
        return bikeLightItemCard;
    }

    public Locator getTShirtItemCard() {
        tShirtItemCard.waitFor();
        return  tShirtItemCard;
    }

    public Locator getJacketItemCard() {
        jacketItemCard.waitFor();
        return jacketItemCard;
    }

    public Locator getOnesieItemCard() {
        onesieItemCard.waitFor();
        return onesieItemCard;
    }

    public Locator getLongSleeveItemCard() {
        longSleeveItemCard.waitFor();
        return longSleeveItemCard;
    }

    public List<Locator> getAllItemCards() {
        itemCard.waitFor();
        return longSleeveItemCard.all();
    }

    public String getTitle() {
        this.page.waitForLoadState();
        return this.page.title();
    }

    public String getURL() {
        return this.page.url();
    }

    public void navigateToPage() {
        page.navigate(ConfigurationData.getBaseUrl() + "inventory.html");
    }

    public void waitForHeader(int timeout) {
        titleHeader.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(timeout));
    }
}
