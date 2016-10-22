import java.util.ArrayList;
import java.util.Random;

public abstract class Transceiver {

	protected static final double SOS_FREQUENCY = 500.0;

	protected int id;
	protected double listenFactor;
	protected Coord location;
	protected double sendFactor;
	protected double sendFrequency;
	protected Random rand = new Random();


	public Transceiver(int id, double listenFactor, Coord location, double sendFactor, double sendFrequency) {
		this.id = id;
		this.listenFactor = listenFactor;
		this.location = location;
		this.sendFactor = sendFactor;
		this.sendFrequency = sendFrequency;
	}

	public abstract double[] getFrequencyBounds();

	public int getID() {
		return this.id;
	}

	public Coord getLocation() {
		return this.location;
	}

	public double getListenFactor() {
		return this.listenFactor;
	}

	public double getSendFrequency() {
		return this.sendFrequency;
	}

	public double getSendFactor() {
		return this.sendFactor;
	}

	public double getSOSFrequency() {
		return Transceiver.SOS_FREQUENCY;
	}
	
	public abstract void receiveMessage(Message message);

	public abstract ArrayList<Message> sendMessages();
}