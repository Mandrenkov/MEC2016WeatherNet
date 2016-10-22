import java.util.*;

public class AeroSpace {
    private double width, height;
    private ArrayList<Transceiver> listeners = new ArrayList<>();
    private Queue<Message> messages = new LinkedList<Message>();
    private final double sendConst = 100;

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
                    if (t.getLocation().distanceTo(mess.getLocation()) <= sendConst * mess.getStrength()) {
                        t.receiveMessage(mess);
                    }
                }
            }
            for (Transceiver t : listeners) {
                for (Message m : t.sendMessages()) {
                    messages.add(m);
                    GUI.addMessage(m);
                }
            }
            synchronized (this) {
                try {
                    wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
