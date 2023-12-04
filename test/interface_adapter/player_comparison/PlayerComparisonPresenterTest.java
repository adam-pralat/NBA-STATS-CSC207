package interface_adapter.player_comparison;

import interface_adapter.ViewManagerModel;
import entity.Player;
import interface_adapter.home_page.HomePagePresenter;
import interface_adapter.home_page.HomePageState;
import interface_adapter.home_page.HomePageViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.home_page.HomePageOutputData;
import use_case.player_comparison.PlayerComparisonOutputData;

import static org.junit.jupiter.api.Assertions.*;

class PlayerComparisonPresenterTest {
        private PlayerComparisonViewModel viewModel;
        private ViewManagerModel viewManagerModel;
        private PlayerComparisonPresenter presenter;

        @BeforeEach
        void setUp() {
            viewModel = new PlayerComparisonViewModel();
            viewManagerModel = new ViewManagerModel();
            presenter = new PlayerComparisonPresenter(viewManagerModel, viewModel);
        }

        @Test
        void prepareSuccessView() {
            Player player1 = new Player(
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

            Player player2 = new Player(
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

            PlayerComparisonOutputData outputData = new PlayerComparisonOutputData(player1.toMap(), player2.toMap(), false);
            presenter.prepareSuccessView(outputData);
            PlayerComparisonState state = new PlayerComparisonState(viewModel.getState()); // Test copy constructor

// Profile information for Player 1
            assertEquals(player1.getFirstName(), state.getFirstName());
            assertEquals(player1.getLastName(), state.getLastName());
            assertEquals(player1.getBirthDate(), state.getBirthDate());
            assertEquals(player1.getCountry(), state.getCountry());
            assertEquals(String.valueOf(player1.getHeight()), state.getHeight());
            assertEquals(String.valueOf(player1.getWeight()), state.getWeight());

// Player 1 information
            assertEquals(player1.getTeam(), state.getTeam());
            assertEquals(player1.getPosition(), state.getPosition());

// Statistic metrics for Player 1
            assertEquals(String.valueOf(player1.getGamesPlayed()), state.getGamesPlayed());
            assertEquals(String.valueOf(player1.getPoints()), state.getPoints());
            assertEquals(String.valueOf(player1.getAssists()), state.getAssists());
            assertEquals(String.valueOf(player1.getTimePlayed()), state.getTimePlayed());
            assertEquals(String.valueOf(player1.getFieldGoalsMade()), state.getFieldGoalsMade());
            assertEquals(String.valueOf(player1.getFieldGoalsAttempted()), state.getFieldGoalsAttempted());
            assertEquals(String.valueOf(player1.getFreeThrowsMade()), state.getFreeThrowsMade());
            assertEquals(String.valueOf(player1.getFreeThrowsAttempted()), state.getFreeThrowsAttempted());
            assertEquals(String.valueOf(player1.getThreePointsMade()), state.getThreePointsMade());
            assertEquals(String.valueOf(player1.getThreePointsAttempted()), state.getThreePointsAttempted());
            assertEquals(String.valueOf(player1.getOffensiveRebounds()), state.getOffensiveRebounds());
            assertEquals(String.valueOf(player1.getDefensiveRebounds()), state.getDefensiveRebounds());
            assertEquals(String.valueOf(player1.getPersonalFouls()), state.getPersonalFouls());
            assertEquals(String.valueOf(player1.getSteals()), state.getSteals());
            assertEquals(String.valueOf(player1.getTurnovers()), state.getTurnovers());
            assertEquals(String.valueOf(player1.getBlocks()), state.getBlocks());
            assertEquals(String.valueOf(player1.getPlusMinus()), state.getPlusMinus());

// Statistic metrics for per game for Player 1
            assertEquals(String.valueOf(player1.pointsPerGame()), state.getPointsPerGame());
            assertEquals(String.valueOf(player1.assistsPerGame()), state.getAssistsPerGame());
            assertEquals(String.valueOf(player1.timePlayedPerGame()), state.getTimePlayedPerGame());
            assertEquals(String.valueOf(player1.fieldGoalsMadePerGame()), state.getFieldGoalsMadePerGame());
            assertEquals(String.valueOf(player1.fieldGoalsAttemptedPerGame()), state.getFieldGoalsAttemptedPerGame());
            assertEquals(String.valueOf(player1.freeThrowsMadePerGame()), state.getFreeThrowsMadePerGame());
            assertEquals(String.valueOf(player1.freeThrowsAttemptedPerGame()), state.getFreeThrowsAttemptedPerGame());
            assertEquals(String.valueOf(player1.threePointsMadePerGame()), state.getThreePointsMadePerGame());
            assertEquals(String.valueOf(player1.threePointsAttemptedPerGame()), state.getThreePointsAttemptedPerGame());
            assertEquals(String.valueOf(player1.offensiveReboundsPerGame()), state.getOffensiveReboundsPerGame());
            assertEquals(String.valueOf(player1.defensiveReboundsPerGame()), state.getDefensiveReboundsPerGame());
            assertEquals(String.valueOf(player1.reboundsPerGame()), state.getReboundsPerGame());
            assertEquals(String.valueOf(player1.personalFoulsPerGame()), state.getPersonalFoulsPerGame());
            assertEquals(String.valueOf(player1.stealsPerGame()), state.getStealsPerGame());
            assertEquals(String.valueOf(player1.turnoversPerGame()), state.getTurnoversPerGame());
            assertEquals(String.valueOf(player1.blocksPerGame()), state.getBlocksPerGame());

// Percentage metrics for Player 1
            assertEquals(String.valueOf(player1.freeThrowPercentage()), state.getFreeThrowPercentage());
            assertEquals(String.valueOf(player1.fieldGoalPercentage()), state.getFieldGoalPercentage());
            assertEquals(String.valueOf(player1.threePointPercentage()), state.getThreePointPercentage());

// Profile information for Player 2
            assertEquals(player2.getFirstName(), state.getFirstName1());
            assertEquals(player2.getLastName(), state.getLastName1());
            assertEquals(player2.getBirthDate(), state.getBirthDate1());
            assertEquals(player2.getCountry(), state.getCountry1());
            assertEquals(String.valueOf(player2.getHeight()), state.getHeight1());
            assertEquals(String.valueOf(player2.getWeight()), state.getWeight1());

// Player 2 information
            assertEquals(player2.getTeam(), state.getTeam1());
            assertEquals(player2.getPosition(), state.getPosition1());

// Statistic metrics for Player 2
            assertEquals(String.valueOf(player2.getGamesPlayed()), state.getGamesPlayed1());
            assertEquals(String.valueOf(player2.getPoints()), state.getPoints1());
            assertEquals(String.valueOf(player2.getAssists()), state.getAssists1());
            assertEquals(String.valueOf(player2.getTimePlayed()), state.getTimePlayed1());
            assertEquals(String.valueOf(player2.getFieldGoalsMade()), state.getFieldGoalsMade1());
            assertEquals(String.valueOf(player2.getFieldGoalsAttempted()), state.getFieldGoalsAttempted1());
            assertEquals(String.valueOf(player2.getFreeThrowsMade()), state.getFreeThrowsMade1());
            assertEquals(String.valueOf(player2.getFreeThrowsAttempted()), state.getFreeThrowsAttempted1());
            assertEquals(String.valueOf(player2.getThreePointsMade()), state.getThreePointsMade1());
            assertEquals(String.valueOf(player2.getThreePointsAttempted()), state.getThreePointsAttempted1());
            assertEquals(String.valueOf(player2.getOffensiveRebounds()), state.getOffensiveRebounds1());
            assertEquals(String.valueOf(player2.getDefensiveRebounds()), state.getDefensiveRebounds1());
            assertEquals(String.valueOf(player2.getPersonalFouls()), state.getPersonalFouls1());
            assertEquals(String.valueOf(player2.getSteals()), state.getSteals1());
            assertEquals(String.valueOf(player2.getTurnovers()), state.getTurnovers1());
            assertEquals(String.valueOf(player2.getBlocks()), state.getBlocks1());
            assertEquals(String.valueOf(player2.getPlusMinus()), state.getPlusMinus1());

// Statistic metrics for per game for Player 2
            assertEquals(String.valueOf(player2.pointsPerGame()), state.getPointsPerGame1());
            assertEquals(String.valueOf(player2.assistsPerGame()), state.getAssistsPerGame1());
            assertEquals(String.valueOf(player2.timePlayedPerGame()), state.getTimePlayedPerGame1());
            assertEquals(String.valueOf(player2.fieldGoalsMadePerGame()), state.getFieldGoalsMadePerGame1());
            assertEquals(String.valueOf(player2.fieldGoalsAttemptedPerGame()), state.getFieldGoalsAttemptedPerGame1());
            assertEquals(String.valueOf(player2.freeThrowsMadePerGame()), state.getFreeThrowsMadePerGame1());
            assertEquals(String.valueOf(player2.freeThrowsAttemptedPerGame()), state.getFreeThrowsAttemptedPerGame1());
            assertEquals(String.valueOf(player2.threePointsMadePerGame()), state.getThreePointsMadePerGame1());
            assertEquals(String.valueOf(player2.threePointsAttemptedPerGame()), state.getThreePointsAttemptedPerGame1());
            assertEquals(String.valueOf(player2.offensiveReboundsPerGame()), state.getOffensiveReboundsPerGame1());
            assertEquals(String.valueOf(player2.defensiveReboundsPerGame()), state.getDefensiveReboundsPerGame1());
            assertEquals(String.valueOf(player2.reboundsPerGame()), state.getReboundsPerGame1());
            assertEquals(String.valueOf(player2.personalFoulsPerGame()), state.getPersonalFoulsPerGame1());
            assertEquals(String.valueOf(player2.stealsPerGame()), state.getStealsPerGame1());
            assertEquals(String.valueOf(player2.turnoversPerGame()), state.getTurnoversPerGame1());
            assertEquals(String.valueOf(player2.blocksPerGame()), state.getBlocksPerGame1());

// Percentage metrics for Player 2
            assertEquals(String.valueOf(player2.freeThrowPercentage()), state.getFreeThrowPercentage1());
            assertEquals(String.valueOf(player2.fieldGoalPercentage()), state.getFieldGoalPercentage1());
            assertEquals(String.valueOf(player2.threePointPercentage()), state.getThreePointPercentage1());


        }

        @Test
        void prepareFailView() {
            presenter.prepareFailView("Sorry, we could not compare the players that you selected. Please try again");
            PlayerComparisonState state = viewModel.getState();
            assertEquals("Sorry, we could not compare the players that you selected. Please try again", state.getPlayerComparisonError());
        }
}