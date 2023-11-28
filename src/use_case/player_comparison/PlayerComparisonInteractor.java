package use_case.player_comparison;

import entity.Player;

public class PlayerComparisonInteractor implements PlayerComparisonInputBoundary {
    final PlayerComparisonDataAccessInterface playerComparisonAccessObject;
    final PlayerComparisonOutputBoundary playerComparisonPresenter;

    public PlayerComparisonInteractor(PlayerComparisonDataAccessInterface playerComparisonAccessObject,
                                      PlayerComparisonOutputBoundary playerComparisonOutputBoundary){
        this.playerComparisonAccessObject = playerComparisonAccessObject;
        this.playerComparisonPresenter = playerComparisonOutputBoundary;
    }

    @Override
    public void execute(PlayerComparisonInputData playerComparisonInputData) {
        //TODO
    }
}
