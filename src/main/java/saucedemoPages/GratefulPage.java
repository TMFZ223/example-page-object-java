package saucedemoPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GratefulPage extends BasePage {
    private final By gratefulHeader = By.className("complete-header");
    private final By goBackButton = By.id("back-to-products");

    public GratefulPage(WebDriver driver) {
        super(driver);
    }

    // Получение текста заголовка благодарности за заказ
    public String getGratefulHeaderText() {
        String gratefulHeaderText = driver.findElement(gratefulHeader).getText();
        return gratefulHeaderText;
    }

    @Step("Убедиться, что на странице завершения заказа отображается текст благодарности {expectedGratefulHeaderText}")
    public void checkGratefulHeaderText(String expectedGratefulHeaderText) {
        assertEquals(expectedGratefulHeaderText, getGratefulHeaderText());
    }

    @Step("Вернуться на страницу товаров")
    public void clickGoBackButton() {
        getWait().until(visibilityOfElementLocated(goBackButton)).click();
    }
}