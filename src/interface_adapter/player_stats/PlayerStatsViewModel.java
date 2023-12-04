package interface_adapter.player_stats;

import entity.Player;
import interface_adapter.ViewModel;
import use_case.player_stats.PlayerStatsInputBoundary;
import use_case.player_stats.PlayerStatsOutputData;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerStatsViewModel extends ViewModel {
    // View Model here manages the data for view, and then it also will react to input from user.

    public static final String EXIT_BUTTON_LABEL = "Exit";
    public static final String GET_STATS_BUTTON_LABEL = "Get Stats";
    public static final String TITLE_LABEL = "View Player Stats";
    private PlayerStatsState state = new PlayerStatsState();

    public PlayerStatsViewModel(){ super("Player Stats View");}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public PlayerStatsState getState() {
        return state;
    }

    public void setState(PlayerStatsState state) {
        this.state = state;
    }
}
