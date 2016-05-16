import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Object{
	
	public int life, speed;

	public Enemy(int x, int y, Color c, int life) {
		setX(x);
		setY(y);
		setColor(c);
		this.life = life;
		setObjektSize(30);
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, objektSize, objektSize);
	}
	
	public void update() {
		setX(getX() + 5);
	}
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
}
