import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Draw extends JPanel{
	
	public TileMap tileMap;
	
	public Draw() {

		tileMap = new TileMap("maps/tilemap.txt");
		//tile = new Tile[10];
		//tile[0] = new Tile(0, 0, Color.RED);
		//tile[1] = new Tile(20,0,Color.BLUE);
	}
	
	
	public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        tileMap.Draw(g);
	        
	}

}
