package Model;

/**
 * Class that represents a card in the game
 * 
 * @author Alexandre
 * @see Model.CardColor
 * @see Model CardValue 
 */
public class Card {

	/**
	 * Attribute that represents the color of the card
	 */
    private CardColor color;
    
    /**
     * Attribute that represents the value of the card
     */
    private CardValue value;

    /**
     * Basic constructor of a card
     *
     * @param color Color of the card
     * @param value Value of the card
     */
    public Card(CardColor color, CardValue value) {
        this.color = color;
        this.value = value;
    }

    /**
     * Color's getter of the card
     *
     * @return the color of the card
     */
    public CardColor getColor() {
        return color;
    }

    /**
     * Value's getter of the card
     *
     * @return the value of the card
     */
    public CardValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.value);
        if (this.color != CardColor.Joker) {
            sb.append(" of ");
            sb.append(this.color);
        }
        return sb.toString();
    }
}
