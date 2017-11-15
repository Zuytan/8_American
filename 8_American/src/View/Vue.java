package View;

import java.util.ArrayList;

import Controller.GameController;
import Model.Discard;
import Model.Player;
import Model.Stock;

public abstract class Vue implements Observer{
	
	/**
	 * Attribute that represents the list of player of the game 
	 */
	private ArrayList<Player> players;
	
	/**
	 * Attribute that represents the discard of the game
	 */
	private Discard discard;
	
	/**
	 * Attribute that represents the stock of the game
	 */
	private Stock stock;
	
	/**
	 * Attribute that allows the view to inform the controller of any action
	 */
	private GameController gc;
	
	public Vue(GameController gc, Stock s, Discard d, ArrayList<Player> players) {
		this.discard = d;
		this.stock = s;
		this.players = players;
		this.gc = gc;
	}
	
	protected ArrayList<Player> getPlayers() {
		return players;
	}

	protected Discard getDiscard() {
		return discard;
	}

	protected Stock getStock() {
		return stock;
	}

	protected GameController getGc() {
		return gc;
	}

	public abstract void afficher();
}
