import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;


public class Tile extends JComponent {

	private static final int WIDTH = 20, HEIGHT = 20;
	private static int x,y;
	 public Tile(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        
    }
		
	 public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
