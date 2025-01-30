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

public class E2eTest extends BaseTest {

    @Test
    public void FullTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterUsername("standard_user");
        authorizationPage.enterPassword("secret_sauce");
        authorizationPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);
        CheckMethods checkMethods = new CheckMethods(driver);
        checkMethods.checkProductTitlePageText("Products");
        productPage.chooseProduct();
        productPage.addProductToCart();
        productPage.goCart();

        CartPage cartPage = new CartPage(driver);
        checkMethods.checkInventoryItemText("Sauce Labs Backpack");

        OrderPage orderPage = new OrderPage(driver);
        orderPage.ClickCheckOutButton();
        orderPage.EnterYourFirstname("Test name");
        orderPage.EnterYourLastname("Test lastname");
        orderPage.EnterYourZipPostalCod("125212");
        orderPage.ClickNextButton();

        FinishOrderPage finishOrderPage = new FinishOrderPage(driver);
        finishOrderPage.ClickFinishButton();

        GratefulPage gratefulPage = new GratefulPage(driver);
        checkMethods.checkGratefulHeaderText("Thank you for your order!");
    }
}