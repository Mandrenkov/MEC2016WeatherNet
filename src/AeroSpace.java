import java.util.ArrayList;
import java.util.Queue;

public class AeroSpace {
    private double width, height;
    private ArrayList<Transceiver> listeners;
    private Queue<Message> messages;

    public AeroSpace(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void addTransceiver(Transceiver t) {
        listeners.add(t);
    }

    public void run() {
        while (true) {
            Message mess = messages.poll();
            if (mess != null) {
                for (Transceiver t : listeners) {
                    t.receive(mess);
                }
            }
            for (Transceiver t : listeners) {
                messages.add(t.send());
            }
        }
    }
}
