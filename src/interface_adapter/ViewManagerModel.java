package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewManagerModel {
    private String activeViewName;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public String getActiveView() {return activeViewName;}

    public void setActiveView(String activeView) {this.activeViewName = activeView;}

    public void firePropretyChanged() {support.firePropertyChange("view", null, this.activeViewName);}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChhangeListener(listener);
    }
}
