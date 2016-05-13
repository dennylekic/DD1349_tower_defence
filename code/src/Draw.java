import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Draw extends JPanel{
	
	public Tile[] tile;
	
	public Draw() {
		tile = new Tile[10];
		tile[0] = new Tile(0, 0, Color.RED);
		tile[1] = new Tile(20,0,Color.BLUE);
	}
	
	
	public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        tile[0].draw(g);
	        tile[1].draw(g);
	        
	}

}
