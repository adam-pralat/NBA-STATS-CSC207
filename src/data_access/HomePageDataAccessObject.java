package data_access;

// Data access object to be used for home page data access interface where both team and player data needs to be accessed

import entity.Player;
import entity.Team;
import use_case.home_page.HomePageDataAccessInterface;

import java.util.Map;

public class HomePageDataAccessObject implements HomePageDataAccessInterface {
    private PlayerDataAccessObject playerDAO;
    private TeamDataAccessObject teamDAO;
    private final String apiKey;

    public HomePageDataAccessObject(String apiKey) {
        this.apiKey = apiKey;
        this.playerDAO = new PlayerDataAccessObject(apiKey);
        this.teamDAO = new TeamDataAccessObject(apiKey);
    }

    @Override
    public boolean playerExistsById(int playerID) {
        return playerDAO.existsById(playerID);
    }

    @Override
    public Player getPlayerInfo(int playerID) {
        return playerDAO.getPlayerInfo(playerID);
    }

    @Override
    public Map<String, Object> getPlayerYearlyStats(int playerID, int season) {
        return playerDAO.getPlayerYearlyStats(playerID, season);
    }

    @Override
    public boolean teamExistsById(int teamID) {
        // return teamDAO.existsById(teamID); - Make sure to check if it is an nba team
        return false;
    }

    @Override
    public Team getTeamInfo(int teamID){
        return teamDAO.getTeamInfo(teamID);
    }

    @Override
    public Team getTeamYearlyStats(int teamID, int season) {
        return teamDAO.getTeamYearlyStats(teamID, season); // Stats for given season
    }

    @Override
    public Team getTeamYearlyRecord(int teamID, int season) {
        return teamDAO.getYearlyRecord(teamID, season); // Record for given season
    }
}
