package Tests;

import PAges.Inventorypage;
import PAges.Loginpage;
import Utils.DataDriven;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void verifySuccessfulLogin() {

        String username =
                DataDriven.jsonReader("validUsername");

        String password =
                DataDriven.jsonReader("validPassword");

        Loginpage loginPage = new Loginpage(driver);
        Inventorypage inventoryPage =
                new Inventorypage(driver);

        loginPage.login(username, password);

        Assert.assertTrue(
                Inventorypage.isInventoryPageDisplayed,
                "User was not redirected to the Inventory page");
    }
}
