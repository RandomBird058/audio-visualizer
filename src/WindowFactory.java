import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 * Is a factory object for creating windows
 * Holds color constants
 */
public class WindowFactory {
    //Color constants
    protected static final Color BACKGROUND = Color.BLACK;

    //A list that holds all of the windows
    private ArrayList<WindowModel> windows;
    //The dimensions of the screen
    private static final Dimension SCREEN_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();
    
    /**
     * Intializes the windows ArrayList
     * Creates the first window
     */
    public WindowFactory()
    {
        windows = new ArrayList<>();
        windows.add(createWindow());
       
    }

    /**
     * Creates a new window
     * @return A new WindowModel
     */
    public WindowModel createWindow()
    {
        return new WindowModel(SCREEN_DIMENSIONS);
    }
}
