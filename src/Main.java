import java.util.Random;

import java.awt.*;
import javax.swing.*;

public class Main {
    public static AeroSpace AS;

	private static final int AERO_SIZE = 300;
    private static final int BOATS = 10;
    private static final int BUOYS = 15;

    private static Random r = new Random(); 

    public static void run(AeroSpace AS) {
        Main.AS = AS;

        JFrame window = new JFrame("RogueQD Monitor");

        // Specify the size and behaviour of window
        window.setSize(AERO_SIZE*2, AERO_SIZE*2 + 200);
        window.setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);       
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Thread() {
            public void run() {
                window.add(new GUI(), BorderLayout.CENTER);
                window.add(new JScrollPane(GUI.textArea), BorderLayout.SOUTH);
                window.setVisible(true);
            }
        }.start();

        AS.run();
    }

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
}