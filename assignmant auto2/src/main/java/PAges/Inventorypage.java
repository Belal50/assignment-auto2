package PAges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Inventorypage {
    WebDriver driver;
    WebDriverWait wait;

    private final By cartIcon =
            By.className("shopping_cart_link");

    private final By products =
            By.className("inventory_item");

    public void Inventorypage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));
    }
    public boolean isInventoryPageDisplayed() {
        wait.until(ExpectedConditions.urlContains(
                "/inventory.html"));

        return driver.getCurrentUrl()
                .contains("/inventory.html");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isCartIconDisplayed() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                cartIcon))
                .isDisplayed();
    }

    public int getProductCount() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        products));

        return driver.findElements(products).size();
    }

}
