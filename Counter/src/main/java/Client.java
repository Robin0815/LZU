
import org.hbrs.ooka.ws2020.uebung2.logger.Inject;
import org.hbrs.ooka.ws2020.uebung2.logger.LoggerInterface;

public class Client {
    private static int counter = 0;
    private static GUI gui;

    @Inject
    public static LoggerInterface myLog;

    @Start
    public static void main(String[] args) {
        myLog.sendLog("Started");
        Controller con = new Controller();
        gui = new GUI("Counter"+counter);
        counter++;
        Counter.setRun(true);
        con.initCounter(0, gui);
    }

    @Stop
    public static void stop(){
        Counter.setRun(false);
        myLog.sendLog("Stopped");
        gui.close();
    }
}
