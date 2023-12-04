package data_access;

import entity.*;
import org.json.JSONException;
import use_case.home_page.HomePageDataAccessInterface;
import use_case.player_comparison.PlayerComparisonDataAccessInterface;
import use_case.schedule.ScheduleDataAccessInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// TODO: Rewrite tests with new player stats
// Data access object that returns filler data for testing purposes
public class TestDAO implements HomePageDataAccessInterface, ScheduleDataAccessInterface, PlayerComparisonDataAccessInterface {
  
    @Override
    public boolean playerExistsById(int playerID) {
        return true;
    }

    @Override
    public boolean existsById(int playerID) throws JSONException { return true; }

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

    // Schedule Methods
    @Override
    public Map<Integer, Game> getGames(LocalDate date) {
        Map<Integer, Game> games = new HashMap<>();
        games.put(12714, new Game(
                12714 ,
                LocalDateTime.of(2023, 11, 16, 18, 30),
                "Finished",
                "Kaseya Center, Miami, FL",
                20,
                "Miami Heat",
                "MIA",
                "https://upload.wikimedia.org/wikipedia/fr/thumb/1/1c/Miami_Heat_-_Logo.svg/1200px-Miami_Heat_-_Logo.svg.png",
                122,
                4,
                "Brooklyn Nets",
                "BKN",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Brooklyn_Nets_newlogo.svg/130px-Brooklyn_Nets_newlogo.svg.png",
                115));
        games.put(12715, new Game(
                12715,
                LocalDateTime.of(2023, 11, 16, 21, 0),
                "Finished",
                "Chase Center, San Francisco, CA",
                11,
                "Golden State Warriors",
                "GSW",
                "https://upload.wikimedia.org/wikipedia/fr/thumb/d/de/Warriors_de_Golden_State_logo.svg/1200px-Warriors_de_Golden_State_logo.svg.png",
                109,
                25,
                "Oklahoma City Thunder",
                "OKC",
                "https://upload.wikimedia.org/wikipedia/fr/thumb/4/4f/Thunder_d%27Oklahoma_City_logo.svg/1200px-Thunder_d%27Oklahoma_City_logo.svg.png",
                128));
        return games;
    }
}
