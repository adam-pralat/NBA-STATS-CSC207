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
    private ArrayList<Player> players; // Players list or string to be decided.

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

    // Team Information error
    private String nameError = null;
    private String nicknameError = null;
    private String codeError = null;
    private String cityError = null;
    private String logoError = null;
    private String conferenceError = null;
    private ArrayList<Player> playersError = null;

    // Wins/Losses error
    private String winsError = null;
    private String lossesError = null;
    private String winsPastTenError = null;
    private String lossesPastTenError = null;
    private String conferencePlaceError = null;

    // Team Statistics error
    private String gamesError = null;
    private String fastBreakPointsError = null;
    private String pointsInPaintError = null;
    private String secondChancePointsError = null;
    private String pointsOffTurnoversError = null;
    private String pointsError = null;
    private String fieldGoalsMadeError = null;
    private String fieldGoalsAttemptedError = null;
    private String freeThrowsMadeError = null;
    private String freeThrowsAttemptedError = null;
    private String threePointsMadeError = null;
    private String threePointsAttemptedError = null;
    private String offRebError = null;
    private String defRebError = null;
    private String assistsError = null;
    private String pFoulsError = null;
    private String stealsError = null;
    private String turnoversError = null;
    private String blocksError = null;
    private String plusMinusError = null;

    public TeamStatsState(TeamStatsState copy) {

        // Team Information
        name = copy.name;
        nameError = copy.nameError;
        nickname = copy.nickname;
        nicknameError = copy.nicknameError;
        code = copy.code;
        codeError = copy.codeError;
        city = copy.city;
        cityError = copy.cityError;
        logo = copy.logo;
        logoError = copy.logoError;
        conference = copy.conference;
        conferenceError = copy.conferenceError;
        players = copy.players;
        playersError = copy.playersError;

        // Wins/Losses
        wins = copy.wins;
        winsError = copy.winsError;
        losses = copy.losses;
        lossesError = copy.lossesError;
        winsPastTen = copy.winsPastTen;
        winsPastTenError = copy.winsPastTenError;
        lossesPastTen = copy.lossesPastTen;
        lossesPastTenError = copy.lossesPastTenError;
        conferencePlace = copy.conferencePlace;
        conferencePlaceError = copy.conferencePlaceError;

        // Team Statistics
        games = copy.games;
        gamesError = copy.gamesError;
        fastBreakPoints = copy.fastBreakPoints;
        fastBreakPointsError = copy.fastBreakPointsError;
        pointsInPaint = copy.pointsInPaint;
        pointsInPaintError = copy.pointsInPaintError;
        secondChancePoints = copy.secondChancePoints;
        secondChancePointsError = copy.secondChancePointsError;
        pointsOffTurnovers = copy.pointsOffTurnovers;
        pointsOffTurnoversError = copy.pointsOffTurnoversError;
        points = copy.points;
        pointsError = copy.pointsError;
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
        offReb = copy.offReb;
        offRebError = copy.offRebError;
        defReb = copy.defReb;
        defRebError = copy.defRebError;
        assists = copy.assists;
        assistsError = copy.assistsError;
        pFouls = copy.pFouls;
        pFoulsError = copy.pFoulsError;
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
}
