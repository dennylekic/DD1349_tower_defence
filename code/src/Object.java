/**
 * Blueprints for all objects.  
 */
import java.awt.Color;

public class Object {
	
	protected int objektSize, x, y, width, height;
	protected Color c;
	
	//get methods
	
	public int getObjektSize() {
		return objektSize;
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
	
	//set methods
	
	public void setObjektSize(int objektSize) {
		this.objektSize = objektSize;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	public void setColor(Color c) {
		this.c = c;
	}
}
