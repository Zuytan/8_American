/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Controller.GameController;
import Model.Card;
import Model.CardColor;
import Model.CardValue;
import Model.Discard;
import Model.Player;
import Model.Stock;
import View.GameView;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author joe
 */
public class ViewWindow extends GameView {
    
    private JFrame win;

    public ViewWindow(GameController gc, Stock s, Discard d, ArrayList<Player> players, int realIndexPlayer) {
        super(gc, s, d, players, realIndexPlayer);
        this.win = new JFrame();
        this.win.setTitle("8 American");    
        this.win.setSize(1000,800);
        this.win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Card c = new Card(CardColor.Clubs,CardValue.Jack);
        ViewCard vc = new ViewCard(c);
        vc.setSize(100, 300);
        this.win.setContentPane(vc);
        this.win.setVisible(true);
    }

    @Override
    public void show() {
    };

    @Override
    public void update() {
    }
    
}
