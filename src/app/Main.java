package app;

import data_access.GameDataAccessObject;
import data_access.HomePageDataAccessObject;
import data_access.PlayerDataAccessObject;
import data_access.TeamDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_page.HomePageController;
import interface_adapter.home_page.HomePageViewModel;
import interface_adapter.player_stats.PlayerStatsController;
import interface_adapter.player_stats.PlayerStatsPresenter;
import interface_adapter.schedule.ScheduleController;
import interface_adapter.schedule.ScheduleViewModel;
import use_case.player_stats.PlayerStatsInputData;
import use_case.player_stats.PlayerStatsInteractor;
import use_case.player_stats.PlayerStatsOutputBoundary;
import use_case.player_stats.PlayerStatsOutputData;
import view.HomeView;
import view.ScheduleView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("APP Title -------");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        HomePageViewModel homePageViewModel = new HomePageViewModel();
        ScheduleViewModel scheduleViewModel = new ScheduleViewModel();

        PlayerDataAccessObject playerDAO = new PlayerDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        TeamDataAccessObject teamDAO = new TeamDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        HomePageDataAccessObject homeDAO = new HomePageDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        GameDataAccessObject gameDAO = new GameDataAccessObject(); // TODO: Input API key here

        // TODO: Maybe use a builder here also??
        ScheduleController scheduleController = ScheduleUseCaseFactory.createScheduleUseCase(viewManagerModel, scheduleViewModel, gameDAO);
        HomePageController homePageController = HomePageUseCaseFactory.createHomePageUseCase(viewManagerModel, homePageViewModel, homeDAO);

        ScheduleView scheduleView = ScheduleUseCaseFactory.create(scheduleViewModel, scheduleController, homePageController);
        views.add(scheduleView, scheduleView.viewName);

        HomeView homeView = HomePageUseCaseFactory.create(homePageViewModel, homePageController, scheduleController);
        views.add(homeView, homeView.viewName);

        viewManagerModel.setActiveView(homeView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
