package view;

import entity.Game;
import entity.Team;
import interface_adapter.home_page.HomePageController;
import interface_adapter.schedule.ScheduleController;
import interface_adapter.schedule.ScheduleState;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.team_stats.TeamStatsController;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class ScheduleView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "schedule";
    private final ScheduleViewModel scheduleViewModel;
    private final ScheduleController scheduleController;
    private final HomePageController homePageController;
    // TODO private final TeamStatsController teamStatsController;
    private final JLabel date;
    private final JButton exit;
    private final JButton previous;
    private final JButton next;
    private final JPanel gamesPanel;

    public ScheduleView(ScheduleController controller, ScheduleViewModel viewModel, HomePageController homePageController) { // TODO , TeamStatsController teamStatsController
        this.scheduleController = controller;
        this.scheduleViewModel = viewModel;
        this.homePageController = homePageController;
        // TODO this.teamStatsController = teamStatsController;

        scheduleViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(scheduleViewModel.TITLE_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT);

        date = new JLabel();
        date.setAlignmentX(CENTER_ALIGNMENT);

        // Creates a panel for navigating the Schedule
        JPanel buttons = new JPanel();
        exit = new JButton("Exit");
        previous = new BasicArrowButton(SwingConstants.WEST);
        next = new BasicArrowButton(SwingConstants.EAST);
        buttons.add(previous);
        buttons.add(exit);
        buttons.add(next);

        // Exit Button
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

        // Previous Date Button
        previous.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(previous)) {
                        ScheduleState currentState = scheduleViewModel.getState();

                        scheduleController.execute(currentState.getDate().minusDays(1));
                    }
                }
            });

        // Next Date Button
        next.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(next)) {
                            ScheduleState currentState = scheduleViewModel.getState();

                            scheduleController.execute(currentState.getDate().plusDays(1));
                        }
                    }
                });

        // Creates a games panel, which will include all games
        gamesPanel = new JPanel();
        gamesPanel.setLayout(new BoxLayout(gamesPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(gamesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Organizes View Layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(date);
        this.add(buttons);
        this.add(scrollPane);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ScheduleState state = (ScheduleState) evt.getNewValue();
        date.setText(state.getDate().toString());
        updateGamesPanel(state.getGames());
    }

    private void updateGamesPanel(Map<Integer, Game> games) {
        gamesPanel.removeAll(); // Clear existing components

        if (games.isEmpty()) {
            JLabel message = new JLabel("There are no games on this date.");
            message.setAlignmentX(CENTER_ALIGNMENT);
            gamesPanel.add(message);
        } else {

            // Sorts the games
            Set<Integer> keySet = games.keySet();
            List<Integer> sortedKeys = new ArrayList<>(keySet);
            Collections.sort(sortedKeys);

            for(int ID : sortedKeys) {
                Game game = games.get(ID);

                gamesPanel.add(Box.createVerticalStrut(20));

                // Creates a game panel for each game, which will include all relevant game info
                JPanel gamePanel = new JPanel();
                gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.X_AXIS));

                // Creates an info panel, which includes game status and date
                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
                gamesPanel.add(infoPanel);
                gamesPanel.add(gamePanel);

                JLabel status = new JLabel(game.getStatus());
                status.setAlignmentX(CENTER_ALIGNMENT);
                JLabel score = new JLabel();
                score.setAlignmentX(CENTER_ALIGNMENT);
                if(status.getText().equals("Scheduled")) {
                    status.setText("Start Time: " + game.getDateTime().toLocalTime());
                    score.setText(" vs ");
                } else {
                    score.setText(game.getHomeTeamPoints() + " - " + game.getAwayTeamPoints());
                }
                JLabel location = new JLabel(game.getLocation());
                location.setAlignmentX(CENTER_ALIGNMENT);
                infoPanel.add(status);
                infoPanel.add(location);

                // Creates a Panel for each team
                JPanel homePanel = new JPanel();
                homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
                gamePanel.add(homePanel);
                gamePanel.add(score);
                JPanel awayPanel = new JPanel();
                awayPanel.setLayout(new BoxLayout(awayPanel, BoxLayout.Y_AXIS));
                gamePanel.add(awayPanel);

                // Tries to get Team Logos from URL
                try {
                    // Scales Image Icons
                    ImageIcon originalHomeIcon = new ImageIcon(new URL(game.getHomeTeamLogo()));
                    ImageIcon originalAwayIcon = new ImageIcon(new URL(game.getAwayTeamLogo()));
                    Image originalHomeImage = originalHomeIcon.getImage();
                    Image originalAwayImage = originalAwayIcon.getImage();
                    Image scaledHomeImage = originalHomeImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    Image scaledAwayImage = originalAwayImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    ImageIcon homeTeamLogo = new ImageIcon(scaledHomeImage);
                    ImageIcon awayTeamLogo = new ImageIcon(scaledAwayImage);

                    JLabel homeLogo = new JLabel();
                    homeLogo.setIcon(homeTeamLogo);
                    homeLogo.setAlignmentX(CENTER_ALIGNMENT);

                    JLabel awayLogo = new JLabel();
                    awayLogo.setIcon(awayTeamLogo);
                    awayLogo.setAlignmentX(CENTER_ALIGNMENT);

                    homePanel.add(homeLogo);
                    awayPanel.add(awayLogo);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                // Create buttons for each team
                JButton homeTeam = new JButton(game.getHomeTeamName() + " (" + game.getHomeTeamCode() + ")");
                homePanel.add(Box.createVerticalStrut(5));
                homePanel.add(homeTeam);
                homeTeam.setAlignmentX(CENTER_ALIGNMENT);
                JButton awayTeam = new JButton(game.getAwayTeamName() + " (" + game.getAwayTeamCode() + ")");
                awayPanel.add(Box.createVerticalStrut(5));
                awayPanel.add(awayTeam);
                awayTeam.setAlignmentX(CENTER_ALIGNMENT);

                // Separates Games in View
                gamesPanel.add(Box.createVerticalStrut(20));
                JLabel separator = new JLabel("<>".repeat(30));
                separator.setAlignmentX(CENTER_ALIGNMENT);
                gamesPanel.add(separator);

                homeTeam.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource().equals(homeTeam)) {
                            // TODO teamStatsController.execute(games.get(ID).getHomeTeamID());
                        }
                    }
                });

                awayTeam.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource().equals(homeTeam)) {
                            // TODO teamStatsController.execute(games.get(ID).getAwayTeamID());
                        }
                    }
                });
            }

            // Repaint the panel
            gamesPanel.revalidate();
            gamesPanel.repaint();
        }
    }
}
