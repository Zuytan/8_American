package Model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that represent a player in the game, no matter if it is real or AI
 * @author Alexandre
 * @see Model.Hand
 *
 */
public class Player {

	/**
	 * Attribute  that represents the name of the player
	 */
    private String name;
    
    /**
     * Attribute that represents the hand of the player
     */
    private Hand hand;
    
    /**
     * Attribute that represents the position of the player in the game
     */
    private int position;
    

    /**
     * Basic constructor that represents a player in the game, and create an empty game
     * @param name  the name of the player
     * @param position the position of the player in the game 
     */
    public Player(String name, int position) {
        this.hand = new Hand();
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Method that return the card in the player's hand at the <i>index</i>
     * position
     *
     * @param index the index of the card
     * @return the card
     */
    public Card playCard(int index) {
        return this.hand.removeCard(index);
    }

    /**
     * Method the add some cards in the player's hand
     *
     * @param cardPicked A card's array
     */
    public void addCards(ArrayList<Card> cardPicked) {
        Iterator<Card> itrCard = cardPicked.iterator();
        while (itrCard.hasNext()) {
            Card c = itrCard.next();
            this.hand.addCard(c);
        }
    }

    /**
     * Getter of the Player's Hand
     * @return the hand of the player
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Setter of the Player's Hand
     * @param hand new hand of the player
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    /**
     * Getter of the position 
     * @return the position of the player
     */
	public int getPosition() {
		return position;
	}

}
