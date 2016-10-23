import java.util.ArrayList;

/* Buoy Entity Module */
public class Buoy extends Transceiver {
    // Buoy send frequencies
    private static final double[] frequencyBounds = {3.0d, 100.0d};
    
    // Chance of sending a weather message
    private static double weatherChance = 0.01d;

    // Frequency for sending messages
    private double sendFrequency;

    // Pending satellite messages
    private ArrayList<SatMessage> pendingSends = new ArrayList<>();

    // Constructor
    public Buoy(int id, double listenFactor, Coord location, double sendFactor, double sendFrequency) {
        super(id, listenFactor, location, sendFactor, sendFrequency);
        this.sendFrequency = sendFrequency;
    }

    // Returns the possible transmission frequency range
    public static double[] getFrequencyBounds() {
        return Buoy.frequencyBounds;
    }

    // Procedure for receiving a message
    public void receiveMessage(Message message) {
        System.out.println("buoy " + this.getID() + " received " + message.getContent());
        if (message.getType() == Message.MsgType.SOS) {
            this.pendingSends.add(new SatMessage(this, null, message));
        }
    }

    // Returns an ArrayList of messages to send
    public ArrayList<Message> sendMessages() {
        ArrayList<Message> messages = new ArrayList<Message>();
        if (Math.random() < this.weatherChance) {
            messages.add(new Message((long) System.currentTimeMillis(), this.location, this.id,
                    this.senseWeather(), Message.MsgType.WEATHER, 1.0, 1.0));
        }
        return messages;
    }

    // Sends satellite messages
    public ArrayList<SatMessage> sendSatMessages() {
        ArrayList<SatMessage> copy = new ArrayList<>(this.pendingSends);
        this.pendingSends = new ArrayList<SatMessage>();
        return copy;
    }

    // Uses sensors to retrieve current weather information
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

    // Receive a satellite message
    public void receiveSatMessage(SatMessage satm) {
        System.out.println("Buoy \"" + this.getID() + "\" satreceived \""
                + satm.getContent() + "\" " + satm.getContent().getContent());
    }

    // Sets the chance of weather occurring
    public void setWeatherChance(double weatherChance) {
        this.weatherChance = weatherChance;
    }
}
