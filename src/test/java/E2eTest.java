import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import io.qameta.allure.Step;

import java.time.Duration;

public class E2eTest {
    private WebDriver driver;
    private Waiting waiting;
    private String MainPageUrl = "https://www.saucedemo.com/";

    @BeforeEach
@Step("Открыть страницу 'https://www.saucedemo.com/'")
    public void setUp() {
        // Инициализация объекта WebDriver
        driver = new ChromeDriver();
        waiting = new Waiting(driver);
        driver.get(MainPageUrl);
    }

    @AfterEach
    public void tearDown() {
        // Закрытие браузера
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void FullTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterUsername("standard_user");
        authorizationPage.enterPassword("secret_sauce");
        authorizationPage.clickLoginButton();
        String urlAfterAuthorization = driver.getCurrentUrl();
        assertTrue(urlAfterAuthorization.contains("https://www.saucedemo.com/"), "Authorization failed");
        ProductPage productPage = new ProductPage(driver);
        productPage.chooseProduct();
        productPage.AddProductToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.GoCart();
        WebElement actualCart = waiting.GetWait().until(visibilityOfElementLocated(By.xpath("//div[@class='inventory_item_name']")));
        assertEquals("Sauce Labs Backpack", actualCart.getText());
        OrderPage orderPage = new OrderPage(driver);
        orderPage.ClickCheckOutButton();
        orderPage.EnterYourFirstname("Test name");
        orderPage.EnterYourLastname("Test lastname");
        orderPage.EnterYourZipPostalCod("125212");
        orderPage.ClickNextButton();
        FinishOrderPage finishOrderPage = new FinishOrderPage(driver);
        finishOrderPage.ClickFinishButton();
        WebElement ActualHeader = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        String expectedResult = "Thank you for your order!";
        String actualResult = ActualHeader.getText();
        assertEquals(expectedResult, actualResult);
    }
}