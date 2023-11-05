package pages.jira;

public class Constants {

    public static final String STORY_NAME = "D3-1";
    public static final String STORY_SUMMARY_FIELD = "Allow Users to Reset Password via Email";
    public static final String BUG_SUMMARY_FIELD = "Password Reset via Email Functionality Issue";
    public static final String VIEW_ISSUE_TEXT = "//a[contains(@class, 'css-14bz9j0') and contains(span, 'View issue')]";
    public static final String HOVER_CARD_TRIGGER = "//span[contains(@data-testid, 'hover-card-trigger-wrapper')]/a[contains(@data-testid, ";
    public static final String ISSUE_FIELD_SUMMAR = "'issue-field-summary.ui.inline-read.link-item')]";
    public static final String STORY_DESCRIPTION_FIELD = "As a user in https://www.saucedemo.com/, I want to be able to reset my password " +
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
    public static final String BUG_DESCRIPTION_FIELD = "As a user, I want to be able to reset my password via email if I forget it, " +
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
}
