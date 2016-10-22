public class Boat extends Transceiver {

	private String name;

	public Boat(int id, float listenFactor, Coord location, String name, float sendFactor) {
		super(id, listenFactor, location, sendFactor);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}