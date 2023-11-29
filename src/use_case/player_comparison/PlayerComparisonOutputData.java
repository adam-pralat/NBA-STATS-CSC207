package use_case.player_comparison;

import java.util.Hashtable;
import java.util.Map;

public class PlayerComparisonOutputData {
    private Map<String, Object> playerStats1 = new Hashtable<>();
    private Map<String, Object> playerStats2 = new Hashtable<>();
    private boolean useCaseFailed;

    public PlayerComparisonOutputData(Map<String, Object> playerStats1, Map<String, Object> playerStats2,
                                      boolean useCaseFailed){
        this.playerStats1 = playerStats1;
        this.playerStats2 = playerStats2;
        this.useCaseFailed = useCaseFailed;
    }

    public Map<String, Object> getPlayerYearlyStats1() { return this.playerStats1; }

    public Map<String, Object> getPlayerYearlyStats2() { return this.playerStats2; }
}
