package interface_adapter.player_stats;

public class PlayerStatsState {

    // Profile information
    private String firstName;
    private String lastName;
    private String birthDate; // YYYY-MM-DD
    private String country;
    private double height; // In meters
    private double weight; // In kg


    // Player information
    private String team; // Name of the player's current team
    private String position;
    private int jerseyNumber;
    private boolean active; // Whether or not the player is currently active


    // Statistic metrics
    private int gamesPlayed;
    private int points;
    private int assists;
    private int timePlayed; // How much time the player has played (In seconds)
    private int fieldGoalsMade;
    private int fieldGoalsAttempted;
    private int freeThrowsMade;
    private int freeThrowsAttempted;
    private int threePointsMade;
    private int threePointsAttempted;
    private int offensiveRebounds;
    private int defensiveRebounds;
    private int personalFouls;
    private int steals;
    private int turnovers;
    private int blocks;
    private int plusMinus;

    // Statistic metrics for per game
    private double pointsPerGame;
    private double assistsPerGame;
    private double timePlayedPerGame; // How much time the player has played (In seconds)
    private double fieldGoalsMadePerGame;
    private double fieldGoalsAttemptedPerGame;
    private double freeThrowsMadePerGame;
    private double freeThrowsAttemptedPerGame;
    private double threePointsMadePerGame;
    private double threePointsAttemptedPerGame;
    private double offensiveReboundsPerGame;
    private double defensiveReboundsPerGame;
    private double personalFoulsPerGame;
    private double stealsPerGame;
    private double turnoversPerGame;
    private double blocksPerGame;
    private double plusMinusPerGame;

    // instantiate Error fields

    // Profile information error
    private String firstNameError = null;
    private String lastNameError = null;
    private String birthDateError = null;
    private String countryError = null;
    private double heightError = null;
    private double weightError = null;


    // Player information error
    private String teamError = null;
    private String positionError = null;
    private int jerseyNumberError = null;
    private boolean activeError = null;


    // Statistic metrics error
    private int gamesPlayedError = null;
    private int pointsError = null;
    private int assistsError = null;
    private int timePlayedError = null;
    private int fieldGoalsMadeError = null;
    private int fieldGoalsAttemptedError = null;
    private int freeThrowsMadeError = null;
    private int freeThrowsAttemptedError = null;
    private int threePointsMadeError = null;
    private int threePointsAttemptedError = null;
    private int offensiveReboundsError = null;
    private int defensiveReboundsError = null;
    private int personalFoulsError = null;
    private int stealsError = null;
    private int turnoversError = null;
    private int blocksError = null;
    private int plusMinusError = null;

