/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Model.Stock;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author joe
 */
public class ViewStock extends JPanel {

    private Stock myStock;

    public ViewStock(Stock s) {
        this.myStock = s;
        ViewCard vc = new ViewCard(this.myStock.getListCards().getLast());
        vc.setImage("backcard");
        vc.setSize(100, 150);
        this.add(vc);
    }

    @Override
    public Dimension getMinimumSize() {
        return super.getSize(); //To change body of generated methods, choose Tools | Templates.
    }
}
