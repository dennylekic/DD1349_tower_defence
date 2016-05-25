import java.awt.event.*;
import java.awt.*;
public class KeyHandler implements MouseMotionListener, MouseListener {

	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseDragged(MouseEvent e) {
		Screen.mse = new Point(Math.abs((e.getX())+(Frame.size.width-Screen.myWidth)/2), e.getY()+ Math.abs((e.getX())+(Frame.size.height-Screen.myHeight)/2));
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Screen.mse = new Point(Math.abs((e.getX())-(Frame.size.width-Screen.myWidth)/2), e.getY()- Math.abs((e.getX())-Math.abs((Frame.size.height-Screen.myHeight)/2)));
		
	}

}
