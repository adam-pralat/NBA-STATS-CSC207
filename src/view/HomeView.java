package view;

import interface_adapter.home_page.HomePageController;
import interface_adapter.home_page.HomePageState;
import interface_adapter.home_page.HomePageViewModel;
import interface_adapter.player_comparison.PlayerComparisonController;
import interface_adapter.schedule.ScheduleController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

public class HomeView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "home page";
    private final HomePageViewModel viewModel;
    private final HomePageController homeController;
    private final ScheduleController scheduleController;
    private final PlayerComparisonController playerComparisonController;
    private JScrollPane playerInfoPane = new JScrollPane();

    private JButton playerStatsButton;
    private JButton teamStatsButton;
    private JButton playerComparisonButton;
    private JButton scheduleButton;

    public HomeView(HomePageViewModel viewModel, HomePageController homeController, ScheduleController scheduleController, PlayerComparisonController playerComparisonController) {
        this.viewModel = viewModel;
        this.homeController = homeController;
        this.scheduleController = scheduleController;
        this.playerComparisonController = playerComparisonController;

        this.viewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(this.viewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        HomePageState state = this.viewModel.getState();

        // TODO: Dont call controller here, call on view being changed
        // this.controller.execute();

        JPanel t = new JPanel();

        JLabel header = new JLabel("Page Title");
        header.setFont(header.getFont().deriveFont(64.0F));

        t.add(header);
        this.add(t);

        JPanel playerInfo = new JPanel();
        playerInfo.add(playerInfoPane);
        this.setFields(state);
//        JTextArea playerName = new JTextArea(state.getPlayerFirstName() + " " + state.getPlayerLastName());
//        playerName.setEditable(false);
//        playerInfo.add(playerName);
//
//        JTextArea playerCountry = new JTextArea(state.getPlayerCountry());
//        playerCountry.setEditable(false);
//        playerInfo.add(playerCountry);
//
//        JTextArea playerTeam = new JTextArea(state.getPlayerTeam());
//        playerTeam.setEditable(false);
//        playerInfo.add(playerTeam);
//
//        JTextArea playerPPG = new JTextArea(Double.toString(state.getPlayerPointsPerGame()));
//        playerPPG.setEditable(false);
//        playerInfo.add(playerPPG);
//
//        JTextArea playerAPG = new JTextArea(Double.toString(state.getPlayerAssistsPerGame()));
//        playerAPG.setEditable(false);
//        playerInfo.add(playerAPG);
//
//        JTextArea playerFTP = new JTextArea(Double.toString(state.getPlayerFreeThrowPercentage()) + "%");
//        playerFTP.setEditable(false);
//        playerInfo.add(playerFTP);
//
//        JTextArea playerFGP = new JTextArea(Double.toString(state.getPlayerFieldGoalPercentage()) + "%");
//        playerFGP.setEditable(false);
//        playerInfo.add(playerFGP);
//
//        JTextArea playerMPG = new JTextArea(Double.toString(state.getplayerMinutesPerGame()));
//        playerMPG.setEditable(false);
//        playerInfo.add(playerMPG);

        this.add(playerInfo);

        JPanel teamInfo = new JPanel();

        JPanel buttons = new JPanel();
        scheduleButton = new JButton(viewModel.SCHEDULE_BUTTON_LABEL);
        buttons.add(scheduleButton);
        scheduleButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(scheduleButton)) {
                            scheduleController.execute(LocalDate.now());
                        }
                    }
                }
        );

        playerStatsButton = new JButton(viewModel.PLAYER_STATS_BUTTON_LABEL);
        buttons.add(playerStatsButton);

        teamStatsButton = new JButton(viewModel.TEAM_STATS_BUTTON_LABEL);
        buttons.add(teamStatsButton);

        playerComparisonButton = new JButton(viewModel.PLAYER_COMPARISON_BUTTON_LABEL);
        buttons.add(playerComparisonButton);
        playerComparisonButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(playerComparisonButton)) {
                            playerComparisonController.execute(1, 2); // TODO: Note, passed in ids 1 and 2 for now
                        }
                    }
                }
        );

        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        HomePageState state = (HomePageState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(HomePageState state) {
        //this.homeController.execute();
        String[][] playerInfoData = {{
                state.getPlayerFirstName() + " " + state.getPlayerLastName(),
                state.getPlayerCountry(),
                state.getPlayerTeam(),
                Double.toString(state.getPlayerPointsPerGame()),
                Double.toString(state.getPlayerAssistsPerGame()),
                state.getPlayerFreeThrowPercentage() + "%",
                state.getPlayerFieldGoalPercentage() + "%",
                Double.toString(state.getPlayerMinutesPlayedPerGame())
        }};
        JTable playerInfoTable = new JTable(playerInfoData, this.viewModel.PLAYER_INFO_COLUMN_NAMES);
        playerInfoPane.setViewportView(playerInfoTable);
    }
}

