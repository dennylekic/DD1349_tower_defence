import javax.swing.*;
import java.awt.*;

public class Room {
	public int worldWidth = 12;
	public int worldHeight = 8;
	public int blockSize= 52;
	
	public Block[][] block;
	
	public void define(){
		  block= new Block[worldHeight][worldWidth];
		  
		for(int y=0;y<block.length;y++){
			for(int x=0;x<block[0].length;x++){
				block[y][x] = new Block((Math.abs(Screen.myWidth/2))- (Math.abs((worldWidth*blockSize)/2))+(Math.abs(x*blockSize)), y*blockSize, blockSize,blockSize,Value.groundGrass,Value.airAir);
				
			}
		}
	}
	
	public Room(){
		define();
		
	}
	public void physic(){
		
	}
	public void draw(Graphics g){
		for(int y=0;y<block.length;y++){
			for(int x=0;x<block[0].length;x++){
				block[y][x].draw(g);
				
		}
	}
		
	}

}

