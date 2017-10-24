package Model;

public class Player {
	private Hand hand;
	
	
	public Player() {
		this.hand = new Hand();
	}
	
	/**
	 * Method that return the card in the player's hand at the <i>index</i> position
	 * @param index the index of the card
	 * @return the card
	 */
	public Card playCard(int index) {
		return this.hand.removeCard(index);
	}
	
	/**
	 * Method the add some cards in the player's hand 
	 * @param cards A card's array
	 */
	public void addCards(Card[] cards) {
		for (int i = 0; i < cards.length; i++) {
			this.hand.addCard(cards[i]);
		}
	}
}
