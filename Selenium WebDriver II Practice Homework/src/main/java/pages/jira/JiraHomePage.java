package pages.jira;

import com.telerikacademy.testframework.UserActions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.jira.Constants.BUG_DESCRIPTION_FIELD;
import static pages.jira.Constants.STORY_DESCRIPTION_FIELD;

public class JiraHomePage extends BaseJiraPage {

    public JiraHomePage(WebDriver driver) {
        super(driver, "jira.homePages");
    }

    public void createJiraStory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String summaryField = "Allow Users to Reset Password via Email";

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.waitForElementPresent("jira.homePage.createButton");
        actions.clickElement("jira.homePage.createButton");

        actions.waitForElementClickable("jira.homePage.summaryField");
        actions.typeValueInField(summaryField, "jira.homePage.summaryField");

        actions.waitForElementClickable("jira.homePage.descriptionField");
        actions.typeValueInField(STORY_DESCRIPTION_FIELD, "jira.homePage.descriptionField");

        actions.waitForElementClickable("jira.homePage.createBugButton");
        actions.clickElement("jira.homePage.createBugButton");

    }

    public void createJiraBug() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String summaryField = "Password Reset via Email Functionality Issue";

        actions.waitForElementPresent("jira.homePage.createButton");
        actions.clickElement("jira.homePage.createButton");

        WebElement dropdownMenuSelectBug = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id='issue-create.ui.modal.create-form.type-picker.issue-type-select']/div")));
        dropdownMenuSelectBug.click();

        WebElement bugOption = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[text()='Bug']")));
        bugOption.click();

        actions.waitForElementClickable("jira.homePage.summaryField");
        actions.typeValueInField(summaryField, "jira.homePage.summaryField");

        actions.waitForElementClickable("jira.homePage.descriptionField");
        actions.typeValueInField(BUG_DESCRIPTION_FIELD, "jira.homePage.descriptionField");

        actions.waitForElementClickable("jira.homePage.createBugButton");
        actions.clickElement("jira.homePage.createBugButton");

    }

    public void createProject(String projectName) throws InterruptedException {

        actions.waitForElementPresent("jira.homePage.createProjectButton");
        actions.clickElement("jira.homePage.createProjectButton");

        actions.waitForElementPresent("jira.homePage.createProject");
        actions.clickElement("jira.homePage.createProject");

        actions.waitForElementPresent("jira.homePage.createProjectTemplateScrum");
        actions.clickElement("jira.homePage.createProjectTemplateScrum");

        actions.waitForElementPresent("jira.homePage.useTemplateButton");
        actions.clickElement("jira.homePage.useTemplateButton");

        actions.waitForElementClickable("jira.homePage.projectTypeButton");
        actions.clickElement("jira.homePage.projectTypeButton");

        actions.waitForElementPresent("jira.homePage.projectNameField");
        actions.typeValueInField(projectName, "jira.homePage.projectNameField");

        actions.waitForElementVisible("jira.homePage.createProjectFinalButton");
        actions.typeValueInFieldWithActions("D3", "jira.homePage.fieldWithActions");

        actions.waitForElementClickable("jira.homePage.finalCreateProjectButton");
        actions.clickElement("jira.homePage.finalCreateProjectButton");

        Thread.sleep(1000);
        if (actions.isElementPresent("jira.goToProject")) {

            actions.clickElement("jira.goToProject");

        }

    }

    public void linkBugToStory() {

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String storyName = "D3-1";

        actions.waitForElementPresent("jira.homePage.clickOnStory");
        actions.clickElement("jira.homePage.clickOnStory");

        actions.waitForElementPresent("jira.homePage.linkIssueButton");
        actions.clickElement("jira.homePage.linkIssueButton");

        actions.waitForElementPresent("jira.homePage.linkIssueSearchField");
        actions.typeValueInField(storyName, "jira.homePage.linkIssueSearchField");

        actions.waitForElementPresent("jira.homePage.linkIssueSearchField");
        actions.typeValueInField(String.valueOf(Keys.ENTER), "jira.homePage.linkIssueSearchField");

        actions.waitForElementPresent("jira.homePage.linkCreateButton");
        actions.clickElement("jira.homePage.linkCreateButton");

    }

    public void deleteProject() {
        UserActions actions = new UserActions();

        actions.waitForElementPresent("jira.projectMenu");
        actions.clickElement("jira.projectMenu");

        actions.waitForElementClickable("jira.viewAllProjects");
        actions.clickElement("jira.viewAllProjects");

        actions.waitForElementVisible("jira.searchField");
        actions.typeValueInFieldWithActions("Draft123", "jira.searchField");

        actions.waitForElementClickable("jira.moreOptions.trash");
        actions.clickElement("jira.moreOptions.trash");

        actions.waitForElementVisible("jira.moveToTrash");
        actions.clickElement("jira.moveToTrash");

        actions.waitForElementClickable("jira.moveToTrashButton");
        actions.clickElement("jira.moveToTrashButton");

        actions.waitForElementClickable("jira.goToTrash");
        actions.clickElement("jira.goToTrash");

        actions.waitForElementVisible("jira.searchField");
        actions.typeValueInFieldWithActions("Draft123", "jira.searchField");

        actions.waitForElementClickable("jira.moreOptions");
        actions.hoverOverElement("jira.moreOptions");
        actions.clickElement("jira.moreOptions");

        actions.waitForElementClickable("jira.deleteOption");
        actions.clickElement("jira.deleteOption");

        actions.waitForElementVisible("jira.deleteButton");
        actions.clickElement("jira.deleteButton");
    }


    public void assertBugAndStoryCreationSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement viewIssueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//a[contains(@class, 'css-14bz9j0') and contains(span, 'View issue')]")));
        Assert.assertTrue("Bug and Story creation was not successful.", viewIssueElement.isDisplayed());
    }

    public void assertBugLinkToStory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//span[contains(@data-testid, 'hover-card-trigger-wrapper')]/a[contains(@data-testid, 'issue-field-summary.ui.inline-read.link-item')]")));
        Assert.assertTrue("Bug is not linked to Story.", linkElement.isDisplayed());
    }

}



