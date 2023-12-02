package use_case.home_page;


import entity.*;

import java.util.Map;
import java.util.Random;

public class HomePageInteractor implements HomePageInputBoundary {
    final HomePageDataAccessInterface homePageDataAccessInterface;
    final HomePageOutputBoundary homePageOutputBoundary;
    final int[] possibleTeamIDs = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 38, 41};

    public HomePageInteractor(HomePageDataAccessInterface homePageDataAccessInterface, HomePageOutputBoundary homePageOutputBoundary) {
        this.homePageDataAccessInterface = homePageDataAccessInterface;
        this.homePageOutputBoundary = homePageOutputBoundary;
    }

    @Override
    public void execute(HomePageInputData inputData) {
        Random rand = new Random();
        int currSeason = 2023;
        // Get a random id for the team that the featured player will be on
        int randomPlayerTeamID = possibleTeamIDs[rand.nextInt(possibleTeamIDs.length)];
        int randomPlayerID = 2; // TODO: random id from players on randomPlayerTeamID in season currSeason - Need to do data access for this

        // Pick random team id, get stats for current season
        int randomTeamID = possibleTeamIDs[rand.nextInt(possibleTeamIDs.length)];

        try {
            // Get season stats for the current season
            Player player = homePageDataAccessInterface.getPlayerInfo(randomPlayerID);
            PlayerStats currentSeasonPlayerStats = homePageDataAccessInterface.getPlayerYearlyStats(randomPlayerID, currSeason);
            player.addStat(currentSeasonPlayerStats);


            Team team = homePageDataAccessInterface.getTeamInfo(randomTeamID);
            TeamRecord teamRecord = homePageDataAccessInterface.getTeamYearlyRecord(randomTeamID, currSeason);
            TeamStats teamStats = homePageDataAccessInterface.getTeamYearlyStats(randomTeamID, currSeason);
            team.addRecord(teamRecord);
            team.addStat(teamStats);


            // Create output data
            HomePageOutputData outputData = new HomePageOutputData(
                    player.getFirstName(),
                    player.getLastName(),
                    player.getBirthDate(),
                    player.getCountry(),
                    player.getTeam(),
                    player.pointsPerGame(),
                    player.assistsPerGame(),
                    player.freeThrowPercentage(),
                    player.fieldGoalPercentage(),
                    player.threePointPercentage(),
                    player.minutesPerGame(),
                    player.stealsPerGame(),
                    player.turnoversPerGame(),
                    player.blocksPerGame(),
                    team.getName(),
                    team.getNickname(),
                    team.getCode(),
                    team.getConference(),
                    team.getWins(),
                    team.getLosses(),
                    team.getWinsPastTen(),
                    team.getLossesPastTen(),
                    team.getConferencePlace(),
                    team.pointsPerGame(),
                    team.freeThrowPercentage(),
                    team.fieldGoalPercentage(),
                    team.threePointPercentage(),
                    false

            );

            // Call output boundary with output data passed in
            homePageOutputBoundary.prepareSuccessView(outputData);
        } catch(RuntimeException e) {
            homePageOutputBoundary.prepareFailView(e.toString());
        }

    }
}
