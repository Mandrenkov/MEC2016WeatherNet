

public class Coord {
	
	double x;
	double y;

	static final double mltplr = 188;
	static final double stddev = 0.3;

	public Coord(){
		this.x = 0;
		this.y = 0;
	}

	public Coord(double x, double y){
		this.x = x;
		this.y = y;
	}

	public static double noise(Transceiver recv, Message m, double listenFrequency){
		final double maxDist = 35;
		double integrity = 1.1;
		double distance = recv.getLocation().distanceTo(m.getLocation());
		System.out.println("distance: " + distance);
		if (distance > maxDist) {
			integrity *= 1-((distance - maxDist) / maxDist);
		}
		return integrity;/*

		double dist = getDist(m.getLocation(), recv.getLocation());

		double sd = (mltplr / (dist * Math.sqrt(2 * stddev*stddev * Math.PI)));
		sd *= Math.exp((-1)*( Math.pow(m.getFreq() - listenFrequency, 2) )/( 2 * stddev*stddev ));
		sd *= m.getStrength() * recv.getListenFactor();

		return sd;*/
	}

	public double distanceTo(Coord other) {
		return getDist(this, other);
	}

	private static double getDist(Coord a, Coord b){
		return Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
}