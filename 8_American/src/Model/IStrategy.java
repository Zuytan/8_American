package Model;

import java.util.ArrayList;

import Controller.GameController;

public interface IStrategy {
	
	/**
	 * Method that execute a strategy 
	 */
	public void execute(Discard d, ArrayList<Card> HandOfAI, GameController gc);
	
	/**
	 * Method that choose the new color
	 * @param d The discard of the game
	 * @param HandOfAI The hand of the AI
	 * @param gc The game controller
	 */
	public void changeColor(Discard d, ArrayList<Card> HandOfAI, GameController gc);
}
