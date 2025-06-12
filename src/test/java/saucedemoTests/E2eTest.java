package saucedemoTests;

import org.junit.jupiter.api.Test;
import saucedemoPages.*;

public class E2eTest extends BaseTest {

    @Test
    public void FullTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
                authorizationPage.enterUsername("standard_user");
        authorizationPage.enterPassword("secret_sauce");
        authorizationPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);
        productPage.checkProductTitlePageText("Products");
        productPage.chooseProduct();
        productPage.addProductToCart();
        productPage.goCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkInventoryItemText("Sauce Labs Backpack");

        OrderPage orderPage = new OrderPage(driver);
        orderPage.ClickCheckOutButton();
        orderPage.EnterYourFirstname("Test name");
        orderPage.EnterYourLastname("Test lastname");
        orderPage.EnterYourZipPostalCod("125212");
        orderPage.ClickNextButton();

        FinishOrderPage finishOrderPage = new FinishOrderPage(driver);
        finishOrderPage.ClickFinishButton();

        GratefulPage gratefulPage = new GratefulPage(driver);
        gratefulPage.checkGratefulHeaderText("Thank you for your order!");
    }
}