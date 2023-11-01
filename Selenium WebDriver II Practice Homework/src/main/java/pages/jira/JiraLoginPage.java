package pages.jira;

import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;

public class JiraLoginPage extends BaseJiraPage {

    public JiraLoginPage(WebDriver driver) {
        super(driver, "jira.homePages");
    }

    public void loginUser() {

        String username = getConfigPropertyByKey("jira.user.username");
        String password = getConfigPropertyByKey("jira.user.password");

        navigateToPage();
        assertPageNavigated();

        actions.waitForElementClickable("jira.loginPage.username");
        actions.typeValueInField(username, "jira.loginPage.username");

        actions.waitForElementVisible("jira.loginPage.loginButton");
        actions.clickElement("jira.loginPage.loginButton");
        actions.waitForElementVisible("jira.loginPage.password");
        actions.typeValueInField(password, "jira.loginPage.password");
        actions.waitForElementVisible("jira.loginPage.loginButton");
        actions.clickElement("jira.loginPage.loginButton");

    }

}
