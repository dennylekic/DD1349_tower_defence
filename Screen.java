import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Screen extends JPanel implements Runnable {
	public Thread thread = new Thread(this);
	public static Image[] titleset_ground = new Image[100];
	public static Image[] titleset_air= new Image[100];
	public static Image[] titleset_res= new Image[100];
	public static Image[] tileset_enemy= new Image[100];

	public static int myWidth, myHeight;
	public static int moneyCount = 100, health= 100;
	public static boolean isFirst=true;
	
	public static Point mse = new Point(0,0);
	public static Save save;
	public static Room room;
	public static Store store;
	
	public static Enemy[] enemies = new Enemy[100];
	public Screen(Frame frame){
		frame.addMouseListener(new KeyHandler());
		frame.addMouseMotionListener(new KeyHandler());
		thread.start();
	}
	public void define(){
		room= new Room();
		save = new Save();
		store = new Store();
		
		
		for(int i=0;i<titleset_ground.length;i++){
			titleset_ground[i] = new ImageIcon("res/titleset_ground.png").getImage();
			titleset_ground[i] = createImage(new FilteredImageSource(titleset_ground[i].getSource(), new CropImageFilter(0,26*i,26,26)));
		}
		for(int i=0;i<titleset_air.length;i++){
			titleset_air[i] = new ImageIcon("res/titleset_air.png").getImage();
			titleset_air[i] = createImage(new FilteredImageSource(titleset_air[i].getSource(), new CropImageFilter(0,26*i,26,26)));
		}
		titleset_res[0]= new ImageIcon("res/titleset_cell.png").getImage();
		titleset_res[1]= new ImageIcon("res/money.png").getImage();
		titleset_res[2]= new ImageIcon("res/heart.png").getImage();
		
		tileset_enemy[0]= new ImageIcon("res/enemy.png").getImage();
		save.loadSave(new File("save/mission1"));
		
		for(int i=0;i<enemies.length;i++){
			enemies[i] = new Enemy();
		}
		
	}
	public void paintComponent(Graphics g){
		if(isFirst){
			 myWidth = getWidth();
	            myHeight = getHeight();
			define();
			isFirst= false;
		}
		  //Set background below.
		  g.setColor(new Color(50,50,50));
		  g.fillRect(0, 0, getWidth(), getHeight());
		  g.setColor(new Color(0,0,0));
		  //Draw left, right, and bottom line.
		  g.drawLine(room.block[0][0].x-1,0, room.block[0][0].x-1, room.block[room.worldHeight-1][0].y-room.blockSize);
		  g.drawLine(room.block[0][room.worldWidth-1].x+ room.blockSize,0, room.block[0][room.worldWidth-1].x+room.blockSize, room.block[room.worldHeight-1][0].y-room.blockSize);
		  g.drawLine(room.block[0][0].x, room.block[room.worldHeight-1][0].y +room.blockSize, room.block[0][room.worldWidth-1].x+room.blockSize, room.block[room.worldHeight-1][0].y +room.blockSize);
		  room.draw(g);
		  
		  for(int i=0;i<enemies.length;i++){
			  if(enemies[i].inScreen){
				  enemies[i].draw(g);
				  
			  }
		  }
		  store.draw(g);
	}
	
	public int spawnTime=3600, spawnFrame=0;
	public void enemySpawner(){
		if(spawnFrame >= spawnTime){
			for(int i=0;i<enemies.length;i++){
				if(!enemies[i].inScreen){
					enemies[i].spawnEnemy(Value.enemyDelta);
					break;
				}	
			}
			spawnFrame=0;
		}else{
			spawnFrame++;
		}
		
	}

	   //Basic game loop.
    public void run() {
        while (true) {
            if(!isFirst){
            	room.physic();
            	enemySpawner();
            	for(int i=0; i<enemies.length;i++){
            		if(enemies[i].inScreen){
            			enemies[i].physic();
            		}
            	}
            }
            repaint();

            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
        }
    }
}
