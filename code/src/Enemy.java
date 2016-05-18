import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Object{
	
	public int life, speed;

	public Enemy(int x, int y, Color c, int life, int speed) {
		setX(x);
		setY(y);
		setColor(c);
		this.life = life;
		this.speed = speed;
		setObjektSize(30);
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
}
