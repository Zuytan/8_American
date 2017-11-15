package Model;

import java.util.ArrayList;

public abstract class Deck {
	/**
	 * List of cards of the deck 
	 */
	private ArrayList<Card> cards = new ArrayList<>();
	
	/**
	 * Method that get the number of Cards in the deck
	 * @return the number of cards
	 */
	public int getNbCard() {
		return cards.size();
	}
	
	/**
	 * Method that return the list of cards in the deck
	 * @return the list of cards
	 */
	protected ArrayList<Card> getListCards(){
		return this.cards;
	}
}
