package Controller;

import java.util.ArrayList;

import Model.Card;
import Model.Hand;

public class Action {

    private static GameController gc;

    public static void initGame(GameController gc0) {
        gc = gc0;
    }

    /**
     * Method that ask for change the direction of game
     */
    public static void changeDirection() {
        gc.setDirection(gc.getDirection() * -1);
    }

    /**
     * Method that swap the hands of each player.
     *
     * @param direction Indicate the direction of the swap 1 or -1
     */
    public static void swapHands(int direction) {
        ArrayList<Hand> listHand = new ArrayList();
        for (int i = 0; i < gc.getPlayers().size(); i++) {
            listHand.add(gc.getPlayers().get(i).getHand());
        }
        if (direction == -1) {
            listHand.add(listHand.remove(0));
        } else {
            listHand.set(0, listHand.remove(listHand.size() - 1));
        }

        for (int i = 0; i < gc.getPlayers().size(); i++) {
            gc.getPlayers().get(i).setHand(listHand.get(i));
        }
    }

    /**
     * The controller is asking the model for the card indicate in parameter and
     * play it on the game
     *
     * @param indexCard The index of the card the player want to play
     */
    public static Card playCard(int indexCard) {
        Card playedCard = gc.getPlayers().get(gc.getCurrentPlayer()).playCard(indexCard);
        return playedCard;
    }

    public static void putOnDiscard(Card c) {
        gc.getDiscard().addCard(c);
    }

    /**
     * Put a number of card in the current player
     *
     * @param nbCard the number of card which is needed
     */
    public static void draw(int nbCard) {
        ArrayList<Card> cardPicked = gc.getStock().pick(nbCard);
        gc.getPlayers().get(gc.getCurrentPlayer()).addCards(cardPicked);
    }

    /**
     * This method change the current player in the direction of the game
     */
    public static void changePlayer() {
        gc.setCurrentPlayer((gc.getCurrentPlayer() + gc.getDirection()) % gc.getPlayers().size());
    }

    /**
     * This method verify if the current player is winning in this turn
     *
     * @return true in case of victory, false either
     */
    public static boolean verifyVictory() {
        boolean victory = false;
        if (gc.getPlayers().get(gc.getCurrentPlayer()).getHand().getNbCard() == 0) {
            victory = true;
        }
        return victory;
    }
}
