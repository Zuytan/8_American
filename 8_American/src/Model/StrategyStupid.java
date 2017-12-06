package Model;

import java.util.ArrayList;
import java.util.Iterator;

import Controller.GameController;
import Exceptions.InvalidActionException;
import Exceptions.InvalidInputException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StrategyStupid implements IStrategy {

    @Override
    public void execute(Discard d, ArrayList<Card> HandOfAI, GameController gc) {
        int cardToPlay = -1;
        Iterator<Card> it = HandOfAI.iterator();
        while (cardToPlay == -1 && it.hasNext()) {
            Card current = it.next();
            if (current.getColor() == d.getLastCardColor()
                    || current.getValue() == d.getLastCard().getValue()
                    || current.getValue() == CardValue.Joker
                    || d.getLastCard().getValue() == CardValue.Joker) {
                cardToPlay = HandOfAI.indexOf(current);
            }
        }
        if (cardToPlay == -1) {
            try {
                gc.drawCard();
            } catch (InvalidActionException e) {
                try {
                    gc.playCard(1);
                } catch (InvalidInputException ex) {
                    Logger.getLogger(StrategyStupid.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidActionException ex) {
                    Logger.getLogger(StrategyStupid.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            try {
                gc.playCard(cardToPlay);
            } catch (InvalidInputException ex) {
                Logger.getLogger(StrategyStupid.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidActionException ex) {
                Logger.getLogger(StrategyStupid.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void changeColor(Discard d, ArrayList<Card> HandOfAI, GameController gc) {
        int colorSelected = HandOfAI.get(0).getColor().ordinal()+1; // cause the choice of the colors start at 1;
        try {
            gc.changeColor(colorSelected);
        } catch (InvalidInputException ex) {
            Logger.getLogger(StrategyStupid.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
