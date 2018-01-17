package Controller;

import java.util.ArrayList;

import Model.Card;
import Model.Discard;
import Model.IStrategy;
import Model.Player;
import View.Observer;
/**
 * A class representing an AI player.
 * It use the pattern Strategy to choose the strategy to use.
 * This class is an observer, it is notified at each turn.
 * @author Raphaël
 * @see Model.IStrategy
 * @see View.Observer
 */
public class AI implements Observer {

    /**
     * The list of strategies that a AI can apply
     */
    private IStrategy strategy;

    /**
     * Number that represent the position of the AI
     */
    private int myNumber;

    /**
     * The game controller of the current game
     */
    private GameController gc;

    /**
     * The discard of the current game
     */
    private Discard d;

    /**
     * The list of all players in the current game
     */
    private ArrayList<Player> players;

    /**
     * Basic contructor of the AI
     * @param gc The gameController of the game where the AI is playing
     * @param d The discard of the game
     * @param players The ArrayList of Player in the game
     * @param idOfAI The id of the AI in the game
     * @param strategy The Strategy she have to apply
     */
    public AI(GameController gc, Discard d, ArrayList<Player> players, int idOfAI, IStrategy strategy) {
        this.gc = gc;
        this.d = d;
        this.players = players;
        this.myNumber = idOfAI;
        this.strategy = strategy;
        
    }

    /**
     * Method that apply a strategy of the AI
     */
    public void applyStrategy() {
        switch (this.gc.getActToDo()) {
            case none:
                this.strategy.execute(d, (ArrayList<Card>) this.players.get(myNumber).getHand().getListCards(), gc);
                break;
            case changeColor:
                this.strategy.changeColor(d, (ArrayList<Card>) this.players.get(myNumber).getHand().getListCards(), gc);
            default:
                break;
        }
    }

    /**
     * Each time the update function is called, the AI test if it must plays now.
     */
    @Override
    public void update() {
        if (this.gc.getCurrentPlayer() == this.myNumber && this.gc.getVictorious() == null) {
            this.applyStrategy();
        }
    }
}
