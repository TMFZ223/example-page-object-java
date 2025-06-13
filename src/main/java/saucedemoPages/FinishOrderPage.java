package saucedemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import io.qameta.allure.Step;

public class FinishOrderPage extends BasePage {
    private final By finishButton = By.id("finish");

    public FinishOrderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на кнопку завершения заказа")
    public void ClickFinishButton() {
        getWait().until(elementToBeClickable(finishButton)).getLocation();
        driver.findElement(finishButton).click();
    }
}