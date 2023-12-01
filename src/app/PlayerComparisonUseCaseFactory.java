package app;

import com.opencsv.exceptions.CsvException;
import interface_adapter.ViewManagerModel;
import interface_adapter.id_information.IdInformationController;
import interface_adapter.id_information.IdInformationViewModel;
import interface_adapter.player_comparison.PlayerComparisonController;
import interface_adapter.player_comparison.PlayerComparisonPresenter;
import interface_adapter.player_comparison.PlayerComparisonViewModel;
import use_case.id_information.IdInformationDataAccessInterface;
import use_case.player_comparison.PlayerComparisonDataAccessInterface;
import use_case.player_comparison.PlayerComparisonInputBoundary;
import use_case.player_comparison.PlayerComparisonInteractor;
import use_case.player_comparison.PlayerComparisonOutputBoundary;
import view.PlayerComparisonView;

import javax.swing.*;
import java.io.IOException;

import static app.IdInformationUseCaseFactory.getController;

public class PlayerComparisonUseCaseFactory {
    private PlayerComparisonUseCaseFactory() {}

    public static PlayerComparisonView create(ViewManagerModel viewManagerModel,
                                              PlayerComparisonViewModel playerComparisonViewModel,
                                              PlayerComparisonDataAccessInterface playerComparisonDAO,
                                              IdInformationViewModel idInformationViewModel,
                                              IdInformationDataAccessInterface idInformationDataAccessInterface)
            throws IOException {
        try{
        PlayerComparisonController playerComparisonController = createPlayerComparisonUseCase(viewManagerModel,
                playerComparisonViewModel, playerComparisonDAO);
        IdInformationController idInformationController = getController(idInformationViewModel, idInformationDataAccessInterface);
        return new PlayerComparisonView(playerComparisonController,
                playerComparisonViewModel,
                idInformationController,
                idInformationViewModel);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Could not open data file.");
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static PlayerComparisonController createPlayerComparisonUseCase(
            ViewManagerModel viewManagerModel,
            PlayerComparisonViewModel playerComparisonViewModel,
            PlayerComparisonDataAccessInterface playerComparisonDataAccessObject) {
        PlayerComparisonOutputBoundary playerComparisonOutputBoundary = new PlayerComparisonPresenter(
                viewManagerModel,
                playerComparisonViewModel);

        PlayerComparisonInputBoundary playerComparisonInteractor = new PlayerComparisonInteractor(
                playerComparisonDataAccessObject, playerComparisonOutputBoundary);

        return new PlayerComparisonController(playerComparisonInteractor);
    }

}
