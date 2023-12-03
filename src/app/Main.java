package app;

import data_access.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_page.HomePageController;
import interface_adapter.home_page.HomePageViewModel;
import interface_adapter.id_information.IdInformationController;
import interface_adapter.id_information.IdInformationViewModel;
import interface_adapter.player_comparison.PlayerComparisonController;
import interface_adapter.player_comparison.PlayerComparisonViewModel;
import interface_adapter.player_stats.PlayerStatsController;
import interface_adapter.schedule.ScheduleController;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.team_stats.TeamStatsController;
import view.HomeView;
import view.PlayerComparisonView;
import view.ScheduleView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static app.IdInformationUseCaseFactory.getController;

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
        PlayerComparisonViewModel playerComparisonViewModel = new PlayerComparisonViewModel();
        ScheduleViewModel scheduleViewModel = new ScheduleViewModel();
        IdInformationViewModel idInformationViewModel = new IdInformationViewModel();

        PlayerDataAccessObject playerDAO = new PlayerDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        TeamDataAccessObject teamDAO = new TeamDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        HomePageDataAccessObject homeDAO = new HomePageDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        //PlayerComparisonDataAccessObject playerComparisonDAO = playerDAO; //new PlayerComparisonDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        GameDataAccessObject gameDAO = new GameDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        IdInformationDataAccessObject IDDAO = new IdInformationDataAccessObject();

        // TODO: Maybe use a builder here also??
        ScheduleController scheduleController = ScheduleUseCaseFactory.createScheduleUseCase(viewManagerModel, scheduleViewModel, gameDAO);
        HomePageController homePageController = HomePageUseCaseFactory.createHomePageUseCase(viewManagerModel, homePageViewModel, homeDAO);

        TeamStatsController teamStatsController = new TeamStatsController();
        ScheduleView scheduleView = ScheduleUseCaseFactory.create(scheduleViewModel, scheduleController, homePageController, teamStatsController);
        views.add(scheduleView, scheduleView.viewName);


        IdInformationController idInformationController = IdInformationUseCaseFactory.getController(idInformationViewModel, IDDAO);

        PlayerComparisonController playerComparisonController = PlayerComparisonUseCaseFactory.createPlayerComparisonUseCase(viewManagerModel, playerComparisonViewModel, playerDAO);
        PlayerComparisonView playerComparisonView = PlayerComparisonUseCaseFactory.create(playerComparisonViewModel, playerComparisonController, idInformationController, idInformationViewModel, homePageController);
        views.add(playerComparisonView, playerComparisonView.viewName);

        HomeView homeView = HomePageUseCaseFactory.create(homePageViewModel, homePageController, scheduleController, playerComparisonController);
        views.add(homeView, homeView.viewName);

        viewManagerModel.setActiveView(homeView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
