package interface_adapter.schedule;

import interface_adapter.ViewModel;
import view.ScheduleView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ScheduleViewModel extends ViewModel {
    public String TITLE_LABEL = "NBA Schedule";
    public ScheduleViewModel() {
        super("schedule");
    }
    private ScheduleState state = new ScheduleState();
    public void setState(ScheduleState state) {
        this.state = state;
    }
    public ScheduleState getState() {
        return state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
