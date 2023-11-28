package use_case.player_stats;

import entity.Player;
import interface_adapter.player_stats.PlayerStatsPresenter;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class PlayerStatsInteractor implements PlayerStatsInputBoundary {
    final PlayerStatsDataAccessInterface playerStatsAccessObject;
    final PlayerStatsOutputBoundary playerStatsPresenter;

    public PlayerStatsInteractor(PlayerStatsDataAccessInterface playerStatsAccessObject, PlayerStatsOutputBoundary playerStatsOutputBoundary) {
        this.playerStatsAccessObject = playerStatsAccessObject;
        this.playerStatsPresenter = playerStatsOutputBoundary;
    }

    @Override
    public void execute(PlayerStatsInputData inputData) {
        int id = inputData.getId();
        if (!playerStatsAccessObject.existsById(id)) {
            playerStatsPresenter.prepareFailView("Player ID does not exist.");
        } else {
            try {
                int currSeason = LocalDate.now().getYear();
                Player player = playerStatsAccessObject.getPlayerInfo(id);

                for(int season = 2015; season <= currSeason; season++) {
                    Map<String, Object> seasonPlayerStats = playerStatsAccessObject.getPlayerYearlyStats(id, season);
                    player.addStat(seasonPlayerStats);
                }

                playerStatsPresenter.prepareSuccessView(new PlayerStatsOutputData(player.toMap(), true));
            } catch (Exception e) {
                playerStatsPresenter.prepareFailView(e.toString());
            }
        }
    }
}
