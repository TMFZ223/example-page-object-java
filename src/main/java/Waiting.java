import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Waiting {
    private WebDriver driver;

    public Waiting(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}