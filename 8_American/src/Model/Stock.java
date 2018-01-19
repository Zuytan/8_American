package Model;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Class that represent the stock of the game 
 * @author Alexandre
 * @see Model.Deck
 *
 */
public class Stock extends Deck {

	/**
	 * Basic constructor of the Stock, that create an empty deck
	 */
    public Stock() {
        super(new LinkedList<Card>());
    }

    /**
     * Method that fill the stock with a card's list, and shuffle the deck
     * @param listCard the card's list 
     */
    public void fillStock(LinkedList<Card> listCard) {
        this.getListCards().addAll(listCard);
        Collections.shuffle(this.getListCards());
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
     * Method that return the nbCard Cards at the top of the deck
     *
     * @return the nbCard Cards at the top of the deck
     */
    public Card pick() {
    	Card c = this.getListCards().pollFirst();
        return c;
    }
}
