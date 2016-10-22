import static com.sun.imageio.plugins.jpeg.JPEG.SOS;

public class Message {
    private int time;
    private Coord position;
    private int senderID;
    private String content;
    private double freq, strength;
    public enum MsgType {CHATTER, WEATHER, SOS};
    private MsgType type;
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
}