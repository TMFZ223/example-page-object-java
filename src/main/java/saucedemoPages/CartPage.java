package saucedemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import io.qameta.allure.Step;

public class CartPage extends BasePage {
    private final By inventoryItemName = By.className("inventory_item_name");
    private final By CheckOutButton = By.name("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Получение текста добавленного товара
    public String getInventoryItemText() {
        String inventoryItemText = getWait().until(visibilityOfElementLocated(inventoryItemName)).getText();
        return inventoryItemText;
    }

    @Step("Убедиться, что в корзину добавлен товар {expectedInventoryItemText}")
    public void checkInventoryItemText(String expectedInventoryItemText) {
        assertEquals(expectedInventoryItemText, getInventoryItemText());
    }

    @Step("Нажать на кнопку для начала оформления заказа")
    public void ClickCheckOutButton() {
        getWait().until(elementToBeClickable(CheckOutButton)).click();
    }
}