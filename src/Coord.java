

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

	public double noise(Transceiver recv, Message m){

		double dist = getDist(m.getLocation(), recv.getLocation());

		double sd = (c / (dist * Math.sqrt(2 * Math.pow(stddev, 2) * Math.PI)));
		sd *= Math.exp((-1)*( Math.pow(m.getFreq() - recv.getListenFreq(), 2) )/( 2 * Math.pow(stddev, 2) ));
		return sd;
	}

	private double getDist(Coord a, Coord b){
		return Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));
	}
}