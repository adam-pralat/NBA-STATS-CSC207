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
    public String PLAYER_SEASON_COMPARISON_BUTTON_LABEL = "Compare Stats of a Player By Season";

    public String[] PLAYER_ROW_NAMES = {
            "Name", "Birth Date", "Country", "Team",
            "Points Per Game", "Assists Per Game", "Free Throw Percentage",
            "Field Goal Percentage", "Three Point Percentage", "Minutes Per Game",
            "Steals Per Game", "Turnovers Per Game", "Blocks Per Game"
    };
    public String[] TEAM_ROW_NAMES = {
            "Team", "Nickname", "Code",
            "Conference", "Conference Place", "Wins",
            "Losses", "Wins (Past 10 Games)", "Losses (Past 10 Games)",
            "Points Per Game", "Free Throw Percentage", "Field Goal Percentage",
            "Three Point Percentage"
    };
    public String PLAYER_HEADER = "Featured Player";
    public String TEAM_HEADER = "Featured Team";
    public String PAGE_TITLE = "Java Jumpman - NBA Statistics";
    public float PAGE_TITLE_FONT_SIZE = 56.0f;
    public float HEADER_FONT_SIZE = 28.0f;


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
