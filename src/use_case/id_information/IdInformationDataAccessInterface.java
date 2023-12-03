package use_case.id_information;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public interface IdInformationDataAccessInterface {
    List<String[]> readCsvData() throws IOException, CsvException;
}
