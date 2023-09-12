package test.cases.trello;

import api.BoardModel;
import api.ListModel;
import api.TrelloApi;
import com.telerikacademy.testframework.CustomWebDriverManager;
import com.telerikacademy.testframework.UserActions;
import org.junit.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

public class BoardTest extends BaseTest {

    private TrelloApi trelloApi = new TrelloApi();
    private BoardModel createdBoard;

    @Before
    public void beforeTest(){
        createdBoard = trelloApi.createBoard("Board Name from Automation", "Description");
    }

    @After
    public void afterTest(){
        var deletionResponse = trelloApi.deleteBoard(createdBoard.id);
    }

    @Test
    public void createBoardWhenCreateBoardClicked() {
        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.assertAddListExists();

        // API: Delete board
    }

    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
        // API: Create a board
        // API: Create a list

        // API: Delete board
    }

    @Ignore
    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {
        ListModel responseListFrom = trelloApi.createList(createdBoard.id, "ListNameAutoFrom");
        ListModel responseListTo = trelloApi.createList(createdBoard.id, "ListNameAutoTo");
        trelloApi.createCard(responseListFrom.id, "CardNameAuto");

        actions.dragAndDropElement("trello.boardPage.cardByName", "trello.boardPage.listByName");
    }

    @Ignore
    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {
        // API: Create a board

        // API: Delete board
    }
}
