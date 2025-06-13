package saucedemoTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    @Step("Открыть главную страницу https://www.saucedemo.com/")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterEach
    @Step("Закрыть браузер")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}