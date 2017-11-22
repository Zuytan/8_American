package Controller;

import java.util.ArrayList;
import java.util.Iterator;

import Model.Card;
import Model.StockCreator;
import Model.Discard;
import Model.Hand;
import Model.Player;
import Model.Stock;

public class GameController {
	
	private Action act;
	/**
	 * Basic constructor of the class
	 * @param direction Indicate the direction of the game <br> 1 = clockwise <br>-1 = anti-clockwise 
	 * @param nbPlayer Indicate the number of player in the game
	 * @param realPlayerIndex Indicate the real player index
	 * @param d 
	 * @param s 
	 */
	public GameController(int direction,int nbPlayer, int realPlayerIndex, Stock s, Discard d) {
		act = new Action();
		act.initGame(direction, nbPlayer, realPlayerIndex, s, d);
	}
	
	/**
	 * Method called by the view to indicate the card the player want to play
	 * @param index index of the card
	 */
	public void playCard(int index) {
		
	}
	
	/**
	 * Method called by the view to indicate that the player want to draw a card 
	 */
	public void drawCard() {
		
	}
	
	/**
	 * Method called by the view to go to the next player
	 */
	public void nextPlayer() {
		
	}
	
	/**
	 * Method called at the beginning of the turn, apply the penalties 
	 */
	private void turnBeginning() {
		
	}
	
	/**
	 * Method called at the end of the turn, catch the penalties of the game 
	 */
	private void turnEnding() {
		
	}

	public ArrayList<Player> getPlayers() {
		// TODO Auto-generated method stub
		return this.act.getPlayers();
	}
	
	public int getCurrentPlayer() {
		return this.act.getCurrentPlayer();
	}
}
