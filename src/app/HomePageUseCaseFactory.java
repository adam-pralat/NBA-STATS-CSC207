package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.home_page.HomePageController;
import interface_adapter.home_page.HomePagePresenter;
import interface_adapter.home_page.HomePageViewModel;
import interface_adapter.player_stats.PlayerStatsController;
import interface_adapter.player_comparison.PlayerComparisonController;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonController;
import interface_adapter.schedule.ScheduleController;
import use_case.home_page.HomePageDataAccessInterface;
import use_case.home_page.HomePageInputBoundary;
import use_case.home_page.HomePageInteractor;
import use_case.home_page.HomePageOutputBoundary;
import view.HomeView;

import javax.swing.*;
import java.io.IOException;

public class HomePageUseCaseFactory {
    private HomePageUseCaseFactory() {}

    public static HomeView create(HomePageViewModel homePageViewModel, HomePageController homePageController, ScheduleController scheduleController, PlayerComparisonController playerComparisonController, PlayerSeasonComparisonController playerSeasonComparisonController, PlayerStatsController playerStatsController) {

            // HomePageController homePageController = createHomePageUseCase(viewManagerModel, homePageViewModel, homePageDAO);
            return new HomeView(homePageViewModel, homePageController, scheduleController, playerComparisonController, playerSeasonComparisonController, playerStatsController);

    }

    public static HomePageController createHomePageUseCase(ViewManagerModel viewManagerModel, HomePageViewModel homePageViewModel, HomePageDataAccessInterface homeDataAccessObject) {

        // Notice how we pass this method's parameters to the Presenter.
        HomePageOutputBoundary homePageOutputBoundary = new HomePagePresenter(homePageViewModel, viewManagerModel);

        HomePageInputBoundary homePageInteractor = new HomePageInteractor(
                homeDataAccessObject, homePageOutputBoundary);

        return new HomePageController(homePageInteractor);
    }

}
