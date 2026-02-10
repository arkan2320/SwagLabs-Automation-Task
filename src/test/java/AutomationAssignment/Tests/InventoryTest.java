package AutomationAssignment.Tests;

import Base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import Utils.DataDriven;
import java.io.IOException;

public class InventoryTest extends BaseTest {

    @Test
    public void verifyInventoryPageElements() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        JsonNode data = DataDriven.jsonReader("validUser");
        loginPage.login(data.get("username").asText(), data.get("password").asText());

        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertEquals(inventoryPage.getPageTitle(), "Swag Labs");
        Assert.assertTrue(inventoryPage.isCartDisplayed());
        Assert.assertEquals(inventoryPage.getProductCount(), 6);
    }
}