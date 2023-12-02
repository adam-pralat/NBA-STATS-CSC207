package interface_adapter.home_page;

import interface_adapter.ViewManagerModel;
import use_case.home_page.HomePageOutputBoundary;
import use_case.home_page.HomePageOutputData;

public class HomePagePresenter implements HomePageOutputBoundary {

    private final HomePageViewModel homePageViewModel;
    private ViewManagerModel viewManagerModel;

    public HomePagePresenter(HomePageViewModel homePageViewModel, ViewManagerModel viewManagerModel) {
        this.homePageViewModel = homePageViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(HomePageOutputData response) {
        HomePageState state = this.homePageViewModel.getState();

        // Player attributes
        state.setPlayerFirstName(response.getPlayerFirstName());
        state.setPlayerLastName(response.getPlayerLastName());
        state.setPlayerBirthDate(response.getPlayerBirthDate());
        state.setPlayerCountry(response.getPlayerCountry());
        state.setPlayerTeam(response.getPlayerTeam());
        state.setPlayerPointsPerGame(response.getPlayerPointsPerGame());
        state.setPlayerAssistsPerGame(response.getPlayerAssistsPerGame());
        state.setPlayerFreeThrowPercentage(response.getPlayerFreeThrowPercentage());
        state.setPlayerFieldGoalPercentage(response.getPlayerFieldGoalPercentage());
        state.setPlayerThreePointPercentage(response.getPlayerThreePointPercentage());
        state.setPlayerStealsPerGame(response.getPlayerStealsPerGame());
        state.setPlayerBlocksPerGame(response.getPlayerBlocksPerGame()); // Note, ignored turnovers for now
        state.setPlayerMinutesPlayedPerGame(response.getPlayerMinutesPlayedPerGame());

        // Team attributes
        state.setTeamName(response.getTeamName());
        state.setTeamNickname(response.getTeamNickname());
        state.setTeamCode(response.getTeamCode());
        state.setConference(response.getConference());
        state.setTeamWins(response.getTeamWins());
        state.setTeamLosses(response.getTeamLosses());
        state.setTeamsWinsLastTen(response.getTeamsWinsLastTen());
        state.setTeamsLossesLastTen(response.getTeamsLossesLastTen());
        state.setConferencePlace(response.getConferencePlace());
        state.setTeamPointsPerGame(response.getTeamPointsPerGame());
        state.setTeamFreeThrowPercentage(response.getTeamFreeThrowPercentage());
        state.setTeamFieldGoalPercentage(response.getTeamFieldGoalPercentage());
        state.setTeamThreePointPercentage(response.getTeamThreePointPercentage());

        this.homePageViewModel.setState(state);
        this.homePageViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(homePageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    };

   public void prepareFailView(String error) {
       HomePageState state = this.homePageViewModel.getState();
       state.setError(error);
       this.viewManagerModel.setActiveView(homePageViewModel.getViewName());
       this.viewManagerModel.firePropertyChanged();

       this.homePageViewModel.setState(state);
       this.homePageViewModel.firePropertyChanged();
   };
}
