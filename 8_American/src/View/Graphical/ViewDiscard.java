/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Model.Discard;
import Model.Stock;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author joe
 */
public class ViewDiscard extends JPanel{
    private Discard myDiscard;
    
    public ViewDiscard(Discard d) {
        this.myDiscard = d;
        ViewCard vc = new ViewCard(this.myDiscard.getListCards().getLast());
        vc.setSize(100, 150);
        this.add(vc);
    }

    @Override
    public Dimension getMinimumSize() {
        return super.getSize(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
