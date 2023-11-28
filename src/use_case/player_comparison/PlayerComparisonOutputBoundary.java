package use_case.player_comparison;

public interface PlayerComparisonOutputBoundary {
    void prepareSuccessView(PlayerComparisonOutputData response);

    void prepareFailView(String error);
}
