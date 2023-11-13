package use_case.player_stats;

import java.util.Dictionary;
import java.util.Hashtable;

public class PlayerStatsOutputData {

    private Dictionary<String, Object> playerStats = new Hashtable<>();
    private boolean useCaseFailed;

    public PlayerStatsOutputData(Dictionary<String, Object> playerStats, boolean useCaseFailed) {
        this.playerStats = playerStats;
        this.useCaseFailed = useCaseFailed;
    }

    public Dictionary<String, Object> getPlayerStats() {
        return this.playerStats;
    }
}
