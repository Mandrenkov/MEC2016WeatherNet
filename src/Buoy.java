import java.util.ArrayList;

public class Buoy extends Transceiver {
    private static final double[] frequencyBounds = {3.0d, 100.0d};
    private static final double WEATHER_CHANCE = 0.01d;

    private double sendFrequency;

    public Buoy(int id, double listenFactor, Coord location, double sendFactor, double sendFrequency) {
        super(id, listenFactor, location, sendFactor, sendFrequency);
        this.sendFrequency = sendFrequency;
    }

    public static double[] getFrequencyBounds() {
        return Buoy.frequencyBounds;
    }

    public void receiveMessage(Message message) {
        System.out.println("buoy " + this.getID() + " received " + message.getContent());
    }

    public ArrayList<Message> sendMessages() {
        ArrayList<Message> messages = new ArrayList<Message>();
        if (Math.random() < this.WEATHER_CHANCE) {
            messages.add(new Message((int) System.currentTimeMillis(), this.location, this.id,
                    this.senseWeather(), Message.MsgType.WEATHER, 1.0, 1.0));
        }
        return messages;
    }

    public ArrayList<SatMessage> sendSatMessages() {
        return new ArrayList<SatMessage>();
    }

    private String senseWeather() {
        return "it's raining outside :(";
    }

    public void receiveSatMessage(SatMessage satm) {
        System.out.println("buoy " + this.getID() + " satreceived " + satm.getContent());
    }
}
