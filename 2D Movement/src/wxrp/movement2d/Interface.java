/**
 * ---------------- Java 2D Graphics ----------------
 * Java 2D Movement
 * ______________________________________________________________________
 * 
 * This type of movement is sometimes called "Asteroids-style" because it 
 * resembles how that classic arcade game worked. 
 * Pressing left/right (A/D) rotates the character, while up/down (W/S) moves it 
 * forward or backward in whatever direction it's facing.
 * --------------------------------------------------
 * Developed with Eclipse IDE
 * @author DannyWarp
 * 
 */ 

package wxrp.movement2d;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;

	public Interface() {
		
		setSize(1200, 670);
			setLocationRelativeTo(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
					setLayout(new BorderLayout());
						setTitle("2D Movement");
		// This line gets a system image.
		Image icon = getToolkit().getImage(ClassLoader.getSystemResource("jar_low.png"));
			setIconImage(icon);		// Set the program icon. 
				add(new Core());		
					setVisible(true);
					
				// Add a key listener method 
					addKeyListener(new KeyAdapter() {
					// The method works only if key is pressed.
						public void keyPressed(KeyEvent e) {
							// If press a certain button:
							if (e.getKeyCode() == KeyEvent.VK_A) {
								Core.rotate_left = true;
							}
							
							if (e.getKeyCode() == KeyEvent.VK_D) {
								Core.rotate_right = true;
							}
							
							if (e.getKeyCode() == KeyEvent.VK_W) {
								Core.move_forward = true;
							}
							
							if (e.getKeyCode() == KeyEvent.VK_S) {
								Core.move_backward = true;
							}
						}
						
					// The method works only if key is released.
						public void keyReleased(KeyEvent e) {
							// If release a certain button:
							if (e.getKeyCode() == KeyEvent.VK_A) {
								Core.rotate_left = false;
							}
							
							if (e.getKeyCode() == KeyEvent.VK_D) {
								Core.rotate_right = false;
							}
							
							if (e.getKeyCode() == KeyEvent.VK_W) {
								Core.move_forward = false;
							}
							
							if (e.getKeyCode() == KeyEvent.VK_S) {
								Core.move_backward = false;
							}
						}
					});
	}
	
	public static void main(String[] args) {
		new Interface();
	}

}