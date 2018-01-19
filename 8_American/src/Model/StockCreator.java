package Model;

import java.util.LinkedList;

/**
 * Class static that is used to create deck of cards 
 * @author Alexandre
 *
 */
public class StockCreator {

	/**
	 * Method that create a deck of <i>nbCard</i> cards 
	 * At the moment, only 32 or 54 cards
	 * @param nbCard Number of cards
	 * @return the deck of cards
	 */
	public static LinkedList<Card> create(int nbCard){
		LinkedList<Card> c;
		switch(nbCard) {
			case 32:
				c = StockCreator.create32CardsDeck();
				break;
			case 54:
				c = StockCreator.create54CardsDeck();
				break;
			default:
				c = new LinkedList<>();
		}
		return c;	
	}
	
	/**
	 * Method that create a deck of 32 cards
	 * @return a deck of 32 cards
	 */
	private static LinkedList<Card> create32CardsDeck(){
		LinkedList<Card> c = new LinkedList<>();
		for(int i = 6; i < 13;i++) {//From the seven to the king
			for (int j = 0; j < 4; j++) {//for each colors
				c.add(new Card(CardColor.values()[j],CardValue.values()[i]));
			}
		}
		return c;
	}
	
	/**
	 * Method that create a deck of 54 cards
	 * @return a deck of 54 cards
	 */
	private static LinkedList<Card> create54CardsDeck(){
		LinkedList<Card> c = StockCreator.create32CardsDeck();
		for(int i = 0; i < 6;i++) {
			for (int j = 0; j < 4; j++) {
				c.add(new Card(CardColor.values()[j],CardValue.values()[i]));
			}
		}
		c.add(new Card(CardColor.Joker, CardValue.Joker));
		c.add(new Card(CardColor.Joker, CardValue.Joker));
		return c;
	}
}
