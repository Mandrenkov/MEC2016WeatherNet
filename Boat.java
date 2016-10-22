public class Boat extends Transceiver {

	private String name;

	public Boat(int id, double listenFactor, Coord location, double sendFactor, double listenFreq, double sendFreq, String name) {
		super(id, listenFactor, location, sendFactor, listenFreq, sendFreq);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Message send() {
		return new Message((int) System.currentTimeMillis(), this.location, this.id, "hello world", Message.CHATTER, this.getSendFreq());
	}

	public void receive(Message message) {

    }
}