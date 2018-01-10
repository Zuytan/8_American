package Model;

import java.util.Collections;
import java.util.LinkedList;

public class Stock extends Deck {

    public Stock() {
        super(new LinkedList<Card>());
    }

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
     * Method that return the <i>nbCard</i> Cards at the top of the deck
     *
     * @param nbCard The number of card to pick
     * @return the <i>nbCard</i> Cards at the top of the deck
     */
    public Card pick() {
    	Card c = this.getListCards().pollFirst();
        return c;
    }
}
