package com.telerikacademy.testframework.pages;

import com.telerikacademy.testframework.UserActions;
import com.telerikacademy.testframework.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected String url;
    protected static WebDriver driver;
    public static UserActions actions;

    public BasePage(WebDriver driver, String urlKey) {
        String pageUrl = Utils.getConfigPropertyByKey(urlKey);
        BasePage.driver = driver;
        this.url = pageUrl;
        actions = new UserActions();
    }


    public void navigateToPage() {
        driver.get(url);
    }

    public void assertPageNavigated() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Landed URL is not as expected. Actual URL: " + currentUrl + ". Expected URL: " + url,
            currentUrl.contains(url));
    }

}
