package interface_adapter.team_stats;

import use_case.team_stats.TeamStatsInputBoundary;
import use_case.team_stats.TeamStatsInputData;

public class TeamStatsController {

    final TeamStatsInputBoundary teamStatsInputBoundary;

    public TeamStatsController(TeamStatsInputBoundary teamStatsInputBoundary) {
        this.teamStatsInputBoundary = teamStatsInputBoundary;
    }

    public void execute(int teamId) {

        //TeamStats Input Boundary has a minor error and was fixed in the other branch.
        //Pull the changes then the error here will be automatically fixed, because
        //TeamStats Input Boundary should have a teamStatsInputData as required type.
        TeamStatsInputData teamStatsInputData = new TeamStatsInputData(teamId);
        teamStatsInputBoundary.execute(teamStatsInputData);

    }

}