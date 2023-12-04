package data_access;

import entity.*;
import use_case.home_page.HomePageDataAccessInterface;
import use_case.schedule.ScheduleDataAccessInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

//
public class TestDAOErrors implements HomePageDataAccessInterface, ScheduleDataAccessInterface {
    // HomePage methods
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

    // Schedule Methods
    @Override
    public Map<Integer, Game> getGames(LocalDate date) {
        throw new RuntimeException();
    }
}
