package saucedemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import io.qameta.allure.Step;

public class OrderPage extends BasePage {
    private By CheckOutButton = By.xpath("//button[@name = 'checkout']");
    private By YourFirstNameInput = By.xpath("//input[@placeholder='First Name']");
    private By YourLastNameInput = By.xpath("//input[@placeholder='Last Name']");
    private By YourZipPostalCodInput = By.xpath("//input[@placeholder='Zip/Postal Code']");
    private By NextButton = By.xpath("//input[@type='submit']");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на кнопку для начала оформления заказа")
    public void ClickCheckOutButton() {
        getWait().until(elementToBeClickable(CheckOutButton)).click();
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
    public void ClickNextButton() {
        getWait().until(elementToBeClickable(NextButton)).click();
    }
}