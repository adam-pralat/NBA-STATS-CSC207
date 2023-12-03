package app;

import interface_adapter.id_information.IdInformationController;
import interface_adapter.id_information.IdInformationPresenter;
import interface_adapter.id_information.IdInformationViewModel;
import use_case.id_information.IdInformationDataAccessInterface;
import use_case.id_information.IdInformationInputBoundary;
import use_case.id_information.IdInformationInteractor;
import use_case.id_information.IdInformationOutputBoundary;

import java.io.IOException;

public class IdInformationUseCaseFactory {

    private IdInformationUseCaseFactory() {}

    private static IdInformationController createIdInformationUseCase(IdInformationViewModel idInformationViewModel, IdInformationDataAccessInterface idInformationDataAccessObject){ //TODO: Note removed for now: throws IOException {
        IdInformationOutputBoundary idInformationOutputBoundary = new IdInformationPresenter(idInformationViewModel);
        IdInformationInputBoundary idInformationInteractor = new IdInformationInteractor(idInformationDataAccessObject, idInformationOutputBoundary);
        return new IdInformationController(idInformationInteractor);
    }

    public static IdInformationController getController(IdInformationViewModel idInformationViewModel, IdInformationDataAccessInterface idInformationDataAccessInterface) {//TODO: Note removed for now: throws IOException {
        return createIdInformationUseCase(idInformationViewModel, idInformationDataAccessInterface);
    }
}
