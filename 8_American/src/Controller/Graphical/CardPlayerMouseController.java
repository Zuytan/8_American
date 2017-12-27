package Controller.Graphical;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Controller.GameController;
import Exceptions.InvalidActionException;
import Exceptions.InvalidInputException;
import View.Graphical.ViewCard;

public class CardPlayerMouseController implements MouseListener{
	
	private GameController gc;
	private ViewCard p;
	
	public CardPlayerMouseController(GameController gc, ViewCard p) {
		this.gc = gc;
		this.p = p;
	}
	
	@Override
	public void mouseClicked(MouseEvent  arg0) {
		// TODO Auto-generated method stub
		int index = this.gc.getPlayers().get(this.gc.getCurrentPlayer()).getHand().getListCards().indexOf(this.p.getCard());
		Robot r;
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_NUMPAD0+index);
			r.keyRelease(KeyEvent.VK_NUMPAD0+index);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		p.setBounds(p.getX(), p.getY() - 7, p.getWidth(), p.getHeight());
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		p.setBounds(p.getX(), p.getY() + 7, p.getWidth(), p.getHeight());
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
