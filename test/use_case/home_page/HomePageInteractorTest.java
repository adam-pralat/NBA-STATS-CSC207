package use_case.home_page;

import data_access.TestDAO;
import data_access.TestDAOErrors;
import junit.framework.TestCase;
import org.junit.Test;

public class HomePageInteractorTest extends TestCase {
    @Test
    public void testExecuteSuccess() {
        HomePageInputData inputData = new HomePageInputData();
        HomePageDataAccessInterface homeDAO = new TestDAO();
        HomePageOutputBoundary outputBoundary = new HomePageOutputBoundary() {
            @Override
            public void prepareSuccessView(HomePageOutputData response) {
                assertEquals(response.getPlayerFirstName(), "A");
                assertEquals(response.getPlayerLastName(), "B");
                assertEquals(response.getPlayerBirthDate(), "2000-01-01");
                assertEquals(response.getPlayerCountry(), "Canada");
                assertEquals(response.getPlayerTeam(), "Toronto Raptors");
                assertEquals(response.getPlayerPointsPerGame(), 1.0);
                assertEquals(response.getPlayerAssistsPerGame(), 1.0);
                assertEquals(response.getPlayerFreeThrowPercentage(), 100.0);
                assertEquals(response.getPlayerFieldGoalPercentage(), 100.0);
                assertEquals(response.getPlayerThreePointPercentage(), 100.0);
                assertEquals(response.getPlayerTurnoversPerGame(), 1.0);
                assertEquals(response.getPlayerStealsPerGame(), 1.0);
                assertEquals(response.getPlayerBlocksPerGame(), 1.0); // Note, ignored turnovers for now
                assertEquals(response.getPlayerMinutesPlayedPerGame(), 1.0);

                assertEquals(response.getTeamName(), "Name");
                assertEquals(response.getTeamNickname(), "Nickname");
                assertEquals(response.getTeamCode(), "AAA");
                assertEquals(response.getConference(), "Conference");
                assertEquals(response.getTeamWins(), 1);
                assertEquals(response.getTeamLosses(), 0);
                assertEquals(response.getTeamsWinsLastTen(), 1);
                assertEquals(response.getTeamsLossesLastTen(), 0);
                assertEquals(response.getConferencePlace(), 1);
                assertEquals(response.getTeamPointsPerGame(), 4.0);
                assertEquals(response.getTeamFreeThrowPercentage(), 100.0);
                assertEquals(response.getTeamFieldGoalPercentage(), 100.0);
                assertEquals(response.getTeamThreePointPercentage(), 100.0);
                assertEquals(response.isUseCaseFailed(), false);
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected fail");
            }
        };
        HomePageInputBoundary interactor = new HomePageInteractor(homeDAO, outputBoundary);
        interactor.execute(inputData);
    }

    @Test
    public void testExecuteFail() {
        HomePageInputData inputData = new HomePageInputData();
        HomePageDataAccessInterface homeDAO = new TestDAOErrors();
        HomePageOutputBoundary outputBoundary = new HomePageOutputBoundary() {
            @Override
            public void prepareSuccessView(HomePageOutputData response) {
                fail("Unexpected success");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Error in accessing data.", error);
            }
        };
        HomePageInputBoundary interactor = new HomePageInteractor(homeDAO, outputBoundary);
        interactor.execute(inputData);
    }
}