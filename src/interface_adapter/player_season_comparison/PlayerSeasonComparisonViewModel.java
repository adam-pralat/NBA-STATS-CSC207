package interface_adapter.player_season_comparison;


import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerSeasonComparisonViewModel extends ViewModel{

    public static final String TITLE_LABEL = "Compare the Seasonal Stats of a Player";
    public static final String COMPARE_BUTTON_LABEL = "Compare";
    private PlayerSeasonComparisonState state;

    public PlayerSeasonComparisonViewModel() {super("playerSeasonComparison");}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public PlayerSeasonComparisonState getState() {return state;}

    public void setState(PlayerSeasonComparisonState state) {
        this.state = state;
    }
}
