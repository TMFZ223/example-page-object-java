import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.time.Duration;

import io.qameta.allure.Step;

public class ProductPage {
    private WebDriver driver;
    private Waiting waiting;
    private By titleProductPage = By.xpath("//span[@class='title']");
    private By product = By.xpath("//img[@alt ='Sauce Labs Backpack']");
    private By cartButton = By.xpath("//button[@name = 'add-to-cart']");
    private By cartLink = By.xpath("//a[@class='shopping_cart_link']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.waiting = new Waiting(driver);
    }

    @Step("Выбрать для покупки товар 'Sauce Labs Backpack'")
    public void chooseProduct() {
        waiting.getWait().until(visibilityOfElementLocated(product)).click();
    }

    @Step("Добавить товар в корзину")
    public void addProductToCart() {
        waiting.getWait().until(elementToBeClickable(cartButton)).click();
    }

    @Step("Перейти в корзину")
    public void goCart() {
        waiting.getWait().until(elementToBeClickable(cartLink)).click();
    }

        // Получение текста заголовка страницы
    public String getProductTitlePageText() {
        String productTitlePageText = driver.findElement(titleProductPage).getText();
        return productTitlePageText;
    }
}