package use_case.player_season_comparison;

public class PlayerSeasonComparisonInputData {
    final private int id;

    // Two integers to store the seasons used for comparing a player's stats
    final private int season1;
    final private int season2;

    public PlayerSeasonComparisonInputData(int id, int season1, int season2) {

        // TODO: is season2 > season1 necessary?
        // TODO: add checks for when the query season doesn't exist (does the api call return null if the player didn't play in the year given?)

        this.season1 = season1;
        this.season2 = season2;

        if (id <= 0) {
            throw new IllegalArgumentException("id cant be negative.");
        }
        this.id = id;
    }

    int getId() {return id;}
    int getSeason1() {return season1;}
    int getSeason2() {return season2;}
}
