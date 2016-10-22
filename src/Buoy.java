import java.util.ArrayList;

public class Buoy extends Transceiver {
    protected static double[] buoyFrequencyBounds = {3.0d, 100.0d};

    private double sendFrequency;
    private final double weatherChance = .01;

    public Buoy(int id, double listenFactor, Coord location, double sendFactor, double sendFrequency) {
        super(id, listenFactor, location, sendFactor, sendFrequency);
        this.sendFrequency = sendFrequency;
    }

    public double[] getFrequencyBounds() {
        return buoyFrequencyBounds;
    }

    public void receiveMessage(Message message) {
        System.out.println("buoy " + this.getID() + " received " + message.getContent());
    }

    public ArrayList<Message> sendMessages() {
        ArrayList<Message> list = new ArrayList<Message>();
        if (rand.nextDouble() < this.weatherChance) {
            list.add(new Message((int) System.currentTimeMillis(), this.location, this.id, "hello world", Message.MsgType.CHATTER, 1.0, 1.0));
        }
        return list;
    }
}
