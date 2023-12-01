package data_access;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import use_case.id_information.IdInformationDataAccessInterface;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class IdInformationDataAccessObject implements IdInformationDataAccessInterface {

    @Override
    public List<String[]> readCsvData() throws IOException, CsvException {
        String csvFilePath = "team_player_id.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            return reader.readAll();
        }
    }
}
