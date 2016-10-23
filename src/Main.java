import java.util.Random;

import java.awt.*;
import javax.swing.*;

/* Main Execution Module */
public class Main {
    // Aerospace reference
    public static AeroSpace AS;

    // Size of aerospace
	private static final int AERO_SIZE = 300, TEST_AERO_SIZE = 25;
    
    // Number of boats to simulate
    private static final int BOATS = 10;

    // Number of buoys to simulate
    private static final int BUOYS = 15;

    // Random object reference
    private static Random r = new Random(); 

    // Runs the simulation given the provided aerospace
    public static void run(AeroSpace AS) {
        Main.AS = AS;

        // Instantiate the window
        JFrame window = new JFrame("RogueQD Monitor");

        // Specify the size and behaviour of window
        window.setSize(AERO_SIZE*2, AERO_SIZE*2 + 200);
        window.setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);       
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Start the GUI
        new Thread() {
            public void run() {
                window.add(new GUI(), BorderLayout.CENTER);
                window.add(new JScrollPane(GUI.textArea), BorderLayout.SOUTH);
                window.setVisible(true);
            }
        }.start();

        // Run the simulation
        AS.run();
    }

    // Main thread entry point
	public static void main(String[] args) {
		System.out.println("Commencing WeatherNet!");

		AeroSpace AS = new AeroSpace(AERO_SIZE, AERO_SIZE);

        for (int i = 0 ; i < BOATS ; i++) {
            double[] boatRange = Boat.getFrequencyBounds();
            double sendFrequency = boatRange[0] + Math.random()*boatRange[1];

            AS.addTransceiver(new Boat(i, 1.0, new Coord(r.nextInt(AERO_SIZE), r.nextInt(AERO_SIZE)), 
                "SS " + (char) (65 + r.nextInt(26)) + "" + i, 1.0, sendFrequency));
        }

        for (int i = 0 ; i < BUOYS ; i++) {
            double[] buoyRange = Buoy.getFrequencyBounds();
            double sendFrequency = buoyRange[0] + Math.random()*buoyRange[1];

            AS.addTransceiver(new Buoy(BOATS + i, 1.0, new Coord(r.nextInt(AERO_SIZE), r.nextInt(AERO_SIZE)), 1.0, sendFrequency));
        }

        run(AS);
	}

    /*
    AeroSpace setUpMessages() {
        AS = new AeroSpace(TEST_AERO_SIZE, TEST_AERO_SIZE);
        double[] buoyRange = Buoy.getFrequencyBounds();
        double sendFrequency = buoyRange[0] + Math.random()*buoyRange[1];
        Buoy buoy = new Buoy(BOATS + 0, 1.0, new Coord(r.nextInt(TEST_AERO_SIZE), r.nextInt(TEST_AERO_SIZE)),
                1.0, sendFrequency);
        buoy.setWeatherChance(.75);
        AS.addTransceiver(buoy);
        double[] boatRange = Boat.getFrequencyBounds();
        sendFrequency = boatRange[0] + Math.random()*boatRange[1];
        Boat boat = new Boat(0, 1.0, new Coord(r.nextInt(TEST_AERO_SIZE), r.nextInt(TEST_AERO_SIZE)),
                "SS " + (65 + r.nextInt(26)), .5, sendFrequency);
        boat.setFireChance(.75);
        boat.setChatterChance(.75);
        AS.addTransceiver(boat);
        return AS;
    }*/
}