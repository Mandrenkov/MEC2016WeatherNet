public class Message {
    private int time;
    private Coord position;
    private int senderID;
    private String content, type;
    private double freq;
    public static final String CHATTER = "chatter";
    Message(int time, Coord postion, int senderID, String content, String type, double freq){
        this.time = time;
        this.position = position;
        this.senderID = senderID;
        this.content = content;
        this.type = type;
        this.freq = freq;
    }
}