import java.util.ArrayList;

public class SatMessage {
    private Buoy sender;
    private ArrayList<Buoy> receivers;
    private Message content;

    public Buoy getSender() {
        return sender;
    }

    public ArrayList<Buoy> getReceivers() {
        return receivers;
    }

    public Message getContent() {
        return content;
    }

    public SatMessage(Buoy sender, ArrayList<Buoy> receivers, Message content) {
        this.sender = sender;
        this.receivers = receivers;
        this.content = content;
    }
}
