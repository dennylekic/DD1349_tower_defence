import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Draw extends JPanel{
	
	public TileMap tileMap;
	public Enemy enemy;
	
	public Draw() {

		tileMap = new TileMap("maps/tilemap.txt");
		enemy = new Enemy(20, 100, Color.RED);
	}
	
	
	public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        tileMap.Draw(g);
	        enemy.Draw(g);
	}

}
