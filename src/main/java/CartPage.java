import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.time.Duration;

import io.qameta.allure.Step;

public class CartPage {
    private WebDriver driver;
    private Waiting waiting;
    private By inventoryItemName = By.xpath("//div[@class='inventory_item_name']"); // Элемент, где показан добавленный товар

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waiting = new Waiting(driver);
    }

    // Получение текста добавленного товара
    public String getInventoryItemText() {
        String inventoryItemText = waiting.getWait().until(visibilityOfElementLocated(inventoryItemName)).getText();
        return  inventoryItemText;
    }
}