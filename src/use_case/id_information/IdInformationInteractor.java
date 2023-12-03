package use_case.id_information;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public class IdInformationInteractor implements IdInformationInputBoundary {

    final IdInformationDataAccessInterface idInformationDataAccessObject;
    final IdInformationOutputBoundary idInformationPresenter;

    public IdInformationInteractor(IdInformationDataAccessInterface idInformationDataAccessInterface,
                                   IdInformationOutputBoundary idInformationOutputBoundary){
        this.idInformationDataAccessObject = idInformationDataAccessInterface;
        this.idInformationPresenter = idInformationOutputBoundary;
    }

    @Override
    public void execute() throws IOException, CsvException {
        List<String[]> tpi;
        tpi = idInformationDataAccessObject.readCsvData();
        IdInformationOutputData idInformationOutputData = new IdInformationOutputData(tpi);
        idInformationPresenter.prepareView(idInformationOutputData);
    }
}
