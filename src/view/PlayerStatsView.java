package view;

import com.opencsv.exceptions.CsvException;
import interface_adapter.home_page.HomePageController;
import interface_adapter.id_information.IdInformationController;
import interface_adapter.id_information.IdInformationState;
import interface_adapter.id_information.IdInformationViewModel;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonViewModel;
import interface_adapter.player_stats.PlayerStatsController;
import interface_adapter.player_stats.PlayerStatsState;
import interface_adapter.player_stats.PlayerStatsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerStatsView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "Player Stats View";
    private final JButton getStats;

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
    private final JPanel season = new JPanel();
    private final JComboBox<String> dropdown = new JComboBox<>(TEAM_NAMES);
    private final JComboBox<Integer> seasonDropdown = new JComboBox<>(SEASONS);

    private final JButton exit;

    private final PlayerStatsViewModel playerStatsViewModel;
    private final PlayerStatsController playerStatsController;
    private final IdInformationViewModel idInformationViewModel;
    private final IdInformationController idInformationController;
    private final HomePageController homePageController;

    public PlayerStatsView(PlayerStatsController controller,
                           PlayerStatsViewModel playerStatsViewModel,
                           IdInformationController idInformationController,
                           IdInformationViewModel idInformationViewModel,
                           HomePageController homePageController) throws IOException, CsvException {
        idInformationController.execute();
        IdInformationState currentState = idInformationViewModel.getState();
        HashMap<String, HashMap<String, Integer>> initial = initialise(currentState.getData());
        Map<String, String[]> formatted = format(initial);


        this.playerStatsController = controller;
        this.playerStatsViewModel = playerStatsViewModel;
        this.idInformationController = idInformationController;
        this.idInformationViewModel = idInformationViewModel;
        this.homePageController = homePageController;
        playerStatsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(PlayerStatsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("Select Team: ");
        team_players.add(titleLabel);
        team_players.add(dropdown);
        String[] initialPlayersData = formatted.get(TEAM_NAMES[0]);
        JComboBox<String> subdropdown = new JComboBox<>(initialPlayersData);
        JLabel playerLabel = new JLabel("Select Player: ");
        team_players.add(playerLabel);
        team_players.add(subdropdown);

        dropdown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    String selectedTeam1 = (String) dropdown.getSelectedItem();
                    String[] playersForTeam1 = formatted.get(selectedTeam1);
                    DefaultComboBoxModel<String> playersForTeamModel1 = new DefaultComboBoxModel<>(playersForTeam1);
                    subdropdown.setModel(playersForTeamModel1);
                }
            }
        });

        JPanel buttons = new JPanel();
        exit = new JButton(playerStatsViewModel.EXIT_BUTTON_LABEL);
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

        getStats = new JButton(PlayerStatsViewModel.GET_STATS_BUTTON_LABEL);
        buttons.add(getStats);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(team_players);
        this.add(buttons);

        getStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(getStats)){
                    String team = dropdown.getSelectedItem().toString();
                    String name = subdropdown.getSelectedItem().toString();
                    int id = initial.get(team).get(name);
                    controller.execute(id);
                    PlayerStatsState currentState = playerStatsViewModel.getState();
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
                    Object[] data = {currentState.getFirstName(), currentState.getLastName(),
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
                            currentState.getFieldGoalPercentage() + "%", currentState.getThreePointPercentage() + "%"};
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

    private void showPopup(Object[] data, String[] columnNames) {
        // Create a JDialog for the popup
        JDialog popupDialog = new JDialog((Frame) null, data[0].toString() + " " + data[1].toString() +
                " Stats", true);
        popupDialog.setSize(1200, 400);

        JPanel contentPanel = new JPanel(new GridLayout(2, 42));
        Object[][] n = {columnNames, data};

        for (Object[] rowData : n) {
            for (Object cellData : rowData) {
                if (cellData == null || ((String) cellData).equals("null%")) {
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
