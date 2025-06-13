package saucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}