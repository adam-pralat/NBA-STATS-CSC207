package interface_adapter.player_stats;

import entity.Player;
import interface_adapter.ViewManagerModel;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonPresenter;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonState;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.player_stats.PlayerStatsOutputData;

import static org.junit.jupiter.api.Assertions.*;

class PlayerStatsPresenterTest {
    private PlayerStatsViewModel viewModel;
    private ViewManagerModel viewManagerModel;
    private PlayerStatsPresenter presenter;

    @BeforeEach
    void setUp() {
        viewModel = new PlayerStatsViewModel();
        viewManagerModel = new ViewManagerModel();
        presenter = new PlayerStatsPresenter(viewManagerModel, viewModel);
    }

    @Test
    void prepareSuccessView() {
        Player player = new Player(
                1,
                "FillerFirst1",
                "FillerLast1",
                "1995-03-20",
                "FillerCountry1",
                2.01,
                95.5,
                "FillerTeam1",
                "Guard",
                23,
                true,
                30,
                450,
                120,
                900,
                180,
                300,
                90,
                120,
                30,
                60,
                40,
                10,
                15,
                25,
                5,
                10,
                5
        );
        PlayerStatsOutputData response = new PlayerStatsOutputData(player.toMap(), false);
        presenter.prepareSuccessView(response);
        PlayerStatsState state = new PlayerStatsState(viewModel.getState()); // Test Copy constructor

        // Profile information
        assertEquals(player.getFirstName(), state.getFirstName());
        assertEquals(player.getLastName(), state.getLastName());
        assertEquals(player.getBirthDate(), state.getBirthDate());
        assertEquals(player.getCountry(), state.getCountry());
        assertEquals(String.valueOf(player.getHeight()), state.getHeight());
        assertEquals(String.valueOf(player.getWeight()), state.getWeight());


// Statistic metrics
        assertEquals(String.valueOf(player.getGamesPlayed()), state.getGamesPlayed());
        assertEquals(String.valueOf(player.getPoints()), state.getPoints());
        assertEquals(String.valueOf(player.getAssists()), state.getAssists());
        assertEquals(String.valueOf(player.getTimePlayed()), state.getTimePlayed());
        assertEquals(String.valueOf(player.getFieldGoalsMade()), state.getFieldGoalsMade());
        assertEquals(String.valueOf(player.getFieldGoalsAttempted()), state.getFieldGoalsAttempted());
        assertEquals(String.valueOf(player.getFreeThrowsMade()), state.getFreeThrowsMade());
        assertEquals(String.valueOf(player.getFreeThrowsAttempted()), state.getFreeThrowsAttempted());
        assertEquals(String.valueOf(player.getThreePointsMade()), state.getThreePointsMade());
        assertEquals(String.valueOf(player.getThreePointsAttempted()), state.getThreePointsAttempted());
        assertEquals(String.valueOf(player.getOffensiveRebounds()), state.getOffensiveRebounds());
        assertEquals(String.valueOf(player.getDefensiveRebounds()), state.getDefensiveRebounds());
        assertEquals(String.valueOf(player.getPersonalFouls()), state.getPersonalFouls());
        assertEquals(String.valueOf(player.getSteals()), state.getSteals());
        assertEquals(String.valueOf(player.getTurnovers()), state.getTurnovers());
        assertEquals(String.valueOf(player.getBlocks()), state.getBlocks());
        assertEquals(String.valueOf(player.getPlusMinus()), state.getPlusMinus());

// Statistic metrics for per game
        assertEquals(String.valueOf(player.pointsPerGame()), state.getPointsPerGame());
        assertEquals(String.valueOf(player.assistsPerGame()), state.getAssistsPerGame());
        assertEquals(String.valueOf(player.timePlayedPerGame()), state.getTimePlayedPerGame());
        assertEquals(String.valueOf(player.fieldGoalsMadePerGame()), state.getFieldGoalsMadePerGame());
        assertEquals(String.valueOf(player.fieldGoalsAttemptedPerGame()), state.getFieldGoalsAttemptedPerGame());
        assertEquals(String.valueOf(player.freeThrowsMadePerGame()), state.getFreeThrowsMadePerGame());
        assertEquals(String.valueOf(player.freeThrowsAttemptedPerGame()), state.getFreeThrowsAttemptedPerGame());
        assertEquals(String.valueOf(player.threePointsMadePerGame()), state.getThreePointsMadePerGame());
        assertEquals(String.valueOf(player.threePointsAttemptedPerGame()), state.getThreePointsAttemptedPerGame());
        assertEquals(String.valueOf(player.offensiveReboundsPerGame()), state.getOffensiveReboundsPerGame());
        assertEquals(String.valueOf(player.defensiveReboundsPerGame()), state.getDefensiveReboundsPerGame());
        assertEquals(String.valueOf(player.reboundsPerGame()), state.getReboundsPerGame());
        assertEquals(String.valueOf(player.personalFoulsPerGame()), state.getPersonalFoulsPerGame());
        assertEquals(String.valueOf(player.stealsPerGame()), state.getStealsPerGame());
        assertEquals(String.valueOf(player.turnoversPerGame()), state.getTurnoversPerGame());
        assertEquals(String.valueOf(player.blocksPerGame()), state.getBlocksPerGame());

// Percentage metrics
        assertEquals(String.valueOf(player.freeThrowPercentage()), state.getFreeThrowPercentage());
        assertEquals(String.valueOf(player.fieldGoalPercentage()), state.getFieldGoalPercentage());
        assertEquals(String.valueOf(player.threePointPercentage()), state.getThreePointPercentage());

    }

    @Test
    void prepareFailView() {
        presenter.prepareFailView("Sorry, we could not get the stats for the player you requested. Please try again.");
        PlayerStatsState state = viewModel.getState();
        assertEquals("Sorry, we could not get the stats for the player you requested. Please try again.", state.getPlayerStatsError());
    }
}