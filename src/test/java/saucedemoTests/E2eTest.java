package saucedemoTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import saucedemoPages.*;

@Epic("E2E test")
public class E2eTest extends BaseTest {
    private List<String> acceptedUsers = Arrays.asList("standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user", "visual_user");

    @DisplayName("Сквозной тест для функционала интернет-магазина")
    @Description("Тестирование критически важного функционала (от входа в систему до оформления покупки")
    @Test
    public void FullTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        Random random = new Random();
        String acceptedUserName = acceptedUsers.get(random.nextInt(acceptedUsers.size()));
        authorizationPage.enterUsername(acceptedUserName);
        authorizationPage.enterPassword("secret_sauce");
        authorizationPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);
        productPage.checkProductTitlePageText("Products");
        productPage.chooseProductSauceLabsBackpack();
        productPage.goCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkInventoryItemText("Sauce Labs Backpack");
        cartPage.ClickCheckOutButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.EnterYourFirstname("Test name");
        orderPage.EnterYourLastname("Test lastname");
        orderPage.EnterYourZipPostalCod("125212");
        orderPage.clickContinueButton();

        FinishOrderPage finishOrderPage = new FinishOrderPage(driver);
        finishOrderPage.ClickFinishButton();

        GratefulPage gratefulPage = new GratefulPage(driver);
        gratefulPage.checkGratefulHeaderText("Thank you for your order!");
        gratefulPage.clickGoBackButton();
        productPage.checkProductTitlePageText("Products");
    }
}