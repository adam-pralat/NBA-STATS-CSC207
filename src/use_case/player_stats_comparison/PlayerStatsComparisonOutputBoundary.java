package use_case.player_stats_comparison;

import use_case.player_stats.PlayerStatsOutputData;

public interface PlayerStatsComparisonOutputBoundary {
    void prepareSuccessView(PlayerStatsComparisonOutputData playerStatsComparisonOutputData);

    void prepareFailView(String error);
}
