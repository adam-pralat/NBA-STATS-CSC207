package use_case.schedule;

import data_access.TestDAO;
import data_access.TestDAOErrors;
import entity.Game;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;

public class ScheduleInteractorTest extends TestCase {

    public void testSuccess() {
        ScheduleInputData inputData = new ScheduleInputData(LocalDate.of(2023, 11, 16));
        ScheduleDataAccessInterface scheduleDAO = new TestDAO();
        ScheduleOutputBoundary successPresenter = new ScheduleOutputBoundary() {
            @Override
            public void prepareSuccessView(ScheduleOutputData outputData) {
                // Checks that the output date is correct
                assertEquals(outputData.getDate(), LocalDate.of(2023, 11, 16));

                // Checks that the output games are correct
                Map<Integer, Game> games = outputData.getGames();

                Game game1 = games.get(12714);
                assertEquals(12714 ,game1.getId());
                assertEquals(LocalDateTime.of(2023, 11, 16, 18, 30), game1.getDateTime());
                assertEquals("Finished", game1.getStatus());
                assertEquals("Kaseya Center, Miami, FL", game1.getLocation());
                assertEquals(20, game1.getHomeTeamID());
                assertEquals("Miami Heat", game1.getHomeTeamName());
                assertEquals("MIA", game1.getHomeTeamCode());
                assertEquals("https://upload.wikimedia.org/wikipedia/fr/thumb/1/1c/Miami_Heat_-_Logo.svg/1200px-Miami_Heat_-_Logo.svg.png", game1.getHomeTeamLogo());
                assertEquals(122, game1.getHomeTeamPoints());
                assertEquals(4, game1.getAwayTeamID());
                assertEquals("Brooklyn Nets", game1.getAwayTeamName());
                assertEquals("BKN", game1.getAwayTeamCode());
                assertEquals("https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Brooklyn_Nets_newlogo.svg/130px-Brooklyn_Nets_newlogo.svg.png", game1.getAwayTeamLogo());
                assertEquals(115, game1.getAwayTeamPoints());

                Game game2 = games.get(12715);
                assertEquals(12715 ,game2.getId());
                assertEquals(LocalDateTime.of(2023, 11, 16, 21, 0), game2.getDateTime());
                assertEquals("Finished", game2.getStatus());
                assertEquals("Chase Center, San Francisco, CA", game2.getLocation());
                assertEquals(11, game2.getHomeTeamID());
                assertEquals("Golden State Warriors", game2.getHomeTeamName());
                assertEquals("GSW", game2.getHomeTeamCode());
                assertEquals("https://upload.wikimedia.org/wikipedia/fr/thumb/d/de/Warriors_de_Golden_State_logo.svg/1200px-Warriors_de_Golden_State_logo.svg.png", game2.getHomeTeamLogo());
                assertEquals(109, game2.getHomeTeamPoints());
                assertEquals(25, game2.getAwayTeamID());
                assertEquals("Oklahoma City Thunder", game2.getAwayTeamName());
                assertEquals("OKC", game2.getAwayTeamCode());
                assertEquals("https://upload.wikimedia.org/wikipedia/fr/thumb/4/4f/Thunder_d%27Oklahoma_City_logo.svg/1200px-Thunder_d%27Oklahoma_City_logo.svg.png", game2.getAwayTeamLogo());
                assertEquals(128, game2.getAwayTeamPoints());

                // Checks that the use case passed
                assertFalse(outputData.isUseCaseFailed());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        ScheduleInputBoundary interactor = new ScheduleInteractor(scheduleDAO, successPresenter);
        interactor.execute(inputData);
    }

    public void testRuntimeException() {
        ScheduleInputData inputData = new ScheduleInputData(LocalDate.of(2023, 11, 16));
        ScheduleDataAccessInterface scheduleDAO = new TestDAOErrors();
        ScheduleOutputBoundary failurePresenter = new ScheduleOutputBoundary() {
            @Override
            public void prepareSuccessView(ScheduleOutputData scheduleOutputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Runtime error.", error);
            }
        };
        ScheduleInputBoundary interactor = new ScheduleInteractor(scheduleDAO, failurePresenter);
        interactor.execute(inputData);
    }
}