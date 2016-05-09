import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	// Dimensinons
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	
	public GamePanel() {
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}

}
