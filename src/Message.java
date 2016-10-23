import java.util.Random;

public class Message {
    private int time;
    private Coord position;
    private int senderID;
    private String content;
    private double freq, strength;
    public enum MsgType {CHATTER, WEATHER, SOS};

    public int getTime() {
        return time;
    }

    public Coord getPosition() {
        return position;
    }

    public MsgType getType() {
        return type;
    }

    private MsgType type;

    public int getSenderID() {
        return senderID;
    }

    Message(int time, Coord position, int senderID, String content, MsgType type, double freq, double strength){
        this.time = time;
        this.position = position;
        this.senderID = senderID;
        this.content = content;
        this.type = type;
        this.freq = freq;
        this.strength = strength;
    }

    public double getStrength() {
        return this.strength;
    }

    public Coord getLocation() {
        return this.position;
    }

    public double getFreq() {
        return this.freq;
    }

    public String getContent() {
        return this.content;
    }

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