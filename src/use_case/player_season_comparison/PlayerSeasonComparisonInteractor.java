package use_case.player_season_comparison;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class PlayerSeasonComparisonInteractor implements PlayerSeasonComparisonInputBoundary {

    final PlayerSeasonComparisonDataAccessInterface playerSeasonComparisonAccessObject;
    final PlayerSeasonComparisonOutputBoundary playerSeasonComparisonPresenter;

    public PlayerSeasonComparisonInteractor(PlayerSeasonComparisonDataAccessInterface playerSeasonComparisonAccessObject, PlayerSeasonComparisonOutputBoundary playerSeasonComparisonPresenter) {
        this.playerSeasonComparisonAccessObject = playerSeasonComparisonAccessObject;
        this.playerSeasonComparisonPresenter = playerSeasonComparisonPresenter;
    }

    @Override
    public void execute(PlayerSeasonComparisonInputData inputData) {
        int id = inputData.getId();
        int season1 = inputData.getSeason1();
        int season2 = inputData.getSeason2();
        if (!playerSeasonComparisonAccessObject.existsById(id)) {
            playerSeasonComparisonPresenter.prepareFailView(("Player ID does not exist."));
        } else {
            try {
                // TODO does season2 > season1 have to be true?
                // create maps for season1 and season2
                Map<String, Object> season1PlayerStats = playerSeasonComparisonAccessObject.getPlayerYearlyStats(id, season1);
                Map<String, Object> season2PlayerStats = playerSeasonComparisonAccessObject.getPlayerYearlyStats(id, season2);

                // this map is for storing the stat change over time
                Map<String, Object> playerSeasonComparison = new HashMap<>();

                // set up iterator to set up playerStatComparison Map
                Iterator<Map.Entry<String, Object>> iterator = season2PlayerStats.entrySet().iterator();

                // iterate through the season2 stats, and from it, subtract season1 stats
                // then put those values in playerStatComparison
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = iterator.next();
                    if (season1PlayerStats.containsKey(entry.getKey())) {
                        int statDiff;
                        statDiff = (int) entry.getValue() - (int) season1PlayerStats.get(entry.getKey());
                        playerSeasonComparison.put(entry.getKey(), statDiff);
                    }
                }

                // TODO: should the second parameter here be true?
                playerSeasonComparisonPresenter.prepareSuccessView(new PlayerSeasonComparisonOutputData(playerSeasonComparison, true));

            } catch (Exception e) {
                playerSeasonComparisonPresenter.prepareFailView(e.toString());
            }
        }
    }
}