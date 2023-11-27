package use_case.player_stats_comparison;

import entity.Player;
import org.json.JSONException;

import java.util.Map;

public interface PlayerStatsComparisonDataAccessInterface {
    public boolean existsById(int playerID) throws JSONException;

    // TODO: is getPlayerInfo really needed?
    Player getPlayerInfo(int playerID);
    Map<String, Object> getPlayerYearlyStats(int playerID, int season);
}