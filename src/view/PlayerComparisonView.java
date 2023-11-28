package view;

import interface_adapter.player_comparison.PlayerComparisonController;
import interface_adapter.player_comparison.PlayerComparisonState;
import interface_adapter.player_comparison.PlayerComparisonViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerComparisonView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "player comparison";

    private final PlayerComparisonViewModel playerComparisonViewModel;
    private final PlayerComparisonController playerComparisonController;

    public PlayerComparisonView(PlayerComparisonController controller, PlayerComparisonViewModel viewModel){
        this.playerComparisonController = controller;
        this.playerComparisonViewModel = viewModel;
        viewModel.addPropertyChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
