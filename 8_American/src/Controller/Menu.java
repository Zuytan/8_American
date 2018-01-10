/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Discard;
import Model.IStrategy;
import Model.Player;
import Model.Stock;
import View.GameView;
import View.Graphical.ViewWindow;
import java.util.ArrayList;

/**
 *
 * @author joe
 */
public class Menu extends Observable {

	/**
	 * List of strategies that can be played
	 */
    private final ArrayList<IStrategy> listStrategy;
    
    /**
     * List of rules that can be played with
     */
    private final ArrayList<Rule> listRule;
    
    /**
     * The current number of AI
     */
    private int nbIA = 2;
    
    /**
     * The current Player name
     */
    private String playerName = "toto"; 
    
    /**
     * The current level of AI
     */
    private int levelOfAI = 1;
    
    /**
     * The current rule to Apply
     */
    private int RuleToApply = 1;

    public int getLevelOfAI() {
        return levelOfAI;
    }

    public void setLevelOfAI(int levelOfAI) {
        this.levelOfAI = levelOfAI;
    }

    public int getRuleToApply() {
        return RuleToApply;
    }

    public void setRuleToApply(int RuleToApply) {
        this.RuleToApply = RuleToApply;
    }

    public int getNbIA() {
        return nbIA;
    }

    public void setNbIA(int nbIA) {
        this.nbIA = nbIA;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public ArrayList<IStrategy> getListStrategy() {
        return listStrategy;
    }

    public ArrayList<Rule> getListRule() {
        return listRule;
    }

    public Menu(ArrayList<IStrategy> listStrategy, ArrayList<Rule> listRule) {
        this.listStrategy = listStrategy;
        this.listRule = listRule;
    }

    public void play() {
        Stock s = new Stock();
        Discard d = new Discard();
        Player moi = new Player(this.playerName,0);
        GameController gc = new GameController(moi, this.nbIA, s, d, this.listRule.get(this.RuleToApply), this.listRule);
        GameView v = new ViewWindow(gc, s, d, gc.getPlayers(), 0);
       //GameView v2 = new ConsoleView(gc, s, d, gc.getPlayers(), 0 );
        gc.addObserver(v);
        //gc.addObserver(v2);
        for (int i = 0; i < nbIA; i++) {
            gc.addObserver(new AI(gc, d, gc.getPlayers(), i + 1, this.listStrategy.get(this.levelOfAI)));
        }
        gc.start();
    }
    
    public void start(){
        this.notifyAllObs();
    }

}
