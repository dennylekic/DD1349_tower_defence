import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Object{

	public Enemy(int x, int y, Color c) {
		setX(x);
		setY(y);
		setColor(c);
		setObjektSize(30);
	}
	
	public void Draw(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, objektSize, objektSize);
	}
	
	public void Update() {
		setX(getX() + 5);
	}
	
}
