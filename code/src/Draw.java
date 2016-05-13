import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Draw extends JPanel{
	
	public TileMap tileMap;
	
	public Draw() {

		tileMap = new TileMap("maps/tilemap.txt");
	}
	
	
	public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        tileMap.Draw(g);
	        g.setColor(Color.RED);
	        
	}

}
