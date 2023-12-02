package interface_adapter.id_information;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class IdInformationViewModel extends ViewModel {

    private IdInformationState state = new IdInformationState();

    public IdInformationViewModel(){ super("id information"); }

    public void setState(IdInformationState state) { this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public IdInformationState getState() { return state; }
}
