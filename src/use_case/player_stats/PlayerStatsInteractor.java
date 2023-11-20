package use_case.player_stats;

import interface_adapter.player_stats.PlayerStatsPresenter;

import java.util.Map;
import java.util.Objects;

public class PlayerStatsInteractor implements PlayerStatsInputBoundary {
    final PlayerStatsDataAccessInterface playerStatsAccessObject;
    final PlayerStatsOutputData playerStatsPresenter;

    public PlayerStatsInteractor(PlayerStatsDataAccessInterface playerStatsAccessObject, PlayerStatsOutputData playerStatsOutputBoundary) {
        this.playerStatsAccessObject = playerStatsAccessObject;
        this.playerStatsPresenter = playerStatsOutputBoundary;
    }

    @Override
    public void execute(PlayerStatsInputData inputData) {
        int id = inputData.getId();
        if (!playerStatsAccessObject.existsById(id)) {
            PlayerStatsPresenter.prepareFailView("Player ID does not exist.");
        } else {
            try {
                int currSeason = 2023; //TODO method to figure out current season
                Player player = playerStatsAccessObject.getPlayerInfo(id);
                // TODO Map<String, Object> currentPlayerStats = playerStatsAccessObject.getPlayerYearlyStats(id, currSeason);

                for(int season = 2015; season <= currSeason; season++) {
                    Map<String, Object> seasonPlayerStats = playerStatsAccessObject.getPlayerYearlyStats(id, season);
                    player.addStats(seasonPlayerStats);
                }

                playerStatsPresenter.prepareSuccessView(new PlayerStatsOutputData(player.toMap(), true));
            } catch (Exception e) {
                playerStatsPresenter.prepareFailView(e.toString());
            }
        }
    }
}
