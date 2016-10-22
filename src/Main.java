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
            AS.addTransceiver(new Boat(i, 1.0, new Coord(r.nextInt(AERO_SIZE), r.nextInt(AERO_SIZE)), 1.0, 500.0));
        }

        for (int i = 0 ; i < 10 ; i++) {
            
            AS.addTransceiver(new Boat(i+10, 1.0, new Coord(r.nextInt(AERO_SIZE), r.nextInt(AERO_SIZE)),
                    "boat"+Integer.toString(i+10), 1.0, 500.0));
        }
        AS.run();
	}
}