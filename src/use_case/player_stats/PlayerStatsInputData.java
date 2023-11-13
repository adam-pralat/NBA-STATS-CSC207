package use_case.player_stats;

public class PlayerStatsInputData {

    final private int id;

    public PlayerStatsInputData(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id cant be negative.");
        }
        this.id = id;
    }

    int getId() {return id;}
}
