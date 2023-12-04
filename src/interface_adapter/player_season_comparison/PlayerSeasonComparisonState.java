package interface_adapter.player_season_comparison;

import interface_adapter.player_stats.PlayerStatsState;

public class PlayerSeasonComparisonState {

    private String playerSeasonComparisonError;

    // Profile information for the player in question
    private String firstName;
    private String lastName;
    private String birthDate; // YYYY-MM-DD
    private String country;

    // height and weight during Season 1
    private String height; // In meters
    private String weight; // In kg


    // Statistic metrics for Season 1
    private String gamesPlayed;
    private String points;
    private String assists;
    private String timePlayed; // How much time the player has played (In seconds)
    private String fieldGoalsMade;
    private String fieldGoalsAttempted;
    private String freeThrowsMade;
    private String freeThrowsAttempted;
    private String threePointsMade;
    private String threePointsAttempted;
    private String offensiveRebounds;
    private String defensiveRebounds;
    private String personalFouls;
    private String steals;
    private String turnovers;
    private String blocks;
    private String plusMinus;

    // Statistic metrics for per game for Season 1
    private String pointsPerGame;
    private String assistsPerGame;
    private String timePlayedPerGame; // How much time the player has played (In seconds)
    private String fieldGoalsMadePerGame;
    private String fieldGoalsAttemptedPerGame;
    private String freeThrowsMadePerGame;
    private String freeThrowsAttemptedPerGame;
    private String threePointsMadePerGame;
    private String threePointsAttemptedPerGame;
    private String offensiveReboundsPerGame;
    private String defensiveReboundsPerGame;
    private String reboundsPerGame;
    private String personalFoulsPerGame;
    private String stealsPerGame;
    private String turnoversPerGame;
    private String blocksPerGame;
    private String plusMinusPerGame;

    // Percentage metrics for Season 1
    private String freeThrowPercentage;
    private String fieldGoalPercentage;
    private String threePointPercentage;

    // Season 2 info

    // Statistic metrics for Season 2
    private String gamesPlayed1;
    private String points1;
    private String assists1;
    private String timePlayed1; // How much time the player has played (In seconds)
    private String fieldGoalsMade1;
    private String fieldGoalsAttempted1;
    private String freeThrowsMade1;
    private String freeThrowsAttempted1;
    private String threePointsMade1;
    private String threePointsAttempted1;
    private String offensiveRebounds1;
    private String defensiveRebounds1;
    private String personalFouls1;
    private String steals1;
    private String turnovers1;
    private String blocks1;
    private String plusMinus1;

    // Statistic metrics for per game for Player 2
    private String pointsPerGame1;
    private String assistsPerGame1;
    private String timePlayedPerGame1; // How much time the player has played (In seconds)
    private String fieldGoalsMadePerGame1;
    private String fieldGoalsAttemptedPerGame1;
    private String freeThrowsMadePerGame1;
    private String freeThrowsAttemptedPerGame1;
    private String threePointsMadePerGame1;
    private String threePointsAttemptedPerGame1;
    private String offensiveReboundsPerGame1;
    private String defensiveReboundsPerGame1;
    private String reboundsPerGame1;
    private String personalFoulsPerGame1;
    private String stealsPerGame1;
    private String turnoversPerGame1;
    private String blocksPerGame1;
    private String plusMinusPerGame1;

    // Percentage metrics for Season 2
    private String freeThrowPercentage1;
    private String fieldGoalPercentage1;
    private String threePointPercentage1;

