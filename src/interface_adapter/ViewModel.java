package interface_adapter;

import java.beans.PropertyChangeListener;

/**
 * This class is the Parent Class of the View Models
 */
public abstract class ViewModel {

    private String viewName;

    /**
     * this method is the constructor of creating a generic View Model
     * @param viewName is the String of name of the view
     */
    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    /**
     *
     * @return the viewName of the class
     */
    public String getViewName() {
        return this.viewName;
    }

    /**
     * Method is called to let the ViewModel know to alert the View
     */
    public abstract void firePropertyChanged();

    /**
     * Method is called to add PropertyChangeListeners
     * @param listener is the PropertyChangeListener
     */
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);


}
