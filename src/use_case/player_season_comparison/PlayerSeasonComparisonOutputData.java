package use_case.player_season_comparison;

import java.util.Hashtable;
import java.util.Map;

public class PlayerSeasonComparisonOutputData {
    private Map<String, Object> playerSeason1Stats = new Hashtable<>();
    private Map<String, Object> playerSeason2Stats = new Hashtable<>();
    private boolean useCaseFailed;

    public PlayerSeasonComparisonOutputData(Map<String, Object> playerSeason1Stats, Map<String, Object> playerSeason2Stats, boolean useCaseFailed) {
        this.playerSeason1Stats = playerSeason1Stats;
        this.playerSeason2Stats = playerSeason2Stats;
        this.useCaseFailed = useCaseFailed;
    }

    public Map<String, Object> getPlayerSeason1Stats() {return this.playerSeason1Stats;}

    public Map<String, Object> getPlayerSeason2Stats() {
        return this.playerSeason2Stats;
    }

    public boolean isUseCaseFailed() {
        return this.useCaseFailed;
    }
}
