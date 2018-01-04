package View.Graphical;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controller.GameController;
import Model.Player;
import View.View;
import javax.swing.BorderFactory;

public class ViewAI extends JPanel implements View {
	private GameController gc;
	private ArrayList<ViewCard> myAI = new ArrayList<>();

	public ViewAI(GameController gc) {
		this.gc = gc;
		this.update();
		ArrayList<Player> myPlayer = gc.getPlayers();
		Iterator<Player> itr = myPlayer.iterator();
		itr.next(); // avoid real player 
		while (itr.hasNext()) {
			Player p1 = itr.next();
			ViewCard vc = new ViewCard();
			vc.setSize(100, 150);
			this.add(vc);
			this.myAI.add(vc);
		}
	}

	@Override
	public Dimension getMinimumSize() {
		// TODO Auto-generated method stub
		return super.getSize();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		ArrayList<Player> p = this.gc.getPlayers();
		
		Iterator<Player> itrP = p.iterator();
		itrP.next();
		Iterator<ViewCard> itrVC = this.myAI.iterator(); 
		while(itrP.hasNext() && itrVC.hasNext()){
			ViewCard currentAIView = itrVC.next();
			currentAIView.removeAll();
			Player currentAI = itrP.next();
			JLabel nbCard = new JLabel( currentAI + " : " + currentAI.getHand().getNbCard());
			nbCard.setPreferredSize(new Dimension(100, 150));
			nbCard.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
			nbCard.setHorizontalAlignment(SwingConstants.CENTER);
			nbCard.setForeground(Color.CYAN);
			if (this.gc.getCurrentPlayer() == currentAI.getPosition()) {
				nbCard.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
			}
			currentAIView.add(nbCard);
		}
		
		this.revalidate();
		this.repaint();
		
	}

}
