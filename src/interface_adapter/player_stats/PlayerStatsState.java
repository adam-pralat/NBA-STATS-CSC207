package interface_adapter.player_stats;

public class PlayerStatsState {

    private String playerStatsError;

    // Profile information
    private String firstName;
    private String lastName;
    private String birthDate; // YYYY-MM-DD
    private String country;
    private String height; // In meters
    private String weight; // In kg


    // Player information
    private String team; // Name of the player's current team
    private String position;
    private String jerseyNumber;
    private boolean active; // Whether or not the player is currently active


    // Statistic metrics
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

    // Statistic metrics for per game
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

    // Percentage metrics TODO: Add error fields
    private String freeThrowPercentage;
    private String fieldGoalPercentage;
    private String threePointPercentage;

    // instantiate Error fields

    // Profile information error
    private String firstNameError = null;
    private String lastNameError = null;
    private String birthDateError = null;
    private String countryError = null;
    private String heightError = null;
    private String weightError = null;


    // Player information error
    private String teamError = null;
    private String positionError = null;
    private String jerseyNumberError = null;
    private String activeError = null;


    // Statistic metrics error
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

    public PlayerStatsState(PlayerStatsState copy) {

        // Profile information
        firstName = copy.firstName;
        firstNameError = copy.firstNameError;
        lastName = copy.lastName;
        lastNameError = copy.lastNameError;
        birthDate = copy.birthDate; // YYYY-MM-DD
        birthDateError = copy.birthDateError;
        country = copy.country;
        countryError = copy.countryError;
        height = copy.height; // In meters
        heightError = copy.heightError;
        weight = copy.weight; // In kg
        weightError = copy.weightError;


        // Player information
        team = copy.team; // Name of the player's current team
        teamError = copy.teamError;
        position = copy.position;
        positionError = copy.positionError;
        jerseyNumber = copy.jerseyNumber;
        jerseyNumberError = copy.jerseyNumberError;
        active = copy.active; // Whether or not the player is currently active
        activeError = copy.activeError;

        // Statistic metrics
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

        // Per game metrics
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

        // Percentage metrics
        freeThrowPercentage = copy.freeThrowPercentage;
        fieldGoalPercentage = copy.fieldGoalPercentage;
        threePointPercentage = copy.threePointPercentage;

    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public PlayerStatsState() {}

    public String getPlayerStatsError() {
        return playerStatsError;
    }

    public void setPlayerStatsError(String playerStatsError) {
        this.playerStatsError = playerStatsError;
    }

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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getTeamError() {
        return teamError;
    }

    public void setTeamError(String teamError) {
        this.teamError = teamError;
    }

    public String getPositionError() {
        return positionError;
    }

    public void setPositionError(String positionError) {
        this.positionError = positionError;
    }

    public String getJerseyNumberError() {
        return jerseyNumberError;
    }

    public void setJerseyNumberError(String jerseyNumberError) {
        this.jerseyNumberError = jerseyNumberError;
    }

    public String getActiveError() {
        return activeError;
    }

    public void setActiveError(String activeError) {
        this.activeError = activeError;
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
}
