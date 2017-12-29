/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Controller.GameController;
import Controller.Graphical.ColorChoiceController;
import Controller.Graphical.StockClickController;
import Model.Discard;
import Model.Player;
import Model.Stock;
import View.GameView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author joe
 */
public class ViewWindow extends GameView {

    private JFrame win;
    private final int WIDTH = 1000;
    private final int HEIGHT = 690;

    public ViewWindow(GameController gc, Stock s, Discard d, ArrayList<Player> players, int realIndexPlayer) {
        super(gc, s, d, players, realIndexPlayer);
        this.win = new JFrame();
        this.win.setTitle("8 American");
        this.win.setSize(this.WIDTH, this.HEIGHT);
        this.win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.win.setResizable(false);
        // BACKGROUND
        JPanel background = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(("images\\tapis.jpg").toLowerCase()));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                g.drawImage(img, 0, 0, this);
            }
        };
        this.win.setContentPane(background);
        this.win.setLayout(new BorderLayout());

        // AI
        ViewAI va = new ViewAI(gc);
        va.setSize(110, win.WIDTH);
        va.setOpaque(false);
        this.win.add(va, BorderLayout.NORTH);
        gc.addObserver(va);
        
        // PANEL REGROUPING STOCK AND DISCARD
        JPanel StockNDiscard = new JPanel();
        StockNDiscard.setOpaque(false);
        StockNDiscard.setLayout(new GridLayout(2, 1));
        this.win.add(StockNDiscard, BorderLayout.CENTER);

        // STOCK
        ViewStock vs = new ViewStock(gc);
        vs.setSize(100, 150);
        vs.setOpaque(false);
        StockNDiscard.add(vs);
        gc.addObserver(vs);

        // DISCARD
        ViewDiscard vd = new ViewDiscard(gc);
        vd.setSize(100, 150);
        vd.setOpaque(false);
        StockNDiscard.add(vd);
        gc.addObserver(vd);

        // HAND OF PLAYER
        ViewHand vh = new ViewHand(gc);
        vh.setSize(110, win.WIDTH);
        vh.setOpaque(false);
        this.win.add(vh, BorderLayout.SOUTH);
        gc.addObserver(vh);
        
        // LAST CARD COLOR
        ViewColorLastCard vclc = new ViewColorLastCard(gc);
        vclc.setSize(110, this.win.HEIGHT);
        vclc.setOpaque(false);
        this.win.add(vclc, BorderLayout.EAST);
        gc.addObserver(vclc);
        
     // LAST CARD COLOR
        ViewColorLastCard vclc2 = new ViewColorLastCard(gc);
        vclc2.setSize(110, this.win.HEIGHT);
        vclc2.setOpaque(false);
        this.win.add(vclc2, BorderLayout.WEST);
        gc.addObserver(vclc2);

        this.win.setVisible(true);
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {
        if (this.getGc().getVictorious() != null) {
            this.show();
        }
        switch (super.getGc().getActToDo()) {
            case none:
                break;
            case changeColor:
                if (this.getGc().getCurrentPlayer() == this.getRealIndexPlayer()) {
                    Object[] possibilities = {"spades", "hearts", "diamonds", "clubs"};
                    String s = (String) JOptionPane.showInputDialog(
                            this.win,
                            "Choose the new color:\n",
                            "Customized Dialog",
                            JOptionPane.PLAIN_MESSAGE,
                            UIManager.getIcon("FileView.fileIcon"),
                            possibilities,
                            "spades");
                    ColorChoiceController.convertChoiceToInt(s, this.getGc());
                }
                break;
            default:
                break;
        }

    }

}
