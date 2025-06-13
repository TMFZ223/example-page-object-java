package saucedemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class AuthorizationPage extends BasePage {
    private final By usernameInput = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести имя пользователя {username}")
    public void enterUsername(String username) {
        if (username != null && !username.trim().isEmpty()) {
            driver.findElement(usernameInput).sendKeys(username);
        } else {
            driver.findElement(usernameInput).clear();
        }
    }

    @Step("Ввести пароль {pass}")
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