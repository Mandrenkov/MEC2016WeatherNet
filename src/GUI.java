import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// GUI for the application
public class GUI extends JPanel implements ActionListener {
    // Container to display messages
    public static JTextArea textArea = new JTextArea(5, 50);

    // Constructor
    public GUI() {
        // Establish the panel layout
        setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);
        
        setFocusable(true);

        // Refresh rendering at maximum 60 FPS
        new Timer(1000/60, this).start();
    }

    // Adds a message to the scroll text area
    public static void addMessage(Message message) {
        textArea.append(String.format("%15s : %3d + @%.1fMHz - %s\n", message.getTime(), message.getSenderID(), message.getFreq(), message.getContent()));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    // Displays the Boats and Buoys
    @Override
    public void paint(Graphics graphics) {
        super.paintComponent(graphics);
        
        Graphics2D g = (Graphics2D) graphics;
       
        // Enable anti-aliasing flags
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Iterate through the transceivers
        for (Transceiver t : AeroSpace.listeners) {
            g.setColor(Color.WHITE);
            
            if (t instanceof Boat) {
                g.setColor(Color.BLUE);
                g.fillOval((int) (2*t.getLocation().getX()), (int) (2*t.getLocation().getY()), 20, 20);    
                g.drawString(((Boat) t).getName(), (int) (2*t.getLocation().getX()) - 40, (int) (2*t.getLocation().getY()) + 15);
            } else {
                g.setColor(Color.GREEN);
                g.fillRect((int) (2*t.getLocation().getX()), (int) (2*t.getLocation().getY()), 20, 20);
                g.drawString(String.valueOf(t.id), (int) (2*t.getLocation().getX()) - 20, (int) (2*t.getLocation().getY()) + 15);
            }
        }
    }

    // Refreshes the screen when an action is performed
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}