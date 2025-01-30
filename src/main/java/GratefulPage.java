import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GratefulPage {
    private WebDriver driver;
    private By gratefulHeader = By.xpath("//h2[@class='complete-header']");

    public GratefulPage(WebDriver driver) {
        this.driver = driver;
    }

    // Получение текста заголовка благодарности за заказ
    public String getGratefulHeaderText() {
        String gratefulHeaderText = driver.findElement(gratefulHeader).getText();
        return gratefulHeaderText;
    }
}