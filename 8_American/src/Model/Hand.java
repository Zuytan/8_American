package Model;

import java.util.ArrayList;

/**
 * Class that represents the Hand of a player
 * @author Alexandre
 * @see Model.Deck
 */
public class Hand extends Deck{

	/**
	 * Basic constructor of the Hand, that create an empty deck of card 
	 */
	public Hand() {
            super(new ArrayList<>());
	}
	
	/**
	 * Method that initialize the Hand of a player with a list of cards
	 * @param list the list of cards in the hand of the player
	 */
	public void init(ArrayList<Card> list) {
		// TODO Auto-generated method stub
		this.getListCards().addAll(list);
	}
	
	/**
	 * Method that add a card in the hand
	 * @param card Card to add
	 */
	public void addCard(Card card) {
		this.getListCards().add(card);
	}
	
	/**
	 * Remove the card at the <i>index</i> items and return it
	 * @param index the index of the card
	 * @return the card removed
	 */
	public Card removeCard(int index) {
		return super.getListCards().remove(index);
	}

	
}
