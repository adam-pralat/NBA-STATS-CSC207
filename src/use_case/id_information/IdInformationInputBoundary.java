package use_case.id_information;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public interface IdInformationInputBoundary {
    void execute() throws IOException, CsvException;
}
