import javax.swing.JFrame;

public class Game {

	private static final int WIDTH = 320, HEIGHT = 240, SCALE  = 4;
	
	public static void main(String[] args) {
		new Game();
		
	}
	
	public Game() {
		JFrame window = new JFrame("tower defence");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH * SCALE + 19, HEIGHT * SCALE + 40);
		window.add(new Draw());
		window.setVisible(true);
		
	}
}
