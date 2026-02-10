package AutomationAssignment.Tests;

import Base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import Utils.DataDriven;
import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifySuccessfulLogin() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        JsonNode data = DataDriven.jsonReader("validUser");

        loginPage.login(data.get("username").asText(), data.get("password").asText());

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Test(priority = 2)
    public void verifyInvalidLogin() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        JsonNode data = DataDriven.jsonReader("invalidUser");

        loginPage.login(data.get("username").asText(), data.get("password").asText());

        Assert.assertTrue(loginPage.getErrorText().contains("Username and password do not match"));
    }

    @Test(priority = 3)
    public void verifyLoginWithoutPassword() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        JsonNode data = DataDriven.jsonReader("emptyPasswordUser");

        loginPage.login(data.get("username").asText(), data.get("password").asText());

        Assert.assertTrue(loginPage.getErrorText().contains("Password is required"));
    }
}