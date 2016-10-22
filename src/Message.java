public class Message {
    private int time;
    private Coord position;
    private int senderID;
    private String content, type;
    private double freq, strength;
    public static final String CHATTER = "chatter";
    Message(int time, Coord position, int senderID, String content, String type, double freq, double strength){
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
}