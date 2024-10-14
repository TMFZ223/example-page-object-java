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
    private  Waiting waiting;
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
        waiting.GetWait().until(elementToBeClickable(CheckOutButton)).click();
    }

@Step("Ввести имя")
    public void EnterYourFirstname(String YourFirstname) {
        waiting.GetWait().until(visibilityOfElementLocated(YourFirstNameInput)).sendKeys(YourFirstname);
    }

@Step("Ввести фамилию")
    public void EnterYourLastname(String YourLastname) {
        driver.findElement(YourLastNameInput).sendKeys(YourLastname);
    }

@Step("Ввести почтовый индекс")
    public void EnterYourZipPostalCod(String YourZipPostalCod) {
        driver.findElement(YourZipPostalCodInput).sendKeys(YourZipPostalCod);
    }

@Step("Нажать на кнопку для продолжения оформления заказа")
    public void ClickNextButton() {
        waiting.GetWait().until(elementToBeClickable(NextButton)).click();
    }
}