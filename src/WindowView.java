import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Windows will be where the game is displayed to the user
 */

public class WindowView extends JFrame {

    private JPanel background;

    /**
     * Changes properties of the frame to match vibe we're going for
     */
    public WindowView(Dimension windowSize, Point windowPosition) {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //Sets the size and position of the window based on information from the model
        setSize(windowSize);
        setLocation(windowPosition);
        setResizable(false);
        setUndecorated(true);
        
        build(windowSize);
        setVisible(true);
    }

    /**
     * Builds what is within the JFrame on creation
     * Builds a grid of equally-sized grid pieces.
     * @param windowSize The size of the window
     */
    private void build(Dimension windowSize)
    {
        //Set the layout of the frame to a grid with a set number of rows and columns
        int gridRows = (int)windowSize.getHeight() / 5;
        int gridCols = (int)windowSize.getWidth() / 5;
        System.out.println("Number of rows: " + gridRows + " Number of columns: " + gridCols);
        setLayout(new GridLayout(gridRows, gridCols));
    
        //Fill the background panel with grid pieces
        for(int i = 0; i < gridRows * gridCols; i++)
        {
            JPanel gridPiece = new JPanel();
            gridPiece.setBorder(BorderFactory.createLineBorder(WindowFactory.BACKGROUND));
            gridPiece.setSize(10, 10);
            add(gridPiece);
        }
    }
}