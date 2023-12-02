package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This Class is responsible for managing the active view when the program is running
 */
public class ViewManagerModel {

    private String activeViewName;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * This method is reponsible for returning the active view the program is on
     * when running
     * @return the name of the current view the program is on
     */
    public String getActiveView() {
        return activeViewName;
    }

    /**
     * Sets the name of the current view
     * @param activeView is a String of the current view the program is
     * on when running
     */
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    /**
     * Method is called to let the ViewModel know to alert the View
     */
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }

    /**
     * Method is called to add PropertyChangeListeners
     * @param listener is the PropertyChangeListener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
