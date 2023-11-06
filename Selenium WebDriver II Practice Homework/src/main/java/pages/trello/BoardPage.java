package pages.trello;

import org.openqa.selenium.WebDriver;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void assertAddListExists() {
        actions.waitForElementPresent("trello.boardPage.listWrapper");
    }
}
