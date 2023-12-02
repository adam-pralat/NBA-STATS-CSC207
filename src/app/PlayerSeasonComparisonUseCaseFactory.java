package app;

import com.opencsv.exceptions.CsvException;
import interface_adapter.ViewManagerModel;
import interface_adapter.id_information.IdInformationController;
import interface_adapter.id_information.IdInformationViewModel;
import use_case.id_information.IdInformationDataAccessInterface;

import interface_adapter.player_season_comparison.PlayerSeasonComparisonController;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonPresenter;
import interface_adapter.player_season_comparison.PlayerSeasonComparisonViewModel;
import use_case.player_season_comparison.PlayerSeasonComparisonDataAccessInterface;
import use_case.player_season_comparison.PlayerSeasonComparisonInputBoundary;
import use_case.player_season_comparison.PlayerSeasonComparisonInteractor;
import use_case.player_season_comparison.PlayerSeasonComparisonOutputBoundary;
import view.PlayerSeasonComparisonView;

import javax.swing.*;
import java.io.IOException;

import static app.IdInformationUseCaseFactory.getController;

public class PlayerSeasonComparisonUseCaseFactory {
    private PlayerSeasonComparisonUseCaseFactory() {}

    public static PlayerSeasonComparisonView create(ViewManagerModel viewManagerModel, PlayerSeasonComparisonViewModel playerSeasonComparisonViewModel, PlayerSeasonComparisonDataAccessInterface playerSeasonComparisonDAO, IdInformationViewModel idInformationViewModel, IdInformationDataAccessInterface idInformationDataAccessInterface) throws IOException {
        try {
            PlayerSeasonComparisonController playerSeasonComparisonController = createPlayerSeasonComparisonUseCase(viewManagerModel, playerSeasonComparisonViewModel, playerSeasonComparisonDAO);
            IdInformationController idInformationController = getController(idInformationViewModel, idInformationDataAccessInterface);
            return new PlayerSeasonComparisonView(playerSeasonComparisonController, playerSeasonComparisonViewModel, idInformationController, idInformationViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open data file.");
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static PlayerSeasonComparisonController createPlayerSeasonComparisonUseCase(
            ViewManagerModel viewManagerModel,
            PlayerSeasonComparisonViewModel playerSeasonComparisonViewModel,
            PlayerSeasonComparisonDataAccessInterface playerSeasonComparisonDataAccessObject) {
        PlayerSeasonComparisonOutputBoundary playerSeasonComparisonOutputBoundary = new PlayerSeasonComparisonPresenter(
                viewManagerModel,
                playerSeasonComparisonViewModel);

        PlayerSeasonComparisonInputBoundary playerSeasonComparisonInteractor = new PlayerSeasonComparisonInteractor(
                playerSeasonComparisonDataAccessObject, playerSeasonComparisonOutputBoundary);

        return new PlayerSeasonComparisonController(playerSeasonComparisonInteractor);
    }

}