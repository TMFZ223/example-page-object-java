import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class AuthorizationPage {
    private WebDriver driver;
    private By usernameInput = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.xpath("//input[@value='Login']");

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;

    }
@Step("Ввести имя пользователя")
    public void enterUsername(String username) {
    if (username != null && !username.trim().isEmpty()) {
        driver.findElement(usernameInput).sendKeys(username);
    } else {
        driver.findElement(usernameInput).clear();
    }
    }
@Step("Ввести пароль")
    public void enterPassword(String pass) {
        if (pass != null && !pass.trim().isEmpty()) {
            driver.findElement(password).sendKeys(pass);
    } else {
        driver.findElement(password).clear();
    } 
    }
@Step("Нажать на кнопку входа")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}