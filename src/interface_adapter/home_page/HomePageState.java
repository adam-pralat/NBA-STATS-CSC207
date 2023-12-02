package interface_adapter.home_page;

public class HomePageState {
    // Error message
    private String error;

    // Featured Player information
    // Note that some player information is cut out to show on home page

    // Profile information
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

    public HomePageState() {}

    public HomePageState(HomePageState copy) {
        this.playerFirstName = copy.playerFirstName;
        this.playerLastName = copy.playerLastName;
        this.playerBirthDate = copy.playerBirthDate;
        this.playerCountry = copy.playerCountry;
        this.playerTeam = copy.playerTeam;
        this.playerPointsPerGame = copy.playerPointsPerGame;
        this.playerAssistsPerGame = copy.playerAssistsPerGame;
        this.playerFreeThrowPercentage = copy.playerFreeThrowPercentage;
        this.playerFieldGoalPercentage = copy.playerFieldGoalPercentage;
        this.playerThreePointPercentage = copy.playerThreePointPercentage;
        this.playerMinutesPlayedPerGame = copy.playerMinutesPlayedPerGame;
        this.playerStealsPerGame = copy.playerStealsPerGame;
        this.playerTurnoversPerGame = copy.playerTurnoversPerGame;
        this.playerBlocksPerGame = copy.playerBlocksPerGame;
        this.teamName = copy.teamName;
        this.teamNickname = copy.teamNickname;
        this.teamCode = copy.teamCode;
        this.conference = copy.conference;
        this.teamWins = copy.teamWins;
        this.teamLosses = copy.teamLosses;
        this.teamsWinsLastTen = copy.teamsWinsLastTen;
        this.teamsLossesLastTen = copy.teamsLossesLastTen;
        this.conferencePlace = copy.conferencePlace;
        this.teamPointsPerGame = copy.teamPointsPerGame;
        this.teamFreeThrowPercentage = copy.teamFreeThrowPercentage;
        this.teamFieldGoalPercentage = copy.teamFieldGoalPercentage;
        this.teamThreePointPercentage = copy.teamThreePointPercentage;
        this.error = copy.error;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public String getPlayerBirthDate() {
        return playerBirthDate;
    }

    public void setPlayerBirthDate(String playerBirthDate) {
        this.playerBirthDate = playerBirthDate;
    }

    public String getPlayerCountry() {
        return playerCountry;
    }

    public void setPlayerCountry(String playerCountry) {
        this.playerCountry = playerCountry;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public double getPlayerPointsPerGame() {
        return playerPointsPerGame;
    }

    public void setPlayerPointsPerGame(double playerPointsPerGame) {
        this.playerPointsPerGame = playerPointsPerGame;
    }

    public double getPlayerAssistsPerGame() {
        return playerAssistsPerGame;
    }

    public void setPlayerAssistsPerGame(double playerAssistsPerGame) {
        this.playerAssistsPerGame = playerAssistsPerGame;
    }

    public double getPlayerFreeThrowPercentage() {
        return playerFreeThrowPercentage;
    }

    public void setPlayerFreeThrowPercentage(double playerFreeThrowPercentage) {
        this.playerFreeThrowPercentage = playerFreeThrowPercentage;
    }

    public double getPlayerFieldGoalPercentage() {
        return playerFieldGoalPercentage;
    }

    public void setPlayerFieldGoalPercentage(double playerFieldGoalPercentage) {
        this.playerFieldGoalPercentage = playerFieldGoalPercentage;
    }

    public double getPlayerThreePointPercentage() {
        return playerThreePointPercentage;
    }

    public void setPlayerThreePointPercentage(double playerThreePointPercentage) {
        this.playerThreePointPercentage = playerThreePointPercentage;
    }

    public double getPlayerMinutesPlayedPerGame() {
        return playerMinutesPlayedPerGame;
    }

    public void setPlayerMinutesPlayedPerGame(double playerMinutesPlayedPerGame) {
        this.playerMinutesPlayedPerGame = playerMinutesPlayedPerGame;
    }

    public double getPlayerStealsPerGame() {
        return playerStealsPerGame;
    }

    public void setPlayerStealsPerGame(double playerStealsPerGame) {
        this.playerStealsPerGame = playerStealsPerGame;
    }

    public double getPlayerTurnoversPerGame() {
        return playerTurnoversPerGame;
    }

    public void setPlayerTurnoversPerGame(double playerTurnoversPerGame) {
        this.playerTurnoversPerGame = playerTurnoversPerGame;
    }

    public double getPlayerBlocksPerGame() {
        return playerBlocksPerGame;
    }

    public void setPlayerBlocksPerGame(double playerBlocksPerGame) {
        this.playerBlocksPerGame = playerBlocksPerGame;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamNickname() {
        return teamNickname;
    }

    public void setTeamNickname(String teamNickname) {
        this.teamNickname = teamNickname;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public int getTeamWins() {
        return teamWins;
    }

    public void setTeamWins(int teamWins) {
        this.teamWins = teamWins;
    }

    public int getTeamLosses() {
        return teamLosses;
    }

    public void setTeamLosses(int teamLosses) {
        this.teamLosses = teamLosses;
    }

    public int getTeamsWinsLastTen() {
        return teamsWinsLastTen;
    }

    public void setTeamsWinsLastTen(int teamsWinsLastTen) {
        this.teamsWinsLastTen = teamsWinsLastTen;
    }

    public int getTeamsLossesLastTen() {
        return teamsLossesLastTen;
    }

    public void setTeamsLossesLastTen(int teamsLossesLastTen) {
        this.teamsLossesLastTen = teamsLossesLastTen;
    }

    public int getConferencePlace() {
        return conferencePlace;
    }

    public void setConferencePlace(int conferencePlace) {
        this.conferencePlace = conferencePlace;
    }

    public double getTeamPointsPerGame() {
        return teamPointsPerGame;
    }

    public void setTeamPointsPerGame(double teamPointsPerGame) {
        this.teamPointsPerGame = teamPointsPerGame;
    }

    public double getTeamFreeThrowPercentage() {
        return teamFreeThrowPercentage;
    }

    public void setTeamFreeThrowPercentage(double teamFreeThrowPercentage) {
        this.teamFreeThrowPercentage = teamFreeThrowPercentage;
    }

    public double getTeamFieldGoalPercentage() {
        return teamFieldGoalPercentage;
    }

    public void setTeamFieldGoalPercentage(double teamFieldGoalPercentage) {
        this.teamFieldGoalPercentage = teamFieldGoalPercentage;
    }

    public double getTeamThreePointPercentage() {
        return teamThreePointPercentage;
    }

    public void setTeamThreePointPercentage(double teamThreePointPercentage) {
        this.teamThreePointPercentage = teamThreePointPercentage;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public void setUseCaseFailed(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "HomePageState{" +
                "error='" + error + '\'' +
                ", playerFirstName='" + playerFirstName + '\'' +
                ", playerLastName='" + playerLastName + '\'' +
                ", playerBirthDate='" + playerBirthDate + '\'' +
                ", playerCountry='" + playerCountry + '\'' +
                ", playerTeam='" + playerTeam + '\'' +
                ", playerPointsPerGame=" + playerPointsPerGame +
                ", playerAssistsPerGame=" + playerAssistsPerGame +
                ", playerFreeThrowPercentage=" + playerFreeThrowPercentage +
                ", playerFieldGoalPercentage=" + playerFieldGoalPercentage +
                ", playerThreePointPercentage=" + playerThreePointPercentage +
                ", playerMinutesPlayedPerGame=" + playerMinutesPlayedPerGame +
                ", playerStealsPerGame=" + playerStealsPerGame +
                ", playerTurnoversPerGame=" + playerTurnoversPerGame +
                ", playerBlocksPerGame=" + playerBlocksPerGame +
                ", teamName='" + teamName + '\'' +
                ", teamNickname='" + teamNickname + '\'' +
                ", teamCode='" + teamCode + '\'' +
                ", conference='" + conference + '\'' +
                ", teamWins=" + teamWins +
                ", teamLosses=" + teamLosses +
                ", teamsWinsLastTen=" + teamsWinsLastTen +
                ", teamsLossesLastTen=" + teamsLossesLastTen +
                ", conferencePlace=" + conferencePlace +
                ", teamPointsPerGame=" + teamPointsPerGame +
                ", teamFreeThrowPercentage=" + teamFreeThrowPercentage +
                ", teamFieldGoalPercentage=" + teamFieldGoalPercentage +
                ", teamThreePointPercentage=" + teamThreePointPercentage +
                ", useCaseFailed=" + useCaseFailed +
                '}';
    }
}
