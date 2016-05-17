import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameControler extends JPanel implements Runnable{
	
	private TileMap tileMap;
	private Enemy enemy;
	
	
	
	//game loog
	private Thread thread;
	private boolean runGame = false;
	private int FPS = 50;
	private long targetTime = 1000 / FPS;
	
	
	public GameControler() {
		
		tileMap = new TileMap("maps/tilemap.txt");
		enemy = new Enemy(20, 100, Color.RED, 20, 5);
		
	}
	
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			runGame = true;
			thread = new Thread(this);
			thread.start();
		}
		
	}
	
	public void run() {
		long start, elapsed, wait;
		
		while(runGame) {
			start = System.nanoTime();
			
			update();
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			if (wait < 0) {
				wait = 5;
			}
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	public void update() {
		enemy.update();
	}
	
	public void paint(Graphics g) {
	        super.paint(g);
	        tileMap.draw(g);
	        enemy.draw(g);
	}
	
}
