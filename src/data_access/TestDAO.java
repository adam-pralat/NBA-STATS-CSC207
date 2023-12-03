package data_access;

import entity.*;
import use_case.home_page.HomePageDataAccessInterface;

import java.util.ArrayList;

// TODO: Rewrite tests with new player stats
// Data access object that returns filler data for testing purposes
public class TestDAO implements HomePageDataAccessInterface {
    @Override
    public boolean playerExistsById(int playerID) {
        return true;
    }

    @Override
    public Player getPlayerInfo(int playerID) {
        return new Player(
                1,
                "A",
                "B",
                "2000-01-01",
                "Canada",
                2.01,
                85.6,
                "",
                "",
                0,
                true,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
        );
    }

    @Override
    public PlayerStats getPlayerYearlyStats(int playerID, int season) {
        return new PlayerStats(
                1,
                1,
                1,
                60,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                "Toronto Raptors",
                "G"
        );
    }

    @Override
    public boolean teamExistsById(int teamID) {
        return true;
    }

    @Override
    public Team getTeamInfo(int teamID) {
        return new Team(
                1,
                "Name",
                "Nickname",
                "AAA",
                "City",
                "Logo URL",
                "Conference",
                new ArrayList<>(),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
        );
    }

    @Override
    public TeamRecord getTeamYearlyRecord(int teamID, int season) {
        return new TeamRecord(
                1,
                0,
                1,
                0,
                1
        );
    }

    @Override
    public TeamStats getTeamYearlyStats(int teamID, int season) {
        return new TeamStats(
                1,
                1,
                1,
                1,
                1,
                4,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1
        );
    }
}
