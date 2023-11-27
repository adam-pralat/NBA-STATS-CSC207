package interface_adapter.home_page;

public class HomePageState {
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
    private String playerPointsPerGame;
    private String playerAssistsPerGame;
    private String playerFreeThrowPercentage;
    private String playerFieldGoalPercentage;
    private String playerThreePointPercentage;
    private String playerTimePlayedPerGame;
    private String playerStealsPerGame;
    private String playerTurnoversPerGame;
    private String playerBlocksPerGame;

    // Featured Team Information
    // General information
    private String teamName;
    private String teamNickname;
    private String teamCode; // Three letter code for the given team
    private String conference;

    // Team standings metrics
    private String teamWins;
    private String teamLosses;
    private String teamsWinsLastTen;
    private String teamsLossesLastTen;
    private String conferencePlace;


    // Statistic metrics
    private String teamPointsPerGame;
    private String teamFreeThrowPercentage;
    private String teamFieldGoalPercentage;
    private String teamThreePointPercentage;

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
        this.playerTimePlayedPerGame = copy.playerTimePlayedPerGame;
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

    public String getPlayerPointsPerGame() {
        return playerPointsPerGame;
    }

    public void setPlayerPointsPerGame(String playerPointsPerGame) {
        this.playerPointsPerGame = playerPointsPerGame;
    }

    public String getPlayerAssistsPerGame() {
        return playerAssistsPerGame;
    }

    public void setPlayerAssistsPerGame(String playerAssistsPerGame) {
        this.playerAssistsPerGame = playerAssistsPerGame;
    }

    public String getPlayerFreeThrowPercentage() {
        return playerFreeThrowPercentage;
    }

    public void setPlayerFreeThrowPercentage(String playerFreeThrowPercentage) {
        this.playerFreeThrowPercentage = playerFreeThrowPercentage;
    }

    public String getPlayerFieldGoalPercentage() {
        return playerFieldGoalPercentage;
    }

    public void setPlayerFieldGoalPercentage(String playerFieldGoalPercentage) {
        this.playerFieldGoalPercentage = playerFieldGoalPercentage;
    }

    public String getPlayerThreePointPercentage() {
        return playerThreePointPercentage;
    }

    public void setPlayerThreePointPercentage(String playerThreePointPercentage) {
        this.playerThreePointPercentage = playerThreePointPercentage;
    }

    public String getPlayerTimePlayedPerGame() {
        return playerTimePlayedPerGame;
    }

    public void setPlayerTimePlayedPerGame(String playerTimePlayedPerGame) {
        this.playerTimePlayedPerGame = playerTimePlayedPerGame;
    }

    public String getPlayerStealsPerGame() {
        return playerStealsPerGame;
    }

    public void setPlayerStealsPerGame(String playerStealsPerGame) {
        this.playerStealsPerGame = playerStealsPerGame;
    }

    public String getPlayerTurnoversPerGame() {
        return playerTurnoversPerGame;
    }

    public void setPlayerTurnoversPerGame(String playerTurnoversPerGame) {
        this.playerTurnoversPerGame = playerTurnoversPerGame;
    }

    public String getPlayerBlocksPerGame() {
        return playerBlocksPerGame;
    }

    public void setPlayerBlocksPerGame(String playerBlocksPerGame) {
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

    public String getTeamWins() {
        return teamWins;
    }

    public void setTeamWins(String teamWins) {
        this.teamWins = teamWins;
    }

    public String getTeamLosses() {
        return teamLosses;
    }

    public void setTeamLosses(String teamLosses) {
        this.teamLosses = teamLosses;
    }

    public String getTeamsWinsLastTen() {
        return teamsWinsLastTen;
    }

    public void setTeamsWinsLastTen(String teamsWinsLastTen) {
        this.teamsWinsLastTen = teamsWinsLastTen;
    }

    public String getTeamsLossesLastTen() {
        return teamsLossesLastTen;
    }

    public void setTeamsLossesLastTen(String teamsLossesLastTen) {
        this.teamsLossesLastTen = teamsLossesLastTen;
    }

    public String getConferencePlace() {
        return conferencePlace;
    }

    public void setConferencePlace(String conferencePlace) {
        this.conferencePlace = conferencePlace;
    }

    public String getTeamPointsPerGame() {
        return teamPointsPerGame;
    }

    public void setTeamPointsPerGame(String teamPointsPerGame) {
        this.teamPointsPerGame = teamPointsPerGame;
    }

    public String getTeamFreeThrowPercentage() {
        return teamFreeThrowPercentage;
    }

    public void setTeamFreeThrowPercentage(String teamFreeThrowPercentage) {
        this.teamFreeThrowPercentage = teamFreeThrowPercentage;
    }

    public String getTeamFieldGoalPercentage() {
        return teamFieldGoalPercentage;
    }

    public void setTeamFieldGoalPercentage(String teamFieldGoalPercentage) {
        this.teamFieldGoalPercentage = teamFieldGoalPercentage;
    }

    public String getTeamThreePointPercentage() {
        return teamThreePointPercentage;
    }

    public void setTeamThreePointPercentage(String teamThreePointPercentage) {
        this.teamThreePointPercentage = teamThreePointPercentage;
    }
}
