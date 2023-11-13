package use_case.team_stats;

public class TeamStatsInputData {
    final private int teamId;

    public TeamStatsInputData(int teamId) {
        if (teamId <= 0) {
            throw new IllegalArgumentException("Team Id can't be negative.");
        }
        this.teamId = teamId;
    }

    public int getTeamId() {
        return teamId;
    }
}
