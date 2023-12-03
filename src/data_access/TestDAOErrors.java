package data_access;

import entity.*;
import use_case.home_page.HomePageDataAccessInterface;

import java.util.ArrayList;

//
public class TestDAOErrors implements HomePageDataAccessInterface {
    @Override
    public boolean playerExistsById(int playerID) {
        throw new RuntimeException();
    }

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
