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

public class JiraHomePage extends BaseJiraPage {

    public JiraHomePage(WebDriver driver) {
        super(driver, "jira.homePages");
    }

    public void createJiraStory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String summaryField = "Allow Users to Reset Password via Email";
        String descriptionField = "As a user in https://www.saucedemo.com/, I want to be able to reset my password " +
                "via email if I forget it, so I can regain access to my account. " +
                "This feature will provide a secure and convenient way for users to reset " +
                "their passwords and ensure the protection of their accounts.\n" +
                "\n" +
                "Acceptance Criteria:\n" +
                "\n" +
                "\"Forgot Password\" Link:\n" +
                "\n" +
                "The login page https://www.saucedemo.com/ should prominently display a \"Forgot Password\" " +
                "link in a visible location, preferably near the login form. When clicked, " +
                "this link should immediately redirect the user to the password reset page.\n" +
                "\n" +
                "Password Reset Page:\n" +
                "\n" +
                "Upon clicking the \"Forgot Password\" link, the user should be directed to the password reset page. " +
                "This page should include a clear and concise message instructing the user to enter " +
                "their registered email address to initiate the password reset process.\n" +
                "\n" +
                "Email Validation and Token Generation:\n" +
                "\n" +
                "After the user enters their email address and clicks the \"Reset Password\" button," +
                " the system should perform server-side validation to ensure the email address is valid and " +
                "registered in the system. If the email address is valid, a unique password reset " +
                "link with a secure token should be generated and sent to the user's email.\n" +
                "\n" +
                "Password Reset Procedure:\n" +
                "\n" +
                "Upon receiving the password reset email, the user should be greeted with a personalized " +
                "message addressing them by name. The email should contain clear and detailed instructions " +
                "on how to proceed with the password reset. It should also include a time-limited " +
                "and encrypted password reset link for enhanced security.\n" +
                "\n" +
                "Priority: High";

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
        actions.typeValueInField(descriptionField, "jira.homePage.descriptionField");

        actions.waitForElementClickable("jira.homePage.createBugButton");
        actions.clickElement("jira.homePage.createBugButton");

    }

    public void createJiraBug() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String summaryField = "Password Reset via Email Functionality Issue";
        String descriptionField = "As a user, I want to be able to reset my password via email if I forget it, " +
                "so I can regain access to my account. " +
                "This feature will provide a secure and convenient way for users to reset their passwords " +
                "and ensure the protection of their accounts.\n" +
                "\n" +
                "Precondition:\n" +
                "The user must have a registered email address in the system to initiate the password reset process.\n" +
                "\n" +
                "Steps to Reproduce:\n" +
                "1. Navigate to the login page https://www.saucedemo.com/\n" +
                "2. Fill valid username in the username field \"standard_user\"\n" +
                "3. Fill wrong password in the password field \"secret_sauce_wrong\"\n" +
                "4. The login page prominently displays a \"Forgot Password\" link in a visible location, " +
                "near the login form\n" +
                "5. Click on the \"Forgot Password\" link and enter an email\n" +
                "6. Upon clicking the \"Forgot Password\" link the password reset " +
                "functionality is not working as expected.\n" +
                "\n" +
                "Expected Result:\n" +
                "\n" +
                "The password reset functionality on https://www.saucedemo.com/ " +
                "should successfully allow users to reset their passwords via email.\n" +
                "\n" +
                "Actual Result:\n" +
                "\n" +
                "The password reset functionality on https://www.saucedemo.com/ is not working as expected. " +
                "When clicking on the \"Forgot Password\" link, the password reset page is not loading," +
                " and users are unable to reset their passwords via email.";

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
        actions.typeValueInField(descriptionField, "jira.homePage.descriptionField");

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



