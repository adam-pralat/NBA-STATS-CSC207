package interface_adapter.player_stats;

import interface_adapter.ViewManagerModel;
import use_case.player_stats.PlayerStatsOutputBoundary;
import use_case.player_stats.PlayerStatsOutputData;

import java.util.Dictionary;
import java.util.Map;
import java.util.concurrent.Callable;

public class PlayerStatsPresenter implements PlayerStatsOutputBoundary {

    private final PlayerStatsViewModel playerStatsViewModel;
    private ViewManagerModel viewManagerModel;

    public PlayerStatsPresenter(ViewManagerModel viewManagerModel,PlayerStatsViewModel playerStatsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.playerStatsViewModel = playerStatsViewModel;
    }

    @Override
    public void prepareSuccessView(PlayerStatsOutputData response) {
        // Change playerStats state
        Map<String, Object> playerStats = response.getPlayerStats();

        // Get State
        PlayerStatsState state = this.playerStatsViewModel.getState();

        // Set all state attributes. If an attribute is null, it is set to be an empty string
        // Basic attributes
        state.setFirstName((playerStats.get("firstName") == null) ? (playerStats.get("firstName")) : (""));
        state.setLastName((playerStats.get("lastName") == null) ? (playerStats.get("lastName")) : (""));
        state.setBirthDate((playerStats.get("birthDate") == null) ? (playerStats.get("birthDate")) : (""));
        state.setCountry((playerStats.get("country") == null) ? (playerStats.get("country")) : (""));
        state.setHeight((playerStats.get("height") == null) ? (playerStats.get("height")) : (""));
        state.setWeight((playerStats.get("weight") == null) ? (playerStats.get("weight")) : (""));

        // Cumulative statistics
        state.setGamesPlayed((playerStats.get("gamesPlayed") == null) ? (playerStats.get("gamesPlayed")) : (""));
        state.setPoints((playerStats.get("points") == null) ? (playerStats.get("points")) : (""));
        state.setAssists((playerStats.get("assists") == null) ? (playerStats.get("assists")) : (""));
        state.setTimePlayed((playerStats.get("timePlayed") == null) ? (playerStats.get("timePlayed")) : ("")); // Convert to minutes/seconds
        state.setFieldGoalsMade((playerStats.get("fieldGoalsMade") == null) ? (playerStats.get("fieldGoalsMade")) : (""));
        state.setFieldGoalsAttempted((playerStats.get("fieldGoalsAttempted") == null) ? (playerStats.get("fieldGoalsAttempted")) : (""));
        state.setFreeThrowsMade((playerStats.get("freeThrowsMade") == null) ? (playerStats.get("freeThrowsMade")) : (""));
        state.setFreeThrowsAttempted((playerStats.get("freeThrowsAttempted") == null) ? (playerStats.get("freeThrowsAttempted")) : (""));
        state.setThreePointsMade((playerStats.get("threePointsMade") == null) ? (playerStats.get("threePointsMade")) : (""));
        state.setThreePointsAttempted((playerStats.get("threePointsAttempted") == null) ? (playerStats.get("threePointsAttempted")) : (""));
        state.setOffensiveRebounds((playerStats.get("offensiveRebounds") == null) ? (playerStats.get("offensiveRebounds")) : (""));
        state.setDefensiveRebounds((playerStats.get("defensiveRebounds") == null) ? (playerStats.get("defensiveRebounds")) : (""));
        state.setPersonalFouls((playerStats.get("personalFouls") == null) ? (playerStats.get("personalFouls")) : (""));
        state.setSteals((playerStats.get("steals") == null) ? (playerStats.get("steals")) : (""));
        state.setTurnovers((playerStats.get("turnovers") == null) ? (playerStats.get("turnovers")) : (""));
        state.setBlocks((playerStats.get("blocks") == null) ? (playerStats.get("blocks")) : (""));
        state.setPlusMinus((playerStats.get("plusMinus") == null) ? (playerStats.get("plusMinus")) : (""));

        // Per game statistics
        state.setPointsPerGame((playerStats.get("pointsPerGame") == null) ? (playerStats.get("pointsPerGame")) : (""));
        state.setAssistsPerGame((playerStats.get("assistsPerGame") == null) ? (playerStats.get("assistsPerGame")) : (""));
        state.setFieldGoalsMadePerGame((playerStats.get("fieldGoalsMadePerGame") == null) ? (playerStats.get("fieldGoalsMadePerGame")) : (""));
        state.setFieldGoalsAttemptedPerGame((playerStats.get("fieldGoalsAttemptedPerGame") == null) ? (playerStats.get("fieldGoalsAttemptedPerGame")) : (""));
        state.setFreeThrowsMadePerGame((playerStats.get("freeThrowsMadePerGame") == null) ? (playerStats.get("freeThrowsMadePerGame")) : (""));
        state.setFreeThrowsAttemptedPerGame((playerStats.get("freeThrowsAttemptedPerGame") == null) ? (playerStats.get("freeThrowsAttemptedPerGame")) : (""));
        state.setThreePointsMadePerGame((playerStats.get("threePointsMadePerGame") == null) ? (playerStats.get("threePointsMadePerGame")) : (""));
        state.setThreePointsAttemptedPerGame((playerStats.get("threePointsAttemptedPerGame") == null) ? (playerStats.get("threePointsAttemptedPerGame")) : (""));
        state.setDefensiveReboundsPerGame((playerStats.get("defensiveReboundsPerGame") == null) ? (playerStats.get("defensiveReboundsPerGame")) : (""));
        state.setOffensiveReboundsPerGame((playerStats.get("offensiveReboundsPerGame") == null) ? (playerStats.get("offensiveReboundsPerGame")) : (""));
        state.setReboundsPerGame((playerStats.get("reboundsPerGame") == null) ? (playerStats.get("reboundsPerGame")) : (""));
        state.setPersonalFoulsPerGame((playerStats.get("personalFoulsPerGame") == null) ? (playerStats.get("personalFoulsPerGame")) : (""));
        state.setStealsPerGame((playerStats.get("stealsPerGame") == null) ? (playerStats.get("stealsPerGame")) : (""));
        state.setTurnoversPerGame((playerStats.get("turnoversPerGame") == null) ? (playerStats.get("turnoversPerGame")) : (""));
        state.setBlocksPerGame((playerStats.get("blocksPerGame") == null) ? (playerStats.get("blocksPerGame")) : (""));
        state.setTimePlayedPerGame((playerStats.get("timePlayedPerGame") == null) ? (playerStats.get("timePlayedPerGame")) : ("-"));

        // Set view and fire property changes
         this.viewManagerModel.setActiveView(playerStatsViewModel.getViewName());
         this.viewManagerModel.firePropertyChanged();

         this.playerStatsViewModel.setState(playerStatsViewModel);
         this.clearViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
         PlayerStatsState state = playerStatsViewModel.getState();
         state.setPlayerStatsError("Sorry, we could not get the stats for the player you requested. Please try again.");
         playerStatsViewModel.setState(state);
         this.viewManagerModel.setActiveView(playerStatsViewModel.getViewName());
         this.viewManagerModel.firePropertyChanged();

         this.playerStatsViewModel.setState(state);
         this.playerStatsViewModel.firePropertyChanged();
    }


}
