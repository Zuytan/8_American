package Model;

public class Card {
	private CardColor color;
	private CardValue value;
	
	/**
	 * Basic constructor of a card
	 * @param color Color of the card
	 * @param value Value of the card
	 */
	public Card(CardColor color, CardValue value) {
		this.color = color;
		this.value = value;
	}
	
	/**
	 * Color's getter of the card
	 * @return the color of the card
	 */
	public CardColor getColor() {
		return color;
	}

	/**
	 * Value's getter of the card
	 * @return the value of the card
	 */
	public CardValue getValue() {
		return value;
	}

}
