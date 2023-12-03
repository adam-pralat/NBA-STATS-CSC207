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


    public void prepareSuccessView(TeamStatsOutputData response) {
        Map<String, Object> teamStats = response.getTeamStats();

        TeamStatsState state = this.teamStatsViewModel.getState();

        // Set all state attributes. If an attribute is null, it is set to be an empty string
        state.setName((teamStats.get("name") != jsonNull) ? (teamStats.get("name").toString()) : (""));
        state.setNickname((teamStats.get("nickname") != jsonNull) ? (teamStats.get("nickname").toString()) : (""));
        state.setCode((teamStats.get("code") != jsonNull) ? (teamStats.get("code").toString()) : (""));
        state.setCity((teamStats.get("city") != jsonNull) ? (teamStats.get("city").toString()) : (""));
        state.setLogo((teamStats.get("logo") != jsonNull) ? (teamStats.get("logo").toString()) : (""));
        state.setConference((teamStats.get("conference") != jsonNull) ? (teamStats.get("conference").toString()) : (""));
        state.setPlayers((teamStats.get("players") != jsonNull) ? (teamStats.get("players").toString()) : (""));

        state.setWins((teamStats.get("wins") != jsonNull) ? (teamStats.get("wins").toString()) : (""));
        state.setLosses((teamStats.get("losses") != jsonNull) ? (teamStats.get("losses").toString()) : (""));
        state.setWinsPastTen((teamStats.get("winsPastTen") != jsonNull) ? (teamStats.get("winsPastTen").toString()) : (""));
        state.setLossesPastTen((teamStats.get("lossesPastTen") != jsonNull) ? (teamStats.get("lossesPastTen").toString()) : (""));
        state.setConferencePlace((teamStats.get("conferencePlace") != jsonNull) ? (teamStats.get("conferencePlace").toString()) : (""));

        state.setGames((teamStats.get("games") != jsonNull) ? (teamStats.get("games").toString()) : (""));
        state.setFastBreakPoints((teamStats.get("fastBreakPoints") != jsonNull) ? (teamStats.get("fastBreakPoints").toString()) : (""));
        state.setPointsInPaint((teamStats.get("pointsInPaint") != jsonNull) ? (teamStats.get("pointsInPaint").toString()) : (""));
        state.setSecondChancePoints((teamStats.get("secondChancePoints") != jsonNull) ? (teamStats.get("secondChancePoints").toString()) : (""));
        state.setPointsOffTurnovers((teamStats.get("pointsOffTurnovers") != jsonNull) ? (teamStats.get("pointsOffTurnovers").toString()) : (""));
        state.setPoints((teamStats.get("points") != jsonNull) ? (teamStats.get("points").toString()) : (""));
        state.setFieldGoalsMade((teamStats.get("fieldGoalsMade") != jsonNull) ? (teamStats.get("fieldGoalsMade").toString()) : (""));
        state.setFieldGoalsAttempted((teamStats.get("fieldGoalsAttempted") != jsonNull) ? (teamStats.get("fieldGoalsAttempted").toString()) : (""));
        state.setFreeThrowsMade((teamStats.get("freeThrowsMade") != jsonNull) ? (teamStats.get("freeThrowsMade").toString()) : (""));
        state.setFreeThrowsAttempted((teamStats.get("freeThrowsAttempted") != jsonNull) ? (teamStats.get("freeThrowsAttempted").toString()) : (""));
        state.setThreePointsMade((teamStats.get("threePointsMade") != jsonNull) ? (teamStats.get("threePointsMade").toString()) : (""));
        state.setThreePointsAttempted((teamStats.get("threePointsAttempted") != jsonNull) ? (teamStats.get("threePointsAttempted").toString()) : (""));
        state.setOffReb((teamStats.get("offReb") != jsonNull) ? (teamStats.get("offReb").toString()) : (""));
        state.setDefReb((teamStats.get("defReb") != jsonNull) ? (teamStats.get("defReb").toString()) : (""));
        state.setAssists((teamStats.get("assists") != jsonNull) ? (teamStats.get("assists").toString()) : (""));
        state.setpFouls((teamStats.get("pFouls") != jsonNull) ? (teamStats.get("pFouls").toString()) : (""));
        state.setSteals((teamStats.get("steals") != jsonNull) ? (teamStats.get("steals").toString()) : (""));
        state.setTurnovers((teamStats.get("turnovers") != jsonNull) ? (teamStats.get("turnovers").toString()) : (""));
        state.setBlocks((teamStats.get("blocks") != jsonNull) ? (teamStats.get("blocks").toString()) : (""));
        state.setPlusMinus((teamStats.get("plusMinus") != jsonNull) ? (teamStats.get("plusMinus").toString()) : (""));

        state.setFreeThrowPercentage((teamStats.get("freeThrowPercentage") != jsonNull) ? (teamStats.get("freeThrowPercentage").toString()) : (""));
        state.setFieldGoalPercentage((teamStats.get("fieldGoalPercentage") != jsonNull) ? (teamStats.get("fieldGoalPercentage").toString()) : (""));
        state.setThreePointPercentage((teamStats.get("threePointPercentage") != jsonNull) ? (teamStats.get("threePointPercentage").toString()) : (""));

        this.teamStatsViewModel.setState(state);
        this.teamStatsViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(teamStatsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

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
