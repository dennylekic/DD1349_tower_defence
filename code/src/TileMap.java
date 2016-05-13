import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;

public class TileMap {
	
	private int numRow, numCol, tileSize;
	
	private int[][] map;
	private Tile[][] tileMap;
	
	
	public TileMap(String s) {
		
		tileSize = new Tile(0,0,Color.RED).getTileSize();
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
				System.out.println(numCol);
				for (int col = 0; col < numRow; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
			br.close();
		} 
		catch (Exception e) {
			System.out.println("error lodin map file");
		}
	}
	
	public void Draw(Graphics g) {
		
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				int tileType = map[row][col];
				if (tileType == 0) {
					tileMap[row][col] = new Tile(row * tileSize, col * tileSize, Color.GREEN);
					tileMap[row][col].draw(g);
				}
				else if (tileType == 1) {	
					tileMap[row][col] = new Tile(row * tileSize, col * tileSize, Color.RED);
					tileMap[row][col].draw(g);
				}
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
