import java.util.*;

/* Represents the air space in the sea */
public class AeroSpace {
    // List of transceivers
    public static ArrayList<Transceiver> listeners = new ArrayList<>();

    // Width and height of the space
    private double width, height;

    // Message queue
    private Queue<Message> messages = new LinkedList<Message>();
    
    // Send constant
    private final double sendConst = 50;

    // Constructor
    public AeroSpace(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Adds a transceiver to the list of known transceivers
    public void addTransceiver(Transceiver t) {
        listeners.add(t);
    }

    // Runs the simulation
    public void run() {
        // Infinite loop
        while (true) {
            // Check for message
            Message mess = messages.poll();
            if (mess != null) {
                for (Transceiver t : listeners) {
                    if (t.getLocation().distanceTo(mess.getLocation()) <= sendConst * mess.getStrength()
                            && t.getID() != mess.getSenderID()) {
                        System.out.println(Coord.noise(t, mess, 238));
                        mess.garble(Coord.noise(t, mess, 100));
                        t.receiveMessage(mess);
                        GUI.addMessage(mess);
                    }
                }
            }
            for (Transceiver t : listeners) {
                for (Message m : t.sendMessages()) {
                    messages.add(m);
                }
                if (t instanceof Buoy) {
                    for (SatMessage satm : ((Buoy) t).sendSatMessages()) {
                        ArrayList<Buoy> receivers = satm.getReceivers();
                        if (receivers == null) {
                            for (Transceiver t2 : listeners) {
                                if (t2 instanceof Buoy) {
                                    ((Buoy) t2).receiveSatMessage(satm);
                                }
                            }
                        } else {
                            for (Buoy receiver : satm.getReceivers()) {
                                receiver.receiveSatMessage(satm);
                            }
                        }
                    }
                } else {
                    t.move((int) (Math.random()*3) - 1, (int) (Math.random()*3) - 1);
                }
            }
            synchronized (this) {
                try {
                    // Wait for 1000 ms
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
