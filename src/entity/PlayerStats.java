package entity;

import java.util.HashMap;
import java.util.Map;

public class PlayerStats {
    public int gamesPlayed;
    public int points;
    public int assists;
    public int timePlayed;
    public int fieldGoalsMade;
    public int fieldGoalsAttempted;
    public int freeThrowsMade;
    public int freeThrowsAttempted;
    public int threePointsMade;
    public int threePointsAttempted;
    public int offensiveRebounds;
    public int defensiveRebounds;
    public int personalFouls;
    public int steals;
    public int turnovers;
    public int blocks;
    public int plusMinus;

    public PlayerStats(int gamesPlayed, int points, int assists, int timePlayed, int fieldGoalsMade, int fieldGoalsAttempted, int freeThrowsMade, int freeThrowsAttempted, int threePointsMade, int threePointsAttempted, int offensiveRebounds, int defensiveRebounds, int personalFouls, int steals, int turnovers, int blocks, int plusMinus) {
        this.gamesPlayed = gamesPlayed;
        this.points = points;
        this.assists = assists;
        this.timePlayed = timePlayed;
        this.fieldGoalsMade = fieldGoalsMade;
        this.fieldGoalsAttempted = fieldGoalsAttempted;
        this.freeThrowsMade = freeThrowsMade;
        this.freeThrowsAttempted = freeThrowsAttempted;
        this.threePointsMade = threePointsMade;
        this.threePointsAttempted = threePointsAttempted;
        this.offensiveRebounds = offensiveRebounds;
        this.defensiveRebounds = defensiveRebounds;
        this.personalFouls = personalFouls;
        this.steals = steals;
        this.turnovers = turnovers;
        this.blocks = blocks;
        this.plusMinus = plusMinus;
    }
}
