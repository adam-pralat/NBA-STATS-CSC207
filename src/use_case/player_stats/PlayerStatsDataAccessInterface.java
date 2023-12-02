package use_case.player_stats;

import entity.Player;
import entity.PlayerStats;
import org.json.JSONException;

import java.util.Map;

public interface PlayerStatsDataAccessInterface {
    public boolean existsById(int playerID) throws JSONException;
    Player getPlayerInfo(int playerID);
    PlayerStats getPlayerYearlyStats(int playerID, int season);
}
