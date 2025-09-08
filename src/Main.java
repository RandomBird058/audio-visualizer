import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Dominic Ricci
 * 9/7/25
 * 
 * Gets the size of the screen to feed to models
 * Executes the program.
 */

public class Main {
    private static Dimension SCREEN_DIMENSIONS;
    public static void main(String[] args) {

        //Get the dimensions of the screen the application is opened in
        SCREEN_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();
        
        //Create a window model
        new WindowModel(SCREEN_DIMENSIONS);
        
    }
}