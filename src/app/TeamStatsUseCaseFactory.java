package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.home_page.HomePageController;
import interface_adapter.team_stats.TeamStatsController;
import interface_adapter.team_stats.TeamStatsPresenter;
import interface_adapter.team_stats.TeamStatsViewModel;
import use_case.team_stats.TeamStatsDataAccessInterface;
import use_case.team_stats.TeamStatsInputBoundary;
import use_case.team_stats.TeamStatsInteractor;
import use_case.team_stats.TeamStatsOutputBoundary;
import view.TeamView;

public class TeamStatsUseCaseFactory {
    private TeamStatsUseCaseFactory() {}

    public static TeamView create(TeamStatsViewModel teamStatsViewModel, TeamStatsController teamStatsController, HomePageController homePageController) {
        return new TeamView(teamStatsController, teamStatsViewModel, homePageController);
    }

    public static TeamStatsController createTeamStatsUseCase(ViewManagerModel viewManagerModel, TeamStatsViewModel teamStatsViewModel, TeamStatsDataAccessInterface teamStatsDataAccessObject) {
        TeamStatsOutputBoundary teamStatsOutputBoundary = new TeamStatsPresenter(teamStatsViewModel, viewManagerModel);
        TeamStatsInputBoundary teamStatsInteractor = new TeamStatsInteractor(teamStatsDataAccessObject, teamStatsOutputBoundary);
        return new TeamStatsController(teamStatsInteractor);
    }
}
