import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAuthorization {
    private WebDriver driver;
    private String MainPageUrl = "https://www.saucedemo.com/";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(MainPageUrl);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @ParameterizedTest
@CsvSource({
        "standard_user, secret_sauce",
        "Arseniy, secret_sauce",
        " , secret_sauce",
        "<script>, secret_sauce",
        "select, secret_sauce",
                "standard_user, secret_s",
        "standard_using, secret_sa",
        ","
})

    public void testCheckAuthorization(String name, String password) throws InterruptedException {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterUsername(name);
        authorizationPage.enterPassword(password);
        authorizationPage.clickLoginButton();
        String expectedUrl;
        if ("standard_user".equals(name) && "secret_sauce".equals(password)) {
            expectedUrl = "https://www.saucedemo.com/inventory.html";
        } else {
            expectedUrl = "https://www.saucedemo.com/";
        }
        String urlAfterAuthorization = driver.getCurrentUrl();
                assertEquals(expectedUrl, urlAfterAuthorization);
    }
}