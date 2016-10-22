public abstract class Transceiver {

	//public Airspace;

	protected int id;
	protected double listenFactor;
	protected Coord location;
	protected double sendFactor;
	protected double listenFreq;

	public Transceiver(int id, double listenFactor, Coord location, double sendFactor, double listenFreq) {
		this.id = id;
		this.listenFactor = listenFactor;
		this.location = location;
		this.sendFactor = sendFactor;
		this.listenFreq = listenFreq;
	}

	public int getID() {
		return this.id;
	}

	public Coord getLocation() {
		return this.location;
	}

	public double getListenFactor() {
		return this.listenFactor;
	}

	public double getListenFreq() {
		return this.listenFreq;
	}

	public double getSendFactor() {
		return this.sendFactor;
	}
	
	public abstract void receive(Message mess);

	public abstract Message send();
}