package use_case.team_stats;

import java.util.Hashtable;
import java.util.Map;

public class TeamStatsOutputData {

    private Map<String, Object> teamStats = new Hashtable<>();
    private boolean useCaseFailed;

    public TeamStatsOutputData(Map<String, Object> teamStats, boolean useCaseFailed) {
        this.teamStats = teamStats;
        this.useCaseFailed = useCaseFailed;
    }

    public Map<String, Object> getTeamStats() {
        return this.teamStats;
    }
}
