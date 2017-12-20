/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Controller.GameController;
import Model.Discard;
import Model.Player;
import Model.Stock;
import View.GameView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
        this.win.setContentPane(new JPanel() {
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
        });
        // HAND OF PLAYER
        this.win.setLayout(new BorderLayout());
        ViewHand vh = new ViewHand(players.get(realIndexPlayer).getHand());
        vh.setSize(110, win.WIDTH);
        vh.setOpaque(false);
        this.win.add(vh, BorderLayout.PAGE_END);
        // STOCK
        ViewStock vs = new ViewStock(gc.getStock());
        vs.setSize(100, 150);
        vs.setOpaque(false);
        this.win.add(vs, BorderLayout.CENTER);
        // DISCARD
        ViewDiscard vd = new ViewDiscard(gc.getDiscard());
        vd.setSize(100, 150);
        vd.setOpaque(false);
        this.win.add(vd, BorderLayout.CENTER);
        this.win.setVisible(true);
    }

    @Override
    public void show() {
    }

    @Override
    public void update() {
    }

}
