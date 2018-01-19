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
 * Class that represents a graphical view of the Card
 * @author Raphael
 * @see JPanel
 * @see View.View
 * @see Model.Card
 */
@SuppressWarnings("serial")
public class ViewCard extends JPanel implements View {

	/**
	 * The card 
	 */
	private Card card;
	
	/**
	 * The image of the card
	 */
	private Image image;

	/**
	 * Constructor that create a specific image with a card in parameter
	 * @param c the card to represents
	 */
	public ViewCard(Card c) {
		this.card = c;
		this.setImage(this.card.toString().replace(" ", "_"));
	}

	/**
	 * Basic constructor of the card's view, the image of the card is the back 
	 */
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

	/**
	 * Setter of the image
	 * @param name
	 */
	public void setImage(String name) {
		// TODO Auto-generated method stub
		try {

			this.image = ImageIO.read(new File(("images\\playing_cards\\" + name + ".png").toLowerCase()));
		} catch (IOException ex) {
			Logger.getLogger(ViewCard.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Getter of the card
	 * @return the card of view
	 */
	public Card getCard() {
		return this.card;
	}
}
