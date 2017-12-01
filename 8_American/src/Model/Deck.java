package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Deck {
	/**
	 * List of cards of the deck 
	 */
	protected List<Card> cards;
        
        protected Deck(List<Card> list){
            this.cards = list;
        }
	
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
	public List<Card> getListCards(){
		return this.cards;
	}
}
