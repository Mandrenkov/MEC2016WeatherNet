public class Message {
    private int time;
    private Coord position;
    private int senderID;
    private String content, type;
    Message(int time, Coord postion, int senderID, String content, String type){
        this.time = time;
        this.position = position;
        this.senderID = senderID;
        this.content = content;
        this.type = type;
    }
}