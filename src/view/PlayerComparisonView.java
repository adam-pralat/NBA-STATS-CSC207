package view;

import com.opencsv.exceptions.CsvException;
import interface_adapter.id_information.IdInformationController;
import interface_adapter.id_information.IdInformationState;
import interface_adapter.id_information.IdInformationViewModel;
import interface_adapter.player_comparison.PlayerComparisonController;
import interface_adapter.player_comparison.PlayerComparisonViewModel;

import javax.swing.*;
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
//
//    private final Map<String, String[]> subCategoryMap = format(PlayerComparisonViewModel.TeamPlayerIds);
//
//    private final JComboBox<String> subCategoryDropdown = new JComboBox<>(subCategoryMap.get(dropdown1.getSelectedItem()));

    private final PlayerComparisonViewModel playerComparisonViewModel;
    private final PlayerComparisonController playerComparisonController;
    private final IdInformationViewModel idInformationViewModel;
    private final IdInformationController idInformationController;

    public PlayerComparisonView(PlayerComparisonController controller,
                                PlayerComparisonViewModel playerComparisonViewModel,
                                IdInformationController idInformationController,
                                IdInformationViewModel idInformationViewModel) throws IOException, CsvException {
        idInformationController.execute();
        IdInformationState currentState = idInformationViewModel.getState();
        HashMap<String, HashMap<String, Integer>> initial = initialise(currentState.getData());
        Map<String, String[]> formatted = format(initial);


        this.playerComparisonController = controller;
        this.playerComparisonViewModel = playerComparisonViewModel;
        this.idInformationController = idInformationController;
        this.idInformationViewModel = idInformationViewModel;
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

        compare = new JButton(PlayerComparisonViewModel.COMPARE_BUTTON_LABEL);
        buttons.add(compare);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(team_players_1);
        this.add(team_players_2);
        this.add(buttons);

//        String selectedOption = (String) dropdown1.getSelectedItem();
//        String[] initialSubCategoryData = subCategoryMap.get(selectedOption);
//        JComboBox<String> subCategoryDropdown = new JComboBox<>(initialSubCategoryData);
//        this.add(subCategoryDropdown);
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

    @Override
    public void actionPerformed(ActionEvent e) {
//        dropdown1.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    // Retrieve the selected category
//                    String selectedCategory = (String) dropdown1.getSelectedItem();
//
//                    // Update the second dropdown based on the selected category
//                    String[] subCategoryData = subCategoryMap.get(selectedCategory);
//                    DefaultComboBoxModel<String> subCategoryModel = new DefaultComboBoxModel<>(subCategoryData);
//                    subCategoryDropdown.setModel(subCategoryModel);
//                }
//            }
//        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
