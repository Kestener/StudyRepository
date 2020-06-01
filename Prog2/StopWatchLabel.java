import java.awt.event.*;
import javax.swing.*;

/**
 * A custom component that acts as a simple stop-watch.  When the user clicks
 * on it, this component starts timing.  When the user clicks again,
 * it displays the time between the two clicks.  Clicking a third time
 * starts another timer, etc.  While it is timing, the label now displays
 * the number of seconds (int) since it was started. The option was to use
 * an ActionListener for that.
 */
public class StopWatchLabel extends JLabel implements MouseListener, ActionListener {

   private long startTime;   // Start time of watch.
                             //   (Time is measured in milliseconds.)

   private boolean running;  // True when the watch is running.
   
   private Timer showTime; // Responsible to generate events to repaint the component
   						  // and give the idea of time being computed while the stop watch
   						  // is running.

   /**
    * Constructor sets initial text on the label to
    * "Click to start timer." and sets up a mouse listener
    * so the label can respond to clicks.
    */
   public StopWatchLabel() {
      super("  Click to start timer.  ", JLabel.CENTER);
      addMouseListener(this);
   }
   
   
   /**
    * Tells whether the watch is currently running.
    */
   public boolean isRunning() {
      return running;
   }
   
   public void actionPerformed(ActionEvent evt) {
	   long time = (System.currentTimeMillis() - startTime) / 1000;
	   // Display the amount of time in seconds in the label.
	   setText("Counting: "+ time + " seconds");
   }

   
   /**
    * React when the user presses the mouse by starting
    * or stopping the watch and changing the text that
    * is shown on the label.
    */
   public void mousePressed(MouseEvent evt) {
      if (running == false) {
            // Record the time and start the watch.
         running = true;
         startTime = evt.getWhen();  // Time when mouse was clicked.
         // Removed setText("Timing...."); to replace for the conditional to show the watch time.
         setText("Counting: waiting");
         if (showTime == null) {
        	 	showTime = new Timer(100, this); // Start the Timer object with the click.
        	 	showTime.start();
         }
         else
        	 	showTime.restart();
      }
      else {
            // Stop the watch.  Compute the elapsed time since the
            // watch was started and display it.
    	  	 showTime.stop(); // Implemented to show the time in the watch and stop it.
         running = false;
         long endTime = evt.getWhen();
         double seconds = (endTime - startTime) / 1000.0;
         setText("Time: " + seconds + " sec.");
      }
   }

   public void mouseReleased(MouseEvent evt) { }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseEntered(MouseEvent evt) { }
   public void mouseExited(MouseEvent evt) { }

}
