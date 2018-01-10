/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.GameController;
import Exceptions.InvalidActionException;
import Exceptions.InvalidInputException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joe
 */
public class StrategyEffectCard implements IStrategy {

    @Override
    public void execute(Discard d, ArrayList<Card> HandOfAI, GameController gc) {
        ArrayList<CardValue> list = gc.getCurrentRule().getListCardEffect();
        int cardEffectToPlay = -1;
        int cardToPlay = -1;
        Iterator<Card> it = HandOfAI.iterator();
        while (cardEffectToPlay == -1 && cardToPlay == -1 && it.hasNext()) {
            Card current = it.next();
            if (list.contains(current.getValue())) {
                if (current.getColor() == d.getLastCardColor()
                        || current.getValue() == d.getLastCard().getValue()
                        || d.getLastCard().getValue() == CardValue.Joker) {
                    cardEffectToPlay = HandOfAI.indexOf(current);
                }
            } else if (current.getColor() == d.getLastCardColor()
                    || current.getValue() == d.getLastCard().getValue()
                    || current.getValue() == CardValue.Joker
                    || d.getLastCard().getValue() == CardValue.Joker) {
                cardToPlay = HandOfAI.indexOf(current);
            }
        }
        if (cardToPlay == -1 && cardEffectToPlay == -1) {
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
            if(cardEffectToPlay != -1){
                cardToPlay = cardEffectToPlay;
            }
            try {
                gc.playCard(cardToPlay);
            } catch (InvalidInputException ex) {
                Logger.getLogger(StrategyStupid.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidActionException ex) {
                Logger.getLogger(StrategyStupid.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * This AI plays the color it had the most in its hand
     */
    @Override
    public void changeColor(Discard d, ArrayList<Card> HandOfAI, GameController gc) {
        int[] tab = {0, 0, 0, 0, 0};
        HandOfAI.forEach((Card c) -> {
            tab[c.getColor().ordinal()]++;
        });
        int colorSelected = 0;
        int max = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > max) {
                colorSelected = i;
                max = tab[i];
            }
        }
        try {
            gc.changeColor(colorSelected + 1);
        } catch (InvalidInputException ex) {
            Logger.getLogger(StrategyStupid.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String toString() {
        return "Effect Card Strategy";
    }

}
