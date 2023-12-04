package view;

import com.opencsv.exceptions.CsvException;
import interface_adapter.home_page.HomePageController;
import interface_adapter.id_information.IdInformationController;
import interface_adapter.id_information.IdInformationState;
import interface_adapter.id_information.IdInformationViewModel;
import interface_adapter.player_comparison.PlayerComparisonController;
import interface_adapter.player_comparison.PlayerComparisonState;
import interface_adapter.player_comparison.PlayerComparisonViewModel;
import interface_adapter.schedule.ScheduleViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class PlayerComparisonView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "player comparison";
    private final JButton compare;
    public static final String[] TEAM_NAMES = {"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets",
            "Charlotte Hornets", "Chicago Bulls",
            "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons",
            "Golden State Warriors", "Houston Rockets", "Indiana Pacers", "LA Clippers", "Los Angeles Lakers",
            "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks", "Minnesota Timberwolves", "New Orleans Pelicans",
            "New York Knicks", "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers", "Phoenix Suns",
            "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors", "Utah Jazz",
            "Washington Wizards"};

    private final JPanel team_players_1 = new JPanel();
    private final JPanel team_players_2 = new JPanel();
    private final JComboBox<String> dropdown1 = new JComboBox<>(TEAM_NAMES);
    private final JComboBox<String> dropdown2 = new JComboBox<>(TEAM_NAMES);
    private final JButton exit;
