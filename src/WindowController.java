import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.Timer;

/**
 * Handles user input for the game window
 */

public class WindowController implements MouseListener, ActionListener, KeyListener
{
    //Tells the program whether the mouse is within the frame
    private boolean inFrame;
    private WindowModel model;
    private Timer update;
    private Point mouseStartingPoint;

    /**
     * 
     */
    public WindowController(WindowModel model)
    {
        this.model = model;
        update = new Timer(1, this);
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(inFrame = true)
        {
            //Get the starting point of the mouse
            mouseStartingPoint = MouseInfo.getPointerInfo().getLocation();
            //Starts the timer that calls actionPerformed repeatedly
            update.start();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Stops the timer that calls actionPerformed repeatedly
        update.stop();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        inFrame = true;
        System.out.println("In frame");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        inFrame = false;
        System.out.println("Out frame");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update)
        {
            //Tell the model to move the window based on the different between the windo's starting and ending point
            model.moveWindow(mouseStartingPoint, MouseInfo.getPointerInfo().getLocation());
            //Update the mouse's starting point
            mouseStartingPoint = MouseInfo.getPointerInfo().getLocation();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //When escape key is pressed, tell model to terminate the program
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            System.out.println("Escape");
            model.terminate();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}