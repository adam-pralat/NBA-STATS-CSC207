package use_case.home_page;

import entity.Player;
import entity.Team;

import java.util.Map;

// TODO: Maybe use 2 DAI - One for player and one for team
// Maybe use facade to combine team DAO and player DAO into a single DAO????

public interface HomePageDataAccessInterface {
    boolean playerExistsById(int playerID);
    Player getPlayerInfo(int playerID);
    Map<String, Object> getPlayerYearlyStats(int playerID, int season);

    boolean teamExistsById(int teamID);

    Team getTeamInfo(int teamID);

    Map<String, Object> getTeamYearlyRecord(int teamID, int season); // Wins, Losses, past 10 wins, past 10 losses in given season

    Map<String, Object> getTeamYearlyStats(int teamID, int season);

    // TODO: Team data access
}
