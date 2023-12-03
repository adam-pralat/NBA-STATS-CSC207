package interface_adapter.player_comparison;

import interface_adapter.ViewManagerModel;
import org.json.JSONObject;
import use_case.player_comparison.PlayerComparisonOutputBoundary;
import use_case.player_comparison.PlayerComparisonOutputData;

import java.util.Map;

public class PlayerComparisonPresenter implements PlayerComparisonOutputBoundary {

    private final PlayerComparisonViewModel playerComparisonViewModel;
    private ViewManagerModel viewManagerModel;
    private Object jsonNull = JSONObject.NULL;

    public PlayerComparisonPresenter(ViewManagerModel viewManagerModel,
                                     PlayerComparisonViewModel playerComparisonViewModel){
        this.viewManagerModel = viewManagerModel;
        this.playerComparisonViewModel = playerComparisonViewModel;
    }

    @Override
    public void prepareSuccessView(PlayerComparisonOutputData response) {
        // Change playerStats1 and playerStats2 state
        Map<String, Object> playerStats1 = response.getPlayerStats1();
        Map<String, Object> playerStats2 = response.getPlayerStats2();

        // Get State
        PlayerComparisonState state = this.playerComparisonViewModel.getState();

        // Set all state attributes. If an attribute is null, it is set to be an empty string
        // Basic attributes for Player 1
        state.setFirstName((playerStats1.get("firstName") != jsonNull) ? (playerStats1.get("firstName").toString()) : (""));
        state.setLastName((playerStats1.get("lastName") != jsonNull) ? (playerStats1.get("lastName").toString()) : (""));
        state.setBirthDate((playerStats1.get("birthDate") != jsonNull) ? (playerStats1.get("birthDate").toString()) : (""));
        state.setCountry((playerStats1.get("country") != jsonNull) ? (playerStats1.get("country").toString()) : (""));
        state.setHeight((playerStats1.get("height") != jsonNull) ? (playerStats1.get("height").toString()) : (""));
        state.setWeight((playerStats1.get("weight") != jsonNull) ? (playerStats1.get("weight").toString()) : (""));
        state.setTeam((playerStats1.get("team") != jsonNull) ? (playerStats1.get("team").toString()) : (""));
        state.setPosition((playerStats1.get("position") != jsonNull) ? (playerStats1.get("position").toString()) : (""));

        // Cumulative statistics for Player 1
        state.setGamesPlayed((playerStats1.get("gamesPlayed") != jsonNull) ? (playerStats1.get("gamesPlayed").toString()) : (""));
        state.setPoints((playerStats1.get("points") != jsonNull) ? (playerStats1.get("points").toString()) : (""));
        state.setAssists((playerStats1.get("assists") != jsonNull) ? (playerStats1.get("assists").toString()) : (""));
        state.setTimePlayed((playerStats1.get("timePlayed") != jsonNull) ? (playerStats1.get("timePlayed").toString()) : ("")); // Convert to minutes/seconds
        state.setFieldGoalsMade((playerStats1.get("fieldGoalsMade") != jsonNull) ? (playerStats1.get("fieldGoalsMade").toString()) : (""));
        state.setFieldGoalsAttempted((playerStats1.get("fieldGoalsAttempted") != jsonNull) ? (playerStats1.get("fieldGoalsAttempted").toString()) : (""));
        state.setFreeThrowsMade((playerStats1.get("freeThrowsMade") != jsonNull) ? (playerStats1.get("freeThrowsMade").toString()) : (""));
        state.setFreeThrowsAttempted((playerStats1.get("freeThrowsAttempted") != jsonNull) ? (playerStats1.get("freeThrowsAttempted").toString()) : (""));
        state.setThreePointsMade((playerStats1.get("threePointsMade") != jsonNull) ? (playerStats1.get("threePointsMade").toString()) : (""));
        state.setThreePointsAttempted((playerStats1.get("threePointsAttempted") != jsonNull) ? (playerStats1.get("threePointsAttempted").toString()) : (""));
        state.setOffensiveRebounds((playerStats1.get("offensiveRebounds") != jsonNull) ? (playerStats1.get("offensiveRebounds").toString()) : (""));
        state.setDefensiveRebounds((playerStats1.get("defensiveRebounds") != jsonNull) ? (playerStats1.get("defensiveRebounds").toString()) : (""));
        state.setPersonalFouls((playerStats1.get("personalFouls") != jsonNull) ? (playerStats1.get("personalFouls").toString()) : (""));
        state.setSteals((playerStats1.get("steals") != jsonNull) ? (playerStats1.get("steals").toString()) : (""));
        state.setTurnovers((playerStats1.get("turnovers") != jsonNull) ? (playerStats1.get("turnovers").toString()) : (""));
        state.setBlocks((playerStats1.get("blocks") != jsonNull) ? (playerStats1.get("blocks").toString()) : (""));
        state.setPlusMinus((playerStats1.get("plusMinus") != jsonNull) ? (playerStats1.get("plusMinus").toString()) : (""));

        // Per game statistics for Player 1
        state.setPointsPerGame((playerStats1.get("pointsPerGame") != jsonNull) ? (playerStats1.get("pointsPerGame").toString()) : (""));
        state.setAssistsPerGame((playerStats1.get("assistsPerGame") != jsonNull) ? (playerStats1.get("assistsPerGame").toString()) : (""));
        state.setFieldGoalsMadePerGame((playerStats1.get("fieldGoalsMadePerGame") != jsonNull) ? (playerStats1.get("fieldGoalsMadePerGame").toString()) : (""));
        state.setFieldGoalsAttemptedPerGame((playerStats1.get("fieldGoalsAttemptedPerGame") != jsonNull) ? (playerStats1.get("fieldGoalsAttemptedPerGame").toString()) : (""));
        state.setFreeThrowsMadePerGame((playerStats1.get("freeThrowsMadePerGame") != jsonNull) ? (playerStats1.get("freeThrowsMadePerGame").toString()) : (""));
        state.setFreeThrowsAttemptedPerGame((playerStats1.get("freeThrowsAttemptedPerGame") != jsonNull) ? (playerStats1.get("freeThrowsAttemptedPerGame").toString()) : (""));
        state.setThreePointsMadePerGame((playerStats1.get("threePointsMadePerGame") != jsonNull) ? (playerStats1.get("threePointsMadePerGame").toString()) : (""));
        state.setThreePointsAttemptedPerGame((playerStats1.get("threePointsAttemptedPerGame") != jsonNull) ? (playerStats1.get("threePointsAttemptedPerGame").toString()) : (""));
        state.setDefensiveReboundsPerGame((playerStats1.get("defensiveReboundsPerGame") != jsonNull) ? (playerStats1.get("defensiveReboundsPerGame").toString()) : (""));
        state.setOffensiveReboundsPerGame((playerStats1.get("offensiveReboundsPerGame") != jsonNull) ? (playerStats1.get("offensiveReboundsPerGame").toString()) : (""));
        state.setReboundsPerGame((playerStats1.get("reboundsPerGame") != jsonNull) ? (playerStats1.get("reboundsPerGame").toString()) : (""));
        state.setPersonalFoulsPerGame((playerStats1.get("personalFoulsPerGame") != jsonNull) ? (playerStats1.get("personalFoulsPerGame").toString()) : (""));
        state.setStealsPerGame((playerStats1.get("stealsPerGame") != jsonNull) ? (playerStats1.get("stealsPerGame").toString()) : (""));
        state.setTurnoversPerGame((playerStats1.get("turnoversPerGame") != jsonNull) ? (playerStats1.get("turnoversPerGame").toString()) : (""));
        state.setBlocksPerGame((playerStats1.get("blocksPerGame") != jsonNull) ? (playerStats1.get("blocksPerGame").toString()) : (""));
        state.setTimePlayedPerGame((playerStats1.get("timePlayedPerGame") != jsonNull) ? (playerStats1.get("timePlayedPerGame").toString()) : (""));

        // Percentage metrics for Player 1
        state.setFreeThrowPercentage((playerStats1.get("freeThrowPercentage") != jsonNull) ? (playerStats1.get("freeThrowPercentage").toString()) : (""));
        state.setFieldGoalPercentage((playerStats1.get("fieldGoalPercentage") != jsonNull) ? (playerStats1.get("fieldGoalPercentage").toString()) : (""));
        state.setThreePointPercentage((playerStats1.get("threePointPercentage") != jsonNull) ? (playerStats1.get("threePointPercentage").toString()) : (""));

        //Basic attributes for Player 2
        state.setFirstName1((playerStats2.get("firstName") != jsonNull) ? (playerStats2.get("firstName").toString()) : (""));
        state.setLastName1((playerStats2.get("lastName") != jsonNull) ? (playerStats2.get("lastName").toString()) : (""));
        state.setBirthDate1((playerStats2.get("birthDate") != jsonNull) ? (playerStats2.get("birthDate").toString()) : (""));
        state.setCountry1((playerStats2.get("country") != jsonNull) ? (playerStats2.get("country").toString()) : (""));
        state.setHeight1((playerStats2.get("height") != jsonNull) ? (playerStats2.get("height").toString()) : (""));
        state.setWeight1((playerStats2.get("weight") != jsonNull) ? (playerStats2.get("weight").toString()) : (""));
        state.setTeam1((playerStats2.get("team") != jsonNull) ? (playerStats2.get("team").toString()) : (""));
        state.setPosition1((playerStats2.get("position") != jsonNull) ? (playerStats2.get("position").toString()) : (""));

        // Cumulative statistics for Player 2
        state.setGamesPlayed1((playerStats2.get("gamesPlayed") != jsonNull) ? (playerStats2.get("gamesPlayed").toString()) : (""));
        state.setPoints1((playerStats2.get("points") != jsonNull) ? (playerStats2.get("points").toString()) : (""));
        state.setAssists1((playerStats2.get("assists") != jsonNull) ? (playerStats2.get("assists").toString()) : (""));
        state.setTimePlayed1((playerStats2.get("timePlayed") != jsonNull) ? (playerStats2.get("timePlayed").toString()) : ("")); // Convert to minutes/seconds
        state.setFieldGoalsMade1((playerStats2.get("fieldGoalsMade") != jsonNull) ? (playerStats2.get("fieldGoalsMade").toString()) : (""));
        state.setFieldGoalsAttempted1((playerStats2.get("fieldGoalsAttempted") != jsonNull) ? (playerStats2.get("fieldGoalsAttempted").toString()) : (""));
        state.setFreeThrowsMade1((playerStats2.get("freeThrowsMade") != jsonNull) ? (playerStats2.get("freeThrowsMade").toString()) : (""));
        state.setFreeThrowsAttempted1((playerStats2.get("freeThrowsAttempted") != jsonNull) ? (playerStats2.get("freeThrowsAttempted").toString()) : (""));
        state.setThreePointsMade1((playerStats2.get("threePointsMade") != jsonNull) ? (playerStats2.get("threePointsMade").toString()) : (""));
        state.setThreePointsAttempted1((playerStats2.get("threePointsAttempted") != jsonNull) ? (playerStats2.get("threePointsAttempted").toString()) : (""));
        state.setOffensiveRebounds1((playerStats2.get("offensiveRebounds") != jsonNull) ? (playerStats2.get("offensiveRebounds").toString()) : (""));
        state.setDefensiveRebounds1((playerStats2.get("defensiveRebounds") != jsonNull) ? (playerStats2.get("defensiveRebounds").toString()) : (""));
        state.setPersonalFouls1((playerStats2.get("personalFouls") != jsonNull) ? (playerStats2.get("personalFouls").toString()) : (""));
        state.setSteals1((playerStats2.get("steals") != jsonNull) ? (playerStats2.get("steals").toString()) : (""));
        state.setTurnovers1((playerStats2.get("turnovers") != jsonNull) ? (playerStats2.get("turnovers").toString()) : (""));
        state.setBlocks1((playerStats2.get("blocks") != jsonNull) ? (playerStats2.get("blocks").toString()) : (""));
        state.setPlusMinus1((playerStats2.get("plusMinus") != jsonNull) ? (playerStats2.get("plusMinus").toString()) : (""));

        // Per game statistics for Player 2
        state.setPointsPerGame1((playerStats2.get("pointsPerGame") != jsonNull) ? (playerStats2.get("pointsPerGame").toString()) : (""));
        state.setAssistsPerGame1((playerStats2.get("assistsPerGame") != jsonNull) ? (playerStats2.get("assistsPerGame").toString()) : (""));
        state.setFieldGoalsMadePerGame1((playerStats2.get("fieldGoalsMadePerGame") != jsonNull) ? (playerStats2.get("fieldGoalsMadePerGame").toString()) : (""));
        state.setFieldGoalsAttemptedPerGame1((playerStats2.get("fieldGoalsAttemptedPerGame") != jsonNull) ? (playerStats2.get("fieldGoalsAttemptedPerGame").toString()) : (""));
        state.setFreeThrowsMadePerGame1((playerStats2.get("freeThrowsMadePerGame") != jsonNull) ? (playerStats2.get("freeThrowsMadePerGame").toString()) : (""));
        state.setFreeThrowsAttemptedPerGame1((playerStats2.get("freeThrowsAttemptedPerGame") != jsonNull) ? (playerStats2.get("freeThrowsAttemptedPerGame").toString()) : (""));
        state.setThreePointsMadePerGame1((playerStats2.get("threePointsMadePerGame") != jsonNull) ? (playerStats2.get("threePointsMadePerGame").toString()) : (""));
        state.setThreePointsAttemptedPerGame1((playerStats2.get("threePointsAttemptedPerGame") != jsonNull) ? (playerStats2.get("threePointsAttemptedPerGame").toString()) : (""));
        state.setDefensiveReboundsPerGame1((playerStats2.get("defensiveReboundsPerGame") != jsonNull) ? (playerStats2.get("defensiveReboundsPerGame").toString()) : (""));
        state.setOffensiveReboundsPerGame1((playerStats2.get("offensiveReboundsPerGame") != jsonNull) ? (playerStats2.get("offensiveReboundsPerGame").toString()) : (""));
        state.setReboundsPerGame1((playerStats2.get("reboundsPerGame") != jsonNull) ? (playerStats2.get("reboundsPerGame").toString()) : (""));
        state.setPersonalFoulsPerGame1((playerStats2.get("personalFoulsPerGame") != jsonNull) ? (playerStats2.get("personalFoulsPerGame").toString()) : (""));
        state.setStealsPerGame1((playerStats2.get("stealsPerGame") != jsonNull) ? (playerStats2.get("stealsPerGame").toString()) : (""));
        state.setTurnoversPerGame1((playerStats2.get("turnoversPerGame") != jsonNull) ? (playerStats2.get("turnoversPerGame").toString()) : (""));
        state.setBlocksPerGame1((playerStats2.get("blocksPerGame") != jsonNull) ? (playerStats2.get("blocksPerGame").toString()) : (""));
        state.setTimePlayedPerGame1((playerStats2.get("timePlayedPerGame") != jsonNull) ? (playerStats2.get("timePlayedPerGame").toString()) : (""));

        // Percentage metrics for Player 2
        state.setFreeThrowPercentage1((playerStats2.get("freeThrowPercentage") != jsonNull) ? (playerStats2.get("freeThrowPercentage").toString()) : (""));
        state.setFieldGoalPercentage1((playerStats2.get("fieldGoalPercentage") != jsonNull) ? (playerStats2.get("fieldGoalPercentage").toString()) : (""));
        state.setThreePointPercentage1((playerStats2.get("threePointPercentage") != jsonNull) ? (playerStats2.get("threePointPercentage").toString()) : (""));

        // Set view and fire property changes
        this.viewManagerModel.setActiveView(playerComparisonViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        this.playerComparisonViewModel.setState(state);
        this.playerComparisonViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        PlayerComparisonState state = playerComparisonViewModel.getState();
        state.setPlayerComparisonError("Sorry, we could not compare the players that you selected. Please try again");
        playerComparisonViewModel.setState(state);
        this.viewManagerModel.setActiveView(playerComparisonViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        this.playerComparisonViewModel.setState(state);
        this.playerComparisonViewModel.firePropertyChanged();
    }
}
