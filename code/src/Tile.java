import java.awt.Color;
import java.awt.Graphics;

public class Tile {

	private int tileSize = 20, x, y;
	private Color c;
	 public Tile(int x, int y , Color c) {
        this.x = x;
        this.y = y;
        this.c = c; 
    }
	 
	public int getTileSize() {
		return tileSize;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Color getColor() {
		return c;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, tileSize, tileSize);
	}
	
	

}
