import java.util.ArrayList;

public class Boat extends Transceiver {
	protected static final double[] frequencyBounds = {150.0d, 250.0d};

	private String name;
	private double sendFrequency;

	public Boat(int id, double listenFactor, Coord location, String name, double sendFactor, double sendFrequency) {
		super(id, listenFactor, location, sendFactor, sendFrequency);
		this.name = name;
	}

	public double[] getFrequencyBounds() {
		return Boat.frequencyBounds;
	}

	public String getName() {
		return this.name;
	}

	public void receiveMessage(Message message) {
		System.out.println("boat " + this.getID() + " received " + message.getContent());
    }

    public ArrayList<Message> sendMessages() {
		ArrayList<Message> messages = new ArrayList<Message>();

		messages.add(new Message((int) System.currentTimeMillis(), this.location,
				this.id, "hello world", Message.CHATTER, 1.0, 1.0));
		return messages;
	}
}