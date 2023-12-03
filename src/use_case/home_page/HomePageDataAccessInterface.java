package use_case.home_page;

import entity.*;

import java.util.Map;

// TODO: Maybe use 2 DAI - One for player and one for team
// Maybe use facade to combine team DAO and player DAO into a single DAO????

public interface HomePageDataAccessInterface {
    boolean playerExistsById(int playerID);
    Player getPlayerInfo(int playerID);
    PlayerStats getPlayerYearlyStats(int playerID, int season);

    boolean teamExistsById(int teamID);

    Team getTeamInfo(int teamID);

    TeamRecord getTeamYearlyRecord(int teamID, int season); // Wins, Losses, past 10 wins, past 10 losses in given season

    TeamStats getTeamYearlyStats(int teamID, int season);

    // TODO: Team data access
}
