package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Stock extends Deck{

	public void fillStock(ArrayList<Card> listCard) {
		this.getListCards().addAll(listCard);
		Collections.shuffle(this.getListCards());
	}
	/**
	 * Method that return the <i>nbCard</i> Cards at the top of the deck 
	 * @param nbCard The number of card to pick
	 * @return the <i>nbCard</i> Cards at the top of the deck
	 */
	public ArrayList<Card> pick(int nbCard) {
		ArrayList<Card> list = new ArrayList<>();
		for (int i = 0; i < nbCard; i++) {
			list.add(this.getListCards().remove(0));
		}
		return list;
	}
}
