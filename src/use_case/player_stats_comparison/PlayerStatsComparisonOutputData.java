package use_case.player_stats_comparison;

import java.util.Hashtable;
import java.util.Map;

public class PlayerStatsComparisonOutputData {

    private Map<String, Object> playerStatsComparison = new Hashtable<>();
    private boolean useCaseFailed;

    public PlayerStatsComparisonOutputData(Map<String, Object> playerStats, boolean useCaseFailed) {
        this.playerStatsComparison = playerStatsComparison;
        this.useCaseFailed = useCaseFailed;
    }

    public Map<String, Object> getPlayerStatsComparison() {
        return this.playerStatsComparison;
    }
}
