package View.Graphical;

import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.JPanel;

import Controller.GameController;
import Controller.Graphical.CardPlayerMouseController;
import Model.Card;
import Model.Hand;
import View.View;

/**
 * Class that represents the view of the hands 
 * @author Alexandre
 * @see JPanel
 * @see View.View
 *
 */
@SuppressWarnings("serial")
public class ViewHand extends JPanel implements View{
	
	/**
	 * The game controller
	 */
	private GameController gc;
	
	/**
	 * The basic constructor 
	 * @param gc the game controller 
	 */
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
		Iterator<Card> itr = myHand.getListCards().iterator();
		while(itr.hasNext()){
			ViewCard vc = new ViewCard(itr.next());
			vc.addMouseListener(new CardPlayerMouseController(gc, vc));
			vc.setSize(100, 150);
			this.add(vc);
		}
		this.revalidate();
		this.repaint();		
	}
 
}
