package view;

import interface_adapter.home_page.HomePageController;
import interface_adapter.schedule.ScheduleController;
import interface_adapter.schedule.ScheduleState;
import interface_adapter.schedule.ScheduleViewModel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

public class ScheduleView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "schedule";
    private final ScheduleViewModel scheduleViewModel;
    private final ScheduleController scheduleController;
    private final HomePageController homePageController;
    JLabel date;
    final JButton exit;
    final JButton previous;
    final JButton next;
    JEditorPane games;

    public ScheduleView(ScheduleController controller, ScheduleViewModel viewModel, HomePageController homePageController) {
        this.scheduleController = controller;
        this.scheduleViewModel = viewModel;
        this.homePageController = homePageController;

        scheduleViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("NBA Schedule");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        date = new JLabel();
        games = new JEditorPane();

        JPanel buttons = new JPanel();
        exit = new JButton(ScheduleViewModel.EXIT_BUTTON_LABEL);
        previous = new BasicArrowButton(SwingConstants.WEST);
        next = new BasicArrowButton(SwingConstants.EAST);
        buttons.add(previous);
        buttons.add(exit);
        buttons.add(next);

        exit.addActionListener(this); // TODO Implement Exit
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
        previous.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(previous)) {
                        ScheduleState currentState = scheduleViewModel.getState();

                        scheduleController.execute(currentState.getDate().minusDays(1));
                    }
                }
            });

        next.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(next)) {
                            ScheduleState currentState = scheduleViewModel.getState();

                            scheduleController.execute(currentState.getDate().plusDays(1));
                        }
                    }
                });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(date);
        this.add(buttons);
        this.add(games);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ScheduleState state = (ScheduleState) evt.getNewValue();
        date.setText(state.getDate().toString());
        games.setText(state.getGames().toString());
    }
}
