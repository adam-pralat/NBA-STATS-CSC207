package app;

import data_access.PlayerDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.player_stats.PlayerStatsController;
import interface_adapter.player_stats.PlayerStatsPresenter;
import use_case.player_stats.PlayerStatsInputData;
import use_case.player_stats.PlayerStatsInteractor;
import use_case.player_stats.PlayerStatsOutputBoundary;
import use_case.player_stats.PlayerStatsOutputData;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Test method for playerStats use case. Prints all player information instead of using view
        PlayerDataAccessObject dao = new PlayerDataAccessObject();

        // Output boundary just prints information. Presenter, view, view model is not tested yet
        PlayerStatsOutputBoundary ob = new PlayerStatsOutputBoundary() {
            @Override
            public void prepareSuccessView(PlayerStatsOutputData response) {
                System.out.println(response.getPlayerStats());
            }

            @Override
            public void prepareFailView(String error) {
                System.out.println(error);
            }
        };
        PlayerStatsInteractor interactor = new PlayerStatsInteractor(dao, ob);
        PlayerStatsController controller = new PlayerStatsController(interactor);
        controller.execute(2566); // Can change id to check different ids
    }
}
