import java.awt.*;
public class Store {
	public static int shopWidth=8;
	public static int buttonSize=52;
	public static int cellSpace=5;
	public static int awayFromRoom=29;
	public static int iconSize = 20;
	public static int iconSpace = 7;
	
	public Rectangle[] button = new Rectangle[shopWidth];
	public Rectangle buttonHealth;
	public Rectangle buttonMoney;
	
public Store(){
	
	
	define();
	
}
public void define(){
	for(int i=0;i<button.length;i++){
		button[i] = new Rectangle((Screen.myWidth)/2- ((shopWidth*buttonSize)/2)+((buttonSize+cellSpace)*i), (Screen.room.block[Screen.room.worldHeight-1][0].y)+Screen.room.blockSize+awayFromRoom, buttonSize,buttonSize);
	}
	buttonHealth= new Rectangle(Screen.room.block[0][0].x-1, button[0].y+10, iconSize, iconSize);
	buttonMoney= new Rectangle(Screen.room.block[0][0].x-1, button[0].y-(3/2)*iconSize, iconSize, iconSize);
	
}
public void draw(Graphics g){
	for(int i=0;i<button.length;i++){
		if(button[i].contains(Screen.mse)){
			g.setColor(new Color(255,255,255,150));
			g.fillRect(button[i].x,button[i].y, button[i].width, button[i].height);
		}
		
	g.drawImage(Screen.titleset_res[0],button[i].x, button[i].y, button[i].width, button[i].height,null);
	}
		
	g.drawImage(Screen.titleset_res[2],buttonHealth.x, buttonHealth.y, buttonHealth.width, buttonHealth.height,null);
	g.drawImage(Screen.titleset_res[1],buttonMoney.x, buttonMoney.y, buttonMoney.width, buttonMoney.height,null);
	g.setFont(new Font("Courier New", Font.BOLD, 14));
	g.setColor(new Color(255,255,255));
	g.drawString("" + Screen.health,buttonHealth.x +buttonHealth.width + iconSpace, buttonHealth.y-15);
	g.drawString("" + Screen.moneyCount,buttonMoney.x +buttonMoney.width + iconSpace, buttonMoney.y+45);
}

}
