package saucedemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import io.qameta.allure.Step;

public class OrderPage extends BasePage {
    private final By YourFirstNameInput = By.id("first-name");
    private final By YourLastNameInput = By.id("last-name");
    private final By YourZipPostalCodInput = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public OrderPage(WebDriver driver) {
        super(driver);
    }


    @Step("Ввести имя {yourFirstname}")
    public void EnterYourFirstname(String yourFirstname) {
        getWait().until(visibilityOfElementLocated(YourFirstNameInput)).sendKeys(yourFirstname);
    }

    @Step("Ввести фамилию {yourLastname}")
    public void EnterYourLastname(String yourLastname) {
        driver.findElement(YourLastNameInput).sendKeys(yourLastname);
    }

    @Step("Ввести почтовый индекс {yourZipPostalCod}")
    public void EnterYourZipPostalCod(String yourZipPostalCod) {
        driver.findElement(YourZipPostalCodInput).sendKeys(yourZipPostalCod);
    }

    @Step("Нажать на кнопку для продолжения оформления заказа")
    public void clickContinueButton() {
        getWait().until(elementToBeClickable(continueButton)).click();
    }
}