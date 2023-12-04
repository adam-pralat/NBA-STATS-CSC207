package interface_adapter.home_page;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.home_page.HomePageOutputData;

import static org.junit.jupiter.api.Assertions.*;

class HomePagePresenterTest {
    private HomePageViewModel viewModel;
    private ViewManagerModel viewManagerModel;
    private HomePagePresenter presenter;

    @BeforeEach
    void setUp() {
        viewModel = new HomePageViewModel();
        viewManagerModel = new ViewManagerModel();
        presenter = new HomePagePresenter(viewModel, viewManagerModel);
    }

    @Test
    void prepareSuccessView() {
        HomePageOutputData sampleResponse = new HomePageOutputData(
                "John",
                "Doe",
                "1990-05-15",
                "USA",
                "Team A",
                25.5, // Points per game
                6.3, // Assists per game
                85.5, // Free throw percentage
                48.7, // Field goal percentage
                40.2, // Three-point percentage
                32.8, // Minutes played per game
                1.5, // Steals per game
                2.2, // Turnovers per game
                0.8, // Blocks per game
                "Team A",
                "Awesome Team",
                "TMA",
                "Western Conference",
                50, // Team wins
                20, // Team losses
                7, // Team wins last ten games
                3, // Team losses last ten games
                2, // Conference place
                110.8, // Team points per game
                78.5, // Team free throw percentage
                45.3, // Team field goal percentage
                33.6, // Team three-point percentage
                false // Use case not failed
        );

        presenter.prepareSuccessView(sampleResponse);
        HomePageState state = new HomePageState(viewModel.getState()); // Test copy constructor

        assertEquals("John", state.getPlayerFirstName());
        assertEquals("Doe", state.getPlayerLastName());
        assertEquals("1990-05-15", state.getPlayerBirthDate());
        assertEquals("USA", state.getPlayerCountry());
        assertEquals("Team A", state.getPlayerTeam());
        assertEquals(25.5, state.getPlayerPointsPerGame());
        assertEquals(6.3, state.getPlayerAssistsPerGame());
        assertEquals(85.5, state.getPlayerFreeThrowPercentage());
        assertEquals(48.7, state.getPlayerFieldGoalPercentage());
        assertEquals(40.2, state.getPlayerThreePointPercentage());
        assertEquals(32.8, state.getPlayerMinutesPlayedPerGame());
        assertEquals(1.5, state.getPlayerStealsPerGame());
        assertEquals(0.8, state.getPlayerBlocksPerGame());
        assertEquals("Team A", state.getTeamName());
        assertEquals("Awesome Team", state.getTeamNickname());
        assertEquals("TMA", state.getTeamCode());
        assertEquals("Western Conference", state.getConference());
        assertEquals(50, state.getTeamWins());
        assertEquals(20, state.getTeamLosses());
        assertEquals(7, state.getTeamsWinsLastTen());
        assertEquals(3, state.getTeamsLossesLastTen());
        assertEquals(2, state.getConferencePlace());
        assertEquals(110.8, state.getTeamPointsPerGame());
        assertEquals(78.5, state.getTeamFreeThrowPercentage());
        assertEquals(45.3, state.getTeamFieldGoalPercentage());
        assertEquals(33.6, state.getTeamThreePointPercentage());
        assertFalse(state.isUseCaseFailed()); // Ensure use case failed is false
        assertEquals(null, state.getError()); // Ensure error is null or empty
    }

    @Test
    void prepareFailView() {
        presenter.prepareFailView("Error Message");
        HomePageState state = viewModel.getState();
        assertEquals("Error Message", state.getError());
    }
}