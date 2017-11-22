package Model;

import java.util.ArrayList;

public class Hand extends Deck{

	public Hand() {
            super(new ArrayList<>());
	}
	
	
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
