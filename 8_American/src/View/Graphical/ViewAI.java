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

	public ViewAI(GameController gc) {
		this.gc = gc;
		this.update();
	}

	@Override
	public Dimension getMinimumSize() {
		// TODO Auto-generated method stub
		return super.getSize();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.removeAll();
		ArrayList<Player> myPlayer = gc.getPlayers();
		Iterator<Player> itr = myPlayer.iterator();
		itr.next(); // avoid real player ?
                int i=1;
		while(itr.hasNext()) {
			Player p1 = itr.next();
			ViewCard vc = new ViewCard();
			vc.setSize(100, 150);
			JLabel nbCard = new JLabel(p1 + " : " + p1.getHand().getNbCard());
			nbCard.setPreferredSize(new Dimension(100, 150));
			nbCard.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
			nbCard.setHorizontalAlignment(SwingConstants.CENTER);
			nbCard.setForeground(Color.CYAN);
                        if(this.gc.getCurrentPlayer()==i){
                            nbCard.setBorder(BorderFactory.createLineBorder(Color.YELLOW,5));
                        }
			vc.add(nbCard);
			this.add(vc);
                        i++;
		}
		this.revalidate();
		this.repaint();
		
	}

}
