package use_case.player_comparison;

public class PlayerComparisonInputData {
    final private int id1;
    final private int id2;

    public PlayerComparisonInputData(int id1, int id2) {
        if (id1 <= 0 || id2 <= 0) {
            throw new IllegalArgumentException("id cant be negative.");
        }
        this.id1 = id1;
        this.id2 = id2;
    }

    int getId1() {return id1;}

    int getId2() {return id2;}
}
