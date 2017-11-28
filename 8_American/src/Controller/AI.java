package Controller;

import java.util.ArrayList;

import Model.Card;
import Model.Discard;
import Model.IStrategy;
import Model.Player;
import Model.StrategyStupid;
import View.Observer;

public class AI implements Observer{
	
	/**
	 * The list of strategies that a AI can apply 
	 */
	private ArrayList<IStrategy> strategies = new ArrayList<>();
	
	/**
	 * Number that represent the position of the AI
	 */
	private int myNumber;

	private GameController gc;

	private Discard d;

	private ArrayList<Player> players;
	
	public AI(GameController gc, Discard d, ArrayList<Player> players, int idOfAI) {
		this.gc = gc;
		this.d = d;
		this.players = players;
		this.myNumber = idOfAI;
		strategies.add(new StrategyStupid());
	}
	/**
	 * Method that apply a strategy of the AI
	 */
	public void applyStrategy() {
		switch(this.gc.getActToDo()) {
		case none:
			strategies.get(0).execute(d,(ArrayList<Card>) this.players.get(myNumber).getHand().getListCards(), gc);
			break;
		case changeColor:
			strategies.get(0).changeColor(d, (ArrayList<Card>) this.players.get(myNumber).getHand().getListCards(), gc);
		default:
			break;
		}
	}


	@Override
	public void update() {
		if(this.gc.getCurrentPlayer() == this.myNumber) {
			this.applyStrategy();
		}
	}
}
