package saucedemoPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ErrorAuthorizationPage extends BasePage {
    private By errorElement = By.xpath("//h3[@data-test='error']");

    public ErrorAuthorizationPage(WebDriver driver) {
        super(driver);
    }

    // Получение текста ошибки
    public String getErrorTextAfterAuthorization() {
        String errorAfterAuthorizationText = getWait().until(visibilityOfElementLocated(errorElement)).getText();
        return errorAfterAuthorizationText;
    }
    @Step("Убедиться, что после ввода невалидных данных после авторизации отображается текст ошибки: {expectedErrorText}")
    public void checkErrorTextAfterAuthorization(String expectedErrorText) {
        assertEquals(expectedErrorText, getErrorTextAfterAuthorization());
    }
}