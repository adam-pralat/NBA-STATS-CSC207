package use_case.player_stats;

import entity.Player;

import java.util.Map;

public interface PlayerStatsDataAccessInterface {
    boolean existsById(int playerId);
    Player getPlayerInfo(int playerID);
    Map<String, Object> getPlayerYearlyStats(int playerID, int season);
}
