/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Model.Card;
import View.View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author joe
 */
public class ViewCard extends JPanel implements View{
    
    private Card card;
    private Image image;

    public ViewCard(Card c){
        this.card = c;
        try{
            System.out.println(("images\\playing_cards\\"+this.card.toString().replace(" ", "_")+".png").toLowerCase());
            this.image = ImageIO.read(new File(("images\\playing_cards\\"+this.card.toString().replace(" ", "_")+".png").toLowerCase()));
        } catch (IOException ex) {
            Logger.getLogger(ViewCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        JPanel me = this;
        this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("hey");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				me.setBounds(me.getX(), me.getY()-7, me.getWidth(), me.getHeight());
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				me.setBounds(me.getX(), me.getY()+7, me.getWidth(), me.getHeight());
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
        	
        });
    }
    
    @Override
    public void setSize(int arg0, int arg1) {
    	// TODO Auto-generated method stub
    	super.setSize(arg0, arg1);
    	this.image = this.image.getScaledInstance(arg0, arg1, Image.SCALE_SMOOTH);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
    
    @Override
    public void show() {
        this.repaint();
    }

    @Override
    public void update() {
    }
    
    @Override
    public Dimension getPreferredSize() {
    	// TODO Auto-generated method stub
    	return this.getSize();
    }
    
    @Override
    public Dimension getMinimumSize() {
    	// TODO Auto-generated method stub
    	return super.getSize();
    }
}
