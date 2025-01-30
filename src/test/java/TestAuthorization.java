import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@Epic("Тестирование функционала авторизации")
public class TestAuthorization extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user", "visual_user"})
    @DisplayName("Позетивный тест авторизации")
    public void positiveTestAuthorization(String user) {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterUsername(user);
        authorizationPage.enterPassword("secret_sauce");
        authorizationPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);

        CheckMethods checkMethods = new CheckMethods(driver);
        String expectedTextAfterAuthorization = "Products";
        checkMethods.checkProductTitlePageText(expectedTextAfterAuthorization);
    }

    @ParameterizedTest
    @CsvSource({"'', 'secret_sauce', 'Epic sadface: Username is required'", "'standard_user', '', 'Epic sadface: Password is required'", "'locked_out_user', 'select', 'Epic sadface: Username and password do not match any user in this service'", "'locked_out_user', '<script>', 'Epic sadface: Username and password do not match any user in this service'"})
    @Description("Негативный тест авторизации")
    @DisplayName("Негативный тест авторизации")
    public void negativeTestAuthorization(String usernameValue, String passValue, String errorText) {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterUsername(usernameValue);
        authorizationPage.enterPassword(passValue);
        authorizationPage.clickLoginButton();

        CheckMethods checkMethods = new CheckMethods(driver);
        checkMethods.checkErrorTextAfterAuthorization(errorText);
    }
}