package view;

import com.opencsv.exceptions.CsvException;
import interface_adapter.home_page.HomePageController;
import interface_adapter.id_information.IdInformationController;
import interface_adapter.id_information.IdInformationState;
import interface_adapter.id_information.IdInformationViewModel;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonController;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonState;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerSeasonComparisonView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "Player Season Comparison View";
    private final JButton compare;
    public static final String[] TEAM_NAMES = {"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets",
            "Charlotte Hornets", "Chicago Bulls",
            "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons",
            "Golden State Warriors", "Houston Rockets", "Indiana Pacers", "LA Clippers", "Los Angeles Lakers",
            "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks", "Minnesota Timberwolves", "New Orleans Pelicans",
            "New York Knicks", "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers", "Phoenix Suns",
            "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors", "Utah Jazz",
            "Washington Wizards"};

    public static final Integer[] SEASONS = {2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023};

    private final JPanel team_players = new JPanel();
    private final JPanel season_1 = new JPanel();
    private final JPanel season_2 = new JPanel();
    private final JComboBox<String> dropdown = new JComboBox<>(TEAM_NAMES);

    private final JComboBox<Integer> season1Dropdown = new JComboBox<>(SEASONS);

    private final JComboBox<Integer> season2Dropdown = new JComboBox<>(SEASONS);
    private final JButton exit;

    private final PlayerSeasonComparisonViewModel playerSeasonComparisonViewModel;
    private final PlayerSeasonComparisonController playerSeasonComparisonController;
    private final IdInformationViewModel idInformationViewModel;
    private final IdInformationController idInformationController;
    private final HomePageController homePageController;

    public PlayerSeasonComparisonView(PlayerSeasonComparisonController controller,
                                      PlayerSeasonComparisonViewModel playerSeasonComparisonViewModel,
                                      IdInformationController idInformationController,
                                      IdInformationViewModel idInformationViewModel,
                                      HomePageController homePageController) throws IOException, CsvException {
        idInformationController.execute();
        IdInformationState currentState = idInformationViewModel.getState();
        HashMap<String, HashMap<String, Integer>> initial = initialise(currentState.getData());
        Map<String, String[]> formatted = format(initial);


        this.playerSeasonComparisonController = controller;
        this.playerSeasonComparisonViewModel = playerSeasonComparisonViewModel;
        this.idInformationController = idInformationController;
        this.idInformationViewModel = idInformationViewModel;
        this.homePageController = homePageController;
        playerSeasonComparisonViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(PlayerSeasonComparisonViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel1 = new JLabel("Select Team: ");
        team_players.add(titleLabel1);
        team_players.add(dropdown);
        String[] initialPlayersData = formatted.get(TEAM_NAMES[0]);
        JComboBox<String> subdropdown1 = new JComboBox<>(initialPlayersData);
        JLabel playerLabel1 = new JLabel("Select Player: ");
        team_players.add(playerLabel1);
        team_players.add(subdropdown1);

        dropdown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    String selectedTeam1 = (String) dropdown.getSelectedItem();
                    String[] playersForTeam1 = formatted.get(selectedTeam1);
                    DefaultComboBoxModel<String> playersForTeamModel1 = new DefaultComboBoxModel<>(playersForTeam1);
                    subdropdown1.setModel(playersForTeamModel1);
                }
            }
        });

        JLabel season1 = new JLabel("Select Season 1: ");
        season_1.add(season1);
        season_1.add(season1Dropdown);

        JLabel season2 = new JLabel("Select Season 2: ");
        season_2.add(season2);
        season_2.add(season2Dropdown);

        JPanel buttons = new JPanel();
        exit = new JButton(playerSeasonComparisonViewModel.EXIT_BUTTON_LABEL);
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

        compare = new JButton(PlayerSeasonComparisonViewModel.COMPARE_BUTTON_LABEL);
        buttons.add(compare);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(team_players);
        this.add(season_1);
        this.add(season_2);
        this.add(buttons);

        compare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(compare)){
                    String team1 = dropdown.getSelectedItem().toString();
                    String name1 = subdropdown1.getSelectedItem().toString();
                    int id = initial.get(team1).get(name1);
                    int s1 = (int) season1Dropdown.getSelectedItem();
                    int s2 = (int) season2Dropdown.getSelectedItem();
                    controller.execute(id, s1, s2);
                    PlayerSeasonComparisonState currentState = playerSeasonComparisonViewModel.getState();
                    String[] columnNames = {"Season", "Games Played", "Points", "Assists",
                            "Time Played", "Field Goals Made", "Field Goals Attempted", "Free Throws Made",
                            "Free Throws Attempted", "Three Points Made", "Three Points Attempted",
                            "Offensive Rebounds", "Defensive Rebounds", "Personal Fouls", "Steals", "Turnovers",
                            "Blocks", "+/-", "Points Per Game", "Assists Per Game", "Time Played Per Game",
                            "Field Goals Made Per Game", "Field Goals Attempted Per Game", "Free Throws Made Per Game",
                            "Free Throws Attempted Per Game", "Three Points Made Per Game",
                            "Three Points Attempted Per Game", "Offensive Rebounds Per Game",
                            "Defensive Rebounds Per Game", "Rebounds Per Game", "Personal Fouls Per Game",
                            "Steals Per Game", "Turnovers Per Game", "Blocks Per Game", "+/- Per Game",
                            "Free Throw Percentage", "Field Goal Percentage", "Three Points Percentage"};
                    Object[][] data = {{s1, currentState.getGamesPlayed(), currentState.getPoints(),
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
                            currentState.getTurnoversPerGame(), currentState.getBlocksPerGame(),
                            currentState.getPlusMinusPerGame(), currentState.getFreeThrowPercentage() + "%",
                            currentState.getFieldGoalPercentage() + "%", currentState.getThreePointPercentage() + "%"},
                            {s2, currentState.getGamesPlayed1(), currentState.getPoints1(),
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
                                    currentState.getTurnoversPerGame1(), currentState.getBlocksPerGame1(),
                                    currentState.getPlusMinusPerGame1(), currentState.getFreeThrowPercentage1() + "%",
                                    currentState.getFieldGoalPercentage1() + "%", currentState.getThreePointPercentage1() + "%"}
                    };
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
        JDialog popupDialog = new JDialog((Frame) null, data[0][0].toString() +
                " compared with " + data[1][0].toString(), true);
        popupDialog.setSize(1200, 300);

        JPanel contentPanel = new JPanel(new GridLayout(3, 38));
        Object[][] n = {columnNames, data[0], data[1]};

        for (Object[] rowData : n) {
            for (Object cellData : rowData) {
                if (cellData == null || String.valueOf(cellData).equals("null%")) {
                    JLabel label = new JLabel("N/A");
                    label.setHorizontalAlignment(JLabel.HORIZONTAL);
                    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    contentPanel.add(label);
                } else {
                    JLabel label = new JLabel(String.valueOf(cellData));
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
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}