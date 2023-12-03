package use_case.player_season_comparison;

import entity.Player;
import entity.PlayerStats;

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
                // create player profile info
                Player playerSeason1Info = playerSeasonComparisonAccessObject.getPlayerInfo(id);
                Player playerSeason2Info = playerSeasonComparisonAccessObject.getPlayerInfo(id);

                // create maps for season1 and season2
                PlayerStats season1PlayerStats = playerSeasonComparisonAccessObject.getPlayerYearlyStats(id, season1);
                PlayerStats season2PlayerStats = playerSeasonComparisonAccessObject.getPlayerYearlyStats(id, season2);

                // add the stats to respective Player instance
                playerSeason1Info.addStat(season1PlayerStats);
                playerSeason2Info.addStat(season2PlayerStats);

                // this map is for storing the stat change over time
//                Map<String, Object> playerSeasonComparison = new HashMap<>();
//
//                // set up iterator to set up playerStatComparison Map
//                Iterator<Map.Entry<String, Object>> iterator = season2PlayerStats.entrySet().iterator();
//
//                // iterate through the season2 stats, and from it, subtract season1 stats
//                // then put those values in playerStatComparison
//                while (iterator.hasNext()) {
//                    Map.Entry<String, Object> entry = iterator.next();
//                    if (season1PlayerStats.containsKey(entry.getKey())) {
//                        int statDiff;
//                        statDiff = (int) entry.getValue() - (int) season1PlayerStats.get(entry.getKey());
//                        playerSeasonComparison.put(entry.getKey(), statDiff);
//                    }
//                }

                playerSeasonComparisonPresenter.prepareSuccessView(new PlayerSeasonComparisonOutputData(playerSeason1Info.toMap(), playerSeason2Info.toMap(), true));

            } catch (Exception e) {
                playerSeasonComparisonPresenter.prepareFailView(e.toString());
            }
        }
    }
}
