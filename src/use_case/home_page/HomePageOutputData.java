package use_case.home_page;

public class HomePageOutputData {
    private String playerFirstName;
    private String playerLastName;
    private String playerBirthDate; // YYYY-MM-DD
    private String playerCountry;

    // Player information
    private String playerTeam; // Name of the player's current team

    // Statistic metrics
    private double playerPointsPerGame;
    private double playerAssistsPerGame;
    private double playerFreeThrowPercentage;
    private double playerFieldGoalPercentage;
    private double playerThreePointPercentage;
    private double playerMinutesPlayedPerGame;
    private double playerStealsPerGame;
    private double playerTurnoversPerGame;
    private double playerBlocksPerGame;

    // Featured Team Information
    // General information
    private String teamName;
    private String teamNickname;
    private String teamCode; // Three letter code for the given team
    private String conference;

    // Team standings metrics
    private int teamWins;
    private int teamLosses;
    private int teamsWinsLastTen;
    private int teamsLossesLastTen;
    private int conferencePlace;


    // Statistic metrics
    private double teamPointsPerGame;
    private double teamFreeThrowPercentage;
    private double teamFieldGoalPercentage;
    private double teamThreePointPercentage;

    private boolean useCaseFailed;

    public HomePageOutputData(String playerFirstName, String playerLastName, String playerBirthDate, String playerCountry, String playerTeam, double playerPointsPerGame, double playerAssistsPerGame, double playerFreeThrowPercentage, double playerFieldGoalPercentage, double playerThreePointPercentage, double playerTimePlayedPerGame, double playerStealsPerGame, double playerTurnoversPerGame, double playerBlocksPerGame, String teamName, String teamNickname, String teamCode, String conference, int teamWins, int teamLosses, int teamsWinsLastTen, int teamsLossesLastTen, int conferencePlace, double teamPointsPerGame, double teamFreeThrowPercentage, double teamFieldGoalPercentage, double teamThreePointPercentage, boolean useCaseFailed) {
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.playerBirthDate = playerBirthDate;
        this.playerCountry = playerCountry;
        this.playerTeam = playerTeam;
        this.playerPointsPerGame = playerPointsPerGame;
        this.playerAssistsPerGame = playerAssistsPerGame;
        this.playerFreeThrowPercentage = playerFreeThrowPercentage;
        this.playerFieldGoalPercentage = playerFieldGoalPercentage;
        this.playerThreePointPercentage = playerThreePointPercentage;
        this.playerMinutesPlayedPerGame = playerTimePlayedPerGame;
        this.playerStealsPerGame = playerStealsPerGame;
        this.playerTurnoversPerGame = playerTurnoversPerGame;
        this.playerBlocksPerGame = playerBlocksPerGame;
        this.teamName = teamName;
        this.teamNickname = teamNickname;
        this.teamCode = teamCode;
        this.conference = conference;
        this.teamWins = teamWins;
        this.teamLosses = teamLosses;
        this.teamsWinsLastTen = teamsWinsLastTen;
        this.teamsLossesLastTen = teamsLossesLastTen;
        this.conferencePlace = conferencePlace;
        this.teamPointsPerGame = teamPointsPerGame;
        this.teamFreeThrowPercentage = teamFreeThrowPercentage;
        this.teamFieldGoalPercentage = teamFieldGoalPercentage;
        this.teamThreePointPercentage = teamThreePointPercentage;
        this.useCaseFailed = useCaseFailed;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public String getPlayerBirthDate() {
        return playerBirthDate;
    }

    public String getPlayerCountry() {
        return playerCountry;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public double getPlayerPointsPerGame() {
        return playerPointsPerGame;
    }

    public double getPlayerAssistsPerGame() {
        return playerAssistsPerGame;
    }

    public double getPlayerFreeThrowPercentage() {
        return playerFreeThrowPercentage;
    }

    public double getPlayerFieldGoalPercentage() {
        return playerFieldGoalPercentage;
    }

    public double getPlayerThreePointPercentage() {
        return playerThreePointPercentage;
    }

    public double getPlayerMinutesPlayedPerGame() {
        return playerMinutesPlayedPerGame;
    }

    public double getPlayerStealsPerGame() {
        return playerStealsPerGame;
    }

    public double getPlayerTurnoversPerGame() {
        return playerTurnoversPerGame;
    }

    public double getPlayerBlocksPerGame() {
        return playerBlocksPerGame;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamNickname() {
        return teamNickname;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public String getConference() {
        return conference;
    }

    public int getTeamWins() {
        return teamWins;
    }

    public int getTeamLosses() {
        return teamLosses;
    }

    public int getTeamsWinsLastTen() {
        return teamsWinsLastTen;
    }

    public int getTeamsLossesLastTen() {
        return teamsLossesLastTen;
    }

    public int getConferencePlace() {
        return conferencePlace;
    }

    public double getTeamPointsPerGame() {
        return teamPointsPerGame;
    }

    public double getTeamFreeThrowPercentage() {
        return teamFreeThrowPercentage;
    }

    public double getTeamFieldGoalPercentage() {
        return teamFieldGoalPercentage;
    }

    public double getTeamThreePointPercentage() {
        return teamThreePointPercentage;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
