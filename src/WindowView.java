import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

/**
 * Windows will be where the game is displayed to the user
 */

public class WindowView extends JFrame {

    /**
     * Changes properties of the frame to match vibe we're going for
     */
    public WindowView(Dimension windowSize, Point windowPosition) {
        //TODO: Change to DO_NOTHING_ON_CLOSE and set a key to close the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Sets the size and position of the window based on information from the model
        setSize(windowSize);
        setLocation(windowPosition);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
    }

}