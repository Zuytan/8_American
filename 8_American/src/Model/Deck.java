package Model;

import java.util.List;

/**
 * Class that represents a card's deck in general
 * 
 * @author Alexandre
 * @see Model.Card
 *
 */
public abstract class Deck {
	/**
	 * List of cards of the deck
	 */
	protected List<Card> cards;

	/**
	 * A constructor that can called only by its childs
	 * @param list The list of Card of the deck
	 */
	protected Deck(List<Card> list) {
		this.cards = list;
	}

	/**
	 * Method that get the number of Cards in the deck
	 * 
	 * @return the number of cards
	 */
	public int getNbCard() {
		return cards.size();
	}

	/**
	 * Method that return the list of cards in the deck
	 * 
	 * @return the list of cards
	 */
	public List<Card> getListCards() {
		return this.cards;
	}
}
