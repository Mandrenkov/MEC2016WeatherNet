import java.util.*;

public class AeroSpace {
    public static ArrayList<Transceiver> listeners = new ArrayList<>();

    private double width, height;
    private Queue<Message> messages = new LinkedList<Message>();
    private final double sendConst = 50;

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
                    if (t.getLocation().distanceTo(mess.getLocation()) <= sendConst * mess.getStrength()
                            && t.getID() != mess.getSenderID()) {
                        System.out.println(Coord.noise(t, mess, 238));
                        mess.garble(Coord.noise(t, mess, 100));
                        t.receiveMessage(mess);
                    }
                }
            }
            for (Transceiver t : listeners) {
                for (Message m : t.sendMessages()) {
                    messages.add(m);
                    GUI.addMessage(m);
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
                    wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
