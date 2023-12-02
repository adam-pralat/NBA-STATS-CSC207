package interface_adapter.team_stats;

import interface_adapter.ViewManagerModel;
import org.json.JSONObject;
import use_case.team_stats.TeamStatsOutputBoundary;
import use_case.team_stats.TeamStatsOutputData;
import java.util.Map;

public class TeamStatsPresenter {

    private final TeamStatsViewModel teamStatsViewModel;
    private ViewManagerModel viewManagerModel;
    private Object jsonNull = JSONObject.NULL;

    public TeamStatsPresenter(TeamStatsViewModel teamStatsViewModel, ViewManagerModel viewManagerModel) {
        this.teamStatsViewModel = teamStatsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(TeamStatsOutputData response) {
        Map<String, Object> teamStats = response.getTeamStats();

        TeamStatsState state = this.teamStatsViewModel.getState();

        state.setName()


        this.teamStatsViewModel.setState(state);
        this.teamStatsViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(teamStatsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        TeamStatsState state = teamStatsViewModel.getState();
        state.setTeamStatsError("Sorry, we could not get the stats for the team you requested. Please try again.");
        teamStatsViewModel.setState(state);
        this.teamStatsViewModel.setState(state);
        this.teamStatsViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(teamStatsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

}
