package use_case.player_comparison;

import entity.Player;
import org.json.JSONException;

public interface PlayerComparisonDataAccessInterface {
    public boolean existsById(int playerID) throws JSONException;
    //TODO
}
