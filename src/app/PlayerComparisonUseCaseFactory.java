package app;

import com.opencsv.exceptions.CsvException;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_page.HomePageController;
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

    public static PlayerComparisonView create(PlayerComparisonViewModel playerComparisonViewModel,
                                              PlayerComparisonController playerComparisonController,
                                              IdInformationController idInformationController,
                                              IdInformationViewModel idInformationViewModel,
                                              HomePageController homePageController) {
            // TODO: RemovedL throws IOException {
       try{
        return new PlayerComparisonView(playerComparisonController,
                playerComparisonViewModel,
                idInformationController,
                idInformationViewModel,
                homePageController);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Could not open data file.");
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static PlayerComparisonController createPlayerComparisonUseCase(
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
