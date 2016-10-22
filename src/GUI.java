import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JPanel implements ActionListener {

    private static JTextArea textArea = new JTextArea(10, 50);

    public GUI() {
        // Establish the panel layout
        setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        
        setFocusable(true);

        add(new JScrollPane(textArea), BorderLayout.SOUTH);

        // Refresh rendering at maximum 60FPS
        new Timer(1000, this).start();
    }

    public static void addMessage(Message message) {
        textArea.append(message.getContent() + "\n");
    }

    /*
    @Override
    public void paint(Graphics graphics) {
        super.paintComponent(graphics);
        
        Graphics2D g = (Graphics2D) graphics;
       
        // Enable anti-aliasing flags
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}