//
//    private final Map<String, String[]> subCategoryMap = format(PlayerComparisonViewModel.TeamPlayerIds);
//
//    private final JComboBox<String> subCategoryDropdown = new JComboBox<>(subCategoryMap.get(dropdown1.getSelectedItem()));

    private final PlayerComparisonViewModel playerComparisonViewModel;
    private final PlayerComparisonController playerComparisonController;
    private final IdInformationViewModel idInformationViewModel;
    private final IdInformationController idInformationController;
    private final HomePageController homePageController;

    public PlayerComparisonView(PlayerComparisonController controller,
                                PlayerComparisonViewModel playerComparisonViewModel,
                                IdInformationController idInformationController,
                                IdInformationViewModel idInformationViewModel,
                                HomePageController homePageController) throws IOException, CsvException {
        idInformationController.execute();
        IdInformationState currentState = idInformationViewModel.getState();
        HashMap<String, HashMap<String, Integer>> initial = initialise(currentState.getData());
        Map<String, String[]> formatted = format(initial);


        this.playerComparisonController = controller;
        this.playerComparisonViewModel = playerComparisonViewModel;
        this.idInformationController = idInformationController;
        this.idInformationViewModel = idInformationViewModel;
        this.homePageController = homePageController;
        playerComparisonViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(PlayerComparisonViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel1 = new JLabel("Select Team 1: ");
        team_players_1.add(titleLabel1);
        team_players_1.add(dropdown1);
        String[] initialPlayersData1 = formatted.get(TEAM_NAMES[0]);
        JComboBox<String> subdropdown1 = new JComboBox<>(initialPlayersData1);
        JLabel playerLabel1 = new JLabel("Select Player 1: ");
        team_players_1.add(playerLabel1);
        team_players_1.add(subdropdown1);
        dropdown1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    String selectedTeam1 = (String) dropdown1.getSelectedItem();
                    String[] playersForTeam1 = formatted.get(selectedTeam1);
                    DefaultComboBoxModel<String> playersForTeamModel1 = new DefaultComboBoxModel<>(playersForTeam1);
                    subdropdown1.setModel(playersForTeamModel1);
                }
            }
        });

        JLabel titleLabel2 = new JLabel("Select Team 2: ");
        team_players_2.add(titleLabel2);
        team_players_2.add(dropdown2);
        String[] initialPlayersData2 = formatted.get(TEAM_NAMES[0]);
        JComboBox<String> subdropdown2 = new JComboBox<>(initialPlayersData2);
        JLabel playerLabel2 = new JLabel("Select Player 2: ");
        team_players_2.add(playerLabel2);
        team_players_2.add(subdropdown2);
        dropdown2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    String selectedTeam2 = (String) dropdown2.getSelectedItem();
                    String[] playersForTeam2 = formatted.get(selectedTeam2);
                    DefaultComboBoxModel<String> playersForTeamModel2 = new DefaultComboBoxModel<>(playersForTeam2);
                    subdropdown2.setModel(playersForTeamModel2);
                }
            }
        });

        JPanel buttons = new JPanel();
        exit = new JButton(playerComparisonViewModel.EXIT_BUTTON_LABEL);
        exit.addActionListener(this);
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
        buttons.add(exit);

        compare = new JButton(PlayerComparisonViewModel.COMPARE_BUTTON_LABEL);
        buttons.add(compare);

        JTable table = new JTable();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(team_players_1);
        this.add(team_players_2);
        this.add(buttons);

        compare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(compare)){
                    String team1 = dropdown1.getSelectedItem().toString();
                    String team2 = dropdown2.getSelectedItem().toString();
                    String name1 = subdropdown1.getSelectedItem().toString();
                    String name2 = subdropdown2.getSelectedItem().toString();
                    int id1 = initial.get(team1).get(name1);
                    int id2 = initial.get(team2).get(name2);
                    controller.execute(id1, id2);
                    PlayerComparisonState currentState = playerComparisonViewModel.getState();
                    String[] columnNames = {"First Name", "Last Name", "Birth Date", "Country", "Height", "Weight",
                            "Games Played", "Points", "Assists",
                            "Time Played", "Field Goals Made", "Field Goals Attempted", "Free Throws Made",
                            "Free Throws Attempted", "Three Points Made", "Three Points Attempted",
                            "Offensive Rebounds", "Defensive Rebounds", "Personal Fouls", "Steals", "Turnovers",
                            "Blocks", "+/-", "Points Per Game", "Assists Per Game", "Time Played Per Game",
                            "Field Goals Made Per Game", "Field Goals Attempted Per Game", "Free Throws Made Per Game",
                            "Free Throws Attempted Per Game", "Three Points Made Per Game",
                            "Three Points Attempted Per Game", "Offensive Rebounds Per Game",
                            "Defensive Rebounds Per Game", "Rebounds Per Game", "Personal Fouls Per Game",
                            "Steals Per Game", "Turnovers Per Game", "Blocks Per Game",
                            "Free Throw Percentage", "Field Goal Percentage", "Three Points Percentage"};
                    Object[][] data = {{currentState.getFirstName(), currentState.getLastName(),
                            currentState.getBirthDate(), currentState.getCountry(), currentState.getHeight() + " m",
                            currentState.getWeight() + " kg", currentState.getGamesPlayed(), currentState.getPoints(),
                            currentState.getAssists(), currentState.getTimePlayed(), currentState.getFieldGoalsMade(),
                            currentState.getFieldGoalsAttempted(), currentState.getFreeThrowsMade(),
                            currentState.getFreeThrowsAttempted(), currentState.getThreePointsMade(),
                            currentState.getThreePointsAttempted(), currentState.getOffensiveRebounds(),
                            currentState.getDefensiveRebounds(), currentState.getPersonalFouls(), currentState.getSteals(),
                            currentState.getTurnovers(), currentState.getBlocks(), currentState.getPlusMinus(),
                            currentState.getPointsPerGame(), currentState.getAssistsPerGame(),
                            currentState.getTimePlayedPerGame(), currentState.getFieldGoalsMadePerGame(),
                            currentState.getFieldGoalsAttemptedPerGame(), currentState.getFreeThrowsMadePerGame(),
                            currentState.getFreeThrowsAttemptedPerGame(), currentState.getThreePointsMadePerGame(),
                            currentState.getThreePointsAttemptedPerGame(), currentState.getOffensiveReboundsPerGame(),
                            currentState.getDefensiveReboundsPerGame(), currentState.getReboundsPerGame(),
                            currentState.getPersonalFoulsPerGame(), currentState.getStealsPerGame(),
                            currentState.getTurnoversPerGame(), currentState.getBlocksPerGame(), currentState.getFreeThrowPercentage() + "%",
                            currentState.getFieldGoalPercentage() + "%", currentState.getThreePointPercentage() + "%"},
                            {currentState.getFirstName1(), currentState.getLastName1(),
                            currentState.getBirthDate1(), currentState.getCountry1(), currentState.getHeight1() + " m",
                            currentState.getWeight1() + " kg", currentState.getGamesPlayed1(), currentState.getPoints1(),
                            currentState.getAssists1(), currentState.getTimePlayed1(), currentState.getFieldGoalsMade1(),
                            currentState.getFieldGoalsAttempted1(), currentState.getFreeThrowsMade1(),
                            currentState.getFreeThrowsAttempted1(), currentState.getThreePointsMade1(),
                            currentState.getThreePointsAttempted1(), currentState.getOffensiveRebounds1(),
                            currentState.getDefensiveRebounds1(), currentState.getPersonalFouls1(), currentState.getSteals1(),
                            currentState.getTurnovers1(), currentState.getBlocks1(), currentState.getPlusMinus1(),
                            currentState.getPointsPerGame1(), currentState.getAssistsPerGame1(),
                            currentState.getTimePlayedPerGame1(), currentState.getFieldGoalsMadePerGame1(),
                            currentState.getFieldGoalsAttemptedPerGame1(), currentState.getFreeThrowsMadePerGame1(),
                            currentState.getFreeThrowsAttemptedPerGame1(), currentState.getThreePointsMadePerGame1(),
                            currentState.getThreePointsAttemptedPerGame1(), currentState.getOffensiveReboundsPerGame1(),
                            currentState.getDefensiveReboundsPerGame1(), currentState.getReboundsPerGame1(),
                            currentState.getPersonalFoulsPerGame1(), currentState.getStealsPerGame1(),
                            currentState.getTurnoversPerGame1(), currentState.getBlocksPerGame1(), currentState.getFreeThrowPercentage1() + "%",
                            currentState.getFieldGoalPercentage1() + "%", currentState.getThreePointPercentage1() + "%"}};
                    showPopup(data, columnNames);
                }
            }
        });
    }

    public HashMap<String, HashMap<String, Integer>> initialise(List<String[]> lst){
        // Convert List<String[]> (format of IdInformation use case) to HashMap<String, HashMap<String, Integer>>
        HashMap<String, HashMap<String, Integer>> initial = new HashMap<>();
        for (String[] array: lst){
            String team = array[0];
            String player = array[1];
            int number = Integer.parseInt(array[2]);
            initial.putIfAbsent(team, new HashMap<>());
            initial.get(team).put(player, number);
        }
        return initial;
    }

    public Map<String, String[]> format(HashMap<String, HashMap<String, Integer>> initial){
        HashMap<String, String[]> transformedMap = new HashMap<>();
        for (Map.Entry<String, HashMap<String, Integer>> entry : initial.entrySet()) {
            String key = entry.getKey();
            HashMap<String, Integer> innerMap = entry.getValue();
            String[] innerKeys = innerMap.keySet().toArray(new String[0]);
            transformedMap.put(key, innerKeys);
        }
        return transformedMap;
    }

    private void showPopup(Object[][] data, String[] columnNames) {
        // Create a JDialog for the popup
        JDialog popupDialog = new JDialog((Frame) null, data[0][0].toString() + " " + data[0][1].toString() +
                " compared with " + data[1][0].toString() + " " + data[1][1].toString(), true);
        popupDialog.setSize(800, 500);

        JPanel contentPanel = new JPanel(new GridLayout(3, 42));
        Object[][] n = {columnNames, data[0], data[1]};

        for (Object[] rowData : n) {
            for (Object cellData : rowData) {
                if ((cellData == null) || ((String) cellData).equals("null%") || "".equals((String) cellData)) {
                    JLabel label = new JLabel("N/A");
                    label.setHorizontalAlignment(JLabel.HORIZONTAL);
                    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    contentPanel.add(label);
                } else {
                    JLabel label = new JLabel((String) cellData);
                    label.setHorizontalAlignment(JLabel.HORIZONTAL);
                    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    contentPanel.add(label);
                }
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
