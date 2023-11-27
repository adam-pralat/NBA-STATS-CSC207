package view;

import interface_adapter.home_page.HomePageController;
import interface_adapter.home_page.HomePageState;
import interface_adapter.home_page.HomePageViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class HomeView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "home page";
    private final HomePageViewModel viewModel;
    private final HomePageController controller;

    public HomeView(HomePageViewModel viewModel, HomePageController controller) {
        this.viewModel = viewModel;
        this.controller = controller;

        this.viewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(this.viewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.controller.execute();
        JPanel playerInfo = new JPanel();

        // TODO Note: the following line instantiates the "clear" button; it uses
        //      a CLEAR_BUTTON_LABEL constant which is defined in the SignupViewModel class.
        //      You need to add this "clear" button to the "buttons" panel.
//        clear = new JButton(SignupViewModel.CLEAR_BUTTON_LABEL);
//        buttons.add(clear);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        HomePageState state = (HomePageState) evt.getNewValue();
        setFields(state);
        System.out.println(state);
    }

    private void setFields(HomePageState state) {
        // TODO - Set all text fields
    }
}
