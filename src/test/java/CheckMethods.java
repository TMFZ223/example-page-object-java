import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckMethods {
    private WebDriver driver;

    public CheckMethods(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Убедиться, что после ввода невалидных данных после авторизации отображается текст ошибки: {expectedErrorText}")
    public void checkErrorTextAfterAuthorization(String expectedErrorText) {
        ErrorAuthorizationPage errorAuthorizationPage = new ErrorAuthorizationPage(driver);
        assertEquals(expectedErrorText, errorAuthorizationPage.getErrorTextAfterAuthorization());
    }

    @Step("Убедиться, что на странице товаров отображается текст {expectedTitleProductPageText}")
    public void checkProductTitlePageText(String expectedTitleProductPageText) {
        ProductPage productPage = new ProductPage(driver);
        assertEquals(expectedTitleProductPageText, productPage.getProductTitlePageText());
    }

    @Step("Убедиться, что в корзину добавлен товар {expectedInventoryItemText}")
    public void checkInventoryItemText(String expectedInventoryItemText) {
        CartPage cartPage = new CartPage(driver);
        assertEquals(expectedInventoryItemText, cartPage.getInventoryItemText());
    }

    @Step("Убедиться, что на странице завершения заказа отображается текст благодарности {expectedGratefulHeaderText}")
    public void checkGratefulHeaderText(String expectedGratefulHeaderText) {
        GratefulPage gratefulPage = new GratefulPage(driver);
        assertEquals(expectedGratefulHeaderText, gratefulPage.getGratefulHeaderText());
    }
}