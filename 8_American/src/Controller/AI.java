package Controller;

import java.util.ArrayList;

import Model.Card;
import Model.Discard;
import Model.IStrategy;
import Model.Player;
import Model.StrategyRandom;
import Model.StrategyStupid;
import View.Observer;

public class AI implements Observer {

    /**
     * The list of strategies that a AI can apply
     */
    private IStrategy strategy;

    /**
     * Number that represent the position of the AI
     */
    private int myNumber;

    private GameController gc;

    private Discard d;

    private ArrayList<Player> players;

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

    @Override
    public void update() {
        if (this.gc.getCurrentPlayer() == this.myNumber && this.gc.getVictorious() == null) {
            this.applyStrategy();
        }
    }
}
