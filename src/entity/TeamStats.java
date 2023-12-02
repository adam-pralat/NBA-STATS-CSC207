package entity;

public class TeamStats {
    public int games;
    public int fastBreakPoints;
    public int pointsInPaint;
    public int secondChancePoints;
    public int pointsOffTurnovers;
    public int points;
    public int fieldGoalsMade;
    public int fieldGoalsAttempted;
    public int freeThrowsMade;
    public int freeThrowsAttempted;
    public int threePointsMade;
    public int threePointsAttempted;
    public int offReb;
    public int defReb;
    public int assists;
    public int pFouls;
    public int steals;
    public int turnovers;
    public int blocks;
    public int plusMinus;

    public TeamStats(int games, int fastBreakPoints, int pointsInPaint, int secondChancePoints, int pointsOffTurnovers, int points, int fieldGoalsMade, int fieldGoalsAttempted, int freeThrowsMade, int freeThrowsAttempted, int threePointsMade, int threePointsAttempted, int offReb, int defReb, int assists, int pFouls, int steals, int turnovers, int blocks, int plusMinus) {
        this.games = games;
        this.fastBreakPoints = fastBreakPoints;
        this.pointsInPaint = pointsInPaint;
        this.secondChancePoints = secondChancePoints;
        this.pointsOffTurnovers = pointsOffTurnovers;
        this.points = points;
        this.fieldGoalsMade = fieldGoalsMade;
        this.fieldGoalsAttempted = fieldGoalsAttempted;
        this.freeThrowsMade = freeThrowsMade;
        this.freeThrowsAttempted = freeThrowsAttempted;
        this.threePointsMade = threePointsMade;
        this.threePointsAttempted = threePointsAttempted;
        this.offReb = offReb;
        this.defReb = defReb;
        this.assists = assists;
        this.pFouls = pFouls;
        this.steals = steals;
        this.turnovers = turnovers;
        this.blocks = blocks;
        this.plusMinus = plusMinus;
    }
}
