package Model;

import java.util.ArrayList;

public class Discard extends Deck{

	@Override
	public void init() {
		
		
	}
	/**
	 * Method that return the last Card of the deck
	 * @return The last card
	 */
	public Card getLastCard() {
		ArrayList<Card> list = super.getListCards();
		return list.get(list.size()-1);
	}
	
	/**
	 * Method that return all the cards 
	 * @return the list of cards 
	 */
	public ArrayList<Card> getAllcard(){
		return super.getListCards();
	}
}
