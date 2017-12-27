package Controller.Graphical;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Controller.GameController;
import View.Graphical.ViewCard;

public class CardPlayerMouseController implements MouseListener{
	
	private GameController gc;
	private ViewCard p;
	
	public CardPlayerMouseController(GameController gc, ViewCard p) {
		this.gc = gc;
		this.p = p;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int index = this.gc.getPlayers().get(this.gc.getCurrentPlayer()).getHand().getListCards().indexOf(this.p.getCard());
		System.out.println(index);
		//this.gc.playCard(index);
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
