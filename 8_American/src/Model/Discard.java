package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Discard extends Deck{

    public Discard() {
        super(new LinkedList<Card>());
    }

	public void init() {
		
		
	}
	/**
	 * Method that return the last Card of the deck
	 * @return The last card
	 */
	public Card getLastCard() {
		LinkedList<Card> list = (LinkedList<Card>) super.getListCards();
		return list.get(list.size()-1);
	}
	
	/**
	 * Method that return all the cards 
	 * @return the list of cards 
	 */
        @Override
	public LinkedList<Card> getListCards(){
		return (LinkedList<Card>) super.getListCards();
	}
	
	/**
	 * Method that put a card on the top of the discard
	 * @param c the card to put on the top.
	 */
	public void addCard(Card c) {
		this.getListCards().addFirst(c);
	}
}
