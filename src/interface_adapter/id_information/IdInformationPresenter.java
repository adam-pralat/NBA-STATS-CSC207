package interface_adapter.id_information;

import use_case.id_information.IdInformationOutputBoundary;
import use_case.id_information.IdInformationOutputData;

public class IdInformationPresenter implements IdInformationOutputBoundary {

    private final IdInformationViewModel idInformationViewModel;

    public IdInformationPresenter(IdInformationViewModel idInformationViewModel) {
        this.idInformationViewModel = idInformationViewModel;
    }

    @Override
    public void prepareView(IdInformationOutputData cod) {
        IdInformationState idInformationState = idInformationViewModel.getState();
        idInformationState.setData(cod.getData());
        this.idInformationViewModel.setState(idInformationState);
        this.idInformationViewModel.firePropertyChanged();
    }
}
