package saucedemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import io.qameta.allure.Step;

public class ProductPage extends BasePage {
    private By titleProductPage = By.xpath("//span[@class='title']");
    private By product = By.xpath("//img[@alt ='Sauce Labs Backpack']");
    private By cartButton = By.xpath("//button[@name = 'add-to-cart']");
    private By cartLink = By.xpath("//a[@class='shopping_cart_link']");

    public ProductPage(WebDriver driver) {
       super(driver);
    }

    @Step("Выбрать для покупки товар 'Sauce Labs Backpack'")
    public void chooseProduct() {
        getWait().until(visibilityOfElementLocated(product)).click();
    }

    @Step("Добавить товар в корзину")
    public void addProductToCart() {
        getWait().until(elementToBeClickable(cartButton)).click();
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