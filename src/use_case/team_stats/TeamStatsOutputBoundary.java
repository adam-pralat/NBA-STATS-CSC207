package use_case.team_stats;

public interface TeamStatsOutputBoundary {
    void prepareSuccessView(TeamStatsOutputData response);
    void prepareFailView(String error);
}
