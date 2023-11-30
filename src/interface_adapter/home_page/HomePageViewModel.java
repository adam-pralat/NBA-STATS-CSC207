package interface_adapter.home_page;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HomePageViewModel extends ViewModel {
    private HomePageState state = new HomePageState();
    public String TITLE_LABEL = "Home Page -----";
    public String SCHEDULE_BUTTON_LABEL = "View Schedule";
    public String PLAYER_STATS_BUTTON_LABEL = "View Player Statistics";
    public String TEAM_STATS_BUTTON_LABEL = "View Team Statistics";
    public String PLAYER_COMPARISON_BUTTON_LABEL = "Compare Two Players";
    public String[] PLAYER_INFO_COLUMN_NAMES = {"A", "B", "C", "D"};

    public HomePageViewModel(){ super("home page"); } // TODO: ViewName should be an argument??
    // - Issue with switching views occurs when viewName string is different between view and view model

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public HomePageState getState() {
        return state;
    }

    public void setState(HomePageState state) {
        this.state = state;
    }
}
