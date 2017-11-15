package Model;

import java.util.ArrayList;

public class Discard extends Deck{

	public void init() {
		
		
	}
	/**
	 * Method that return the last Card of the deck
	 * @return The last card
	 */
	public Card getLastCard() {
		ArrayList<Card> list = super.getListCards();
		return list.get(list.size()-1);
	}
	
	/**
	 * Method that return all the cards 
	 * @return the list of cards 
	 */
	public ArrayList<Card> getAllcard(){
		return super.getListCards();
	}
	
	/**
	 * Method that put a card on the top of the discard
	 * @param c the card to put on the top.
	 */
	public void addCard(Card c) {
		this.getListCards().add(c);
	}
}
