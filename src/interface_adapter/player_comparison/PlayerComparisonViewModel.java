package interface_adapter.player_comparison;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.HashMap;

public class PlayerComparisonViewModel extends ViewModel {
    public static final String COMPARE_BUTTON_LABEL = "Compare";
    public static final String TITLE_LABEL = "Player Comparison";
    public static final String[] TEAM_NAMES = {"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets",
            "Charlotte Hornets", "Chicago Bulls",
            "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons",
            "Golden State Warriors", "Houston Rockets", "Indiana Pacers", "LA Clippers", "Los Angeles Lakers",
            "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks", "Minnesota Timberwolves", "New Orleans Pelicans",
            "New York Knicks", "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers", "Phoenix Suns",
            "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors", "Utah Jazz",
            "Washington Wizards"};

    //public static final HashMap<String, HashMap<String, Integer>> TeamPlayerIds;

    private PlayerComparisonState state = new PlayerComparisonState();

    public PlayerComparisonViewModel() { super("player comparison"); }

    public void setState(PlayerComparisonState state) { this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public PlayerComparisonState getState() {
        return state;
    }
}
