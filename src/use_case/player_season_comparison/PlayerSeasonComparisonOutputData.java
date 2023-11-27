package use_case.player_season_comparison;

import java.util.Hashtable;
import java.util.Map;

public class PlayerSeasonComparisonOutputData {

    private Map<String, Object> playerSeasonComparison = new Hashtable<>();
    private boolean useCaseFailed;

    public PlayerSeasonComparisonOutputData(Map<String, Object> playerSeasonComparison, boolean useCaseFailed) {
        this.playerSeasonComparison = playerSeasonComparison;
        this.useCaseFailed = useCaseFailed;
    }

    public Map<String, Object> getPlayerSeasonComparison() {
        return this.playerSeasonComparison;
    }
}
