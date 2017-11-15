package Controller;

import java.util.ArrayList;
import java.util.Iterator;

import Model.Card;
import Model.DeckCreator;
import Model.Discard;
import Model.Hand;
import Model.Player;
import Model.Stock;

public class GameController {
	/**
	 * Attribute that indicates the direction of game.
	 * 1 = clockwise
	 * -1 = anti-clockwise
	 */
	private int direction;

	/**
	 * Attribute that indicate the index of the current player
	 */
	private int actualPlayer;

	/**
	 * Attribute that indicate the real-player index.
	 */
	private int realPlayerIndex;
	
	/**
	 * Attribute that contains each player of the game
	 */
	private ArrayList<Player> players = new ArrayList<>();

	/**
	 * Attribute that represents the stock of cards
	 */
	private Stock stock;
	
	/**
	 * Attribute that represent the discard of the game
	 */
	private Discard discard;
	/**
	 * Basic constructor of the class
	 * @param direction Indicate the direction of the game <br> 1 = clockwise <br>-1 = anti-clockwise 
	 * @param nbPlayer Indicate the number of player in the game
	 * @param realPlayerIndex Indicate the real player index
	 */
	public GameController(int direction,int nbPlayer, int realPlayerIndex) {
		this.direction = direction;
		this.realPlayerIndex = realPlayerIndex;
		this.actualPlayer = 0;
		this.stock = new Stock();
		this.stock.fillStock(DeckCreator.create(54));
		this.discard = new Discard();
		
		for (int i = 0; i < nbPlayer; i++) {
			players.add(new Player());
		}
		for (Player p : this.players) {
			p.getHand().init(this.stock.pick(7));
		}
		this.discard.addCard(this.stock.pick(1).get(0));//Retourne une arraylist donc on fait un get pour reprendre la carte
	}
	
	/**
	 * Method that return the number of player in the game
	 * @return the number of player in the game
	 */
	public int getNbPlayer() {
		return this.players.size();
		 
	}

	/**
	 * Method that ask for change the direction of game
	 */
	public void changeDirection(){
		this.direction *= -1;
	}

	/**
	 * Method that swap the hands of each player.
	 * @param direction Indicate the direction of the swap 1 or -1
	 */
	public void swapHands(int direction) {

	}

	/**
	 * The controller is asking the model for the card indicate in parameter and play it on the game 
	 * @param indexCard The index of the card the player want to play
	 */
	public void playCard(int indexCard) {
		Card playedCard = this.players.get(actualPlayer).playCard(indexCard);
		this.discard.addCard(playedCard);
	}

	/**
	 * Put a number of card in the current player
	 * @param nbCard the number of card which is needed
	 */
	public void draw(int nbCard) {
		ArrayList<Card> cardPicked = this.stock.pick(nbCard);
		this.players.get(this.actualPlayer).addCards(cardPicked);
	}

	/**
	 * This method change the current player in the direction of the game
	 */
	public void changePlayer() {
		this.actualPlayer = (this.actualPlayer+1)%this.getNbPlayer();
	}

	/**
	 * This method verify if the current player is winning in this turn
	 * @return true in case of victory, false either
	 */
	public boolean verifyVictory() {
		boolean victory = false;
		if(this.players.get(actualPlayer).getHand().getNbCard() == 0) {
			victory = true;
		}
		return victory;
	}

	/**
	 * Set the end of the actual player's turn, verify victory and go to the next player.
	 */
	public void nextPlayer() {
		
	}
}
