import java.util.ArrayList;

public class Buoy extends Transceiver {

    public Buoy(int id, double listenFactor, Coord location, double sendFactor, double sendFrequency) {
        super(id, listenFactor, location, sendFactor, sendFrequency);
    }

    public void receiveMessage(Message message) {
        System.out.println("buoy " + this.getID() + " received " + message.getContent());
    }

    public ArrayList<Message> sendMessages() {
        Message m =  new Message((int) System.currentTimeMillis(), this.location,
                this.id, "hello world", Message.CHATTER, 1.0, 1.0);
    }
}
