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
public class ViewCard extends JPanel implements View {

	private Card card;
	private Image image;

	public ViewCard(Card c) {
		this.card = c;
		this.setImage(this.card.toString().replace(" ", "_"));
	}

	public ViewCard() {
		this.card = null;
		this.setImage("backcard");
	}
	
	@Override
	public void setSize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		super.setSize(arg0, arg1);
		this.image = this.image.getScaledInstance(arg0, arg1, Image.SCALE_SMOOTH);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, (int)(this.getWidth()/2-50), (int)(this.getHeight()/2-75), this);
	}

	@Override
	public void show() {
		this.repaint();
	}

	@Override
	public  void update() {
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

	public void setImage(String name) {
		// TODO Auto-generated method stub
		try {

			this.image = ImageIO.read(new File(("images\\playing_cards\\" + name + ".png").toLowerCase()));
		} catch (IOException ex) {
			Logger.getLogger(ViewCard.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Card getCard() {
		return this.card;
	}
}
