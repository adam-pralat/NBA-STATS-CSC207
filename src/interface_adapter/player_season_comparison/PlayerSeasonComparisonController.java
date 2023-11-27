package interface_adapter.player_season_comparison;

import use_case.player_season_comparison.PlayerSeasonComparisonInputBoundary;
import use_case.player_season_comparison.PlayerSeasonComparisonInputData;

public class PlayerSeasonComparisonController {
    final PlayerSeasonComparisonInputBoundary playerSeasonComparisonUseCaseInteractor;

    public PlayerSeasonComparisonController(PlayerSeasonComparisonInputBoundary playerSeasonComparisonUseCaseInteractor) {
        this.playerSeasonComparisonUseCaseInteractor = playerSeasonComparisonUseCaseInteractor;
    }

    public void execute(int id, int season1, int season2) {
        PlayerSeasonComparisonInputData playerSeasonComparisonInputData = new PlayerSeasonComparisonInputData(id, season1, season2);
        playerSeasonComparisonUseCaseInteractor.execute(playerSeasonComparisonInputData);
    }

}
