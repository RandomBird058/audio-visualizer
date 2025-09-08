import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;

/**
 * 
 * Handles backend for windows.
 * Knows the size of the screen and feeds it to the window
 */

public class WindowModel
{
    private Random rand;
    private WindowController controller;
    private Dimension windowSize;
    private WindowView window;
    private Point windowPosition;

    /**
     * Declares the controller and the window
     * @param screenSize
     */
    public WindowModel(Dimension screenSize)
    {
        //TODO: Start the window at a random point on the screen
        windowPosition = new Point(0, 0);

        //Instantiate random number generator
        rand = new Random();

        //Instantiate controller for the window
        controller = new WindowController(this);

        //Create the dimension of the window and initialize the window to those dimensions
        windowSize = determineWindowSize(screenSize);
        window = new WindowView(windowSize, windowPosition);

        //Add action listeners to the window
        window.addMouseListener(controller);
    }

    /**
     * Divides the dimensions of the screen by a random integer to determine the dimensions of the window
     * @param screenSize The dimensions of the screen
     * @return The dimensions of the window
     */
    private Dimension determineWindowSize(Dimension screenSize)
    {
        int windowWidth = screenSize.width / rand.nextInt(2, 5);
        int windowHeight = screenSize.height / rand.nextInt(2, 5);
        System.out.println("Width: " + windowWidth + " Height: " + windowHeight);
        return new Dimension(windowWidth, windowHeight);
    }

    /**
     * Moves the window depending on the difference between the start and end positions of the mouse between a time period
     * @param mouseStartingPoint The starting position of the mouse
     * @param mouseEndingPoint The ending position of the mouse
     */
    public void moveWindow(Point mouseStartingPoint, Point mouseEndingPoint)
    {
        //Find the difference between the starting and ending point of the mouse
        double differenceX = mouseStartingPoint.getX() - mouseEndingPoint.getX();
        double differenceY = mouseStartingPoint.getY() - mouseEndingPoint.getY();

        //Add this difference to the window's position point
        windowPosition.setLocation(windowPosition.getX() - differenceX, windowPosition.getY() - differenceY);

        //Changes the visible location of the window to the new point
        window.setLocation(windowPosition);
    }

}