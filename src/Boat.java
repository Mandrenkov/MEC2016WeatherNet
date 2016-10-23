import java.util.ArrayList;

/* Boat Entity Module */
public class Boat extends Transceiver {
	// Send frequency bounds
	protected static final double[] frequencyBounds = {150.0d, 250.0d};

	// Name of boat
	private String name;

	// Boat's send frequency
	private double sendFrequency;

	// Message type chances
	private static double chatterChance = .01, fireChance = .01;

	// Boat constructor
	public Boat(int id, double listenFactor, Coord location, String name, double sendFactor, double sendFrequency) {
		super(id, listenFactor, location, sendFactor, sendFrequency);
		this.name = name;
	}

	// Returns the frequency bounds of Boats
	public static double[] getFrequencyBounds() {
		return Boat.frequencyBounds;
	}

	// Returns the name of the boat
	public String getName() {
		return this.name;
	}

	// Receive a message
	public void receiveMessage(Message mess) {
		System.out.println("Boat \"" + this.getName() + "\" received \"" + mess.getContent() + "\"");
    }

    // Returns an ArrayList of messages to send
    public ArrayList<Message> sendMessages() {
		ArrayList<Message> list = new ArrayList<Message>();

		if (Math.random() < this.chatterChance) {
			list.add(new Message((long) System.currentTimeMillis(), this.location,
					this.id, "Hi stranger!  How fair yee?  From the " + this.name, Message.MsgType.CHATTER, this.sendFrequency, 1.0));
		}
		if (Math.random() < this.chatterChance) {
			list.add((new Message((long) System.currentTimeMillis(), this.location,
					this.id, "Uh oh!  whoops.lightOnFire() on the " + this.name, Message.MsgType.SOS, this.sendFrequency, 1.0)));
		}
		return list;
	}

	// Sets the chance of fire occurring
    public void setFireChance(double fireChance) {
        this.fireChance = fireChance;
    }

    // Sets the chance of fire occurring
    public void setChatterChance(double chatterChance) {
        this.chatterChance = chatterChance;
    }
}