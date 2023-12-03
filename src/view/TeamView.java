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
import java.util.Map;
import java.util.HashMap;

public class TeamView extends JPanel implements ActionListener, PropertyChangeListener {

    // Choose a team first and then view the stats for the team.
    public final String viewName = "team stats";
    private Map<String, Integer> teamNameToIdMap;
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
    // int[] possibleTeamIDs = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 19, 20, 21, 22, 23, 24,
    // 25, 26, 27, 28, 29, 30, 31, 38, 41};

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
        teamNameToIdMap = initialiseTeamNameIdMap();
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
                    teamStatsLabel.setText("Selected team: " + teamSelected);
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
                    String teamName = (String) teamDropdown.getSelectedItem();
                    int teamId = teamNameToIdMap.get(teamName);
                    teamStatsController.execute(teamId);
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

    public Map<String, Integer> initialiseTeamNameIdMap() {
        Map<String, Integer> initial = new HashMap<>();
        Integer[] possibleTeamIDs = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 19, 20, 21, 22, 23, 24,
                25, 26, 27, 28, 29, 30, 31, 38, 40, 41};
        for (int i = 0; i < TEAM_NAMES.length; i++) {
            initial.put(TEAM_NAMES[i], possibleTeamIDs[i]);
        }
        // You must ensure that TEAM_NAMES and possibleTeamIDs are the same length
        // and correspond correctly before running this code.
        return initial;
    }

    //Those are the team names , and each team should have a unique id, and you could make a hashmap of teams so their ids within teamview and
    //then use that in dropdowns, then there is a method that gets the things selected in dropdown and use that to exectue team stats.



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
