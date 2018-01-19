package Model;

import java.util.LinkedList;

/**
 * Class that represent the discard of the game 
 * @author Alexandre
 * @see Model.Deck
 *
 */
public class Discard extends Deck {

	/**
	 * Color of the last card of the discard
	 */
    private CardColor lastCardColor;

    /**
     * Classic constructor of the discard that create an empty list of card
     */
    public Discard() {
        super(new LinkedList<Card>());
    }

    /**
     * Method that return the last Card of the deck
     *
     * @return The last card
     */
    public Card getLastCard() {
        LinkedList<Card> list = (LinkedList<Card>) super.getListCards();
        return list.getFirst();
    }

    /**
     * Method that return all the cards
     *
     * @return the list of cards
     */
    @Override
    public LinkedList<Card> getListCards() {
        return (LinkedList<Card>) super.getListCards();
    }

    /**
     * Method that put a card on the top of the discard
     *
     * @param c the card to put on the top.
     */
    public void addCard(Card c) {
        this.getListCards().addFirst(c);
        lastCardColor = c.getColor();
    }
    
    public void reinit() {
    	this.cards.clear();
    }

    public void changeLastColor(CardColor cardColor) {
        this.lastCardColor = cardColor;
    }

    public CardColor getLastCardColor() {
        return lastCardColor;
    }

}
