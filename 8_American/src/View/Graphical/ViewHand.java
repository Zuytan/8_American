package View.Graphical;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import Controller.GameController;
import Controller.Graphical.CardPlayerMouseController;
import Model.Hand;
import View.View;

public class ViewHand extends JPanel implements View{
	
	private GameController gc;
	
	public ViewHand(GameController gc) {
		this.gc = gc;
		this.update();
	}

    @Override
    public Dimension getMinimumSize() {
        return super.getSize(); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public void update() {
		this.removeAll();
		Hand myHand = this.gc.getPlayers().get(0).getHand();
		myHand.getListCards().forEach((c)->{
			ViewCard vc = new ViewCard(c);
			vc.addMouseListener(new CardPlayerMouseController(gc, vc));
			vc.setSize(100, 150);
			this.add(vc);
		});
		this.revalidate();
		this.repaint();		
	}
 
}
