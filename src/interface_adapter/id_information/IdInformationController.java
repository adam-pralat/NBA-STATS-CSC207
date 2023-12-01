package interface_adapter.id_information;

import com.opencsv.exceptions.CsvException;
import use_case.id_information.IdInformationInputBoundary;

import java.io.IOException;

public class IdInformationController {

    final IdInformationInputBoundary idInformationInteractor;
    public IdInformationController(IdInformationInputBoundary idInformationInteractor){
        this.idInformationInteractor = idInformationInteractor;
    }

    public void execute() throws IOException, CsvException {
        idInformationInteractor.execute();
    }
}
