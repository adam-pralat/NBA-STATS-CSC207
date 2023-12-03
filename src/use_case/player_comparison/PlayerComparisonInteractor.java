package use_case.player_comparison;

import entity.Player;
import entity.PlayerStats;

import java.util.Map;

public class PlayerComparisonInteractor implements PlayerComparisonInputBoundary {
    final PlayerComparisonDataAccessInterface playerComparisonAccessObject;
    final PlayerComparisonOutputBoundary playerComparisonPresenter;

    public PlayerComparisonInteractor(PlayerComparisonDataAccessInterface playerComparisonAccessObject,
                                      PlayerComparisonOutputBoundary playerComparisonOutputBoundary){
        this.playerComparisonAccessObject = playerComparisonAccessObject;
        this.playerComparisonPresenter = playerComparisonOutputBoundary;
    }

    @Override
    public void execute(PlayerComparisonInputData playerComparisonInputData) {
        int id1 = playerComparisonInputData.getId1();
        int id2 = playerComparisonInputData.getId2();
        if (!playerComparisonAccessObject.existsById(id1)) {
            playerComparisonPresenter.prepareFailView("Player ID1 does not exist.");
        } else if (!playerComparisonAccessObject.existsById(id2)) {
            playerComparisonPresenter.prepareFailView("Player ID2 does not exist.");
        } else {
            try {
                int currSeason = 2023;
                Player player1 = playerComparisonAccessObject.getPlayerInfo(id1);
                Player player2 = playerComparisonAccessObject.getPlayerInfo(id2);
                PlayerStats seasonPlayerStats1 = playerComparisonAccessObject.getPlayerYearlyStats(id1, currSeason);
                player1.addStat(seasonPlayerStats1);
                PlayerStats seasonPlayerStats2 = playerComparisonAccessObject.getPlayerYearlyStats(id2, currSeason);
                player2.addStat(seasonPlayerStats2);
                playerComparisonPresenter.prepareSuccessView(new PlayerComparisonOutputData(player1.toMap(), player2.toMap(), true));
            } catch (Exception e) {
                playerComparisonPresenter.prepareFailView(e.toString());
            }
        }
    }
}
