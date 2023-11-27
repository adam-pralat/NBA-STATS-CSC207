package view;

import interface_adapter.schedule.ScheduleController;
import interface_adapter.schedule.ScheduleState;
import interface_adapter.schedule.ScheduleViewModel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ScheduleView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Schedule";
    private final ScheduleViewModel scheduleViewModel;
    private final ScheduleController scheduleController;
    JLabel date;
    final JButton exit;
    final JButton previous;
    final JButton next;
    JLabel games;

    public ScheduleView(ScheduleController controller, ScheduleViewModel viewModel) {
        this.scheduleController = controller;
        this.scheduleViewModel = viewModel;

        scheduleViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("NBA Schedule");

        date = new JLabel();
        games = new JLabel();

        JPanel buttons = new JPanel();
        exit = new JButton();
        previous = new BasicArrowButton(SwingConstants.WEST);
        next = new BasicArrowButton(SwingConstants.EAST);
        buttons.add(previous);
        buttons.add(exit);
        buttons.add(next);

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
        date.setText(String.valueOf(state.getDate()));
        games.setText(state.getGames().toString());
    }
}
