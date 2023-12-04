package interface_adapter.player_season_comparison;

import entity.Player;
import interface_adapter.ViewManagerModel;
import interface_adapter.player_comparison.PlayerComparisonPresenter;
import interface_adapter.player_comparison.PlayerComparisonState;
import interface_adapter.player_comparison.PlayerComparisonViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.player_comparison.PlayerComparisonOutputData;
import use_case.player_season_comparison.PlayerSeasonComparisonOutputData;

import static org.junit.jupiter.api.Assertions.*;

class PlayerSeasonComparisonPresenterTest {
    private PlayerSeasonComparisonViewModel viewModel;
    private ViewManagerModel viewManagerModel;
    private PlayerSeasonComparisonPresenter presenter;

    @BeforeEach
    void setUp() {
        viewModel = new PlayerSeasonComparisonViewModel();
        viewManagerModel = new ViewManagerModel();
        presenter = new PlayerSeasonComparisonPresenter(viewManagerModel, viewModel);
    }

    @Test
    void prepareSuccessView() {
        Player playerSeason1 = new Player(
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

        Player playerSeason2 = new Player(
                2,
                "FillerFirst2",
                "FillerLast2",
                "1998-06-15",
                "FillerCountry2",
                2.10,
                100.0,
                "FillerTeam2",
                "Forward",
                99,
                false,
                20,
                300,
                80,
                600,
                120,
                200,
                60,
                80,
                20,
                40,
                30,
                8,
                10,
                15,
                3,
                8,
                3
        );

        PlayerSeasonComparisonOutputData outputData = new PlayerSeasonComparisonOutputData(playerSeason1.toMap(), playerSeason2.toMap(), false);
        presenter.prepareSuccessView(outputData);
        PlayerSeasonComparisonState state = new PlayerSeasonComparisonState(viewModel.getState()); // Test copy constructor
        // Profile information for Player 1
        assertEquals(playerSeason1.getFirstName(), state.getFirstName());
        assertEquals(playerSeason1.getLastName(), state.getLastName());
        assertEquals(playerSeason1.getBirthDate(), state.getBirthDate());
        assertEquals(playerSeason1.getCountry(), state.getCountry());
        assertEquals(String.valueOf(playerSeason1.getHeight()), state.getHeight());
        assertEquals(String.valueOf(playerSeason1.getWeight()), state.getWeight());

// Statistic metrics for Player 1
        assertEquals(String.valueOf(playerSeason1.getGamesPlayed()), state.getGamesPlayed());
        assertEquals(String.valueOf(playerSeason1.getPoints()), state.getPoints());
        assertEquals(String.valueOf(playerSeason1.getAssists()), state.getAssists());
        assertEquals(String.valueOf(playerSeason1.minutesPlayed()), state.getTimePlayed());
        assertEquals(String.valueOf(playerSeason1.getFieldGoalsMade()), state.getFieldGoalsMade());
        assertEquals(String.valueOf(playerSeason1.getFieldGoalsAttempted()), state.getFieldGoalsAttempted());
        assertEquals(String.valueOf(playerSeason1.getFreeThrowsMade()), state.getFreeThrowsMade());
        assertEquals(String.valueOf(playerSeason1.getFreeThrowsAttempted()), state.getFreeThrowsAttempted());
        assertEquals(String.valueOf(playerSeason1.getThreePointsMade()), state.getThreePointsMade());
        assertEquals(String.valueOf(playerSeason1.getThreePointsAttempted()), state.getThreePointsAttempted());
        assertEquals(String.valueOf(playerSeason1.getOffensiveRebounds()), state.getOffensiveRebounds());
        assertEquals(String.valueOf(playerSeason1.getDefensiveRebounds()), state.getDefensiveRebounds());
        assertEquals(String.valueOf(playerSeason1.getPersonalFouls()), state.getPersonalFouls());
        assertEquals(String.valueOf(playerSeason1.getSteals()), state.getSteals());
        assertEquals(String.valueOf(playerSeason1.getTurnovers()), state.getTurnovers());
        assertEquals(String.valueOf(playerSeason1.getBlocks()), state.getBlocks());
        assertEquals(String.valueOf(playerSeason1.getPlusMinus()), state.getPlusMinus());

// Statistic metrics for per game for Player season 1
        assertEquals(String.valueOf(playerSeason1.pointsPerGame()), state.getPointsPerGame());
        assertEquals(String.valueOf(playerSeason1.assistsPerGame()), state.getAssistsPerGame());
        assertEquals(String.valueOf(playerSeason1.minutesPerGame()), state.getTimePlayedPerGame());
        assertEquals(String.valueOf(playerSeason1.fieldGoalsMadePerGame()), state.getFieldGoalsMadePerGame());
        assertEquals(String.valueOf(playerSeason1.fieldGoalsAttemptedPerGame()), state.getFieldGoalsAttemptedPerGame());
        assertEquals(String.valueOf(playerSeason1.freeThrowsMadePerGame()), state.getFreeThrowsMadePerGame());
        assertEquals(String.valueOf(playerSeason1.freeThrowsAttemptedPerGame()), state.getFreeThrowsAttemptedPerGame());
        assertEquals(String.valueOf(playerSeason1.threePointsMadePerGame()), state.getThreePointsMadePerGame());
        assertEquals(String.valueOf(playerSeason1.threePointsAttemptedPerGame()), state.getThreePointsAttemptedPerGame());
        assertEquals(String.valueOf(playerSeason1.offensiveReboundsPerGame()), state.getOffensiveReboundsPerGame());
        assertEquals(String.valueOf(playerSeason1.defensiveReboundsPerGame()), state.getDefensiveReboundsPerGame());
        assertEquals(String.valueOf(playerSeason1.reboundsPerGame()), state.getReboundsPerGame());
        assertEquals(String.valueOf(playerSeason1.personalFoulsPerGame()), state.getPersonalFoulsPerGame());
        assertEquals(String.valueOf(playerSeason1.stealsPerGame()), state.getStealsPerGame());
        assertEquals(String.valueOf(playerSeason1.turnoversPerGame()), state.getTurnoversPerGame());
        assertEquals(String.valueOf(playerSeason1.blocksPerGame()), state.getBlocksPerGame());

// Percentage metrics for Player season 1
        assertEquals(String.valueOf(playerSeason1.freeThrowPercentage()), state.getFreeThrowPercentage());
        assertEquals(String.valueOf(playerSeason1.fieldGoalPercentage()), state.getFieldGoalPercentage());
        assertEquals(String.valueOf(playerSeason1.threePointPercentage()), state.getThreePointPercentage());


// Statistic metrics for Player season 2
        assertEquals(String.valueOf(playerSeason2.getGamesPlayed()), state.getGamesPlayed1());
        assertEquals(String.valueOf(playerSeason2.getPoints()), state.getPoints1());
        assertEquals(String.valueOf(playerSeason2.getAssists()), state.getAssists1());
        assertEquals(String.valueOf(playerSeason2.minutesPlayed()), state.getTimePlayed1());
        assertEquals(String.valueOf(playerSeason2.getFieldGoalsMade()), state.getFieldGoalsMade1());
        assertEquals(String.valueOf(playerSeason2.getFieldGoalsAttempted()), state.getFieldGoalsAttempted1());
        assertEquals(String.valueOf(playerSeason2.getFreeThrowsMade()), state.getFreeThrowsMade1());
        assertEquals(String.valueOf(playerSeason2.getFreeThrowsAttempted()), state.getFreeThrowsAttempted1());
        assertEquals(String.valueOf(playerSeason2.getThreePointsMade()), state.getThreePointsMade1());
        assertEquals(String.valueOf(playerSeason2.getThreePointsAttempted()), state.getThreePointsAttempted1());
        assertEquals(String.valueOf(playerSeason2.getOffensiveRebounds()), state.getOffensiveRebounds1());
        assertEquals(String.valueOf(playerSeason2.getDefensiveRebounds()), state.getDefensiveRebounds1());
        assertEquals(String.valueOf(playerSeason2.getPersonalFouls()), state.getPersonalFouls1());
        assertEquals(String.valueOf(playerSeason2.getSteals()), state.getSteals1());
        assertEquals(String.valueOf(playerSeason2.getTurnovers()), state.getTurnovers1());
        assertEquals(String.valueOf(playerSeason2.getBlocks()), state.getBlocks1());
        assertEquals(String.valueOf(playerSeason2.getPlusMinus()), state.getPlusMinus1());

// Statistic metrics for per game for Player season 2
        assertEquals(String.valueOf(playerSeason2.pointsPerGame()), state.getPointsPerGame1());
        assertEquals(String.valueOf(playerSeason2.assistsPerGame()), state.getAssistsPerGame1());
        assertEquals(String.valueOf(playerSeason2.minutesPerGame()), state.getTimePlayedPerGame1());
        assertEquals(String.valueOf(playerSeason2.fieldGoalsMadePerGame()), state.getFieldGoalsMadePerGame1());
        assertEquals(String.valueOf(playerSeason2.fieldGoalsAttemptedPerGame()), state.getFieldGoalsAttemptedPerGame1());
        assertEquals(String.valueOf(playerSeason2.freeThrowsMadePerGame()), state.getFreeThrowsMadePerGame1());
        assertEquals(String.valueOf(playerSeason2.freeThrowsAttemptedPerGame()), state.getFreeThrowsAttemptedPerGame1());
        assertEquals(String.valueOf(playerSeason2.threePointsMadePerGame()), state.getThreePointsMadePerGame1());
        assertEquals(String.valueOf(playerSeason2.threePointsAttemptedPerGame()), state.getThreePointsAttemptedPerGame1());
        assertEquals(String.valueOf(playerSeason2.offensiveReboundsPerGame()), state.getOffensiveReboundsPerGame1());
        assertEquals(String.valueOf(playerSeason2.defensiveReboundsPerGame()), state.getDefensiveReboundsPerGame1());
        assertEquals(String.valueOf(playerSeason2.reboundsPerGame()), state.getReboundsPerGame1());
        assertEquals(String.valueOf(playerSeason2.personalFoulsPerGame()), state.getPersonalFoulsPerGame1());
        assertEquals(String.valueOf(playerSeason2.stealsPerGame()), state.getStealsPerGame1());
        assertEquals(String.valueOf(playerSeason2.turnoversPerGame()), state.getTurnoversPerGame1());
        assertEquals(String.valueOf(playerSeason2.blocksPerGame()), state.getBlocksPerGame1());
    }

    @Test
    void prepareFailView() {
        presenter.prepareFailView("Sorry, we could not get the season stats for the player you requested. Please try again.");
        PlayerSeasonComparisonState state = viewModel.getState();
        assertEquals("Sorry, we could not get the season stats for the player you requested. Please try again.", state.getPlayerSeasonComparisonError());
    }
}