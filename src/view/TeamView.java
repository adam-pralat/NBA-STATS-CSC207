package view;

import interface_adapter.home_page.HomePageController;
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
    private final HomePageController homePageController;
    private final JComboBox<String> teamDropdown;
    private final JButton viewStatsButton;
    private final JLabel teamStatsLabel;
    private final JButton exit;

    public TeamView(TeamStatsController controller, TeamStatsViewModel teamStatsViewModel, HomePageController homePageController) {
        this.teamStatsController = controller;
        this.teamStatsViewModel = teamStatsViewModel;
        this.homePageController = homePageController;
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

        exit = new JButton("Exit");

        JPanel selectionPanel = new JPanel();
        selectionPanel.add(new JLabel("Select Team: "));
        selectionPanel.add(teamDropdown);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(selectionPanel);
        this.add(viewStatsButton);
        this.add(teamStatsLabel);
        this.add(exit);

        exit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(exit)) {
                            homePageController.execute();
                        }
                    }
                }
        );

        viewStatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(viewStatsButton)) {
                    String team = teamDropdown.getSelectedItem().toString();
                    int teamId = //TODO;
                    controller.execute(teamId);
                    TeamStatsState state = teamStatsViewModel.getState();
                    String[] columnNames = {"Name", "Nickname", "Code", "City", "Logo", "Conference", "Players", "Wins", "Losses",
                            "WinsPastTen", "LossesPastTen", "ConferencePlace", "Games", "FastBreakPoints",
                            "PointsInPaint", "SecondChancePoints", "PointsOffTurnovers", "Points", "FieldGoalsMade",
                            "FieldGoalsAttempted", "FreeThrowsMade", "FreeThrowsAttempted", "ThreePointsMade",
                            "ThreePointsAttempted", "OffReb", "DefReb", "Assists", "PFouls", "Steals", "Turnovers",
                            "Blocks", "PlusMinus", "PointsPerGame", "AssistsPerGame", "FieldGoalsMadePerGame",
                            "FieldGoalsAttemptedPerGame", "FreeThrowsMadePerGame", "FreeThrowsAttemptedPerGame",
                            "ThreePointsMadePerGame", "ThreePointsAttemptedPerGame", "OffensiveReboundsPerGame",
                            "DefensiveReboundsPerGame", "ReboundsPerGame", "PersonalFoulsPerGame", "StealsPerGame",
                            "TurnoversPerGame", "BlocksPerGame", "PlusMinusPerGame", "FieldGoalPercentage",
                            "FreeThrowPercentage", "ThreePointPercentage"};

                    Object[][] data = {
                            {
                                    state.getName(), state.getNickname(), state.getCode(), state.getCity(), state.getLogo(),
                                    state.getConference(), state.getPlayers(), state.getWins(), state.getLosses(),
                                    state.getWinsPastTen(), state.getLossesPastTen(), state.getConferencePlace(), state.getGames(),
                                    state.getFastBreakPoints(), state.getPointsInPaint(), state.getSecondChancePoints(),
                                    state.getPointsOffTurnovers(), state.getPoints(), state.getFieldGoalsMade(),
                                    state.getFieldGoalsAttempted(), state.getFreeThrowsMade(), state.getFreeThrowsAttempted(),
                                    state.getThreePointsMade(), state.getThreePointsAttempted(), state.getOffReb(),
                                    state.getDefReb(), state.getAssists(), state.getpFouls(), state.getSteals(),
                                    state.getTurnovers(), state.getBlocks(), state.getPlusMinus(), state.getPointsPerGame(),
                                    state.getAssistsPerGame(), state.getFieldGoalsMadePerGame(), state.getFieldGoalsAttemptedPerGame(),
                                    state.getFreeThrowsMadePerGame(), state.getFreeThrowsAttemptedPerGame(),
                                    state.getThreePointsMadePerGame(), state.getThreePointsAttemptedPerGame(),
                                    state.getOffensiveReboundsPerGame(), state.getDefensiveReboundsPerGame(),
                                    state.getReboundsPerGame(), state.getPersonalFoulsPerGame(), state.getStealsPerGame(),
                                    state.getTurnoversPerGame(), state.getBlocksPerGame(), state.getPlusMinusPerGame(),
                                    String.format("%.2f%%", Integer.parseInt(state.getFieldGoalPercentage()) / 100.0),
                                    String.format("%.2f%%", Integer.parseInt(state.getFreeThrowPercentage()) / 100.0),
                                    String.format("%.2f%%", Integer.parseInt(state.getThreePointPercentage()) / 100.0)
                            }
                    };

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
