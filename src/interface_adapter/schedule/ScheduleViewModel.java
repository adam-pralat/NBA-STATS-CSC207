package interface_adapter.schedule;

import interface_adapter.ViewModel;
import view.ScheduleView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ScheduleViewModel extends ViewModel {

    public static final String EXIT_BUTTON_LABEL = "Exit";
    public final String TITLE_LABEL = "Schedule View";

    private ScheduleState state = new ScheduleState();

    public ScheduleViewModel() {
        super("schedule");
    }


    public void setState(ScheduleState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ScheduleState getState() {
        return state;
    }

}