    public PlayerSeasonComparisonState(PlayerSeasonComparisonState copy) {
        // Season 1 info
        // Profile information for Season 1
        firstName = copy.firstName;
        lastName = copy.lastName;
        birthDate = copy.birthDate; // YYYY-MM-DD

        // Player information for Season 1
        country = copy.country;
        height = copy.height; // In meters
        weight = copy.weight; // In kg

        // Statistic metrics for Season 1
        gamesPlayed = copy.gamesPlayed;
        points = copy.points;
        assists = copy.assists;
        timePlayed = copy.timePlayed; // How much time the player has played (In seconds)
        fieldGoalsMade = copy.fieldGoalsMade;
        fieldGoalsAttempted = copy.fieldGoalsAttempted;
        freeThrowsMade = copy.freeThrowsMade;
        freeThrowsAttempted = copy.freeThrowsAttempted;
        threePointsMade = copy.threePointsMade;
        threePointsAttempted = copy.threePointsAttempted;
        offensiveRebounds = copy.offensiveRebounds;
        defensiveRebounds = copy.defensiveRebounds;
        personalFouls = copy.personalFouls;
        steals = copy.steals;
        turnovers = copy.turnovers;
        blocks = copy.blocks;
        plusMinus = copy.plusMinus;

        // Per game metrics for Season 1
        pointsPerGame = copy.pointsPerGame;
        assistsPerGame = copy.assistsPerGame;
        timePlayedPerGame = copy.timePlayedPerGame; // How much time the player has played (In seconds)
        fieldGoalsMadePerGame = copy.fieldGoalsMadePerGame;
        fieldGoalsAttemptedPerGame = copy.fieldGoalsAttemptedPerGame;
        freeThrowsMadePerGame = copy.freeThrowsMadePerGame;
        freeThrowsAttemptedPerGame = copy.freeThrowsAttemptedPerGame;
        threePointsMadePerGame = copy.threePointsMadePerGame;
        threePointsAttemptedPerGame = copy.threePointsAttemptedPerGame;
        offensiveReboundsPerGame = copy.offensiveReboundsPerGame;
        defensiveReboundsPerGame = copy.defensiveReboundsPerGame;
        reboundsPerGame = copy.reboundsPerGame;
        personalFoulsPerGame = copy.personalFoulsPerGame;
        stealsPerGame = copy.stealsPerGame;
        turnoversPerGame = copy.turnoversPerGame;
        blocksPerGame = copy.blocksPerGame;
        plusMinusPerGame = copy.plusMinusPerGame;

        // Percentage metrics for Season 1
        freeThrowPercentage = copy.freeThrowPercentage;
        fieldGoalPercentage = copy.fieldGoalPercentage;
        threePointPercentage = copy.threePointPercentage;

        // Season 2 info

        // Statistic metrics for Season 2
        gamesPlayed1 = copy.gamesPlayed1;
        points1 = copy.points1;
        assists1 = copy.assists1;
        timePlayed1 = copy.timePlayed1; // How much time the player has played (In seconds)
        fieldGoalsMade1 = copy.fieldGoalsMade1;
        fieldGoalsAttempted1 = copy.fieldGoalsAttempted1;
        freeThrowsMade1 = copy.freeThrowsMade1;
        freeThrowsAttempted1 = copy.freeThrowsAttempted1;
        threePointsMade1 = copy.threePointsMade1;
        threePointsAttempted1 = copy.threePointsAttempted1;
        offensiveRebounds1 = copy.offensiveRebounds1;
        defensiveRebounds1 = copy.defensiveRebounds1;
        personalFouls1 = copy.personalFouls1;
        steals1 = copy.steals1;
        turnovers1 = copy.turnovers1;
        blocks1 = copy.blocks1;
        plusMinus1 = copy.plusMinus1;

        // Per game metrics for Season 2
        pointsPerGame1 = copy.pointsPerGame1;
        assistsPerGame1 = copy.assistsPerGame1;
        timePlayedPerGame1 = copy.timePlayedPerGame1; // How much time the player has played (In seconds)
        fieldGoalsMadePerGame1 = copy.fieldGoalsMadePerGame1;
        fieldGoalsAttemptedPerGame1 = copy.fieldGoalsAttemptedPerGame1;
        freeThrowsMadePerGame1 = copy.freeThrowsMadePerGame1;
        freeThrowsAttemptedPerGame1 = copy.freeThrowsAttemptedPerGame1;
        threePointsMadePerGame1 = copy.threePointsMadePerGame1;
        threePointsAttemptedPerGame1 = copy.threePointsAttemptedPerGame1;
        offensiveReboundsPerGame1 = copy.offensiveReboundsPerGame1;
        defensiveReboundsPerGame1 = copy.defensiveReboundsPerGame1;
        reboundsPerGame1 = copy.reboundsPerGame1;
        personalFoulsPerGame1 = copy.personalFoulsPerGame1;
        stealsPerGame1 = copy.stealsPerGame1;
        turnoversPerGame1 = copy.turnoversPerGame1;
        blocksPerGame1 = copy.blocksPerGame1;
        plusMinusPerGame1 = copy.plusMinusPerGame1;

        // Percentage metrics for Season 2
        freeThrowPercentage1 = copy.freeThrowPercentage1;
        fieldGoalPercentage1 = copy.fieldGoalPercentage1;
        threePointPercentage1 = copy.threePointPercentage1;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public PlayerSeasonComparisonState() {
    }

    public void setPlayerSeasonComparisonError(String playerComparisonError) {
        this.playerSeasonComparisonError = playerComparisonError;
    }

    // Getters and setters for player information
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    // Season 1 Getters + Setters

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(String gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(String timePlayed) {
        this.timePlayed = timePlayed;
    }

    public String getFieldGoalsMade() {
        return fieldGoalsMade;
    }

    public void setFieldGoalsMade(String fieldGoalsMade) {
        this.fieldGoalsMade = fieldGoalsMade;
    }

    public String getFieldGoalsAttempted() {
        return fieldGoalsAttempted;
    }

    public void setFieldGoalsAttempted(String fieldGoalsAttempted) {
        this.fieldGoalsAttempted = fieldGoalsAttempted;
    }

    public String getFreeThrowsMade() {
        return freeThrowsMade;
    }

    public void setFreeThrowsMade(String freeThrowsMade) {
        this.freeThrowsMade = freeThrowsMade;
    }

    public String getFreeThrowsAttempted() {
        return freeThrowsAttempted;
    }

    public void setFreeThrowsAttempted(String freeThrowsAttempted) {
        this.freeThrowsAttempted = freeThrowsAttempted;
    }

    public String getThreePointsMade() {
        return threePointsMade;
    }

    public void setThreePointsMade(String threePointsMade) {
        this.threePointsMade = threePointsMade;
    }

    public String getThreePointsAttempted() {
        return threePointsAttempted;
    }

    public void setThreePointsAttempted(String threePointsAttempted) {
        this.threePointsAttempted = threePointsAttempted;
    }

    public String getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(String offensiveRebounds) {
        this.offensiveRebounds = offensiveRebounds;
    }

    public String getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(String defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    public String getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(String personalFouls) {
        this.personalFouls = personalFouls;
    }

    public String getSteals() {
        return steals;
    }

    public void setSteals(String steals) {
        this.steals = steals;
    }

    public String getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(String turnovers) {
        this.turnovers = turnovers;
    }

    public String getBlocks() {
        return blocks;
    }

    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    public String getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(String plusMinus) {
        this.plusMinus = plusMinus;
    }

    public String getPointsPerGame() {
        return pointsPerGame;
    }

    public void setPointsPerGame(String pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
    }

    public String getAssistsPerGame() {
        return assistsPerGame;
    }

    public void setAssistsPerGame(String assistsPerGame) {
        this.assistsPerGame = assistsPerGame;
    }

    public String getTimePlayedPerGame() {
        return timePlayedPerGame;
    }

    public void setTimePlayedPerGame(String timePlayedPerGame) {
        this.timePlayedPerGame = timePlayedPerGame;
    }

    public String getFieldGoalsMadePerGame() {
        return fieldGoalsMadePerGame;
    }

    public void setFieldGoalsMadePerGame(String fieldGoalsMadePerGame) {
        this.fieldGoalsMadePerGame = fieldGoalsMadePerGame;
    }

    public String getFieldGoalsAttemptedPerGame() {
        return fieldGoalsAttemptedPerGame;
    }

    public void setFieldGoalsAttemptedPerGame(String fieldGoalsAttemptedPerGame) {
        this.fieldGoalsAttemptedPerGame = fieldGoalsAttemptedPerGame;
    }

    public String getFreeThrowsMadePerGame() {
        return freeThrowsMadePerGame;
    }

    public void setFreeThrowsMadePerGame(String freeThrowsMadePerGame) {
        this.freeThrowsMadePerGame = freeThrowsMadePerGame;
    }

    public String getFreeThrowsAttemptedPerGame() {
        return freeThrowsAttemptedPerGame;
    }

    public void setFreeThrowsAttemptedPerGame(String freeThrowsAttemptedPerGame) {
        this.freeThrowsAttemptedPerGame = freeThrowsAttemptedPerGame;
    }

    public String getThreePointsMadePerGame() {
        return threePointsMadePerGame;
    }

    public void setThreePointsMadePerGame(String threePointsMadePerGame) {
        this.threePointsMadePerGame = threePointsMadePerGame;
    }

    public String getThreePointsAttemptedPerGame() {
        return threePointsAttemptedPerGame;
    }

    public void setThreePointsAttemptedPerGame(String threePointsAttemptedPerGame) {
        this.threePointsAttemptedPerGame = threePointsAttemptedPerGame;
    }

    public String getOffensiveReboundsPerGame() {
        return offensiveReboundsPerGame;
    }

    public void setOffensiveReboundsPerGame(String offensiveReboundsPerGame) {
        this.offensiveReboundsPerGame = offensiveReboundsPerGame;
    }

    public String getDefensiveReboundsPerGame() {
        return defensiveReboundsPerGame;
    }

    public void setDefensiveReboundsPerGame(String defensiveReboundsPerGame) {
        this.defensiveReboundsPerGame = defensiveReboundsPerGame;
    }

    public String getReboundsPerGame() {
        return reboundsPerGame;
    }

    public void setReboundsPerGame(String reboundsPerGame) {
        this.reboundsPerGame = reboundsPerGame;
    }

    public String getPersonalFoulsPerGame() {
        return personalFoulsPerGame;
    }

    public void setPersonalFoulsPerGame(String personalFoulsPerGame) {
        this.personalFoulsPerGame = personalFoulsPerGame;
    }

    public String getStealsPerGame() {
        return stealsPerGame;
    }

    public void setStealsPerGame(String stealsPerGame) {
        this.stealsPerGame = stealsPerGame;
    }

    public String getTurnoversPerGame() {
        return turnoversPerGame;
    }

    public void setTurnoversPerGame(String turnoversPerGame) {
        this.turnoversPerGame = turnoversPerGame;
    }

    public String getBlocksPerGame() {
        return blocksPerGame;
    }

    public void setBlocksPerGame(String blocksPerGame) {
        this.blocksPerGame = blocksPerGame;
    }

    public String getPlusMinusPerGame() {
        return plusMinusPerGame;
    }

    public void setPlusMinusPerGame(String plusMinusPerGame) {
        this.plusMinusPerGame = plusMinusPerGame;
    }

    public String getFreeThrowPercentage() {
        return freeThrowPercentage;
    }

    public void setFreeThrowPercentage(String freeThrowPercentage) {
        this.freeThrowPercentage = freeThrowPercentage;
    }

    public String getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }

    public void setFieldGoalPercentage(String fieldGoalPercentage) {
        this.fieldGoalPercentage = fieldGoalPercentage;
    }

    public String getThreePointPercentage() {
        return threePointPercentage;
    }

    public void setThreePointPercentage(String threePointPercentage) {
        this.threePointPercentage = threePointPercentage;
    }

    // Season 2 Getters + Setters
    public String getGamesPlayed1() {
        return gamesPlayed1;
    }

    public void setGamesPlayed1(String gamesPlayed1) {
        this.gamesPlayed1 = gamesPlayed1;
    }

    public String getPoints1() {
        return points1;
    }

    public void setPoints1(String points1) {
        this.points1 = points1;
    }

    public String getAssists1() {
        return assists1;
    }

    public void setAssists1(String assists1) {
        this.assists1 = assists1;
    }

    public String getTimePlayed1() {
        return timePlayed1;
    }

    public void setTimePlayed1(String timePlayed1) {
        this.timePlayed1 = timePlayed1;
    }

    public String getFieldGoalsMade1() {
        return fieldGoalsMade1;
    }

    public void setFieldGoalsMade1(String fieldGoalsMade1) {
        this.fieldGoalsMade1 = fieldGoalsMade1;
    }

    public String getFieldGoalsAttempted1() {
        return fieldGoalsAttempted1;
    }

    public void setFieldGoalsAttempted1(String fieldGoalsAttempted1) {
        this.fieldGoalsAttempted1 = fieldGoalsAttempted1;
    }

    public String getFreeThrowsMade1() {
        return freeThrowsMade1;
    }

    public void setFreeThrowsMade1(String freeThrowsMade1) {
        this.freeThrowsMade1 = freeThrowsMade1;
    }

    public String getFreeThrowsAttempted1() {
        return freeThrowsAttempted1;
    }

    public void setFreeThrowsAttempted1(String freeThrowsAttempted1) {
        this.freeThrowsAttempted1 = freeThrowsAttempted1;
    }

    public String getThreePointsMade1() {
        return threePointsMade1;
    }

    public void setThreePointsMade1(String threePointsMade1) {
        this.threePointsMade1 = threePointsMade1;
    }

    public String getThreePointsAttempted1() {
        return threePointsAttempted1;
    }

    public void setThreePointsAttempted1(String threePointsAttempted1) {
        this.threePointsAttempted1 = threePointsAttempted1;
    }

    public String getOffensiveRebounds1() {
        return offensiveRebounds1;
    }

    public void setOffensiveRebounds1(String offensiveRebounds1) {
        this.offensiveRebounds1 = offensiveRebounds1;
    }

    public String getDefensiveRebounds1() {
        return defensiveRebounds1;
    }

    public void setDefensiveRebounds1(String defensiveRebounds1) {
        this.defensiveRebounds1 = defensiveRebounds1;
    }

    public String getPersonalFouls1() {
        return personalFouls1;
    }

    public void setPersonalFouls1(String personalFouls1) {
        this.personalFouls1 = personalFouls1;
    }

    public String getSteals1() {
        return steals1;
    }

    public void setSteals1(String steals1) {
        this.steals1 = steals1;
    }

    public String getTurnovers1() {
        return turnovers1;
    }

    public void setTurnovers1(String turnovers1) {
        this.turnovers1 = turnovers1;
    }

    public String getBlocks1() {
        return blocks1;
    }

    public void setBlocks1(String blocks1) {
        this.blocks1 = blocks1;
    }

    public String getPlusMinus1() {
        return plusMinus1;
    }

    public void setPlusMinus1(String plusMinus1) {
        this.plusMinus1 = plusMinus1;
    }

    public String getPointsPerGame1() {
        return pointsPerGame1;
    }

    public void setPointsPerGame1(String pointsPerGame1) {
        this.pointsPerGame1 = pointsPerGame1;
    }

    public String getAssistsPerGame1() {
        return assistsPerGame1;
    }

    public void setAssistsPerGame1(String assistsPerGame1) {
        this.assistsPerGame1 = assistsPerGame1;
    }

    public String getTimePlayedPerGame1() {
        return timePlayedPerGame1;
    }

    public void setTimePlayedPerGame1(String timePlayedPerGame1) {
        this.timePlayedPerGame1 = timePlayedPerGame1;
    }

    public String getFieldGoalsMadePerGame1() {
        return fieldGoalsMadePerGame1;
    }

    public void setFieldGoalsMadePerGame1(String fieldGoalsMadePerGame1) {
        this.fieldGoalsMadePerGame1 = fieldGoalsMadePerGame1;
    }

    public String getFieldGoalsAttemptedPerGame1() {
        return fieldGoalsAttemptedPerGame1;
    }

    public void setFieldGoalsAttemptedPerGame1(String fieldGoalsAttemptedPerGame1) {
        this.fieldGoalsAttemptedPerGame1 = fieldGoalsAttemptedPerGame1;
    }

    public String getFreeThrowsMadePerGame1() {
        return freeThrowsMadePerGame1;
    }

    public void setFreeThrowsMadePerGame1(String freeThrowsMadePerGame1) {
        this.freeThrowsMadePerGame1 = freeThrowsMadePerGame1;
    }

    public String getFreeThrowsAttemptedPerGame1() {
        return freeThrowsAttemptedPerGame1;
    }

    public void setFreeThrowsAttemptedPerGame1(String freeThrowsAttemptedPerGame1) {
        this.freeThrowsAttemptedPerGame1 = freeThrowsAttemptedPerGame1;
    }

    public String getThreePointsMadePerGame1() {
        return threePointsMadePerGame1;
    }

    public void setThreePointsMadePerGame1(String threePointsMadePerGame1) {
        this.threePointsMadePerGame1 = threePointsMadePerGame1;
    }

    public String getThreePointsAttemptedPerGame1() {
        return threePointsAttemptedPerGame1;
    }

    public void setThreePointsAttemptedPerGame1(String threePointsAttemptedPerGame1) {
        this.threePointsAttemptedPerGame1 = threePointsAttemptedPerGame1;
    }

    public String getOffensiveReboundsPerGame1() {
        return offensiveReboundsPerGame1;
    }

    public void setOffensiveReboundsPerGame1(String offensiveReboundsPerGame1) {
        this.offensiveReboundsPerGame1 = offensiveReboundsPerGame1;
    }

    public String getDefensiveReboundsPerGame1() {
        return defensiveReboundsPerGame1;
    }

    public void setDefensiveReboundsPerGame1(String defensiveReboundsPerGame1) {
        this.defensiveReboundsPerGame1 = defensiveReboundsPerGame1;
    }

    public String getReboundsPerGame1() {
        return reboundsPerGame1;
    }

    public void setReboundsPerGame1(String reboundsPerGame1) {
        this.reboundsPerGame1 = reboundsPerGame1;
    }

    public String getPersonalFoulsPerGame1() {
        return personalFoulsPerGame1;
    }

    public void setPersonalFoulsPerGame1(String personalFoulsPerGame1) {
        this.personalFoulsPerGame1 = personalFoulsPerGame1;
    }

    public String getStealsPerGame1() {
        return stealsPerGame1;
    }

    public void setStealsPerGame1(String stealsPerGame1) {
        this.stealsPerGame1 = stealsPerGame1;
    }

    public String getTurnoversPerGame1() {
        return turnoversPerGame1;
    }

    public void setTurnoversPerGame1(String turnoversPerGame1) {
        this.turnoversPerGame1 = turnoversPerGame1;
    }

    public String getBlocksPerGame1() {
        return blocksPerGame1;
    }

    public void setBlocksPerGame1(String blocksPerGame1) {
        this.blocksPerGame1 = blocksPerGame1;
    }

    public String getPlusMinusPerGame1() {
        return plusMinusPerGame1;
    }

    public void setPlusMinusPerGame1(String plusMinusPerGame1) {
        this.plusMinusPerGame1 = plusMinusPerGame1;
    }

    public String getFreeThrowPercentage1() {
        return freeThrowPercentage1;
    }

    public void setFreeThrowPercentage1(String freeThrowPercentage1) {
        this.freeThrowPercentage1 = freeThrowPercentage1;
    }

    public String getFieldGoalPercentage1() {
        return fieldGoalPercentage1;
    }

    public void setFieldGoalPercentage1(String fieldGoalPercentage1) {
        this.fieldGoalPercentage1 = fieldGoalPercentage1;
    }

    public String getThreePointPercentage1() {
        return threePointPercentage1;
    }

    public void setThreePointPercentage1(String threePointPercentage1) {
        this.threePointPercentage1 = threePointPercentage1;
    }
}