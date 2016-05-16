import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Draw extends JPanel{
	
	public TileMap tileMap;
	public Enemy enemy;
	public boolean runGame = true;
	
	
	public Draw() {
		
		tileMap = new TileMap("maps/tilemap.txt");
		enemy = new Enemy(20, 100, Color.RED, 20);
		run();
	}
	
	public void run() {
		
	}
	
	public void update() {
		enemy.update();
	}
	
	public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        tileMap.draw(g);
	        enemy.draw(g);
	}

}
