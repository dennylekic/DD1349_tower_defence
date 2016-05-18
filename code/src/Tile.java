import java.awt.Color;
import java.awt.Graphics;

public class Tile extends Object{

	
	public Tile(int x, int y , Color c) {
        setX(x);
        setY(y);
        setColor(c);
        setObjektSize(40); 
    }
	 
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, objektSize, objektSize);
	}
}
