package use_case.player_season_comparison;

public interface PlayerSeasonComparisonOutputBoundary {
    void prepareSuccessView(PlayerSeasonComparisonOutputData playerSeasonComparisonOutputData);

    void prepareFailView(String error);
}
