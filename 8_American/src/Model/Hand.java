package Model;

public class Hand extends Deck{

	public Hand() {
		
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Method that add a card in the hand
	 * @param card Card to add
	 */
	public void addCard(Card card) {
		
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
