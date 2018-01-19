/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Model.Discard;
import View.View;

import java.awt.Dimension;

import javax.swing.JPanel;

import Controller.GameController;

/**
 *Class that represents the view of the card
 * @author Raphael
 * @see JPanel
 * @see View.View
 */
@SuppressWarnings("serial")
public class ViewDiscard extends JPanel implements View {

	/**
	 * The game controller
	 */
    private GameController gc;

    /**
     * Basic constructor of the ViewDiscard
     * @param gc the game controller
     */
    public ViewDiscard(GameController gc) {
        this.gc = gc;
        this.update();
    }

    @Override
    public Dimension getMinimumSize() {
        return super.getSize(); 
    }

    @Override
    public void update() {
    	ViewDiscard me = this;
        this.removeAll();
        Discard myDiscard = this.gc.getDiscard();
        ViewCard vc = new ViewCard(myDiscard.getListCards().getFirst());
        vc.setSize(100, 150);
        this.add(vc);    
        me.revalidate();
	     me.repaint();  
	     try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
       
    }

}
