package test.cases.jira;

import com.telerikacademy.testframework.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import pages.jira.JiraLoginPage;

public class BaseTest {

    UserActions actions = new UserActions();

    @BeforeClass
    public static void setUp() {
        UserActions.loadBrowser("jira.homePages");
    }

    @AfterClass
    public static void tearDown() {
        UserActions.quitDriver();
    }

    public void login() {
        JiraLoginPage loginPage = new JiraLoginPage(actions.getDriver());
        loginPage.loginUser("user");
    }


}
