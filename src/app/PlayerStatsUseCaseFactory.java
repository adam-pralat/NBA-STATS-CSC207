package app;

import com.opencsv.exceptions.CsvException;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_page.HomePageController;
import interface_adapter.id_information.IdInformationController;
import interface_adapter.id_information.IdInformationViewModel;
import interface_adapter.player_stats.PlayerStatsController;
import interface_adapter.player_stats.PlayerStatsPresenter;
import interface_adapter.player_stats.PlayerStatsViewModel;
import use_case.id_information.IdInformationDataAccessInterface;
import use_case.player_stats.PlayerStatsDataAccessInterface;
import use_case.player_stats.PlayerStatsInputBoundary;
import use_case.player_stats.PlayerStatsInteractor;
import use_case.player_stats.PlayerStatsOutputBoundary;
import view.PlayerSeasonComparisonView;
import view.PlayerStatsView;

import javax.swing.*;
import java.io.IOException;

import static app.IdInformationUseCaseFactory.getController;

public class PlayerStatsUseCaseFactory {
    private PlayerStatsUseCaseFactory() {
    }

    public static PlayerStatsView create(ViewManagerModel viewManagerModel, PlayerStatsViewModel playerStatsViewModel, PlayerStatsDataAccessInterface playerStatsDAO, IdInformationViewModel idInformationViewModel, IdInformationDataAccessInterface idInformationDataAccessInterface, HomePageController homePageController) throws IOException {
        try {
            PlayerStatsController playerStatsController = createPlayerStatsUseCase(viewManagerModel, playerStatsViewModel, playerStatsDAO);
            IdInformationController idInformationController = getController(idInformationViewModel, idInformationDataAccessInterface);
            return new PlayerStatsView(playerStatsController, playerStatsViewModel, idInformationController, idInformationViewModel, homePageController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open data file.");
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static PlayerStatsController createPlayerStatsUseCase(
            ViewManagerModel viewManagerModel,
            PlayerStatsViewModel playerSeasonComparisonViewModel,
            PlayerStatsDataAccessInterface playerSeasonComparisonDataAccessObject) {
        PlayerStatsOutputBoundary playerSeasonComparisonOutputBoundary = new PlayerStatsPresenter(
                viewManagerModel,
                playerSeasonComparisonViewModel);

        PlayerStatsInputBoundary playerSeasonComparisonInteractor = new PlayerStatsInteractor(
                playerSeasonComparisonDataAccessObject, playerSeasonComparisonOutputBoundary);

        return new PlayerStatsController(playerSeasonComparisonInteractor);
    }

}