package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
    public ArrayList<Card> pick(int nbCard) {
        ArrayList<Card> list = new ArrayList<>();
        for (int i = 0; i < nbCard; i++) {
            list.add(this.getListCards().pollFirst());
        }
        return list;
    }
}
