import com.sun.prism.shader.Solid_Color_AlphaTest_Loader;

import java.util.ArrayList;

public class Buoy extends Transceiver {
    private static final double[] frequencyBounds = {3.0d, 100.0d};
    private static final double WEATHER_CHANCE = 0.01d;

    private double sendFrequency;
    private ArrayList<SatMessage> pendingSends = new ArrayList<>();

    public Buoy(int id, double listenFactor, Coord location, double sendFactor, double sendFrequency) {
        super(id, listenFactor, location, sendFactor, sendFrequency);
        this.sendFrequency = sendFrequency;
    }

    public static double[] getFrequencyBounds() {
        return Buoy.frequencyBounds;
    }

    public void receiveMessage(Message message) {
        System.out.println("buoy " + this.getID() + " received " + message.getContent());
        if (message.getType() == Message.MsgType.SOS) {
            this.pendingSends.add(new SatMessage(this, null, message));
        }
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
        ArrayList<SatMessage> copy = (ArrayList<SatMessage>) this.pendingSends.clone();
        this.pendingSends = new ArrayList<SatMessage>();
        return copy;
    }

    private String senseWeather() {
        switch (rand.nextInt(7)) {
            case 0:
                return "it's raining outside :(";
            case 1:
                return "it's sunny outside :)";
            case 2:
                return "oh no, hurricane :o";
            case 3:
                return "windy :---)";
            case 4:
                return "more rain D:";
            default:
                return "clear skies :D";
        }
    }

    public void receiveSatMessage(SatMessage satm) {
        System.out.println("buoy " + this.getID() + " satreceived "
                + satm.getContent() + " " + satm.getContent().getContent());
    }
}
