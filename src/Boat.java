public class Boat extends Transceiver {

	private String name;

	public Boat(int id, double listenFactor, Coord location, String name, double sendFactor) {
		super(id, listenFactor, location, sendFactor, 1);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Message receiveMessage(Message message) {

    }

    public void sendMessages() {
		Message m = new Message((int) System.currentTimeMillis(), this.location,
				this.id, "hello world", Message.CHATTER, 1.0, 1.0);
	}
}