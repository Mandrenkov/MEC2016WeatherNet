public class Buoy extends Transceiver {

    private static final double listenFactor = 1.0, sendFactor = 1.0, listenFreq = 500.0, sendFreq = 200.0;

    public Buoy(int id, Coord location) {
        super(id, listenFactor, location, sendFactor, listenFreq, sendFreq);
    }

    public Message receiveMessage(Message message) {
        //System.out.println("buoy " + this.getID() + " received " + mess.getContent());
    }

    public void sendMessages() {
        Message m =  new Message((int) System.currentTimeMillis(), this.location,
                this.id, "hello world", Message.CHATTER, 1.0, 1.0);
    }
}
