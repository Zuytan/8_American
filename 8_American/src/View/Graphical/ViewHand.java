package View.Graphical;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;


import Model.Hand;

public class ViewHand extends JPanel{
	private Hand myHand;
	
	public ViewHand(Hand h) {
		this.myHand = h;
		this.myHand.getListCards().forEach((c)->{
			ViewCard vc = new ViewCard(c);
			vc.setSize(100, 150);
			this.add(vc);
		});
	}

    @Override
    public Dimension getMinimumSize() {
        return super.getSize(); //To change body of generated methods, choose Tools | Templates.
    }
        
}
