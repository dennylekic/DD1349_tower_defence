import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Object{
	
	public int life, speed, rowPointer, colPointer, rowOld, colOld;
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
	
	private void printStuf() {
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				System.out.print(map[row][col].getTileType() + " ");
			}
			System.out.println();
		}
	}
	
	public int update() {
		
		if (map[rowPointer][colPointer+1].getTileType()==1 && colOld != colPointer+1) {
			colOld = colPointer;
			rowOld = -2;
			colPointer ++;
		}
		else if (map[rowPointer-1][colPointer].getTileType()==1 && rowOld != rowPointer-1) {
			rowOld = rowPointer;
			colOld = -2;
			rowPointer --;
		}
		else if (map[rowPointer+1][colPointer].getTileType()==1 && rowOld != rowPointer+1) {
			rowOld = rowPointer;
			colOld = -2;
			rowPointer ++;
		}
		else if (map[rowPointer][colPointer-1].getTileType()==1 && colOld != colPointer-1) {
			colOld = colPointer;
			rowOld = -2;
			colPointer --;
		}
		
		x = map[rowPointer][colPointer].getX() +4; 
		y = map[rowPointer][colPointer].getY() +4;
	
		if (map[rowPointer][colPointer+1].getTileType()==2 && colOld != colPointer+1) {
			return 1;
		} 
		else {
			return 0;
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
					rowPointer = row;
					colPointer = col;
					setX(map[row][col].getX() + 4); 
					setY(map[row][col].getY() + 4);
					return;
				} 
			}
		}
	}
}
