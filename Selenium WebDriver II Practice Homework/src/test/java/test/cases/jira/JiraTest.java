package test.cases.jira;


import org.junit.Test;
import pages.jira.JiraHomePage;


public class JiraTest extends BaseTest {


    @Test
    public void createStoryInJira_when_homePageNavigated() throws InterruptedException {
        login();

        JiraHomePage.createProject("Draft123");
        JiraHomePage.createJiraStory();

        JiraHomePage.assertBugAndStoryCreationSuccess();
    }

    @Test
    public void createBugInJira_when_homePageNavigated() {
        login();

        JiraHomePage.createJiraBug();
        JiraHomePage.assertBugAndStoryCreationSuccess();

    }

    @Test
    public void linkBugToStory_when_homePageNavigated() {
        login();

        JiraHomePage.linkBugToStory();

        JiraHomePage.assertBugLinkToStory();
        JiraHomePage.deleteProject();

    }
}
