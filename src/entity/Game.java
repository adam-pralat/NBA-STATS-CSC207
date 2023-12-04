package entity;

import java.time.LocalDateTime;

public class Game {
    private final int id; // API game-ID
    private final LocalDateTime dateTime;
    private final String status;
    private final String location;
    private final int homeTeamID;
    private final String homeTeamName;
    private final String homeTeamCode;
    private final String homeTeamLogo;
    private final int homeTeamPoints;
    private final int awayTeamID;
    private final String awayTeamName;
    private final String awayTeamCode;
    private final String awayTeamLogo;
    private final int awayTeamPoints;

    public Game(int id,
                LocalDateTime dateTime,
                String status,
                String location,
                int homeTeamID,
                String homeTeamName,
                String homeTeamCode,
                String homeTeamLogo,
                int homeTeamPoints,
                int awayTeamID,
                String awayTeamName,
                String awayTeamCode,
                String awayTeamLogo,
                int awayTeamPoints) {
        this.id = id;
        this.dateTime = dateTime;
        this.status = status;
        this.location = location;
        this.homeTeamID = homeTeamID;
        this.homeTeamName = homeTeamName;
        this.homeTeamCode = homeTeamCode;
        this.homeTeamLogo = homeTeamLogo;
        this.homeTeamPoints = homeTeamPoints;
        this.awayTeamID = awayTeamID;
        this.awayTeamName = awayTeamName;
        this.awayTeamCode = awayTeamCode;
        this.awayTeamLogo = awayTeamLogo;
        this.awayTeamPoints = awayTeamPoints;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getStatus() {
        return status;
    }

    public String getLocation() {
        return location;
    }

    public int getHomeTeamID() {
        return homeTeamID;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getHomeTeamCode() {
        return homeTeamCode;
    }

    public String getHomeTeamLogo() {
        return homeTeamLogo;
    }

    public int getHomeTeamPoints() {
        return homeTeamPoints;
    }

    public int getAwayTeamID() {
        return awayTeamID;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public String getAwayTeamCode() {
        return awayTeamCode;
    }

    public String getAwayTeamLogo() {
        return awayTeamLogo;
    }

    public int getAwayTeamPoints() {
        return awayTeamPoints;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", homeTeamID=" + homeTeamID +
                ", homeTeamName='" + homeTeamName + '\'' +
                ", homeTeamCode='" + homeTeamCode + '\'' +
                ", homeTeamLogo='" + homeTeamLogo + '\'' +
                ", homeTeamPoints=" + homeTeamPoints +
                ", awayTeamID=" + awayTeamID +
                ", awayTeamName='" + awayTeamName + '\'' +
                ", awayTeamCode='" + awayTeamCode + '\'' +
                ", awayTeamLogo='" + awayTeamLogo + '\'' +
                ", awayTeamPoints=" + awayTeamPoints +
                '}';
    }
}