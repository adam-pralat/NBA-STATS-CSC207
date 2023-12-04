package app;

import data_access.*;
import entity.PlayerStats;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_page.HomePageController;
import interface_adapter.home_page.HomePageViewModel;
import interface_adapter.id_information.IdInformationController;
import interface_adapter.id_information.IdInformationViewModel;
import interface_adapter.player_comparison.PlayerComparisonController;
import interface_adapter.player_comparison.PlayerComparisonViewModel;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonController;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonViewModel;
import interface_adapter.player_stats.PlayerStatsViewModel;
import interface_adapter.player_stats.PlayerStatsController;
import interface_adapter.schedule.ScheduleController;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.team_stats.TeamStatsController;
import interface_adapter.team_stats.TeamStatsViewModel;
import use_case.id_information.IdInformationDataAccessInterface;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static app.IdInformationUseCaseFactory.getController;

public class Main {
    static ViewManagerModel viewManagerModel;
    public static void main(String[] args) {
        JFrame application = new JFrame("Java Jumpman");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // ViewModels
        HomePageViewModel homePageViewModel = new HomePageViewModel();
        ScheduleViewModel scheduleViewModel = new ScheduleViewModel();
        PlayerComparisonViewModel playerComparisonViewModel = new PlayerComparisonViewModel();
        IdInformationViewModel idInformationViewModel = new IdInformationViewModel();
        PlayerSeasonComparisonViewModel playerSeasonComparisonViewModel = new PlayerSeasonComparisonViewModel();
        TeamStatsViewModel teamStatsViewModel = new TeamStatsViewModel();
        PlayerStatsViewModel playerStatsViewModel = new PlayerStatsViewModel();

        // DataAccessObjects
        PlayerDataAccessObject playerDAO = new PlayerDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        TeamDataAccessObject teamDAO = new TeamDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        HomePageDataAccessObject homeDAO = new HomePageDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        GameDataAccessObject gameDAO = new GameDataAccessObject("7925154257mshf7cd3eb10ac507cp1d04b9jsnaba7faa4cf09");
        IdInformationDataAccessObject IDDAO = new IdInformationDataAccessObject();

        // Controllers
        ScheduleController scheduleController = ScheduleUseCaseFactory.createScheduleUseCase(viewManagerModel, scheduleViewModel, gameDAO);
        HomePageController homePageController = HomePageUseCaseFactory.createHomePageUseCase(viewManagerModel, homePageViewModel, homeDAO);
        TeamStatsController teamStatsController = TeamStatsUseCaseFactory.createTeamStatsUseCase(viewManagerModel, teamStatsViewModel, teamDAO);
        PlayerSeasonComparisonController playerSeasonComparisonController = PlayerSeasonComparisonUseCaseFactory.createPlayerSeasonComparisonUseCase(viewManagerModel, playerSeasonComparisonViewModel, playerDAO);
        PlayerStatsController playerStatsController = PlayerStatsUseCaseFactory.createPlayerStatsUseCase(viewManagerModel, playerStatsViewModel, playerDAO);
        PlayerComparisonController playerComparisonController = PlayerComparisonUseCaseFactory.createPlayerComparisonUseCase(viewManagerModel, playerComparisonViewModel, playerDAO);
        IdInformationController idInformationController = IdInformationUseCaseFactory.getController(idInformationViewModel, IDDAO);

        // Views
        HomeView homeView = HomePageUseCaseFactory.create(homePageViewModel, homePageController, scheduleController, playerComparisonController, playerSeasonComparisonController, playerStatsController, teamStatsController);
        views.add(homeView, homeView.viewName);

        ScheduleView scheduleView = ScheduleUseCaseFactory.create(scheduleViewModel, scheduleController, homePageController, teamStatsController);
        views.add(scheduleView, scheduleView.viewName);

        PlayerStatsView playerStatsView;
        try {
            playerStatsView = PlayerStatsUseCaseFactory.create(viewManagerModel, playerStatsViewModel, playerDAO, idInformationViewModel, IDDAO, homePageController);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assert playerStatsView != null;
        views.add(playerStatsView, playerStatsView.viewName);

        TeamView teamView = TeamStatsUseCaseFactory.create(teamStatsViewModel, teamStatsController, homePageController);
        views.add(teamView, teamView.viewName);

        PlayerComparisonView playerComparisonView = PlayerComparisonUseCaseFactory.create(playerComparisonViewModel, playerComparisonController, idInformationController, idInformationViewModel, homePageController);
        assert playerComparisonView != null;
        views.add(playerComparisonView, playerComparisonView.viewName);

        PlayerSeasonComparisonView playerSeasonComparisonView;
        try {
            playerSeasonComparisonView = PlayerSeasonComparisonUseCaseFactory.create(viewManagerModel, playerSeasonComparisonViewModel, playerDAO, idInformationViewModel, IDDAO, homePageController);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assert playerSeasonComparisonView != null;
        views.add(playerSeasonComparisonView, playerSeasonComparisonView.viewName);

        viewManagerModel.setActiveView(homeView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
