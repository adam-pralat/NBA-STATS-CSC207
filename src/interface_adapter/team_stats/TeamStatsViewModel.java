package interface_adapter.team_stats;

import entity.Team;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TeamStatsViewModel extends ViewModel {

    public static final String EXIT_BUTTON_LABEL = "Exit";
    public static final String VIEW_STATS_LABEL = "View Stats";
    private TeamStatsState state = new TeamStatsState();

    public TeamStatsViewModel(){super("team stats");}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TeamStatsState getState() {
        return state;
    }

    public void setState(TeamStatsState state) {
        this.state = state;
    }
}
