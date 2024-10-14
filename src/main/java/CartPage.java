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
    private  Waiting waiting;
    private By cartLink = By.xpath("//a[@class='shopping_cart_link']");

    public CartPage(WebDriver driver) {
                this.driver = driver;
                this.waiting = new Waiting(driver);
    }

@Step("Перейти в корзину")
    public void GoCart() {
        waiting.GetWait().until(elementToBeClickable(cartLink)).click();

    }
}