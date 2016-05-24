/**
 * colle and control all lin game.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameControler extends JPanel implements Runnable{
	
	private TileMap tileMap;
	private ArrayList<Enemy> enemy;
	private Player player;
	private puseBottun puseBottun;
	
	//game loop
	private Thread thread;
	private boolean runGame = false, gameOver = false;
	private int FPS = 5;
	private long targetTime = 1000 / FPS;
	
	public GameControler() {
		
		init();
		sponEnemy();
		
	}
	
	public void init() {
		tileMap = new TileMap("maps/tilemap.txt");
		enemy = new ArrayList<Enemy>();
		player = new Player();
		puseBottun = new puseBottun();
	}
	
	/**
	 * Game run loop
	 */
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			runGame = true;
			thread = new Thread(this);
			thread.start();
		}
		
	}
	
	public void run() {
		long start, elapsed, wait, timerNewEnemy;
		
		timerNewEnemy = 0;
		
		while(runGame) {
			start = System.nanoTime();
			
			if (puseBottun.getPuse() == false) {
				update();
			}
			
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			timerNewEnemy++;
			
			if (wait < 0) {
				wait = 5;
			}
			if (player.getLife() <= 0) {
				runGame = false;
				gameOver = true;
			}
			if (timerNewEnemy == 10) {
				sponEnemy();
				timerNewEnemy = 0;
			}
			
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sponEnemy() {
		enemy.add(new Enemy(tileMap.getTileMap(), new Color(120, 13, 34), 20, 1));
	}
	
	public void update() {
		for (int i = 0; i < enemy.size(); i++) {
			if(enemy.get(i).update() == 1) {
				enemy.remove(i);
				player.takeDamage(50);
			}
		}
	}
	
	public void paint(Graphics g) {
	        super.paint(g);
	        Graphics2D g2 = (Graphics2D) g;
	        tileMap.draw(g2);
	        player.draw(g2);
	        puseBottun.draw(g2);
	        for (int i = 0; i < enemy.size(); i++) {
				enemy.get(i).draw(g2);
			}
	        if (gameOver) {
				player.gameOver(g2);
			}
	        
	}
	
}
