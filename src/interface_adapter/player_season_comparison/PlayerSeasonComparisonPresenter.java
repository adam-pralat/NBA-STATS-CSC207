package interface_adapter.player_season_comparison;

import interface_adapter.ViewManagerModel;
import interface_adapter.player_stats.PlayerStatsState;
import org.json.JSONObject;
import use_case.player_season_comparison.PlayerSeasonComparisonOutputBoundary;
import use_case.player_season_comparison.PlayerSeasonComparisonOutputData;

import java.util.Map;

public class PlayerSeasonComparisonPresenter implements PlayerSeasonComparisonOutputBoundary {

    private final PlayerSeasonComparisonViewModel playerSeasonComparisonViewModel;
    private ViewManagerModel viewManagerModel;
    private Object jsonNull = JSONObject.NULL;

    public PlayerSeasonComparisonPresenter(ViewManagerModel viewManagerModel, PlayerSeasonComparisonViewModel playerSeasonComparisonViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.playerSeasonComparisonViewModel = playerSeasonComparisonViewModel;
    }

    @Override
    public void prepareSuccessView(PlayerSeasonComparisonOutputData response) {
        // Change playerStats state
        Map<String, Object> playerStats = response.getPlayerSeasonComparison();

        // Get State
        PlayerSeasonComparisonState state = this.playerSeasonComparisonViewModel.getState();

        // Set all state attributes. If an attribute is null, it is set to be an empty string
        // Cumulative statistics
        state.setGamesPlayed((playerStats.get("gamesPlayed") != jsonNull) ? (playerStats.get("gamesPlayed").toString()) : (""));
        state.setPoints((playerStats.get("points") != jsonNull) ? (playerStats.get("points").toString()) : (""));
        state.setAssists((playerStats.get("assists") != jsonNull) ? (playerStats.get("assists").toString()) : (""));
        state.setTimePlayed((playerStats.get("timePlayed") != jsonNull) ? (playerStats.get("timePlayed").toString()) : ("")); // Convert to minutes/seconds
        state.setFieldGoalsMade((playerStats.get("fieldGoalsMade") != jsonNull) ? (playerStats.get("fieldGoalsMade").toString()) : (""));
        state.setFieldGoalsAttempted((playerStats.get("fieldGoalsAttempted") != jsonNull) ? (playerStats.get("fieldGoalsAttempted").toString()) : (""));
        state.setFreeThrowsMade((playerStats.get("freeThrowsMade") != jsonNull) ? (playerStats.get("freeThrowsMade").toString()) : (""));
        state.setFreeThrowsAttempted((playerStats.get("freeThrowsAttempted") != jsonNull) ? (playerStats.get("freeThrowsAttempted").toString()) : (""));
        state.setThreePointsMade((playerStats.get("threePointsMade") != jsonNull) ? (playerStats.get("threePointsMade").toString()) : (""));
        state.setThreePointsAttempted((playerStats.get("threePointsAttempted") != jsonNull) ? (playerStats.get("threePointsAttempted").toString()) : (""));
        state.setOffensiveRebounds((playerStats.get("offensiveRebounds") != jsonNull) ? (playerStats.get("offensiveRebounds").toString()) : (""));
        state.setDefensiveRebounds((playerStats.get("defensiveRebounds") != jsonNull) ? (playerStats.get("defensiveRebounds").toString()) : (""));
        state.setPersonalFouls((playerStats.get("personalFouls") != jsonNull) ? (playerStats.get("personalFouls").toString()) : (""));
        state.setSteals((playerStats.get("steals") != jsonNull) ? (playerStats.get("steals").toString()) : (""));
        state.setTurnovers((playerStats.get("turnovers") != jsonNull) ? (playerStats.get("turnovers").toString()) : (""));
        state.setBlocks((playerStats.get("blocks") != jsonNull) ? (playerStats.get("blocks").toString()) : (""));
        state.setPlusMinus((playerStats.get("plusMinus") != jsonNull) ? (playerStats.get("plusMinus").toString()) : (""));

        // Per game statistics
        state.setPointsPerGame((playerStats.get("pointsPerGame") != jsonNull) ? (playerStats.get("pointsPerGame").toString()) : (""));
        state.setAssistsPerGame((playerStats.get("assistsPerGame") != jsonNull) ? (playerStats.get("assistsPerGame").toString()) : (""));
        state.setFieldGoalsMadePerGame((playerStats.get("fieldGoalsMadePerGame") != jsonNull) ? (playerStats.get("fieldGoalsMadePerGame").toString()) : (""));
        state.setFieldGoalsAttemptedPerGame((playerStats.get("fieldGoalsAttemptedPerGame") != jsonNull) ? (playerStats.get("fieldGoalsAttemptedPerGame").toString()) : (""));
        state.setFreeThrowsMadePerGame((playerStats.get("freeThrowsMadePerGame") != jsonNull) ? (playerStats.get("freeThrowsMadePerGame").toString()) : (""));
        state.setFreeThrowsAttemptedPerGame((playerStats.get("freeThrowsAttemptedPerGame") != jsonNull) ? (playerStats.get("freeThrowsAttemptedPerGame").toString()) : (""));
        state.setThreePointsMadePerGame((playerStats.get("threePointsMadePerGame") != jsonNull) ? (playerStats.get("threePointsMadePerGame").toString()) : (""));
        state.setThreePointsAttemptedPerGame((playerStats.get("threePointsAttemptedPerGame") != jsonNull) ? (playerStats.get("threePointsAttemptedPerGame").toString()) : (""));
        state.setDefensiveReboundsPerGame((playerStats.get("defensiveReboundsPerGame") != jsonNull) ? (playerStats.get("defensiveReboundsPerGame").toString()) : (""));
        state.setOffensiveReboundsPerGame((playerStats.get("offensiveReboundsPerGame") != jsonNull) ? (playerStats.get("offensiveReboundsPerGame").toString()) : (""));
        state.setReboundsPerGame((playerStats.get("reboundsPerGame") != jsonNull) ? (playerStats.get("reboundsPerGame").toString()) : (""));
        state.setPersonalFoulsPerGame((playerStats.get("personalFoulsPerGame") != jsonNull) ? (playerStats.get("personalFoulsPerGame").toString()) : (""));
        state.setStealsPerGame((playerStats.get("stealsPerGame") != jsonNull) ? (playerStats.get("stealsPerGame").toString()) : (""));
        state.setTurnoversPerGame((playerStats.get("turnoversPerGame") != jsonNull) ? (playerStats.get("turnoversPerGame").toString()) : (""));
        state.setBlocksPerGame((playerStats.get("blocksPerGame") != jsonNull) ? (playerStats.get("blocksPerGame").toString()) : (""));
        state.setTimePlayedPerGame((playerStats.get("timePlayedPerGame") != jsonNull) ? (playerStats.get("timePlayedPerGame").toString()) : (""));

        // Percentage metrics
        state.setFreeThrowPercentage((playerStats.get("freeThrowPercentage") != jsonNull) ? (playerStats.get("freeThrowPercentage").toString()) : (""));
        state.setFieldGoalPercentage((playerStats.get("fieldGoalPercentage") != jsonNull) ? (playerStats.get("fieldGoalPercentage").toString()) : (""));
        state.setThreePointPercentage((playerStats.get("threePointPercentage") != jsonNull) ? (playerStats.get("threePointPercentage").toString()) : (""));

        // Set view and fire property changes
        this.viewManagerModel.setActiveView(playerSeasonComparisonViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        this.playerSeasonComparisonViewModel.setState(state);
        this.playerSeasonComparisonViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        PlayerSeasonComparisonState state = playerSeasonComparisonViewModel.getState();
        state.setPlayerStatsError("Sorry, we could not get the stats for the player you requested. Please try again.");
        playerSeasonComparisonViewModel.setState(state);
        this.viewManagerModel.setActiveView(playerSeasonComparisonViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        this.playerSeasonComparisonViewModel.setState(state);
        this.playerSeasonComparisonViewModel.firePropertyChanged();
    }
}
