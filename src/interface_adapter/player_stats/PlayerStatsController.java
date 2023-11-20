package interface_adapter.player_stats;

import use_case.player_stats.PlayerStatsInputBoundary;
import use_case.player_stats.PlayerStatsInputData;

public class PlayerStatsController {

    final PlayerStatsInputBoundary playerStatsUseCaseInteractor;
    public PlayerStatsController(PlayerStatsInputBoundary playerStatsUseCaseInteractor) {
        this.playerStatsUseCaseInteractor = playerStatsUseCaseInteractor;
    }

    public void execute(int id) {
        PlayerStatsInputData playerStatsInputData = new PlayerStatsInputData(id);
        playerStatsUseCaseInteractor.execute(playerStatsInputData);
    }
}
