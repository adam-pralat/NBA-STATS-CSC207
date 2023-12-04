package interface_adapter.team_stats;

import entity.Player;

import java.util.ArrayList;

public class TeamStatsState {

    private String teamStatsError;

    // Team Information
    private String name;
    private String nickname;
    private String code;
    private String city;
    private String logo;
    private String conference;
    private String players; // Players list or string to be decided.

    // Wins/Losses
    private String wins;
    private String losses;
    private String winsPastTen;
    private String lossesPastTen;
    private String conferencePlace;

    // Team Statistics
    private String games;
    private String fastBreakPoints;
    private String pointsInPaint;
    private String secondChancePoints;
    private String pointsOffTurnovers;
    private String points;
    private String fieldGoalsMade;
    private String fieldGoalsAttempted;
    private String freeThrowsMade;
    private String freeThrowsAttempted;
    private String threePointsMade;
    private String threePointsAttempted;
    private String offReb;
    private String defReb;
    private String assists;
    private String pFouls;
    private String steals;
    private String turnovers;
    private String blocks;
    private String plusMinus;

    // Per game metrics
    private String pointsPerGame;
    private String assistsPerGame;
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
    private String fieldGoalPercentage;
    private String freeThrowPercentage;
    private String threePointPercentage;


    public TeamStatsState(TeamStatsState copy) {

        // Team Information
        name = copy.name;
        nickname = copy.nickname;
        code = copy.code;
        city = copy.city;
        logo = copy.logo;
        conference = copy.conference;
        players = copy.players;

        // Wins/Losses
        wins = copy.wins;
        losses = copy.losses;
        winsPastTen = copy.winsPastTen;
        lossesPastTen = copy.lossesPastTen;
        conferencePlace = copy.conferencePlace;

        // Team Statistics
        games = copy.games;
        fastBreakPoints = copy.fastBreakPoints;
        pointsInPaint = copy.pointsInPaint;
        secondChancePoints = copy.secondChancePoints;
        pointsOffTurnovers = copy.pointsOffTurnovers;
        points = copy.points;
        fieldGoalsMade = copy.fieldGoalsMade;
        fieldGoalsAttempted = copy.fieldGoalsAttempted;
        freeThrowsMade = copy.freeThrowsMade;
        freeThrowsAttempted = copy.freeThrowsAttempted;
        threePointsMade = copy.threePointsMade;
        threePointsAttempted = copy.threePointsAttempted;
        offReb = copy.offReb;
        defReb = copy.defReb;
        assists = copy.assists;
        pFouls = copy.pFouls;
        steals = copy.steals;
        turnovers = copy.turnovers;
        blocks = copy.blocks;
        plusMinus = copy.plusMinus;

        // Per game metrics
        pointsPerGame = copy.pointsPerGame;
        assistsPerGame = copy.assistsPerGame;
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

    public TeamStatsState () {}

    public String getTeamStatsError() {
        return teamStatsError;
    }

    public void setTeamStatsError(String teamStatsError) {
        this.teamStatsError = teamStatsError;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getWinsPastTen() {
        return winsPastTen;
    }

    public void setWinsPastTen(String winsPastTen) {
        this.winsPastTen = winsPastTen;
    }

    public String getLossesPastTen() {
        return lossesPastTen;
    }

    public void setLossesPastTen(String lossesPastTen) {
        this.lossesPastTen = lossesPastTen;
    }

    public String getConferencePlace() {
        return conferencePlace;
    }

    public void setConferencePlace(String conferencePlace) {
        this.conferencePlace = conferencePlace;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public String getFastBreakPoints() {
        return fastBreakPoints;
    }

    public void setFastBreakPoints(String fastBreakPoints) {
        this.fastBreakPoints = fastBreakPoints;
    }

    public String getPointsInPaint() {
        return pointsInPaint;
    }

    public void setPointsInPaint(String pointsInPaint) {
        this.pointsInPaint = pointsInPaint;
    }

    public String getSecondChancePoints() {
        return secondChancePoints;
    }

    public void setSecondChancePoints(String secondChancePoints) {
        this.secondChancePoints = secondChancePoints;
    }

    public String getPointsOffTurnovers() {
        return pointsOffTurnovers;
    }

    public void setPointsOffTurnovers(String pointsOffTurnovers) {
        this.pointsOffTurnovers = pointsOffTurnovers;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
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

    public String getOffReb() {
        return offReb;
    }

    public void setOffReb(String offReb) {
        this.offReb = offReb;
    }

    public String getDefReb() {
        return defReb;
    }

    public void setDefReb(String defReb) {
        this.defReb = defReb;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getpFouls() {
        return pFouls;
    }

    public void setpFouls(String pFouls) {
        this.pFouls = pFouls;
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

    public String getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }

    public void setFieldGoalPercentage(String fieldGoalPercentage) {
        this.fieldGoalPercentage = fieldGoalPercentage;
    }

    public String getFreeThrowPercentage() {
        return freeThrowPercentage;
    }

    public void setFreeThrowPercentage(String freeThrowPercentage) {
        this.freeThrowPercentage = freeThrowPercentage;
    }

    public String getThreePointPercentage() {
        return threePointPercentage;
    }

    public void setThreePointPercentage(String threePointPercentage) {
        this.threePointPercentage = threePointPercentage;
    }
}
