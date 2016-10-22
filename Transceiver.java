public class Transceiver {

	//public Airspace;

	private int id;
	private float listenFactor;
	private Coord location;
	private float sendFactor;

	public Transceiver(int id, float listenFactor, Coord location, float sendFactor) {
		this.id = id;
		this.listenFactor = listenFactor;
		this.location = location;
		this.sendFactor = sendFactor;
	}

	public int getID() {
		return this.id;
	}

	public Coord getLocation() {
		return this.location;
	}

	public float getListenFactor() {
		return this.listenFactor;
	}

	public float getSendFactor() {
		return this.sendFactor;
	}

	public void receive(Message mess) {
		
	}

	public Message send() {
		
	}
}