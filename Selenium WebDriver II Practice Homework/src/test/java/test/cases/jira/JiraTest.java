package test.cases.jira;


import org.junit.Test;
import pages.jira.JiraHomePage;


public class JiraTest extends BaseTest{

    // Please run the tests one by one. Thank you!


    //First Test
    @Test
    public void createStoryInJira_when_homePageNavigated() throws InterruptedException {
        login();

        JiraHomePage home = new JiraHomePage(actions.getDriver());

        home.createProject("Draft123");
        home.createJiraStory();

        home.assertBugAndStoryCreationSuccess();
    }

    //Second Test
    @Test
    public void createBugInJira_when_homePageNavigated() {
        login();

        JiraHomePage homePage = new JiraHomePage(actions.getDriver());
        homePage.createJiraBug();

        homePage.assertBugAndStoryCreationSuccess();

    }

    //Third Test
    @Test
    public void linkBugToStory_when_homePageNavigated() {
        login();

        JiraHomePage homePage = new JiraHomePage(actions.getDriver());
        homePage.linkBugToStory();

        homePage.assertBugLinkToStory();
        homePage.deleteProject();

    }
}
