package view;

import interface_adapter.team_stats.TeamStatsController;
import interface_adapter.team_stats.TeamStatsViewModel;
import interface_adapter.team_stats.TeamStatsState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TeamView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "team stats";
    public static final String[] TEAM_NAMES = {"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets",
            "Charlotte Hornets", "Chicago Bulls",
            "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons",
            "Golden State Warriors", "Houston Rockets", "Indiana Pacers", "LA Clippers", "Los Angeles Lakers",
            "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks", "Minnesota Timberwolves", "New Orleans Pelicans",
            "New York Knicks", "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers", "Phoenix Suns",
            "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors", "Utah Jazz",
            "Washington Wizards"};

    private final TeamStatsViewModel teamStatsViewModel;
    private final TeamStatsController teamStatsController;
    private final JComboBox<String> teamDropdown;
    private final JButton viewStatsButton;
    private final JLabel teamStatsLabel;

    public TeamView(TeamStatsController controller, TeamStatsViewModel teamStatsViewModel) {

        this.teamStatsController = controller;
        this.teamStatsViewModel = teamStatsViewModel;
        teamStatsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Team Statistics");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        teamDropdown = new JComboBox<>(TEAM_NAMES);
        viewStatsButton = new JButton("View Stats");
        viewStatsButton.addActionListener(this);

        teamStatsLabel = new JLabel();
        teamStatsLabel.setVerticalAlignment(JLabel.TOP);

        JPanel selectionPanel = new JPanel();
        selectionPanel.add(new JLabel("Select Team: "));
        selectionPanel.add(teamDropdown);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(selectionPanel);
        this.add(viewStatsButton);
        this.add(teamStatsLabel);
    }

    private void showPopup(TeamStatsState state) {
        // ... same showPopup method as in your PlayerComparisonView ...
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(viewStatsButton)) {
            String selectedTeam = (String) teamDropdown.getSelectedItem();
            // Assuming teamStatsController can handle team name directly
            int id1 =
            teamStatsController.execute(selectedTeam);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            TeamStatsState state = (TeamStatsState) evt.getNewValue();
            showPopup(state); // Update view with team statistics in a popup
        }
    }
}
