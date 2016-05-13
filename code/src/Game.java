import javax.swing.JFrame;

public class Game {

	private static final int WIDTH = 320, HEIGHT = 240, SCALE  = 2;
	
	public static void main(String[] args) {
		new Game();
		
	}
	
	public Game() {
		JFrame window = new JFrame("tower defence");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		window.add(new Draw());
		window.setVisible(true);
		
	}
}
