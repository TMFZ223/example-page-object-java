package saucedemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import io.qameta.allure.Step;

public class ProductPage extends BasePage {
    private final By titleProductPage = By.className("title");
    private final By productSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLink = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Добавить в корзину товар 'Sauce Labs Backpack'")
    public void chooseProductSauceLabsBackpack() {
        getWait().until(visibilityOfElementLocated(productSauceLabsBackpack)).click();
    }

    @Step("Перейти в корзину")
    public void goCart() {
        getWait().until(elementToBeClickable(cartLink)).click();
    }

    // Получение текста заголовка страницы
    public String getProductTitlePageText() {
        String productTitlePageText = driver.findElement(titleProductPage).getText();
        return productTitlePageText;
    }

    @Step("Убедиться, что на странице товаров отображается текст {expectedTitleProductPageText}")
    public void checkProductTitlePageText(String expectedTitleProductPageText) {
        assertEquals(expectedTitleProductPageText, getProductTitlePageText());
    }
}