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
 *
 * @author joe
 */
public class ViewDiscard extends JPanel implements View {

    private GameController gc;

    public ViewDiscard(GameController gc) {
        this.gc = gc;
        this.update();
    }

    @Override
    public Dimension getMinimumSize() {
        return super.getSize(); //To change body of generated methods, choose Tools | Templates.
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }

}
