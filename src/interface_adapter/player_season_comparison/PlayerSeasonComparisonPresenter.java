package interface_adapter.player_season_comparison;

import interface_adapter.ViewManagerModel;
import org.json.JSONObject;
import use_case.player_season_comparison.PlayerSeasonComparisonOutputBoundary;
import use_case.player_season_comparison.PlayerSeasonComparisonOutputData;

import java.util.Map;

// TODO: Switch time played to minutes played
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
        Map<String, Object> season1PlayerStats = response.getPlayerSeason1Stats();
        Map<String, Object> season2PlayerStats = response.getPlayerSeason2Stats();

        // Get State
        PlayerSeasonComparisonState state = this.playerSeasonComparisonViewModel.getState();

        // Set all state attributes. If an attribute is null, it is set to be an empty string

        // Set basic profile information of player
        state.setFirstName((season1PlayerStats.get("firstName") != jsonNull) ? (season1PlayerStats.get("firstName").toString()) : (""));
        state.setLastName((season1PlayerStats.get("lastName") != jsonNull) ? (season1PlayerStats.get("lastName").toString()) : (""));
        state.setBirthDate((season1PlayerStats.get("birthDate") != jsonNull) ? (season1PlayerStats.get("birthDate").toString()) : (""));
        state.setCountry((season1PlayerStats.get("country") != jsonNull) ? (season1PlayerStats.get("country").toString()) : (""));
        state.setHeight((season1PlayerStats.get("height") != jsonNull) ? (season1PlayerStats.get("height").toString()) : (""));
        state.setWeight((season1PlayerStats.get("weight") != jsonNull) ? (season1PlayerStats.get("weight").toString()) : (""));

        // Cumulative statistics for Season 1
        state.setGamesPlayed((season1PlayerStats.get("gamesPlayed") != jsonNull) ? (season1PlayerStats.get("gamesPlayed").toString()) : (""));
        state.setPoints((season1PlayerStats.get("points") != jsonNull) ? (season1PlayerStats.get("points").toString()) : (""));
        state.setAssists((season1PlayerStats.get("assists") != jsonNull) ? (season1PlayerStats.get("assists").toString()) : (""));
        state.setTimePlayed((season1PlayerStats.get("timePlayed") != jsonNull) ? (season1PlayerStats.get("timePlayed").toString()) : ("")); // Convert to minutes/seconds
        state.setFieldGoalsMade((season1PlayerStats.get("fieldGoalsMade") != jsonNull) ? (season1PlayerStats.get("fieldGoalsMade").toString()) : (""));
        state.setFieldGoalsAttempted((season1PlayerStats.get("fieldGoalsAttempted") != jsonNull) ? (season1PlayerStats.get("fieldGoalsAttempted").toString()) : (""));
        state.setFreeThrowsMade((season1PlayerStats.get("freeThrowsMade") != jsonNull) ? (season1PlayerStats.get("freeThrowsMade").toString()) : (""));
        state.setFreeThrowsAttempted((season1PlayerStats.get("freeThrowsAttempted") != jsonNull) ? (season1PlayerStats.get("freeThrowsAttempted").toString()) : (""));
        state.setThreePointsMade((season1PlayerStats.get("threePointsMade") != jsonNull) ? (season1PlayerStats.get("threePointsMade").toString()) : (""));
        state.setThreePointsAttempted((season1PlayerStats.get("threePointsAttempted") != jsonNull) ? (season1PlayerStats.get("threePointsAttempted").toString()) : (""));
        state.setOffensiveRebounds((season1PlayerStats.get("offensiveRebounds") != jsonNull) ? (season1PlayerStats.get("offensiveRebounds").toString()) : (""));
        state.setDefensiveRebounds((season1PlayerStats.get("defensiveRebounds") != jsonNull) ? (season1PlayerStats.get("defensiveRebounds").toString()) : (""));
        state.setPersonalFouls((season1PlayerStats.get("personalFouls") != jsonNull) ? (season1PlayerStats.get("personalFouls").toString()) : (""));
        state.setSteals((season1PlayerStats.get("steals") != jsonNull) ? (season1PlayerStats.get("steals").toString()) : (""));
        state.setTurnovers((season1PlayerStats.get("turnovers") != jsonNull) ? (season1PlayerStats.get("turnovers").toString()) : (""));
        state.setBlocks((season1PlayerStats.get("blocks") != jsonNull) ? (season1PlayerStats.get("blocks").toString()) : (""));
        state.setPlusMinus((season1PlayerStats.get("plusMinus") != jsonNull) ? (season1PlayerStats.get("plusMinus").toString()) : (""));

        // Per game statistics for Season 1
        state.setPointsPerGame((season1PlayerStats.get("pointsPerGame") != jsonNull) ? (season1PlayerStats.get("pointsPerGame").toString()) : (""));
        state.setAssistsPerGame((season1PlayerStats.get("assistsPerGame") != jsonNull) ? (season1PlayerStats.get("assistsPerGame").toString()) : (""));
        state.setFieldGoalsMadePerGame((season1PlayerStats.get("fieldGoalsMadePerGame") != jsonNull) ? (season1PlayerStats.get("fieldGoalsMadePerGame").toString()) : (""));
        state.setFieldGoalsAttemptedPerGame((season1PlayerStats.get("fieldGoalsAttemptedPerGame") != jsonNull) ? (season1PlayerStats.get("fieldGoalsAttemptedPerGame").toString()) : (""));
        state.setFreeThrowsMadePerGame((season1PlayerStats.get("freeThrowsMadePerGame") != jsonNull) ? (season1PlayerStats.get("freeThrowsMadePerGame").toString()) : (""));
        state.setFreeThrowsAttemptedPerGame((season1PlayerStats.get("freeThrowsAttemptedPerGame") != jsonNull) ? (season1PlayerStats.get("freeThrowsAttemptedPerGame").toString()) : (""));
        state.setThreePointsMadePerGame((season1PlayerStats.get("threePointsMadePerGame") != jsonNull) ? (season1PlayerStats.get("threePointsMadePerGame").toString()) : (""));
        state.setThreePointsAttemptedPerGame((season1PlayerStats.get("threePointsAttemptedPerGame") != jsonNull) ? (season1PlayerStats.get("threePointsAttemptedPerGame").toString()) : (""));
        state.setDefensiveReboundsPerGame((season1PlayerStats.get("defensiveReboundsPerGame") != jsonNull) ? (season1PlayerStats.get("defensiveReboundsPerGame").toString()) : (""));
        state.setOffensiveReboundsPerGame((season1PlayerStats.get("offensiveReboundsPerGame") != jsonNull) ? (season1PlayerStats.get("offensiveReboundsPerGame").toString()) : (""));
        state.setReboundsPerGame((season1PlayerStats.get("reboundsPerGame") != jsonNull) ? (season1PlayerStats.get("reboundsPerGame").toString()) : (""));
        state.setPersonalFoulsPerGame((season1PlayerStats.get("personalFoulsPerGame") != jsonNull) ? (season1PlayerStats.get("personalFoulsPerGame").toString()) : (""));
        state.setStealsPerGame((season1PlayerStats.get("stealsPerGame") != jsonNull) ? (season1PlayerStats.get("stealsPerGame").toString()) : (""));
        state.setTurnoversPerGame((season1PlayerStats.get("turnoversPerGame") != jsonNull) ? (season1PlayerStats.get("turnoversPerGame").toString()) : (""));
        state.setBlocksPerGame((season1PlayerStats.get("blocksPerGame") != jsonNull) ? (season1PlayerStats.get("blocksPerGame").toString()) : (""));
        state.setTimePlayedPerGame((season1PlayerStats.get("timePlayedPerGame") != jsonNull) ? (season1PlayerStats.get("timePlayedPerGame").toString()) : (""));

        // Percentage metrics for Season 1
        state.setFreeThrowPercentage((season1PlayerStats.get("freeThrowPercentage") != jsonNull) ? (season1PlayerStats.get("freeThrowPercentage").toString()) : (""));
        state.setFieldGoalPercentage((season1PlayerStats.get("fieldGoalPercentage") != jsonNull) ? (season1PlayerStats.get("fieldGoalPercentage").toString()) : (""));
        state.setThreePointPercentage((season1PlayerStats.get("threePointPercentage") != jsonNull) ? (season1PlayerStats.get("threePointPercentage").toString()) : (""));

        // Cumulative statistics for Season 2
        state.setGamesPlayed1((season2PlayerStats.get("gamesPlayed") != jsonNull) ? (season2PlayerStats.get("gamesPlayed").toString()) : (""));
        state.setPoints1((season2PlayerStats.get("points") != jsonNull) ? (season2PlayerStats.get("points").toString()) : (""));
        state.setAssists1((season2PlayerStats.get("assists") != jsonNull) ? (season2PlayerStats.get("assists").toString()) : (""));
        state.setTimePlayed1((season2PlayerStats.get("timePlayed") != jsonNull) ? (season2PlayerStats.get("timePlayed").toString()) : ("")); // Convert to minutes/seconds
        state.setFieldGoalsMade1((season2PlayerStats.get("fieldGoalsMade") != jsonNull) ? (season2PlayerStats.get("fieldGoalsMade").toString()) : (""));
        state.setFieldGoalsAttempted1((season2PlayerStats.get("fieldGoalsAttempted") != jsonNull) ? (season2PlayerStats.get("fieldGoalsAttempted").toString()) : (""));
        state.setFreeThrowsMade1((season2PlayerStats.get("freeThrowsMade") != jsonNull) ? (season2PlayerStats.get("freeThrowsMade").toString()) : (""));
        state.setFreeThrowsAttempted1((season2PlayerStats.get("freeThrowsAttempted") != jsonNull) ? (season2PlayerStats.get("freeThrowsAttempted").toString()) : (""));
        state.setThreePointsMade1((season2PlayerStats.get("threePointsMade") != jsonNull) ? (season2PlayerStats.get("threePointsMade").toString()) : (""));
        state.setThreePointsAttempted1((season2PlayerStats.get("threePointsAttempted") != jsonNull) ? (season2PlayerStats.get("threePointsAttempted").toString()) : (""));
        state.setOffensiveRebounds1((season2PlayerStats.get("offensiveRebounds") != jsonNull) ? (season2PlayerStats.get("offensiveRebounds").toString()) : (""));
        state.setDefensiveRebounds1((season2PlayerStats.get("defensiveRebounds") != jsonNull) ? (season2PlayerStats.get("defensiveRebounds").toString()) : (""));
        state.setPersonalFouls1((season2PlayerStats.get("personalFouls") != jsonNull) ? (season2PlayerStats.get("personalFouls").toString()) : (""));
        state.setSteals1((season2PlayerStats.get("steals") != jsonNull) ? (season2PlayerStats.get("steals").toString()) : (""));
        state.setTurnovers1((season2PlayerStats.get("turnovers") != jsonNull) ? (season2PlayerStats.get("turnovers").toString()) : (""));
        state.setBlocks1((season2PlayerStats.get("blocks") != jsonNull) ? (season2PlayerStats.get("blocks").toString()) : (""));
        state.setPlusMinus1((season2PlayerStats.get("plusMinus") != jsonNull) ? (season2PlayerStats.get("plusMinus").toString()) : (""));

        // Per game statistics for Season 2
        state.setPointsPerGame1((season2PlayerStats.get("pointsPerGame") != jsonNull) ? (season2PlayerStats.get("pointsPerGame").toString()) : (""));
        state.setAssistsPerGame1((season2PlayerStats.get("assistsPerGame") != jsonNull) ? (season2PlayerStats.get("assistsPerGame").toString()) : (""));
        state.setFieldGoalsMadePerGame1((season2PlayerStats.get("fieldGoalsMadePerGame") != jsonNull) ? (season2PlayerStats.get("fieldGoalsMadePerGame").toString()) : (""));
        state.setFieldGoalsAttemptedPerGame1((season2PlayerStats.get("fieldGoalsAttemptedPerGame") != jsonNull) ? (season2PlayerStats.get("fieldGoalsAttemptedPerGame").toString()) : (""));
        state.setFreeThrowsMadePerGame1((season2PlayerStats.get("freeThrowsMadePerGame") != jsonNull) ? (season2PlayerStats.get("freeThrowsMadePerGame").toString()) : (""));
        state.setFreeThrowsAttemptedPerGame1((season2PlayerStats.get("freeThrowsAttemptedPerGame") != jsonNull) ? (season2PlayerStats.get("freeThrowsAttemptedPerGame").toString()) : (""));
        state.setThreePointsMadePerGame1((season2PlayerStats.get("threePointsMadePerGame") != jsonNull) ? (season2PlayerStats.get("threePointsMadePerGame").toString()) : (""));
        state.setThreePointsAttemptedPerGame1((season2PlayerStats.get("threePointsAttemptedPerGame") != jsonNull) ? (season2PlayerStats.get("threePointsAttemptedPerGame").toString()) : (""));
        state.setDefensiveReboundsPerGame1((season2PlayerStats.get("defensiveReboundsPerGame") != jsonNull) ? (season2PlayerStats.get("defensiveReboundsPerGame").toString()) : (""));
        state.setOffensiveReboundsPerGame1((season2PlayerStats.get("offensiveReboundsPerGame") != jsonNull) ? (season2PlayerStats.get("offensiveReboundsPerGame").toString()) : (""));
        state.setReboundsPerGame1((season2PlayerStats.get("reboundsPerGame") != jsonNull) ? (season2PlayerStats.get("reboundsPerGame").toString()) : (""));
        state.setPersonalFoulsPerGame1((season2PlayerStats.get("personalFoulsPerGame") != jsonNull) ? (season2PlayerStats.get("personalFoulsPerGame").toString()) : (""));
        state.setStealsPerGame1((season2PlayerStats.get("stealsPerGame") != jsonNull) ? (season2PlayerStats.get("stealsPerGame").toString()) : (""));
        state.setTurnoversPerGame1((season2PlayerStats.get("turnoversPerGame") != jsonNull) ? (season2PlayerStats.get("turnoversPerGame").toString()) : (""));
        state.setBlocksPerGame1((season2PlayerStats.get("blocksPerGame") != jsonNull) ? (season2PlayerStats.get("blocksPerGame").toString()) : (""));
        state.setTimePlayedPerGame1((season2PlayerStats.get("timePlayedPerGame") != jsonNull) ? (season2PlayerStats.get("timePlayedPerGame").toString()) : (""));


        // Set view and fire property changes
        this.viewManagerModel.setActiveView(playerSeasonComparisonViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        this.playerSeasonComparisonViewModel.setState(state);
        this.playerSeasonComparisonViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        PlayerSeasonComparisonState state = playerSeasonComparisonViewModel.getState();
        state.setPlayerSeasonComparisonError("Sorry, we could not get the season stats for the player you requested. Please try again.");
        playerSeasonComparisonViewModel.setState(state);
        this.viewManagerModel.setActiveView(playerSeasonComparisonViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        this.playerSeasonComparisonViewModel.setState(state);
        this.playerSeasonComparisonViewModel.firePropertyChanged();
    }
}
