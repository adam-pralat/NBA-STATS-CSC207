package interface_adapter.id_information;

import use_case.id_information.IdInformationInputBoundary;

public class IdInformationController {

    final IdInformationInputBoundary idInformationInteractor;
    public IdInformationController(IdInformationInputBoundary idInformationInteractor){
        this.idInformationInteractor = idInformationInteractor;
    }

    public void execute(){
        idInformationInteractor.execute();
    }
}
