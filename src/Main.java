import java.util.Random;

public class Main {
	private static final int aeroSize = 500;
	public static void main(String[] args){

		System.out.println("MEC 2016");
		AeroSpace AS = new AeroSpace(aeroSize, aeroSize);
        Random r = new Random();
        for (int i=0; i < 10; i++) {
            AS.addTransceiver(new Buoy(i, 1.0, new Coord(r.nextInt(aeroSize), r.nextInt(aeroSize)), 1.0, 500.0));
            AS.addTransceiver(new Boat(i+10, 1.0, new Coord(r.nextInt(aeroSize), r.nextInt(aeroSize)),
                    "boat"+Integer.toString(i+10), 1.0, 500.0));
        }
        AS.run();
	}
}