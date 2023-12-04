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
        try {
            if (!playerSeasonComparisonAccessObject.existsById(id)) {
                playerSeasonComparisonPresenter.prepareFailView(("Sorry, we could not get that data."));
            } else {
                    Player playerSeason1Info = playerSeasonComparisonAccessObject.getPlayerInfo(id);
                    Player playerSeason2Info = playerSeasonComparisonAccessObject.getPlayerInfo(id);
                    PlayerStats season1PlayerStats = playerSeasonComparisonAccessObject.getPlayerYearlyStats(id, season1);
                    PlayerStats season2PlayerStats = playerSeasonComparisonAccessObject.getPlayerYearlyStats(id, season2);
                    playerSeason1Info.addStat(season1PlayerStats);
                    playerSeason2Info.addStat(season2PlayerStats);
                    playerSeasonComparisonPresenter.prepareSuccessView(new PlayerSeasonComparisonOutputData(playerSeason1Info.toMap(), playerSeason2Info.toMap(), false));
            }
        } catch (Exception e){
            playerSeasonComparisonPresenter.prepareFailView("Sorry, we could not get that data.");
        }
    }
}
