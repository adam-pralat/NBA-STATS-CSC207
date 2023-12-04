package use_case.team_stats;

import entity.Team;
import entity.TeamRecord;
import entity.TeamStats;
import interface_adapter.team_stats.TeamStatsPresenter;

import java.time.LocalDate;
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
        int teamId = inputData.getTeamId();
        if (!teamStatsDataAccessInterface.existsById(teamId)) {
            teamStatsOutputBoundary.prepareFailView("Team ID does not exist.");
        } else {
            try {
                int currSeason = LocalDate.now().getYear();
                Team team = teamStatsDataAccessInterface.getTeamInfo(teamId);

                //TODO method for yearly record, similar to Yearly stats

                for(int season = 2015; season <= currSeason; season++) {
                    TeamStats seasonTeamStats = teamStatsDataAccessInterface.getTeamYearlyStats(teamId, season);
                    team.addStat(seasonTeamStats);
                    TeamRecord seasonTeamRecord = teamStatsDataAccessInterface.getYearlyRecord(teamId, season);
                    team.addRecord(seasonTeamRecord);
                }

                teamStatsOutputBoundary.prepareSuccessView(new TeamStatsOutputData(team.toMap(), true));
            } catch (Exception e) {
                teamStatsOutputBoundary.prepareFailView(e.toString());
            }
        }
    }
}
