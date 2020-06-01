  /*
  * A trivial applet that tests the StopWatchTimer component.
  * The applet just creates and shows a StopWatchTimer.
  * The original applet was giving a warning. Updated to JApplet from
  * javax.swing package.
  * */
    
import java.awt.*;
import javax.swing.*;
    
public class TestStopWatchRunner extends JApplet { // Changed from Applet to JApplet from Swing package.
	public void init() {
          
          StopWatchLabel watch = new StopWatchLabel(); // Changed the type from Runner to Label
          watch.setFont( new Font("SansSerif", Font.BOLD, 24) );
          watch.setBackground(Color.white);
          watch.setForeground( new Color(180,0,0) );
          setBackground(Color.white);
          setLayout(new BorderLayout() );
          add(watch, BorderLayout.CENTER);
          
       }
    
    }
