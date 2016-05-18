
public class Player {

	private int life = 1000, xp = 0, gold = 100;
	
	//get methods
	
	public int getLife() {
		return life;
	}
	
	public int getXp() {
		return xp;
	}
	
	public int getGold() {
		return gold;
	}
	
	//set methods

	public void setLife(int life) {
		this.life = life;
	}
	
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	//in game methods

	public void takeDamage(int damage) {
		life = life - damage;
	}
	
	public void healing(int heal) {
		life = life + heal;
	}
	
	public void earnXp(int earn) {
		xp = xp + earn;
	}
	
	public void earnGold(int earn) {
		gold = gold + earn;
	}
	
	public void spendGold(int spend) {
		gold = gold - spend;
	}
	
	
}