    public PlayerStatsState(PlayerStatsState copy) {

        // Profile information
        firstName = copy.firstName;
        firstNameError = copy.firstNameError;
        lastName = copy.lastName;
        lastNameError = copy.lastNameError;
        birthDate = copy.birthDate; // YYYY-MM-DD
        birthDateError = copy.birthDateError;
        country = copy.country;
        countryError = copy.countryError
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
        jerseyNumberError = copy.jerseyNumberError
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
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public PlayerStatsState() {}

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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
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

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getFieldGoalsMade() {
        return fieldGoalsMade;
    }

    public void setFieldGoalsMade(int fieldGoalsMade) {
        this.fieldGoalsMade = fieldGoalsMade;
    }

    public int getFieldGoalsAttempted() {
        return fieldGoalsAttempted;
    }

    public void setFieldGoalsAttempted(int fieldGoalsAttempted) {
        this.fieldGoalsAttempted = fieldGoalsAttempted;
    }

    public int getFreeThrowsMade() {
        return freeThrowsMade;
    }

    public void setFreeThrowsMade(int freeThrowsMade) {
        this.freeThrowsMade = freeThrowsMade;
    }

    public int getFreeThrowsAttempted() {
        return freeThrowsAttempted;
    }

    public void setFreeThrowsAttempted(int freeThrowsAttempted) {
        this.freeThrowsAttempted = freeThrowsAttempted;
    }

    public int getThreePointsMade() {
        return threePointsMade;
    }

    public void setThreePointsMade(int threePointsMade) {
        this.threePointsMade = threePointsMade;
    }

    public int getThreePointsAttempted() {
        return threePointsAttempted;
    }

    public void setThreePointsAttempted(int threePointsAttempted) {
        this.threePointsAttempted = threePointsAttempted;
    }

    public int getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(int offensiveRebounds) {
        this.offensiveRebounds = offensiveRebounds;
    }

    public int getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(int defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    public int getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(int personalFouls) {
        this.personalFouls = personalFouls;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(int plusMinus) {
        this.plusMinus = plusMinus;
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

    public double getHeightError() {
        return heightError;
    }

    public void setHeightError(double heightError) {
        this.heightError = heightError;
    }

    public double getWeightError() {
        return weightError;
    }

    public void setWeightError(double weightError) {
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

    public int getJerseyNumberError() {
        return jerseyNumberError;
    }

    public void setJerseyNumberError(int jerseyNumberError) {
        this.jerseyNumberError = jerseyNumberError;
    }

    public boolean isActiveError() {
        return activeError;
    }

    public void setActiveError(boolean activeError) {
        this.activeError = activeError;
    }

    public int getGamesPlayedError() {
        return gamesPlayedError;
    }

    public void setGamesPlayedError(int gamesPlayedError) {
        this.gamesPlayedError = gamesPlayedError;
    }

    public int getPointsError() {
        return pointsError;
    }

    public void setPointsError(int pointsError) {
        this.pointsError = pointsError;
    }

    public int getAssistsError() {
        return assistsError;
    }

    public void setAssistsError(int assistsError) {
        this.assistsError = assistsError;
    }

    public int getTimePlayedError() {
        return timePlayedError;
    }

    public void setTimePlayedError(int timePlayedError) {
        this.timePlayedError = timePlayedError;
    }

    public int getFieldGoalsMadeError() {
        return fieldGoalsMadeError;
    }

    public void setFieldGoalsMadeError(int fieldGoalsMadeError) {
        this.fieldGoalsMadeError = fieldGoalsMadeError;
    }

    public int getFieldGoalsAttemptedError() {
        return fieldGoalsAttemptedError;
    }

    public void setFieldGoalsAttemptedError(int fieldGoalsAttemptedError) {
        this.fieldGoalsAttemptedError = fieldGoalsAttemptedError;
    }

    public int getFreeThrowsMadeError() {
        return freeThrowsMadeError;
    }

    public void setFreeThrowsMadeError(int freeThrowsMadeError) {
        this.freeThrowsMadeError = freeThrowsMadeError;
    }

    public int getFreeThrowsAttemptedError() {
        return freeThrowsAttemptedError;
    }

    public void setFreeThrowsAttemptedError(int freeThrowsAttemptedError) {
        this.freeThrowsAttemptedError = freeThrowsAttemptedError;
    }

    public int getThreePointsMadeError() {
        return threePointsMadeError;
    }

    public void setThreePointsMadeError(int threePointsMadeError) {
        this.threePointsMadeError = threePointsMadeError;
    }

    public int getThreePointsAttemptedError() {
        return threePointsAttemptedError;
    }

    public void setThreePointsAttemptedError(int threePointsAttemptedError) {
        this.threePointsAttemptedError = threePointsAttemptedError;
    }

    public int getOffensiveReboundsError() {
        return offensiveReboundsError;
    }

    public void setOffensiveReboundsError(int offensiveReboundsError) {
        this.offensiveReboundsError = offensiveReboundsError;
    }

    public int getDefensiveReboundsError() {
        return defensiveReboundsError;
    }

    public void setDefensiveReboundsError(int defensiveReboundsError) {
        this.defensiveReboundsError = defensiveReboundsError;
    }

    public int getPersonalFoulsError() {
        return personalFoulsError;
    }

    public void setPersonalFoulsError(int personalFoulsError) {
        this.personalFoulsError = personalFoulsError;
    }

    public int getStealsError() {
        return stealsError;
    }

    public void setStealsError(int stealsError) {
        this.stealsError = stealsError;
    }

    public int getTurnoversError() {
        return turnoversError;
    }

    public void setTurnoversError(int turnoversError) {
        this.turnoversError = turnoversError;
    }

    public int getBlocksError() {
        return blocksError;
    }

    public void setBlocksError(int blocksError) {
        this.blocksError = blocksError;
    }

    public int getPlusMinusError() {
        return plusMinusError;
    }

    public void setPlusMinusError(int plusMinusError) {
        this.plusMinusError = plusMinusError;
    }

    // Additional function for calculating statPerGame and formatting the data appropriately
    // Additional methods for getting and setting the reformatted data
    // (These are from the Player.java entity to make formatting easier
    private double statPerGame(int stat){
        if (gamesPlayed != 0) {
            double perGame = (double) stat / (double) gamesPlayed;
            DecimalFormat df = new DecimalFormat("#.##"); // Round double to 2 decimal places
            return Double.valueOf(df.format(perGame));
        } else {
            return 0.0;
        }
    }

    // "getters" for per game stats metric
    public double pointsPerGame() { return statPerGame(points);}
    public double assistsPerGame(){ return statPerGame(assists);}

    public double fieldGoalsMadePerGame() {return statPerGame(fieldGoalsMade); }
    public double fieldGoalsAttemptedPerGame() {return statPerGame(fieldGoalsAttempted); }

    public double freeThrowsMadePerGame() {return statPerGame(freeThrowsMade); }
    public double freeThrowsAttemptedPerGame() {return statPerGame(freeThrowsAttempted); }

    public double threePointsMadePerGame() {return statPerGame(threePointsMade); }
    public double threePointsAttemptedPerGame() {return statPerGame(threePointsAttempted); }

    public double defensiveReboundsPerGame() {return statPerGame(defensiveRebounds); }

    public double offensiveReboundsPerGame() {return statPerGame(offensiveRebounds); }

    public double reboundsPerGame(){ return statPerGame(totalRebounds());}

    public double personalFoulsPerGame(){ return statPerGame(personalFouls); }

    public double stealsPerGame(){ return statPerGame(steals); }

    public double turnoversPerGame() {return statPerGame(turnovers); }

    public double blocksPerGame(){ return statPerGame(blocks);}

    public double timePlayedPerGame() {return statPerGame(timePlayed);}

    // setters for per game stats metrics
    public void setPointsPerGame(double pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
    }

    public void setAssistsPerGame(double assistsPerGame) {
        this.assistsPerGame = assistsPerGame;
    }

    public void setTimePlayedPerGame(double timePlayedPerGame) {
        this.timePlayedPerGame = timePlayedPerGame;
    }

    public void setFieldGoalsMadePerGame(double fieldGoalsMadePerGame) {
        this.fieldGoalsMadePerGame = fieldGoalsMadePerGame;
    }

    public void setFieldGoalsAttemptedPerGame(double fieldGoalsAttemptedPerGame) {
        this.fieldGoalsAttemptedPerGame = fieldGoalsAttemptedPerGame;
    }

    public void setFreeThrowsMadePerGame(double freeThrowsMadePerGame) {
        this.freeThrowsMadePerGame = freeThrowsMadePerGame;
    }

    public void setFreeThrowsAttemptedPerGame(double freeThrowsAttemptedPerGame) {
        this.freeThrowsAttemptedPerGame = freeThrowsAttemptedPerGame;
    }

    public void setThreePointsMadePerGame(double threePointsMadePerGame) {
        this.threePointsMadePerGame = threePointsMadePerGame;
    }

    public void setThreePointsAttemptedPerGame(double threePointsAttemptedPerGame) {
        this.threePointsAttemptedPerGame = threePointsAttemptedPerGame;
    }

    public void setOffensiveReboundsPerGame(double offensiveReboundsPerGame) {
        this.offensiveReboundsPerGame = offensiveReboundsPerGame;
    }

    public void setDefensiveReboundsPerGame(double defensiveReboundsPerGame) {
        this.defensiveReboundsPerGame = defensiveReboundsPerGame;
    }

    public void setPersonalFoulsPerGame(double personalFoulsPerGame) {
        this.personalFoulsPerGame = personalFoulsPerGame;
    }

    public void setStealsPerGame(double stealsPerGame) {
        this.stealsPerGame = stealsPerGame;
    }

    public void setTurnoversPerGame(double turnoversPerGame) {
        this.turnoversPerGame = turnoversPerGame;
    }

    public void setBlocksPerGame(double blocksPerGame) {
        this.blocksPerGame = blocksPerGame;
    }

    public void setPlusMinusPerGame(double plusMinusPerGame) {
        this.plusMinusPerGame = plusMinusPerGame;
    }
}
