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

    // instantiate Error fields

    // Profile information error for Season 1
    private String firstNameError = null;
    private String lastNameError = null;
    private String birthDateError = null;
    private String countryError = null;
    private String heightError = null;
    private String weightError = null;

    // Statistic metrics error for Season 1
    private String gamesPlayedError = null;
    private String pointsError = null;
    private String assistsError = null;
    private String timePlayedError = null;
    private String fieldGoalsMadeError = null;
    private String fieldGoalsAttemptedError = null;
    private String freeThrowsMadeError = null;
    private String freeThrowsAttemptedError = null;
    private String threePointsMadeError = null;
    private String threePointsAttemptedError = null;
    private String offensiveReboundsError = null;
    private String defensiveReboundsError = null;
    private String personalFoulsError = null;
    private String stealsError = null;
    private String turnoversError = null;
    private String blocksError = null;
    private String plusMinusError = null;

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

    // instantiate Error fields

    // Statistic metrics error for Season 2
    private String gamesPlayedError1 = null;
    private String pointsError1 = null;
    private String assistsError1 = null;
    private String timePlayedError1 = null;
    private String fieldGoalsMadeError1 = null;
    private String fieldGoalsAttemptedError1 = null;
    private String freeThrowsMadeError1 = null;
    private String freeThrowsAttemptedError1 = null;
    private String threePointsMadeError1 = null;
    private String threePointsAttemptedError1 = null;
    private String offensiveReboundsError1 = null;
    private String defensiveReboundsError1 = null;
    private String personalFoulsError1 = null;
    private String stealsError1 = null;
    private String turnoversError1 = null;
    private String blocksError1 = null;
    private String plusMinusError1 = null;

    public PlayerSeasonComparisonState(PlayerSeasonComparisonState copy) {
        // Season 1 info
        // Profile information for Season 1
        firstName = copy.firstName;
        firstNameError = copy.firstNameError;
        lastName = copy.lastName;
        lastNameError = copy.lastNameError;
        birthDate = copy.birthDate; // YYYY-MM-DD
        birthDateError = copy.birthDateError;

        // Player information for Season 1
        country = copy.country;
        countryError = copy.countryError;
        height = copy.height; // In meters
        heightError = copy.heightError;
        weight = copy.weight; // In kg
        weightError = copy.weightError;

        // Statistic metrics for Season 1
        gamesPlayed = copy.gamesPlayed;
        gamesPlayedError = copy.gamesPlayedError;
        points = copy.points;
        pointsError = copy.pointsError;
        assists = copy.assists;
        assistsError = copy.assistsError;
        timePlayed = copy.timePlayed; // How much time the player has played (In seconds)
        timePlayedError = copy.timePlayedError;
        fieldGoalsMade = copy.fieldGoalsMade;
        fieldGoalsMadeError = copy.fieldGoalsMadeError;
        fieldGoalsAttempted = copy.fieldGoalsAttempted;
        fieldGoalsAttemptedError = copy.fieldGoalsAttemptedError;
        freeThrowsMade = copy.freeThrowsMade;
        freeThrowsMadeError = copy.freeThrowsMadeError;
        freeThrowsAttempted = copy.freeThrowsAttempted;
        freeThrowsAttemptedError = copy.freeThrowsAttemptedError;
        threePointsMade = copy.threePointsMade;
        threePointsMadeError = copy.threePointsMadeError;
        threePointsAttempted = copy.threePointsAttempted;
        threePointsAttemptedError = copy.threePointsAttemptedError;
        offensiveRebounds = copy.offensiveRebounds;
        offensiveReboundsError = copy.offensiveReboundsError;
        defensiveRebounds = copy.defensiveRebounds;
        defensiveReboundsError = copy.defensiveReboundsError;
        personalFouls = copy.personalFouls;
        personalFoulsError = copy.personalFoulsError;
        steals = copy.steals;
        stealsError = copy.stealsError;
        turnovers = copy.turnovers;
        turnoversError = copy.turnoversError;
        blocks = copy.blocks;
        blocksError = copy.blocksError;
        plusMinus = copy.plusMinus;
        plusMinusError = copy.plusMinusError;

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
        gamesPlayedError1 = copy.gamesPlayedError1;
        points1 = copy.points1;
        pointsError1 = copy.pointsError1;
        assists1 = copy.assists1;
        assistsError1 = copy.assistsError1;
        timePlayed1 = copy.timePlayed1; // How much time the player has played (In seconds)
        timePlayedError1 = copy.timePlayedError1;
        fieldGoalsMade1 = copy.fieldGoalsMade1;
        fieldGoalsMadeError1 = copy.fieldGoalsMadeError1;
        fieldGoalsAttempted1 = copy.fieldGoalsAttempted1;
        fieldGoalsAttemptedError1 = copy.fieldGoalsAttemptedError1;
        freeThrowsMade1 = copy.freeThrowsMade1;
        freeThrowsMadeError1 = copy.freeThrowsMadeError1;
        freeThrowsAttempted1 = copy.freeThrowsAttempted1;
        freeThrowsAttemptedError1 = copy.freeThrowsAttemptedError1;
        threePointsMade1 = copy.threePointsMade1;
        threePointsMadeError1 = copy.threePointsMadeError1;
        threePointsAttempted1 = copy.threePointsAttempted1;
        threePointsAttemptedError1 = copy.threePointsAttemptedError1;
        offensiveRebounds1 = copy.offensiveRebounds1;
        offensiveReboundsError1 = copy.offensiveReboundsError1;
        defensiveRebounds1 = copy.defensiveRebounds1;
        defensiveReboundsError1 = copy.defensiveReboundsError1;
        personalFouls1 = copy.personalFouls1;
        personalFoulsError1 = copy.personalFoulsError1;
        steals1 = copy.steals1;
        stealsError1 = copy.stealsError1;
        turnovers1 = copy.turnovers1;
        turnoversError1 = copy.turnoversError1;
        blocks1 = copy.blocks1;
        blocksError1 = copy.blocksError1;
        plusMinus1 = copy.plusMinus1;
        plusMinusError1 = copy.plusMinusError1;

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

    // Errors
    public String getPlayerSeasonComparisonError() {
        return playerSeasonComparisonError;
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

    public String getFirstNameError() {
        return firstNameError;
    }

    public void setFirstNameError(String firstNameError) {
        this.firstNameError = firstNameError;
    }

    public String getLastNameError() {
        return lastNameError;
    }

    public void setLastNameError(String lastNameError) {
        this.lastNameError = lastNameError;
    }

    public String getBirthDateError() {
        return birthDateError;
    }

    public void setBirthDateError(String birthDateError) {
        this.birthDateError = birthDateError;
    }

    public String getCountryError() {
        return countryError;
    }

    public void setCountryError(String countryError) {
        this.countryError = countryError;
    }

    public String getHeightError() {
        return heightError;
    }

    public void setHeightError(String heightError) {
        this.heightError = heightError;
    }

    public String getWeightError() {
        return weightError;
    }

    public void setWeightError(String weightError) {
        this.weightError = weightError;
    }

    public String getGamesPlayedError() {
        return gamesPlayedError;
    }

    public void setGamesPlayedError(String gamesPlayedError) {
        this.gamesPlayedError = gamesPlayedError;
    }

    public String getPointsError() {
        return pointsError;
    }

    public void setPointsError(String pointsError) {
        this.pointsError = pointsError;
    }

    public String getAssistsError() {
        return assistsError;
    }

    public void setAssistsError(String assistsError) {
        this.assistsError = assistsError;
    }

    public String getTimePlayedError() {
        return timePlayedError;
    }

    public void setTimePlayedError(String timePlayedError) {
        this.timePlayedError = timePlayedError;
    }

    public String getFieldGoalsMadeError() {
        return fieldGoalsMadeError;
    }

    public void setFieldGoalsMadeError(String fieldGoalsMadeError) {
        this.fieldGoalsMadeError = fieldGoalsMadeError;
    }

    public String getFieldGoalsAttemptedError() {
        return fieldGoalsAttemptedError;
    }

    public void setFieldGoalsAttemptedError(String fieldGoalsAttemptedError) {
        this.fieldGoalsAttemptedError = fieldGoalsAttemptedError;
    }

    public String getFreeThrowsMadeError() {
        return freeThrowsMadeError;
    }

    public void setFreeThrowsMadeError(String freeThrowsMadeError) {
        this.freeThrowsMadeError = freeThrowsMadeError;
    }

    public String getFreeThrowsAttemptedError() {
        return freeThrowsAttemptedError;
    }

    public void setFreeThrowsAttemptedError(String freeThrowsAttemptedError) {
        this.freeThrowsAttemptedError = freeThrowsAttemptedError;
    }

    public String getThreePointsMadeError() {
        return threePointsMadeError;
    }

    public void setThreePointsMadeError(String threePointsMadeError) {
        this.threePointsMadeError = threePointsMadeError;
    }

    public String getThreePointsAttemptedError() {
        return threePointsAttemptedError;
    }

    public void setThreePointsAttemptedError(String threePointsAttemptedError) {
        this.threePointsAttemptedError = threePointsAttemptedError;
    }

    public String getOffensiveReboundsError() {
        return offensiveReboundsError;
    }

    public void setOffensiveReboundsError(String offensiveReboundsError) {
        this.offensiveReboundsError = offensiveReboundsError;
    }

    public String getDefensiveReboundsError() {
        return defensiveReboundsError;
    }

    public void setDefensiveReboundsError(String defensiveReboundsError) {
        this.defensiveReboundsError = defensiveReboundsError;
    }

    public String getPersonalFoulsError() {
        return personalFoulsError;
    }

    public void setPersonalFoulsError(String personalFoulsError) {
        this.personalFoulsError = personalFoulsError;
    }

    public String getStealsError() {
        return stealsError;
    }

    public void setStealsError(String stealsError) {
        this.stealsError = stealsError;
    }

    public String getTurnoversError() {
        return turnoversError;
    }

    public void setTurnoversError(String turnoversError) {
        this.turnoversError = turnoversError;
    }

    public String getBlocksError() {
        return blocksError;
    }

    public void setBlocksError(String blocksError) {
        this.blocksError = blocksError;
    }

    public String getPlusMinusError() {
        return plusMinusError;
    }

    public void setPlusMinusError(String plusMinusError) {
        this.plusMinusError = plusMinusError;
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

    public String getGamesPlayedError1() {
        return gamesPlayedError1;
    }

    public void setGamesPlayedError1(String gamesPlayedError1) {
        this.gamesPlayedError1 = gamesPlayedError1;
    }

    public String getPointsError1() {
        return pointsError1;
    }

    public void setPointsError1(String pointsError1) {
        this.pointsError1 = pointsError1;
    }

    public String getAssistsError1() {
        return assistsError1;
    }

    public void setAssistsError1(String assistsError1) {
        this.assistsError1 = assistsError1;
    }

    public String getTimePlayedError1() {
        return timePlayedError1;
    }

    public void setTimePlayedError1(String timePlayedError1) {
        this.timePlayedError1 = timePlayedError1;
    }

    public String getFieldGoalsMadeError1() {
        return fieldGoalsMadeError1;
    }

    public void setFieldGoalsMadeError1(String fieldGoalsMadeError1) {
        this.fieldGoalsMadeError1 = fieldGoalsMadeError1;
    }

    public String getFieldGoalsAttemptedError1() {
        return fieldGoalsAttemptedError1;
    }

    public void setFieldGoalsAttemptedError1(String fieldGoalsAttemptedError1) {
        this.fieldGoalsAttemptedError1 = fieldGoalsAttemptedError1;
    }

    public String getFreeThrowsMadeError1() {
        return freeThrowsMadeError1;
    }

    public void setFreeThrowsMadeError1(String freeThrowsMadeError1) {
        this.freeThrowsMadeError1 = freeThrowsMadeError1;
    }

    public String getFreeThrowsAttemptedError1() {
        return freeThrowsAttemptedError1;
    }

    public void setFreeThrowsAttemptedError1(String freeThrowsAttemptedError1) {
        this.freeThrowsAttemptedError1 = freeThrowsAttemptedError1;
    }

    public String getThreePointsMadeError1() {
        return threePointsMadeError1;
    }

    public void setThreePointsMadeError1(String threePointsMadeError1) {
        this.threePointsMadeError1 = threePointsMadeError1;
    }

    public String getThreePointsAttemptedError1() {
        return threePointsAttemptedError1;
    }

    public void setThreePointsAttemptedError1(String threePointsAttemptedError1) {
        this.threePointsAttemptedError1 = threePointsAttemptedError1;
    }

    public String getOffensiveReboundsError1() {
        return offensiveReboundsError1;
    }

    public void setOffensiveReboundsError1(String offensiveReboundsError1) {
        this.offensiveReboundsError1 = offensiveReboundsError1;
    }

    public String getDefensiveReboundsError1() {
        return defensiveReboundsError1;
    }

    public void setDefensiveReboundsError1(String defensiveReboundsError1) {
        this.defensiveReboundsError1 = defensiveReboundsError1;
    }

    public String getPersonalFoulsError1() {
        return personalFoulsError1;
    }

    public void setPersonalFoulsError1(String personalFoulsError1) {
        this.personalFoulsError1 = personalFoulsError1;
    }

    public String getStealsError1() {
        return stealsError1;
    }

    public void setStealsError1(String stealsError1) {
        this.stealsError1 = stealsError1;
    }

    public String getTurnoversError1() {
        return turnoversError1;
    }

    public void setTurnoversError1(String turnoversError1) {
        this.turnoversError1 = turnoversError1;
    }

    public String getBlocksError1() {
        return blocksError1;
    }

    public void setBlocksError1(String blocksError1) {
        this.blocksError1 = blocksError1;
    }

    public String getPlusMinusError1() {
        return plusMinusError1;
    }

    public void setPlusMinusError1(String plusMinusError1) {
        this.plusMinusError1 = plusMinusError1;
    }
}