package use_case.player_stats;

public interface PlayerStatsOutputBoundary {
    void prepareSuccessView(PlayerStatsOutputData id);

    void prepareFailView(String error);
}
