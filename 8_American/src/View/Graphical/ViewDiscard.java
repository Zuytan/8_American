/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Model.Discard;
import Model.Stock;
import View.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.GameController;
import java.util.logging.Level;
import java.util.logging.Logger;

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
