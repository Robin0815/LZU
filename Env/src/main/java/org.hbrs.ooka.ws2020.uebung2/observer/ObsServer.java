package org.hbrs.ooka.ws2020.uebung2.observer;

import org.hbrs.ooka.ws2020.uebung2.assembler.ComponentThread;
import org.hbrs.ooka.ws2020.uebung2.component.Component;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ObsServer implements PropertyChangeListener {

    public static Event event = new Event();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private ObsServer(){

    }
    private static ObsServer instance = new ObsServer();

    public static ObsServer getInstance(){
        return instance;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void registerSubPub(SubPub pcl){
        this.addPropertyChangeListener(pcl);
        pcl.addPropertyChangeListener(this);
    }

    public void removeSubPub(SubPub pcl){
        this.removePropertyChangeListener(pcl);
        pcl.removePropertyChangeListener(this);
    }
    public void setEvent(Event value) {
        support.firePropertyChange("Event", this.event, value);
        //System.out.println(value.toString());
        this.event = value;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getNewValue() instanceof Event){
            Event value = (Event) evt.getNewValue();
            setEvent(value);
        }
    }
}
