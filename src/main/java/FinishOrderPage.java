import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.time.Duration;
import io.qameta.allure.Step;

public class FinishOrderPage {
    private WebDriver driver;
    private Waiting waiting;
    private By FinishButton = By.xpath("//button[@name='finish']");

    public FinishOrderPage(WebDriver driver) {
        this.driver = driver;
        this.waiting = new Waiting(driver);
    }

@Step("Нажать на кнопку завершения заказа")
    public void ClickFinishButton() {
        waiting.getWait().until(elementToBeClickable(FinishButton)).click();
    }
}