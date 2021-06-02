/**
 * ---------------- Java 2D Graphics ---------------- 
 * Java 2D Movement
 * Developed with Eclipse IDE
 * @author DannyWarp
 * 
 */ 

package wxrp.movement2d;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

public class Core extends JComponent {

	private static final long serialVersionUID = 1L;

	static boolean move_forward, move_backward, rotate_left, rotate_right;
	double rotation, rotation_speed = 1, position_x, position_y, speed = 1.5;
	Image tank;

		public Core() {
			
			tank = loadBody(); // Load image
			
			Timer timer = new Timer(10, new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
				// This functions change the rotation value.
					if (rotate_left) {
						rotation -= rotation_speed;
					}
					
					if (rotate_right) {
						rotation += rotation_speed;
					}
					
					// This functions performs rotated direction.
						if (move_forward) {
							position_y += -Math.cos(Math.toRadians(rotation)) * speed;
							position_x += Math.sin(Math.toRadians(rotation)) * speed;
						}
						
						if (move_backward) {
							position_y -= -Math.cos(Math.toRadians(rotation)) * speed;
							position_x -= Math.sin(Math.toRadians(rotation)) * speed;
						}

					repaint();
				}
			});
			timer.start();

		}
		
	public Image loadBody() {
		return getToolkit().getImage("res/tank.png");
		// This line gets a system image (only if this JAR build).
		//return getToolkit().getImage(ClassLoader.getSystemResource("tank.png"));
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		var transform = g2d.getTransform();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// The line below improves image quality.
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.translate(position_x, position_y);
		g2d.rotate(Math.toRadians(rotation), 48.5, 65);		// Rotates the image around its center.
		g2d.drawImage(tank, transform, this);				// Draws an image.
		g2d.dispose();
		Toolkit.getDefaultToolkit().sync();
	}

}

/*
 * 
 * 
 * 
 * 
 * 
 */