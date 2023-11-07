package use_case.player_stats;

import interface_adapter.player_stats.PlayerStatsPresenter;

import java.util.Dictionary;
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
                Dictionary<String, Object> playerStats = playerStatsAccessObject.getStats();
                playerStatsPresenter.prepareSuccessView(new PlayerStatsOutputData(playerStats, true));
            } catch (Exception e) {
                playerStatsPresenter.prepareFailView(e.toString());
            }
        }
    }
}
