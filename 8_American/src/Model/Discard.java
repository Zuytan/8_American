package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Discard extends Deck{
	private CardColor lastCardColor;
    public Discard() {
        super(new LinkedList<Card>());
    }

	/**
	 * Method that return the last Card of the deck
	 * @return The last card
	 */
	public Card getLastCard() {
		LinkedList<Card> list = (LinkedList<Card>) super.getListCards();
		return list.getFirst();
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
		lastCardColor = c.getColor();
	}

	public void changeLastColor(CardColor cardColor) {
		this.lastCardColor = cardColor;
	}

	public CardColor getLastCardColor() {
		return lastCardColor;
	}
	
}
