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

import Model.Player;

public class ViewAI extends JPanel {
	private ArrayList<Player> myPlayer;

	public ViewAI(ArrayList<Player> p) {
		this.myPlayer = p;
		Iterator<Player> itr = this.myPlayer.iterator();
		itr.next();
		while(itr.hasNext()) {
			Player p1 = itr.next();
			ViewCard vc = new ViewCard();
			vc.setSize(100, 150);
			JLabel nbCard = new JLabel(p1 + " : " + p1.getHand().getNbCard());
			nbCard.setPreferredSize(new Dimension(100, 150));
			nbCard.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
			nbCard.setHorizontalAlignment(SwingConstants.CENTER);
			nbCard.setForeground(Color.CYAN);
			vc.add(nbCard);
			this.add(vc);
		}
		

	}

	@Override
	public Dimension getMinimumSize() {
		// TODO Auto-generated method stub
		return super.getSize();
	}

}
