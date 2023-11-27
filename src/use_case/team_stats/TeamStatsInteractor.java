package use_case.team_stats;

import entity.Team;
import interface_adapter.team_stats.TeamStatsPresenter;

import java.util.Map;
import java.util.Objects;

public class TeamStatsInteractor implements TeamStatsInputBoundary {

    final TeamStatsDataAccessInterface teamStatsDataAccessInterface;

    final TeamStatsOutputBoundary teamStatsOutputBoundary;

    public TeamStatsInteractor(TeamStatsDataAccessInterface teamStatsDataAccessInterface,
                               TeamStatsOutputBoundary teamStatsOutputBoundary) {
        this.teamStatsDataAccessInterface = teamStatsDataAccessInterface;
        this.teamStatsOutputBoundary = teamStatsOutputBoundary;
    }

    @Override
    public void execute(TeamStatsInputData inputData) {
        int teamid = inputData.getTeamId();
        if (!teamStatsDataAccessInterface.existsById(teamid)) {
            teamStatsOutputBoundary.prepareFailView("Team ID does not exist.");
        } else {
            try {
                int currSeason = 2023; //TODO method to figure out current season
                Team team = teamStatsDataAccessInterface.getTeamInfo(teamid);

                //TODO method for yearly record, similar to Yearly stats

                for(int season = 2015; season <= currSeason; season++) {
                    Map<String, Object> seasonTeamStats = teamStatsDataAccessInterface.getTeamYearlyStats(teamid, season);
                    team.addStat(seasonTeamStats);
                    Map<String, Object> seasonTeamRecord = teamStatsDataAccessInterface.getYearlyRecord(teamid, season);
                    team.addStat(seasonTeamRecord);
                }

                teamStatsOutputBoundary.prepareSuccessView(new TeamStatsOutputData(team.toMap(), true));
            } catch (Exception e) {
                teamStatsOutputBoundary.prepareFailView(e.toString());
            }
        }
    }
}
