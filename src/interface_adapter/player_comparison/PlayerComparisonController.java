package interface_adapter.player_comparison;

import use_case.player_comparison.PlayerComparisonInputBoundary;
import use_case.player_comparison.PlayerComparisonInputData;

public class PlayerComparisonController {

    final PlayerComparisonInputBoundary playerComparisonUseCaseInteractor;

    public PlayerComparisonController(PlayerComparisonInputBoundary playerComparisonUseCaseInteractor){
        this.playerComparisonUseCaseInteractor = playerComparisonUseCaseInteractor;
    }

    public void execute(int id1, int id2){
        PlayerComparisonInputData playerComparisonInputData = new PlayerComparisonInputData(id1, id2);
        playerComparisonUseCaseInteractor.execute(playerComparisonInputData);
    }
}
