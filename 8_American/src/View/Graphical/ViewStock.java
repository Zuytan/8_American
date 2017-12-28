/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Model.Stock;
import View.View;

import java.awt.Dimension;
import javax.swing.JPanel;

import Controller.GameController;
import Controller.Graphical.StockClickController;

/**
 *
 * @author joe
 */
public class ViewStock extends JPanel implements View{

    private GameController gc;

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
	public void update() {
		
	}
}
