package use_case.team_stats;

import entity.Team;
import entity.TeamRecord;
import entity.TeamStats;
import org.json.JSONException;

import java.util.Map;

public interface TeamStatsDataAccessInterface {
    public boolean existsById(int teamID) throws JSONException;
    Team getTeamInfo(int teamID);
    TeamRecord getYearlyRecord(int teamID, int season);
    TeamStats getTeamYearlyStats(int teamID, int season);
}
