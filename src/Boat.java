import java.util.ArrayList;

public class Boat extends Transceiver {
	protected static final double[] frequencyBounds = {150.0d, 250.0d};

	private String name;
	private double sendFrequency;
	private final double chatterChance = .01;

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

	public void receiveMessage(Message mess) {
		System.out.println("boat " + this.getID() + " received " + mess.getContent());
    }

    public ArrayList<Message> sendMessages() {
		ArrayList<Message> list = new ArrayList<Message>();
		if (Math.random() < this.chatterChance) {
			list.add(new Message((int) System.currentTimeMillis(), this.location,
					this.id, "hello world", Message.CHATTER, 1.0, 1.0));
		}
		return list;
	}
}