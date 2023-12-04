package use_case.player_stats;

import data_access.TestDAO;
import data_access.TestDAOErrors;
import junit.framework.TestCase;
import org.junit.Test;
import use_case.home_page.*;

import java.util.Map;

// TODO: Finish test
public class PlayerStatsInteractorTest extends TestCase {
    public void testExecuteSuccess() {
        PlayerStatsInputData inputData = new PlayerStatsInputData(265);
        PlayerStatsDataAccessInterface playerDAO = new TestDAO();
        PlayerStatsOutputBoundary outputBoundary = new PlayerStatsOutputBoundary() {
            @Override
            public void prepareSuccessView(PlayerStatsOutputData response) {
                Map<String, Object> playerData = response.getPlayerStats();
                assertEquals(playerData.get("firstName"), "A");
                assertEquals(playerData.get("lastName"), "B");
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected fail");
            }
        };
        PlayerStatsInteractor interactor = new PlayerStatsInteractor(playerDAO, outputBoundary);
        interactor.execute(inputData);
    }

    @Test
    public void testExecuteFail() {
        PlayerStatsInputData inputData = new PlayerStatsInputData(265);
        PlayerStatsDataAccessInterface playerDAO = new TestDAOErrors();
        PlayerStatsOutputBoundary outputBoundary = new PlayerStatsOutputBoundary() {
            @Override
            public void prepareSuccessView(PlayerStatsOutputData response) {
                fail("Unexpected success");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Error in getting data.", error);
            }
        };
        PlayerStatsInputBoundary interactor = new PlayerStatsInteractor(playerDAO, outputBoundary);
        interactor.execute(inputData);
    }

}