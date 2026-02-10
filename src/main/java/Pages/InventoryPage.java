package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By pageTitle = By.className("app_logo");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By products = By.className("inventory_item");

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public boolean isCartDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    public int getProductCount() {
        return driver.findElements(products).size();
    }
}