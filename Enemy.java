import java.awt.*;

public class Enemy extends Rectangle {
	public int xC,yC;
	public int enemySize = 52;
	public int distanceWalked;
	//Number code the directions to be walked in.
	public int up=0,down=1,right=2,left=3;
	public int direction=right;
	public int enemyID =Value.enemyAir;
	
	//Checkar ifall enemy är on-screen.
	public boolean inScreen = false;
	public boolean goingUp = false;
	public boolean goingDown = false;
	public boolean goingLeft = false;
	public boolean goingRight = false;

	
	public Enemy(){
	
	}
	public void spawnEnemy(int enemyID){
		for(int y=0;y<Screen.room.block.length;y++){
			if(Screen.room.block[y][0].groundID==Value.groundRoad){
				setBounds(Screen.room.block[y][0].x, Screen.room.block[y][0].y, enemySize,enemySize);
				xC=0;
				yC=y;
			}
	}
		this.enemyID= enemyID;
		inScreen=true;
	}
	public void draw(Graphics g){
	
			g.drawImage(Screen.tileset_enemy[enemyID],x,y,width,height,null);

}
	public void deleteEnemy(){
		inScreen= false;
		
	}
	public void loseHealth(){
		Screen.health--;
	}
	//low walkspeed= snabbare... jag är dum... orkar ej ändra atm.
	public int walkFrame=0,walkSpeed=30;
	public void physic(){
		if(walkFrame>= walkSpeed){
			if(direction==right){
			x++;
		}else if(direction==up){
			y--;
		}else if(direction==down){
			y++;
		}else if(direction==left){
			x--;
		}
		distanceWalked++;
		
		if(distanceWalked==Screen.room.blockSize){
			if(direction==right){
				xC++;
				goingRight=true;
			}else if(direction==up){
				yC--;
				goingUp=true;
			}else if(direction==down){
				yC++;
				goingDown=true;
			}else if(direction==left){
				xC--;
				goingLeft=true;
			}
			if(!goingUp){
			try{
				if(Screen.room.block[yC+1][xC].groundID == Value.groundRoad){
			direction=down;
			}}catch(Exception e){}
			}
			if(!goingDown){
			try{
				if(Screen.room.block[yC-1][xC].groundID == Value.groundRoad){
			direction=up;
			}}catch(Exception e){}
			}
			if(!goingLeft){
			try{
				if(Screen.room.block[yC][xC+1].groundID == Value.groundRoad){
					direction=right;
			}}catch(Exception e){}
			}
			if(!goingRight){
				try{
					if(Screen.room.block[yC][xC-1].groundID == Value.groundRoad){
						direction=left;
				}}catch(Exception e){}
				}
			
			if(Screen.room.block[yC][xC].airID== Value.endCastle){
				deleteEnemy();
				loseHealth();
			}
			goingUp=false;
			goingDown=false;
			goingLeft=false;
			goingRight=false;
			distanceWalked=0;
			}
			walkFrame=0;
	} else{
			walkFrame++;
	}
	}
}

	

