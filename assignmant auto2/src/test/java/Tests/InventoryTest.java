package Tests;

import Base.Basetest;
import PAges.Inventorypage;
import PAges.Loginpage;
import Utils.DataDriven;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends Basetest {

    @Test
    public void verifyInventoryPageElements() {


        String username =
                DataDriven.jsonReader("validUsername");

        String password =
                DataDriven.jsonReader("validPassword");



        Loginpage loginPage = new Loginpage(driver);
        Inventorypage inventoryPage =
                new Inventorypage(driver);


        loginPage.login(username, password);


        Assert.assertTrue(
                inventoryPage.isInventoryPageDisplayed(),
                "User was not redirected to the Inventory page"
        );


        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Swag Labs",
                "The page title is incorrect"
        );

        // Verify cart icon is displayed
        Assert.assertTrue(
                inventoryPage.isCartIconDisplayed(),
                "The shopping cart icon is not displayed"
        );


        Assert.assertEquals(
                inventoryPage.getProductCount(),
                6,
                "The inventory page should display exactly 6 products"
        );
    }
}
