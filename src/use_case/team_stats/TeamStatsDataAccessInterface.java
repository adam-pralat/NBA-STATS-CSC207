package use_case.team_stats;

import entity.Team;
import org.json.JSONException;

import java.util.Map;

public interface TeamStatsDataAccessInterface {
    public boolean existsById(int teamID) throws JSONException;
    Team getTeamInfo(int teamID);
    Map<String, Object> getYearlyRecord(int teamID, int season);
    Map<String, Object> getTeamYearlyStats(int teamID, int season);
}
