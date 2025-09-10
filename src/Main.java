/**
 * Dominic Ricci
 * 9/7/25
 * 
 * Executes the program.
 */

public class Main {
    public static void main(String[] args) {
        WindowFactory factory = new WindowFactory();
        factory.createWindow();
        factory.createWindow();
    }
}

/**
 * Look up SwingWorker
 * 
 * Whether to run every window on a separate thread for your Java snake game, where the snake moves between windows, is not generally recommended and can lead to significant complications.

Recommended Approach: Single Event-Dispatching Thread (EDT)
In Java Swing (and similarly, JavaFX), the preferred and standard approach is to handle all UI operations—creating, modifying, and interacting with GUI components—on a single dedicated thread called the Event-Dispatching Thread (EDT).

GUI Libraries are Not Thread-Safe: Swing and AWT components are generally not thread-safe. If multiple threads try to modify the same GUI components simultaneously (which would happen if each window runs on a different thread), you can encounter unpredictable behavior, race conditions, deadlocks, and graphical glitches.

Sequential Event Processing: The EDT ensures that all user interactions (mouse clicks, key presses) and updates (repainting) are processed in a sequential, orderly manner, preventing drawing corruption.

How to Manage Multiple Windows in a Single-Threaded GUI
To manage your multiple-window snake game correctly, you should keep all window-related operations on the EDT and use separate threads only for specific, non-UI tasks:

Main Window Management: Your game can use a single JFrame or a few coordinated JFrames/JDialogs. The creation, showing, hiding, and disposal of these windows must happen on the EDT.

Game Logic Thread: The game loop—which handles the snake's movement, collision detection, and window transition logic—should ideally run on a separate non-EDT thread. This is crucial so that the game logic doesn't freeze the user interface (the EDT).

This thread will calculate the new positions and states.

When the game logic needs to update the display (e.g., draw the snake in the new position, or switch windows), it must use SwingUtilities.invokeLater() or SwingUtilities.invokeAndWait() to push the drawing/UI update task back onto the EDT.

Window Transition: When the snake moves off one window, your Game Logic Thread should:

Calculate the details for the next window (e.g., its position and the snake's entry point).

Use SwingUtilities.invokeLater() to command the EDT to hide the current window and display the next one with the updated game state.

Conclusion ⚠️
Using a separate thread for every window would be an over-complication that goes against the established best practices for Java GUI development and would likely introduce more bugs than it solves. Stick to the standard model: EDT for all UI tasks, and a separate thread for the game loop/logic.
 */