package interface_adapter.id_information;

import java.util.List;

public class IdInformationState {
    private List<String[]> data;
    public IdInformationState(IdInformationState copy) { data = copy.data; }
    public IdInformationState(){}
    public List<String[]> getData(){ return data; }
    public void setData(List<String[]> data){ this.data = data; }
}
