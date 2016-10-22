import java.util.Random;

public class Main {
	private static final int AERO_SIZE = 500;
    private static final int BOATS = 10;
    private static final int BUOYS = 15;

    private static Random r = new Random(); 

	public static void main(String[] args) {
		System.out.println("Commencing WeatherNet!");

		AeroSpace AS = new AeroSpace(AERO_SIZE, AERO_SIZE);

        for (int i = 0 ; i < BOATS ; i++) {
            double[] boatRange = Boat.getFrequencyBounds();
            double sendFrequency = boatRange[0] + Math.random()*boatRange[1];

            AS.addTransceiver(new Boat(i, 1.0, new Coord(r.nextInt(AERO_SIZE), r.nextInt(AERO_SIZE)), 
                "SS " + (65 + r.nextInt(26)) + "" + i, 1.0, sendFrequency));
        }

        for (int i = 0 ; i < BUOYS ; i++) {
            double[] buoyRange = Buoy.getFrequencyBounds();
            double sendFrequency = buoyRange[0] + Math.random()*buoyRange[1];

            AS.addTransceiver(new Buoy(BOATS + i, 1.0, new Coord(r.nextInt(AERO_SIZE), r.nextInt(AERO_SIZE)), 1.0, sendFrequency));
        }

        AS.run();
	}
}