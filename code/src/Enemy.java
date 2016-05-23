import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Object{
	
	public int life, speed;
	private Tile[][] map;

	public Enemy(Tile[][] map, Color c, int life, int speed) {
		this.map = map;
		setColor(c);
		this.life = life;
		this.speed = speed;
		setObjektSize(30);
		startPositon();
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, objektSize, objektSize);
	}
	
	public void update() {
		if(x >= 40 * 32 - objektSize){
			x = 0;
		}
		else {
			x = x + speed;
		}
	}
	
	public int getLife() {
		return life;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void startPositon() {
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				if (map[row][col].getTileType() == -1) {
					setX(row * 40); 
					setY(col * 40 + 4);
					System.out.println("ponter");
				} 
			}
		}
	}
}
