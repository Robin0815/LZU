

import org.hbrs.ooka.ws2020.uebung2.annotation.Inject;
import org.hbrs.ooka.ws2020.uebung2.logger.LoggerInterface;
import org.hbrs.ooka.ws2020.uebung2.observer.Event;
import org.hbrs.ooka.ws2020.uebung2.observer.ObsServer;
import org.hbrs.ooka.ws2020.uebung2.observer.SubPub;
import org.hbrs.ooka.ws2020.uebung2.annotation.Start;
import org.hbrs.ooka.ws2020.uebung2.annotation.Stop;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Client implements SubPub {
    private static int counter = 0;
    private static GUI gui;

    @Inject
    public static LoggerInterface myLog;

    @Inject
    public static ObsServer obs;

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Start
    public void main(String[] args) {
        //
        myLog.sendLog("Counter"+counter+"Started");
        obs.registerSubPub(this);
        Event event = new Event();
        event.state="started";
        event.compName="Counter"+counter;
        setEvent(event);
        //ab hier benötigt vorher nur logger und observer
        Controller con = new Controller();
        gui = new GUI("Counter"+counter);
        counter++;
        Counter.setRun(true);
        con.initCounter(0, gui);
    }

    @Stop
    public void stop(){
        //
        myLog.sendLog("Counter"+counter+" Stopped");
        Event event = new Event();
        event.state="stopped";
        event.compName="Counter"+counter;
        setEvent(event);
        obs.removeSubPub(this);
        System.out.println("Code wird ausgeführt");
        //ab hier benötigt vorher nur logger und observer
        Counter.setRun(false);
        gui.close();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Event i = (Event) evt.getNewValue();
        System.out.println("Update erhalten: "+i.toString());
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setEvent(Event event) {
        support.firePropertyChange("Event", null, event);
    }
}
