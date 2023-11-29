package entity;

public class Game {
    private final Integer id; // API game-ID
    private final String date;
    private String status;
    private final String location;
    private final String homeTeamName;
    private final String homeTeamCode;
    private final String homeTeamLogo;
    private Integer homeTeamWins;
    private Integer homeTeamLosses;
    private Integer homeTeamPoints;
    private final String awayTeamName;
    private final String awayTeamCode;
    private final String awayTeamLogo;
    private Integer awayTeamWins;
    private Integer awayTeamLosses;
    private Integer awayTeamPoints;

    public Game(Integer id,
                String date,
                String status,
                String location,
                String homeTeamName,
                String homeTeamCode,
                String homeTeamLogo,
                Integer homeTeamWins,
                Integer homeTeamLosses,
                Integer homeTeamPoints,
                String awayTeamName,
                String awayTeamCode,
                String awayTeamLogo,
                Integer awayTeamWins,
                Integer awayTeamLosses,
                Integer awayTeamPoints) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.location = location;
        this.homeTeamName = homeTeamName;
        this.homeTeamCode = homeTeamCode;
        this.homeTeamLogo = homeTeamLogo;
        this.homeTeamWins = homeTeamWins;
        this.homeTeamLosses = homeTeamLosses;
        this.homeTeamPoints = homeTeamPoints;
        this.awayTeamName = awayTeamName;
        this.awayTeamCode = awayTeamCode;
        this.awayTeamLogo = awayTeamLogo;
        this.awayTeamWins = awayTeamWins;
        this.awayTeamLosses = awayTeamLosses;
        this.awayTeamPoints = awayTeamPoints;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getHomeTeamWins() {
        return homeTeamWins;
    }

    public void setHomeTeamWins(Integer homeTeamWins) {
        this.homeTeamWins = homeTeamWins;
    }

    public Integer getHomeTeamLosses() {
        return homeTeamLosses;
    }

    public void setHomeTeamLosses(Integer homeTeamLosses) {
        this.homeTeamLosses = homeTeamLosses;
    }

    public Integer getHomeTeamPoints() {
        return homeTeamPoints;
    }

    public void setHomeTeamPoints(Integer homeTeamPoints) {
        this.homeTeamPoints = homeTeamPoints;
    }

    public Integer getAwayTeamWins() {
        return awayTeamWins;
    }

    public void setAwayTeamWins(Integer awayTeamWins) {
        this.awayTeamWins = awayTeamWins;
    }

    public Integer getAwayTeamLosses() {
        return awayTeamLosses;
    }

    public void setAwayTeamLosses(Integer awayTeamLosses) {
        this.awayTeamLosses = awayTeamLosses;
    }

    public Integer getAwayTeamPoints() {
        return awayTeamPoints;
    }

    public void setAwayTeamPoints(Integer awayTeamPoints) {
        this.awayTeamPoints = awayTeamPoints;
    }

    @Override
    public String toString() {
        return "________________________________________________________\n" +
                date + "\n" + status + '\n' + location + '\n' +
                homeTeamCode + " | " + homeTeamName + " : " + homeTeamPoints + " - " +
                awayTeamPoints + " : " + awayTeamName + " | " + awayTeamCode + '\n' +
                "(" + homeTeamWins + " - " + homeTeamLosses + ")\t\t(" + awayTeamWins + " - " + awayTeamLosses + ")\n";
    }
}