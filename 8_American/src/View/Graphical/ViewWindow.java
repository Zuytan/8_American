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

    public ViewWindow(GameController gc, Stock s, Discard d, ArrayList<Player> players, int realIndexPlayer) {
        super(gc, s, d, players, realIndexPlayer);
        this.win = new JFrame();
        this.win.setTitle("8 American");    
        this.win.setSize(1000,700);
        this.win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.win.setContentPane(new JPanel() {
        	@Override
        	protected void paintComponent(Graphics g) {
        		// TODO Auto-generated method stub
        		super.paintComponent(g);
        		BufferedImage img=null;
				try {
					img = ImageIO.read(new File(("images\\tapis.jpg").toLowerCase()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		g.drawImage(img,0,0,this);
        	}
        });
        ViewHand vh = new ViewHand(players.get(realIndexPlayer).getHand());
        vh.setSize(110, win.WIDTH);
        vh.setOpaque(false);
        this.win.add(vh, BorderLayout.PAGE_END);
        this.win.setVisible(true);
    }

    @Override
    public void show() {
    };

    @Override
    public void update() {
    }
    
}
