package Controller;

import java.util.ArrayList;
import java.util.Iterator;

import Model.Card;
import Model.StockCreator;
import Model.Discard;
import Model.Hand;
import Model.Player;
import Model.Stock;

public class Action {

    /**
     * Attribute that indicates the direction of game. 1 = clockwise -1 =
     * anti-clockwise
     */
    private static int direction;

    /**
     * Attribute that indicate the index of the current player
     */
    private static int currentPlayer;

    /**
     * Attribute that indicate the real-player index.
     */
    private static int realPlayerIndex;
    /**
     * Attribute that contains each player of the game
     */
    private static ArrayList<Player> players = new ArrayList<>();

    /**
     * Attribute that represents the stock of cards
     */
    private static Stock stock;

    /**
     * Attribute that represent the discard of the game
     */
    private static Discard discard;

    public static void initGame(int direction2, int nbPlayer, int realPlayerIndex2, Stock s, Discard d) {
        // TODO Auto-generated method stub
        direction = direction;
        realPlayerIndex = realPlayerIndex;
        currentPlayer = 0;
        stock = s;
        stock.fillStock(StockCreator.create(54));
        discard = d;

        for (int i = 0; i < nbPlayer; i++) {
            players.add(new Player());
        }
        Iterator<Player> itrPlayer = players.iterator();
        while (itrPlayer.hasNext()) {
            Player p = itrPlayer.next();
            p.getHand().init(stock.pick(7));
        }
        discard.addCard(stock.pick(1).get(0));//Retourne une arraylist donc on fait un get pour reprendre la carte
    }

    /**
     * Method that ask for change the direction of game
     */
    public static void changeDirection() {
        direction *= -1;
    }

    /**
     * Method that swap the hands of each player.
     *
     * @param direction Indicate the direction of the swap 1 or -1
     */
    public static void swapHands(int direction) {
        ArrayList<Hand> listHand = new ArrayList();
        for (int i = 0; i < players.size(); i++) {
            listHand.add(players.get(i).getHand());
        }
        if (direction == -1) {
            listHand.add(listHand.remove(0));
        } else {
            listHand.set(0, listHand.remove(listHand.size() - 1));
        }
        
        for (int i=0;i<players.size();i++){
            players.get(i).setHand(listHand.get(i));
        }
    }

    /**
     * The controller is asking the model for the card indicate in parameter and
     * play it on the game
     *
     * @param indexCard The index of the card the player want to play
     */
    public static Card playCard(int indexCard) {
        Card playedCard = players.get(currentPlayer).playCard(indexCard);
        discard.addCard(playedCard);
		return playedCard;
    }

    /**
     * Put a number of card in the current player
     *
     * @param nbCard the number of card which is needed
     */
    public static void draw(int nbCard) {
        ArrayList<Card> cardPicked = stock.pick(nbCard);
        players.get(currentPlayer).addCards(cardPicked);
    }

    /**
     * This method change the current player in the direction of the game
     */
    public static void changePlayer() {
        currentPlayer = (currentPlayer + direction) % players.size();
    }

    /**
     * This method verify if the current player is winning in this turn
     *
     * @return true in case of victory, false either
     */
    public static boolean verifyVictory() {
        boolean victory = false;
        if (players.get(currentPlayer).getHand().getNbCard() == 0) {
            victory = true;
        }
        return victory;
    }

    /**
     * Method that return the index of the current player
     *
     * @return the index of the current Player
     */
    public static int getCurrentPlayer() {
        return currentPlayer;
    }

    public static ArrayList<Player> getPlayers() {
        // TODO Auto-generated method stub
        return players;
    }
    public static Discard getDiscard() {
		return discard;
	}
}
