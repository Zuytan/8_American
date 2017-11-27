package Controller;

import java.util.ArrayList;
import java.util.Iterator;

import Model.Card;
import Model.CardColor;
import Model.StockCreator;
import Model.Discard;
import Model.EnumAction;
import Model.Hand;
import Model.Player;
import Model.Stock;
import Model.EnumAction;
public class GameController extends Observable{
	
	private EnumAction actToDo;
	public EnumAction getActToDo() {
		return actToDo;
	}

	private Rule currentRule;
	/**
	 * Basic constructor of the class
	 * @param direction Indicate the direction of the game <br> 1 = clockwise <br>-1 = anti-clockwise 
	 * @param nbPlayer Indicate the number of player in the game
	 * @param realPlayerIndex Indicate the real player index
	 * @param d 
	 * @param s 
	 */
	public GameController(int direction,int nbPlayer, int realPlayerIndex, Stock s, Discard d) {
		this.currentRule = new MinimalRule();
		actToDo = EnumAction.none;
		Action.initGame(direction, nbPlayer, realPlayerIndex, s, d);
	}
	
	/**
	 * Method called by the view to indicate the card the player want to play
	 * @param index index of the card
	 */
	public void playCard(int index) {
		Card c = Action.playCard(index);
		EnumAction ea = currentRule.apply(c);
		if(ea == EnumAction.changeColor) {
			this.actToDo = EnumAction.changeColor;
		}
		notifyAllObs();
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
		return Action.getPlayers();
	}
	
	public int getCurrentPlayer() {
		return Action.getCurrentPlayer();
	}
	
	public void changeColor(int choice) {
		if(choice > 0 && choice < 5) {
			Action.getDiscard().changeLastColor(CardColor.values()[choice-1]);
		}
		this.actToDo = EnumAction.none;
		super.notifyAllObs();
	}
}
