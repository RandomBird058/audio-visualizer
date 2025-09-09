import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;

/**
 * 
 * Handles backend for windows.
 * Knows the size of the screen and feeds it to the window view
 * Knows the controller and gets input from it
 * Knows the position of the window
 * Has a random number generator
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
        //Instantiate random number generator
        rand = new Random();

        //Instantiate controller for the window
        controller = new WindowController(this);

        //Create the dimension of the window and initialize the window to those dimensions
        windowSize = determineWindowSize(screenSize);

        //Start the window at a random point on the screen without going off the screen
        windowPosition = windowStartPosition(screenSize);

        //Instantiate the window
        window = new WindowView(windowSize, windowPosition);

        //Add listeners to the window
        window.addMouseListener(controller);
        window.addKeyListener(controller);
    }

    /**
     * Divides the dimensions of the screen by a random integer to determine the dimensions of the window
     * @param screenSize The dimensions of the screen
     * @return The dimensions of the window
     */
    private Dimension determineWindowSize(Dimension screenSize)
    {
        int windowWidth = screenSize.width / rand.nextInt(2, 4);
        int windowHeight = screenSize.height / rand.nextInt(2, 4);
        System.out.println("Width: " + windowWidth + " Height: " + windowHeight);
        return new Dimension(windowWidth, windowHeight);
    }

    /**
     * Calculates the starting point of the window by generating random values between 0 and the screen size - the window width
     * @param screenSize The size of the screen
     * @return The point that the screen will start at
     */
    private Point windowStartPosition(Dimension screenSize)
    {
        int x = rand.nextInt((int)(screenSize.getWidth() - windowSize.getWidth()));
        int y = rand.nextInt((int)(screenSize.getHeight() - windowSize.getHeight()));
        System.out.println("Window position: " + x + ", " + y);
        return new Point(x, y);
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

    //Terminates the program
    public void terminate()
    {
        System.exit(0);
    }

}