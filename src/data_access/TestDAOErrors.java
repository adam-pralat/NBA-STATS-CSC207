package data_access;

import entity.*;
import org.json.JSONException;
import use_case.home_page.HomePageDataAccessInterface;
import use_case.player_comparison.PlayerComparisonDataAccessInterface;

import java.util.ArrayList;

//
public class TestDAOErrors implements HomePageDataAccessInterface, PlayerComparisonDataAccessInterface {
    @Override
    public boolean playerExistsById(int playerID) {
        throw new RuntimeException();
    }

    @Override
    public boolean existsById(int playerID) throws JSONException { throw new RuntimeException(); }

    @Override
    public Player getPlayerInfo(int playerID) {
        throw new RuntimeException();
    }

    @Override
    public PlayerStats getPlayerYearlyStats(int playerID, int season) {
        throw new RuntimeException();
    }

    @Override
    public boolean teamExistsById(int teamID) {
        throw new RuntimeException();
    }

    @Override
    public Team getTeamInfo(int teamID) {
        throw new RuntimeException();
    }

    @Override
    public TeamRecord getTeamYearlyRecord(int teamID, int season) {
        throw new RuntimeException();
    }

    @Override
    public TeamStats getTeamYearlyStats(int teamID, int season) {
        throw new RuntimeException();
    }
}
