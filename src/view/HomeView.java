package view;

import interface_adapter.home_page.HomePageController;
import interface_adapter.home_page.HomePageState;
import interface_adapter.home_page.HomePageViewModel;
import interface_adapter.player_comparison.PlayerComparisonController;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonController;
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
    private final PlayerSeasonComparisonController playerSeasonComparisonController;

    private JScrollPane playerInfoPane = new JScrollPane();

    private JButton playerStatsButton;
    private JButton teamStatsButton;
    private JButton playerComparisonButton;
    private JButton scheduleButton;
    private JButton playerSeasonComparisonButton;
    private JPanel playerInfo;
    private JPanel pageTitle;
    private JPanel teamInfo;
    private JLabel title;
    private JPanel buttons;
    private JLabel teamHeader;
    private JLabel playerHeader;
    private String[] playerRowData;
    private String[] teamRowData;


    public HomeView(HomePageViewModel viewModel, HomePageController homeController, ScheduleController scheduleController, PlayerComparisonController playerComparisonController, PlayerSeasonComparisonController playerSeasonComparisonController) {
        this.viewModel = viewModel;
        this.homeController = homeController;
        this.scheduleController = scheduleController;
        this.playerComparisonController = playerComparisonController;
        this.playerSeasonComparisonController = playerSeasonComparisonController;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.viewModel.addPropertyChangeListener(this);
        title = new JLabel(this.viewModel.TITLE_LABEL);

        HomePageState state = this.viewModel.getState();

        pageTitle = new JPanel();

        JLabel header = new JLabel(viewModel.PAGE_TITLE);
        header.setFont(header.getFont().deriveFont(viewModel.PAGE_TITLE_FONT_SIZE));
        pageTitle.add(header);

        playerHeader = new JLabel(viewModel.PLAYER_HEADER);
        playerHeader.setFont(playerHeader.getFont().deriveFont(viewModel.HEADER_FONT_SIZE));

        playerInfo = new JPanel(new GridLayout(13, 2));
        playerRowData = new String[]{
                state.getPlayerFirstName() + " " + state.getPlayerLastName(), state.getPlayerBirthDate(), state.getPlayerCountry(), state.getPlayerTeam(),
                String.valueOf(state.getPlayerPointsPerGame()), String.valueOf(state.getPlayerAssistsPerGame()), String.valueOf(state.getPlayerFreeThrowPercentage()),
                String.valueOf(state.getPlayerFieldGoalPercentage()), String.valueOf(state.getPlayerThreePointPercentage()), String.valueOf(state.getPlayerMinutesPlayedPerGame()),
                String.valueOf(state.getPlayerStealsPerGame()), String.valueOf(state.getPlayerTurnoversPerGame()), String.valueOf(state.getPlayerBlocksPerGame())
        };

        for (int rowNum=0; rowNum<viewModel.PLAYER_ROW_NAMES.length; rowNum++){
            // Add stat label
            JLabel label = new JLabel(viewModel.PLAYER_ROW_NAMES[rowNum]);
            label.setHorizontalAlignment(JLabel.HORIZONTAL);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            playerInfo.add(label);

            // Add stat
            JLabel stat = new JLabel(playerRowData[rowNum]);
            stat.setHorizontalAlignment(JLabel.HORIZONTAL);
            stat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            playerInfo.add(stat);
        }

        teamHeader = new JLabel(viewModel.TEAM_HEADER);
        teamHeader.setFont(teamHeader.getFont().deriveFont(viewModel.HEADER_FONT_SIZE));

        teamInfo = new JPanel(new GridLayout(13, 2));
        teamRowData = new String[]{
                state.getTeamName(), state.getTeamNickname(), state.getTeamCode(),
                state.getConference(), String.valueOf(state.getConferencePlace()), String.valueOf(state.getTeamWins()),
                String.valueOf(state.getTeamLosses()), String.valueOf(state.getTeamsWinsLastTen()), String.valueOf(state.getTeamsLossesLastTen()),
                String.valueOf(state.getTeamPointsPerGame()), state.getTeamFreeThrowPercentage() + "%", state.getTeamFieldGoalPercentage() + "%",
                state.getTeamThreePointPercentage() + "%"
        };

        for (int rowNum=0; rowNum<viewModel.TEAM_ROW_NAMES.length; rowNum++){
            // Add stat label
            JLabel label = new JLabel(viewModel.TEAM_ROW_NAMES[rowNum]);
            label.setHorizontalAlignment(JLabel.HORIZONTAL);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            teamInfo.add(label);

            // Add stat
            JLabel stat = new JLabel(teamRowData[rowNum]);
            stat.setHorizontalAlignment(JLabel.HORIZONTAL);
            stat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            teamInfo.add(stat);
        }


        buttons = new JPanel();
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

        playerSeasonComparisonButton = new JButton(viewModel.PLAYER_SEASON_COMPARISON_BUTTON_LABEL);
        buttons.add(playerSeasonComparisonButton);
        playerSeasonComparisonButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(playerSeasonComparisonButton)) {
                            playerSeasonComparisonController.execute(265, 2022, 2023); // TODO: Note, passedin id 1 and seasons 2015 and 2023 for now
                        }
                    }
                }
        );

        pageTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        teamInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        teamHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);
        this.add(pageTitle);
        this.add(playerHeader);
        this.add(playerInfo);
        this.add(teamHeader);
        this.add(teamInfo);
        this.add(buttons);

        // TODO: Dont call controller here, call on view being changed?? - For now it is called now
        this.homeController.execute();
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
        this.removeAll();
        playerRowData = new String[]{
                state.getPlayerFirstName() + " " + state.getPlayerLastName(), state.getPlayerBirthDate(), state.getPlayerCountry(), state.getPlayerTeam(),
                String.valueOf(state.getPlayerPointsPerGame()), String.valueOf(state.getPlayerAssistsPerGame()), state.getPlayerFreeThrowPercentage() + "%",
                state.getPlayerFieldGoalPercentage() + "%", state.getPlayerThreePointPercentage() + "%", String.valueOf(state.getPlayerMinutesPlayedPerGame()),
                String.valueOf(state.getPlayerStealsPerGame()), String.valueOf(state.getPlayerTurnoversPerGame()), String.valueOf(state.getPlayerBlocksPerGame())
        };

        //this.remove(playerInfo);
        // playerInfo.removeAll();
        playerInfo = new JPanel(new GridLayout(13, 2));
        for (int rowNum=0; rowNum<viewModel.PLAYER_ROW_NAMES.length; rowNum++){
            // Add stat label
            JLabel label = new JLabel(viewModel.PLAYER_ROW_NAMES[rowNum]);
            label.setHorizontalAlignment(JLabel.HORIZONTAL);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            playerInfo.add(label);

            // Add stat
            JLabel stat = new JLabel(playerRowData[rowNum]);
            stat.setHorizontalAlignment(JLabel.HORIZONTAL);
            stat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            playerInfo.add(stat);
        }

        // teamInfo
        teamInfo = new JPanel(new GridLayout(13, 2));
        teamRowData = new String[]{
                state.getTeamName(), state.getTeamNickname(), state.getTeamCode(),
                state.getConference(), String.valueOf(state.getConferencePlace()), String.valueOf(state.getTeamWins()),
                String.valueOf(state.getTeamLosses()), String.valueOf(state.getTeamsWinsLastTen()), String.valueOf(state.getTeamsLossesLastTen()),
                String.valueOf(state.getTeamPointsPerGame()), state.getTeamFreeThrowPercentage() + "%", state.getTeamFieldGoalPercentage() + "%",
                state.getTeamThreePointPercentage() + "%"
        };

        for (int rowNum=0; rowNum<viewModel.TEAM_ROW_NAMES.length; rowNum++){
            // Add stat label
            JLabel label = new JLabel(viewModel.TEAM_ROW_NAMES[rowNum]);
            label.setHorizontalAlignment(JLabel.HORIZONTAL);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            teamInfo.add(label);

            // Add stat
            JLabel stat = new JLabel(teamRowData[rowNum]);
            stat.setHorizontalAlignment(JLabel.HORIZONTAL);
            stat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            teamInfo.add(stat);
        }

        pageTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        teamInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        teamHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(pageTitle);
        this.add(playerHeader);
        this.add(playerInfo);
        this.add(teamHeader);
        this.add(teamInfo);
        this.add(buttons);
    }
}

