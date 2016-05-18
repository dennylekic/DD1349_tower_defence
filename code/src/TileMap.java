import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;

import org.w3c.dom.css.RGBColor;

public class TileMap {
	
	private int numRow, numCol, tileSize;
	
	private int[][] map;
	private Tile[][] tileMap;
	
	private Color[] colorList;
	
	
	public TileMap(String s) {
		
		colorListInisiat();
		
		//get tile size
		tileSize = new Tile(0,0,Color.RED).getObjektSize();
		
		// lodes in map sturktionr from file 
		try {
			BufferedReader br = new BufferedReader(new FileReader(s));
			
			numRow = Integer.parseInt(br.readLine());
			numCol = Integer.parseInt(br.readLine());
			
			map = new int[numCol][numRow];
			tileMap = new Tile[numCol][numRow];
			
			String blank = " ";
			for (int row = 0; row < numRow; row++) {
				String line = br.readLine();
				String[] tokens = line.split(blank);
				for (int col = 0; col < numCol; col++) {
					map[col][row] = Integer.parseInt(tokens[col]);
				}
			}
			br.close();
		} 
		catch (Exception e) {
			System.out.println("error lodin map file");
			System.out.println(e);
		}
	}
	
	private void colorListInisiat() {
		colorList = new Color[3];
		colorList[0] = new Color(0,100,0);
		colorList[1] = Color.BLACK;
		colorList[2] = Color.GRAY;
				
	}
	
	// draws the map
	
	public void draw(Graphics g) {
			
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				tileMap[row][col] = new Tile(row * tileSize, col * tileSize, colorList[map[row][col]]);
				tileMap[row][col].draw(g);
			}
		}
	}
	
	public int[][] getMap()	{
		return map;
	}
	
	public Tile[][] getTileMap() {
		return tileMap;
	}

}
