import java.util.Random;

/* Represents a discrete radio message. */
public class Message {
    // Time message was sent (unix time)
    private long time; 

    // Position of message sender
    private Coord position;

    // ID of message sender
    private int senderID; 

    // Actual content of message
    private String content; 

    // Frequency message was transmitted, strength of signal
    private double freq, strength; 

    // Types of messages
    public enum MsgType {CHATTER, WEATHER, SOS}; 

    // Type of message
    private MsgType type;

    // getter for time attribute
    public long getTime() {
        return time;
    }

    // getter for position attribute
    public Coord getPosition() {
        return position;
    }

    // getter for type attribute
    public MsgType getType() {
        return type;
    }

    // getter for senderID attribute
    public int getSenderID() {
        return senderID;
    }

    // constructor
    Message(long time, Coord position, int senderID, String content, MsgType type, double freq, double strength){
        this.time = time;
        this.position = position;
        this.senderID = senderID;
        this.content = content;
        this.type = type;
        this.freq = freq;
        this.strength = strength;
    }

    // getter for signal strength attribute
    public double getStrength() {
        return this.strength;
    }

    // getter for sender location attribute
    public Coord getLocation() {
        return this.position;
    }

    // getter for message frequency attribute
    public double getFreq() {
        return this.freq;
    }

    // getter for message content attribute
    public String getContent() {
        return this.content;
    }

    // random permutes a string to simulate garbling a radio transmission
    // integrity >= 1 is perfect, less brings increasing levels of garbling
    public void garble(double integrity) {
        Random rand = new Random();
        char[] array = this.content.toCharArray();
        for (int i=0; i < array.length; i++) {
            if (rand.nextDouble() > integrity) {
                array[i] = array[rand.nextInt(array.length)];
            }
        }
        this.content = new String(array);
    }
}