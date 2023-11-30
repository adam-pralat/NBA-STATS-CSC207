package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.player_comparison.PlayerComparisonController;
import interface_adapter.player_comparison.PlayerComparisonPresenter;
import interface_adapter.player_comparison.PlayerComparisonViewModel;
import use_case.player_comparison.PlayerComparisonDataAccessInterface;
import use_case.player_comparison.PlayerComparisonInputBoundary;
import use_case.player_comparison.PlayerComparisonInteractor;
import use_case.player_comparison.PlayerComparisonOutputBoundary;
import view.PlayerComparisonView;

public class PlayerComparisonUseCaseFactory {
    private PlayerComparisonUseCaseFactory() {}

    public static PlayerComparisonView create(ViewManagerModel viewManagerModel,
                                              PlayerComparisonViewModel playerComparisonViewModel,
                                              PlayerComparisonDataAccessInterface playerComparisonDAO) {
        PlayerComparisonController playerComparisonController = createPlayerComparisonUseCase(viewManagerModel,
                playerComparisonViewModel, playerComparisonDAO);
        return new PlayerComparisonView(playerComparisonController, playerComparisonViewModel);
    }

    private static PlayerComparisonController createPlayerComparisonUseCase(
            ViewManagerModel viewManagerModel,
            PlayerComparisonViewModel playerComparisonViewModel,
            PlayerComparisonDataAccessInterface playerComparisonDataAccessObject) {
        PlayerComparisonOutputBoundary playerComparisonOutputBoundary = new PlayerComparisonPresenter(
                viewManagerModel,
                playerComparisonViewModel);

        PlayerComparisonInputBoundary playerComparisonInteractor = new PlayerComparisonInteractor(
                playerComparisonDataAccessObject, playerComparisonOutputBoundary);

        return new PlayerComparisonController(playerComparisonInteractor);
    }

}
