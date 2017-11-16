package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	private Hand hand;

	public Player() {
		this.hand = new Hand();
	}
	
	/**
	 * Method that return the card in the player's hand at the <i>index</i> position
	 * @param index the index of the card
	 * @return the card
	 */
	public Card playCard(int index) {
		return this.hand.removeCard(index);
	}
	
	/**
	 * Method the add some cards in the player's hand 
	 * @param cardPicked A card's array
	 */
	public void addCards(ArrayList<Card> cardPicked) {
		Iterator<Card> itrCard = cardPicked.iterator();
		while (itrCard.hasNext()) {
			Card c = itrCard.next();
			this.hand.addCard(c);
		}
	}
	
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
}
