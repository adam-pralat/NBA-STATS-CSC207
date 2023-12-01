package use_case.id_information;

import java.util.List;

public class IdInformationOutputData {
    private final List<String[]> data;
    public IdInformationOutputData(List<String[]> data){ this.data = data; }

    public List<String[]> getData() { return data; }
}
