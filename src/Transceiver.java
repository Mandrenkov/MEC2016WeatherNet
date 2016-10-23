import java.util.ArrayList;
import java.util.Random;

/* Boat and Buoy Parent Class */
public abstract class Transceiver {

	// Frequency of SOS distress signal
	protected static final double SOS_FREQUENCY = 500.0;

	// ID of transceiver
	protected int id;

	// Listen strength multiplier
	protected double listenFactor;
	
	// Location of transceiver
	protected Coord location;

	// Send strength multiplier
	protected double sendFactor;

	// Send frequency
	protected double sendFrequency;

	// Random object
	protected Random rand = new Random();

	// Constructor
	public Transceiver(int id, double listenFactor, Coord location, double sendFactor, double sendFrequency) {
		this.id = id;
		this.listenFactor = listenFactor;
		this.location = location;
		this.sendFactor = sendFactor;
		this.sendFrequency = sendFrequency;
	}

	// Returns the ID
	public int getID() {
		return this.id;
	}

	// Returns the location
	public Coord getLocation() {
		return this.location;
	}

	// Returns the listen factor
	public double getListenFactor() {
		return this.listenFactor;
	}

	// Returns the send frequency
	public double getSendFrequency() {
		return this.sendFrequency;
	}

	// Returns the send factor
	public double getSendFactor() {
		return this.sendFactor;
	}

	// Returns the frequency of the SOS distress signal
	public double getSOSFrequency() {
		return Transceiver.SOS_FREQUENCY;
	}

	// Moves the transceiver to a new location
	public void move(double deltaX, double deltaY) {
		location = new Coord(location.getX() + deltaX, location.getY() + deltaY);
	}
	
	// Procedure for receiving a message
	public abstract void receiveMessage(Message message);

	// Procedure for sending a message
	public abstract ArrayList<Message> sendMessages();
}