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

public class GameController extends Observable {

    
    private String victorious = null;
    /**
     * Attribute that indicates the direction of game. 1 = clockwise -1 =
     * anti-clockwise
     */
    private int direction;

    /**
     * Attribute that indicate the index of the current player
     */
    private int currentPlayer;

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

    public int getDirection() {
        return direction;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Stock getStock() {
        return stock;
    }

    public Discard getDiscard() {
        return discard;
    }

    public Rule getCurrentRule() {
        return currentRule;
    }

    public void setCurrentRule(Rule currentRule) {
        this.currentRule = currentRule;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    private EnumAction actToDo;

    public EnumAction getActToDo() {
        return actToDo;
    }

    public String getVictorious() {
        return victorious;
    }

    private Rule currentRule;

    /**
     * Basic constructor of the class
     *
     * @param direction Indicate the direction of the game <br> 1 = clockwise
     * <br>-1 = anti-clockwise
     * @param nbPlayer Indicate the number of player in the game
     * @param realPlayerIndex Indicate the real player index
     * @param d
     * @param s
     */
    public GameController(Player player, int direction, int nbAI, Stock s, Discard d) {
        Action.initGame(this);
        this.currentRule = new MinimalRule(this);
        actToDo = EnumAction.none;
        // TODO Auto-generated method stub
        this.direction = direction;
        this.currentPlayer = 0;
        this.stock = s;
        this.stock.fillStock(StockCreator.create(54));
        this.discard = d;
        this.players.add(player);
        for (int i = 1; i < nbAI; i++) {
            this.players.add(new Player("AI "+i));
        }
        Iterator<Player> itrPlayer = players.iterator();
        while (itrPlayer.hasNext()) {
            Player p = itrPlayer.next();
            p.getHand().init(Action.draw(7));
        }
        this.discard.addCard(Action.draw(1).get(0));//Retourne une arraylist donc on fait un get pour reprendre la carte

    }

    /**
     * Method called by the view to indicate the card the player want to play
     *
     * @param index index of the card
     */
    public void playCard(int index) {
        Card c = Action.playCard(index);
        EnumAction ea = currentRule.apply(c);
        Action.putOnDiscard(c);
        this.actToDo = ea;
        if (this.actToDo == EnumAction.none) {
            this.nextPlayer();
        }
        notifyAllObs();
    }

    /**
     * Method called by the view to indicate that the player want to draw a card
     */
    public void drawCard() {
        this.players.get(currentPlayer).addCards(Action.draw(1));
        this.nextPlayer();
        notifyAllObs();
    }

    /**
     * Method called by the view to go to the next player
     */
    private void nextPlayer() {
        if(Action.verifyVictory()){
            this.victorious = this.players.get(this.currentPlayer).toString();
        }
        else{
            Action.changePlayer();
        }
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

    public void changeColor(int choice) {
        if (choice > 0 && choice < 5) { // avoid nonsense choice
            this.discard.changeLastColor(CardColor.values()[choice - 1]);
        }
        this.actToDo = EnumAction.none;
        this.nextPlayer();
        notifyAllObs();
    }

    public void start() {
        this.notifyAllObs();
    }
}
