package view;

import interface_adapter.team_stats.TeamStatsController;
import interface_adapter.team_stats.TeamStatsViewModel;
import interface_adapter.team_stats.TeamStatsState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

public class TeamView extends JPanel implements ActionListener, PropertyChangeListener {

    // Choose a team first and then view the stats for the team.
    public final String viewName = "team stats";
    public static final String[] TEAM_NAMES = {
            "Atlanta Hawks", "Boston Celtics", "Brooklyn Nets",
            "Charlotte Hornets", "Chicago Bulls", "Cleveland Cavaliers", "Dallas Mavericks",
            "Denver Nuggets", "Detroit Pistons", "Golden State Warriors", "Houston Rockets",
            "Indiana Pacers", "LA Clippers", "Los Angeles Lakers", "Memphis Grizzlies",
            "Miami Heat", "Milwaukee Bucks", "Minnesota Timberwolves", "New Orleans Pelicans",
            "New York Knicks", "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers",
            "Phoenix Suns", "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs",
            "Toronto Raptors", "Utah Jazz", "Washington Wizards"
    };

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
        teamDropdown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String teamSelected = (String) teamDropdown.getSelectedItem();
                    // Perform action based on team selected
                }
            }
        });

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

        viewStatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(viewStatsButton)) {
                    String team = teamDropdown.getSelectedItem().toString();
                    //TODO: get id from team selected and pass it to controller to execute.
                    TeamStatsState state = teamStatsViewModel.getState();
                    String[] columnNames = {"Name", "Nickname", "Code", "Conference", "ConferencePlace",
                            "Wins", "Losses", "WinsPastTen", "LossesPastTen", "PointsPerGame",
                            "FreeThrowPercentage", "FieldGoalPercentage", "ThreePointPercentage"};
                    Object[][] data = {{state.getName(), state.getNickname(), state.getCode(), state.getConference(),
                            String.valueOf(state.getConferencePlace()), String.valueOf(state.getWins()),
                            String.valueOf(state.getLosses()), String.valueOf(state.getWinsPastTen()),
                            String.valueOf(state.getLossesPastTen()), String.valueOf(state.getPointsPerGame()),
                            state.getFreeThrowPercentage() + "%", state.getFieldGoalPercentage() + "%",
                            state.getThreePointPercentage() + "%"}};
                    showPopup(data, columnNames);
                    System.out.println(Arrays.deepToString(data));
                }
            }
        });
    }

    private void showPopup(Object[][] data, String[] columnNames) {
        JDialog popupDialog = new JDialog(JOptionPane.getFrameForComponent(this),
                "Team Stats for " + data[0][0] + " - " + data[0][1], true);
        popupDialog.setSize(new Dimension(400, 300));

        JPanel contentPanel = new JPanel(new GridLayout(data.length, columnNames.length));
        for (Object[] rowData : data) {
            for (Object cellData : rowData) {
                JLabel label = new JLabel((String) cellData);
                label.setHorizontalAlignment(JLabel.HORIZONTAL);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                contentPanel.add(label);
            }
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        popupDialog.getContentPane().setLayout(new BorderLayout());
        popupDialog.getContentPane().add(scrollPane, BorderLayout.CENTER);

        popupDialog.setLocationRelativeTo(this);
        popupDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
