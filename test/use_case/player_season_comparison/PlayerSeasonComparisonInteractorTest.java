package use_case.player_season_comparison;

import data_access.TestDAO;
import data_access.TestDAOErrors;
import entity.Player;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class PlayerSeasonComparisonInteractorTest extends TestCase {
    @Test
    public void testExecuteSuccess() {
        PlayerSeasonComparisonInputData inputData = new PlayerSeasonComparisonInputData(1, 2021, 2022);
        PlayerSeasonComparisonDataAccessInterface playerSeasonComparisonDAO = new TestDAO();
        PlayerSeasonComparisonOutputBoundary outputBoundary = new PlayerSeasonComparisonOutputBoundary() {
            @Override
            public void prepareSuccessView(PlayerSeasonComparisonOutputData response) {
                assertEquals(1, response.getPlayerSeason1Stats().get("gamesPlayed"));
                assertEquals(1, response.getPlayerSeason1Stats().get("points"));
                assertEquals(60, response.getPlayerSeason1Stats().get("timePlayed"));
                assertEquals(1, response.getPlayerSeason1Stats().get("fieldGoalsMade"));
                assertEquals(1, response.getPlayerSeason1Stats().get("fieldGoalsAttempted"));
                assertEquals(1, response.getPlayerSeason1Stats().get("threePointsMade"));
                assertEquals(1, response.getPlayerSeason1Stats().get("threePointsAttempted"));
                assertEquals(1, response.getPlayerSeason1Stats().get("offensiveRebounds"));
                assertEquals(1, response.getPlayerSeason1Stats().get("defensiveRebounds"));
                assertEquals(1, response.getPlayerSeason1Stats().get("personalFouls"));
                assertEquals(1, response.getPlayerSeason1Stats().get("steals"));
                assertEquals(1, response.getPlayerSeason1Stats().get("turnovers"));
                assertEquals(1, response.getPlayerSeason1Stats().get("blocks"));
                assertEquals(1, response.getPlayerSeason1Stats().get("plusMinus"));
                assertEquals("Toronto Raptors", response.getPlayerSeason1Stats().get("team"));
                assertEquals("G", response.getPlayerSeason1Stats().get("position"));
                assertEquals(1, response.getPlayerSeason2Stats().get("gamesPlayed"));
                assertEquals(1, response.getPlayerSeason2Stats().get("points"));
                assertEquals(60, response.getPlayerSeason2Stats().get("timePlayed"));
                assertEquals(1, response.getPlayerSeason2Stats().get("fieldGoalsMade"));
                assertEquals(1, response.getPlayerSeason2Stats().get("fieldGoalsAttempted"));
                assertEquals(1, response.getPlayerSeason2Stats().get("threePointsMade"));
                assertEquals(1, response.getPlayerSeason2Stats().get("threePointsAttempted"));
                assertEquals(1, response.getPlayerSeason2Stats().get("offensiveRebounds"));
                assertEquals(1, response.getPlayerSeason2Stats().get("defensiveRebounds"));
                assertEquals(1, response.getPlayerSeason2Stats().get("personalFouls"));
                assertEquals(1, response.getPlayerSeason2Stats().get("steals"));
                assertEquals(1, response.getPlayerSeason2Stats().get("turnovers"));
                assertEquals(1, response.getPlayerSeason2Stats().get("blocks"));
                assertEquals(1, response.getPlayerSeason2Stats().get("plusMinus"));
                assertEquals("Toronto Raptors", response.getPlayerSeason2Stats().get("team"));
                assertEquals("G", response.getPlayerSeason2Stats().get("position"));
                assertEquals(false, response.isUseCaseFailed());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected Fail");
            }
        };
        PlayerSeasonComparisonInputBoundary interactor = new PlayerSeasonComparisonInteractor(playerSeasonComparisonDAO, outputBoundary);
        interactor.execute(inputData);
    }

    @Test
    public void testIdFail() {
        PlayerSeasonComparisonInputData inputData = new PlayerSeasonComparisonInputData(1, 2022, 2023);
        PlayerSeasonComparisonDataAccessInterface playerSeasonComparisonDAO = new TestDAOErrors();

        PlayerSeasonComparisonOutputBoundary outputBoundary = new PlayerSeasonComparisonOutputBoundary() {
            @Override
            public void prepareSuccessView(PlayerSeasonComparisonOutputData response) {
                fail("Unexpected success");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Sorry, we could not get that data.", error);
            }
        };
        PlayerSeasonComparisonInputBoundary interactor = new PlayerSeasonComparisonInteractor(playerSeasonComparisonDAO, outputBoundary);
        interactor.execute(inputData);
    }
}