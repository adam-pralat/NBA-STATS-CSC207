package use_case.player_stats;

public interface PlayerStatsOutputBoundary {
    void prepareSuccessView(PlayerStatsOutputData response);

    void prepareFailView(String error);
}
