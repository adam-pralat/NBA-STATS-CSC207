package use_case.player_comparison;

import data_access.TestDAO;
import data_access.TestDAOErrors;
import junit.framework.TestCase;
import org.junit.Test;

public class PlayerComparisonInteractorTest extends TestCase {
    @Test
    public void testExecuteSuccess(){
        PlayerComparisonInputData playerComparisonInputData = new PlayerComparisonInputData(1, 1);
        PlayerComparisonDataAccessInterface playerComparisonDAO = new TestDAO();
        PlayerComparisonOutputBoundary outputBoundary = new PlayerComparisonOutputBoundary() {
            @Override
            public void prepareSuccessView(PlayerComparisonOutputData response) {
                assertEquals("A", response.getPlayerStats1().get("firstName"));
                assertEquals("B", response.getPlayerStats1().get("lastName"));
                assertEquals("2000-01-01", response.getPlayerStats1().get("birthDate"));
                assertEquals("Canada", response.getPlayerStats1().get("country"));
                assertEquals(1.0, response.getPlayerStats1().get("pointsPerGame"));
                assertEquals(1.0, response.getPlayerStats1().get("assistsPerGame"));
                assertEquals(100.0, response.getPlayerStats1().get("freeThrowPercentage"));
                assertEquals(100.0, response.getPlayerStats1().get("fieldGoalPercentage"));
                assertEquals(100.0, response.getPlayerStats1().get("threePointPercentage"));
                assertEquals(1.0, response.getPlayerStats1().get("turnoversPerGame"));
                assertEquals(1.0, response.getPlayerStats1().get("stealsPerGame"));
                assertEquals(1.0, response.getPlayerStats1().get("blocksPerGame"));
                assertEquals(1.0, response.getPlayerStats1().get("minutesPlayedPerGame"));

                assertEquals("A", response.getPlayerStats2().get("firstName"));
                assertEquals("B", response.getPlayerStats2().get("lastName"));
                assertEquals("2000-01-01", response.getPlayerStats2().get("birthDate"));
                assertEquals("Canada", response.getPlayerStats2().get("country"));
                assertEquals(1.0, response.getPlayerStats2().get("pointsPerGame"));
                assertEquals(1.0, response.getPlayerStats2().get("assistsPerGame"));
                assertEquals(100.0, response.getPlayerStats2().get("freeThrowPercentage"));
                assertEquals(100.0, response.getPlayerStats2().get("fieldGoalPercentage"));
                assertEquals(100.0, response.getPlayerStats2().get("threePointPercentage"));
                assertEquals(1.0, response.getPlayerStats2().get("turnoversPerGame"));
                assertEquals(1.0, response.getPlayerStats2().get("stealsPerGame"));
                assertEquals(1.0, response.getPlayerStats2().get("blocksPerGame"));
                assertEquals(1.0, response.getPlayerStats2().get("minutesPlayedPerGame"));

                assertEquals(response.isUseCaseFailed(), false);
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected fail");
            }
        };
        PlayerComparisonInputBoundary interactor = new PlayerComparisonInteractor(playerComparisonDAO, outputBoundary);
        interactor.execute(playerComparisonInputData);
    }

    @Test
    public void testExecuteFail(){
        PlayerComparisonInputData inputData = new PlayerComparisonInputData(1, 1);
        PlayerComparisonDataAccessInterface playerComparisonDAO = new TestDAOErrors();
        PlayerComparisonOutputBoundary outputBoundary = new PlayerComparisonOutputBoundary() {
            @Override
            public void prepareSuccessView(PlayerComparisonOutputData response) { fail("Unexpected success"); }

            @Override
            public void prepareFailView(String error) {
                assertEquals("java.lang.RuntimeException", error); }
        };
        PlayerComparisonInputBoundary interactor = new PlayerComparisonInteractor(playerComparisonDAO, outputBoundary);
        interactor.execute(inputData);
    }
}