/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import View.View;

import java.awt.Dimension;
import javax.swing.JPanel;

import Controller.GameController;
import Controller.Graphical.StockClickController;

/**
 *	Class that represents the graphical view of the stock
 * @author Raphael
 * @see JPanel
 * @see View.View
 */
@SuppressWarnings("serial")
public class ViewStock extends JPanel implements View{

	/**
	 * The gameController of the game 
	 */
    private GameController gc;

    /**
     * The basic constructor of the view
     * @param gc the game controller
     */
    public ViewStock(GameController gc) {
        this.gc = gc;
        ViewCard vc = new ViewCard();
        vc.addMouseListener(new StockClickController(this.gc,vc));
        vc.setSize(100, 150);
        this.add(vc);
    }

    @Override
    public Dimension getMinimumSize() {
        return super.getSize(); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public  void update() {
		
	}
}
