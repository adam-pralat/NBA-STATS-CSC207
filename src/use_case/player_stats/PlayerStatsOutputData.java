package use_case.player_stats;

import java.util.Hashtable;
import java.util.Map;

public class PlayerStatsOutputData {

    private Map<String, Object> playerStats = new Hashtable<>();
    private boolean useCaseFailed;

    public PlayerStatsOutputData(Map<String, Object> playerStats, boolean useCaseFailed) {
        this.playerStats = playerStats;
        this.useCaseFailed = useCaseFailed;
    }

    public Map<String, Object> getPlayerStats() {
        return this.playerStats;
    }
}
