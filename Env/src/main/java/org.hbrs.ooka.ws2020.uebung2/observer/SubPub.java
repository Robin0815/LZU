package org.hbrs.ooka.ws2020.uebung2.observer;

import java.beans.PropertyChangeListener;

public interface SubPub extends PropertyChangeListener {
    void addPropertyChangeListener(PropertyChangeListener pcl);
    void removePropertyChangeListener(PropertyChangeListener pcl);
    void setEvent(Event event);
}
