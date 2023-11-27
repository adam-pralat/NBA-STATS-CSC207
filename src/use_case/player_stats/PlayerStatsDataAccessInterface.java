package use_case.player_stats;

import entity.Player;
import org.json.JSONException;

import java.util.Map;

public interface PlayerStatsDataAccessInterface {
    public boolean existsById(int playerID) throws JSONException;
    Player getPlayerInfo(int playerID);
    Map<String, Object> getPlayerYearlyStats(int playerID, int season);
}
