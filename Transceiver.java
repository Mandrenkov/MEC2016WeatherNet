public abstract class Transceiver {

	//public Airspace;

	protected int id;
	protected float listenFactor;
	protected Coord location;
	protected float sendFactor;

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

	public abstract void receive(Message mess);

	public abstract Message send();
}