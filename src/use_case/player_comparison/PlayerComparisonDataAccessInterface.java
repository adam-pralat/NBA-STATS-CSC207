package use_case.player_comparison;

import entity.Player;
import org.json.JSONException;

import java.util.Map;

public interface PlayerComparisonDataAccessInterface {
    public boolean existsById(int playerID) throws JSONException;
    Player getPlayerInfo(int playerID);
    Map<String, Object> getPlayerYearlyStats(int playerID, int season);
}
