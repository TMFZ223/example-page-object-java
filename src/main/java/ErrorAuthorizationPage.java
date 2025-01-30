import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ErrorAuthorizationPage {
    private WebDriver driver;
    private Waiting waiting;
    private By errorElement = By.xpath("//h3[@data-test='error']");

    public ErrorAuthorizationPage(WebDriver driver) {
        this.driver = driver;
        this.waiting = new Waiting(driver);
    }

    // Получение текста ошибки
    public String getErrorTextAfterAuthorization() {
        String errorAfterAuthorizationText = waiting.getWait().until(visibilityOfElementLocated(errorElement)).getText();
        return errorAfterAuthorizationText;
    }
}