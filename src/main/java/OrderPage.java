import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.time.Duration;

import io.qameta.allure.Step;

public class OrderPage {
    private WebDriver driver;
    private Waiting waiting;
    private By CheckOutButton = By.xpath("//button[@name = 'checkout']");
    private By YourFirstNameInput = By.xpath("//input[@placeholder='First Name']");
    private By YourLastNameInput = By.xpath("//input[@placeholder='Last Name']");
    private By YourZipPostalCodInput = By.xpath("//input[@placeholder='Zip/Postal Code']");
    private By NextButton = By.xpath("//input[@type='submit']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.waiting = new Waiting(driver);
    }

    @Step("Нажать на кнопку для начала оформления заказа")
    public void ClickCheckOutButton() {
        waiting.getWait().until(elementToBeClickable(CheckOutButton)).click();
    }

    @Step("Ввести имя {yourFirstname}")
    public void EnterYourFirstname(String yourFirstname) {
        waiting.getWait().until(visibilityOfElementLocated(YourFirstNameInput)).sendKeys(yourFirstname);
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
        waiting.getWait().until(elementToBeClickable(NextButton)).click();
    }
}