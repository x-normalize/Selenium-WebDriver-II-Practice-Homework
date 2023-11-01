package pages.jira;

import com.telerikacademy.testframework.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseJiraPage extends BasePage {
    public BaseJiraPage(WebDriver driver, String urlKey) {
        super(driver, urlKey);
    }
}
