package View;

import java.util.ArrayList;

import Controller.GameController;
import Model.Discard;
import Model.Player;
import Model.Stock;
import View.View;

/**
 * Abstract class for the views of the game in general
 * @author Alexandre
 * @see View.View
 */
public abstract class GameView implements View{
	
	/**
	 * Attribute that represents the human position in the game
	 */
	private int myNumber;

	/**
	 * Attribute that allows the view to inform the controller of any action
	 */
	private GameController gc;
	
	/**
	 * Basic construct of the basic view
	 * @param gc GameController of the game 
	 * @param s Stock of the game 
	 * @param d Discard of the game 
	 * @param players players of the game 
	 * @param realIndexPlayer Index of the real player in the game 
	 */
	public GameView(GameController gc,  int realIndexPlayer) {
		this.gc = gc;
		this.myNumber = realIndexPlayer;
	}
	
	/**
	 * Getter of the players
	 * @return the players of the game 
	 */
	protected ArrayList<Player> getPlayers() {
		return this.gc.getPlayers();
	}

	/**
	 * Getter of the discard 
	 * @return the discard of the game
	 */
	protected Discard getDiscard() {
		return this.gc.getDiscard();
	}

	/**
	 * Getter of the stock
	 * @return the discard of the stock
	 */
	protected Stock getStock() {
		return this.gc.getStock();
	}

	/**
	 * Getter of the gamecontroller
	 * @return the gamecontroller of the game 
	 */
	protected GameController getGc() {
		return gc;
	}
	

	protected int getRealIndexPlayer() {
		return this.myNumber;
	}
}
