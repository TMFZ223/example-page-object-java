import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAuthorization {
    private WebDriver driver;
    private String MainPageUrl = "https://www.saucedemo.com/";
    static List<String> names = Arrays.asList("standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user", "visual_user", "standard_using", "Arseniy", "select", "<script>", "");
    static List<String> passwords = Arrays.asList("secret_sauce", "secret_sauc", "select", "</script>", "");

    static Stream<Arguments> provideTestArguments() {
        List<Arguments> argumentsList = new ArrayList<>();
        for (String name : names) {
            for (String password : passwords) {
                argumentsList.add(Arguments.of(name, password));
            }
        }
        return argumentsList.stream();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(MainPageUrl);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void testCheckAuthorization(String name, String password) throws InterruptedException {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterUsername(name);
        authorizationPage.enterPassword(password);
        authorizationPage.clickLoginButton();
        String expectedUrl;
        List<String> AcceptedUsers = Arrays.asList("standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user", "visual_user");
        if (AcceptedUsers.contains(name) && "secret_sauce".equals(password)) {
            expectedUrl = "https://www.saucedemo.com/inventory.html";
        } else {
            expectedUrl = "https://www.saucedemo.com/";
        }
        String urlAfterAuthorization = driver.getCurrentUrl();
        assertEquals(expectedUrl, urlAfterAuthorization);
    }
}
