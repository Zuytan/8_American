package Model;

import java.util.ArrayList;

import Controller.GameController;
import Exceptions.InvalidActionException;
import Exceptions.InvalidInputException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StrategyRandom implements IStrategy {

    @Override
    public void execute(Discard d, ArrayList<Card> HandOfAI, GameController gc) {
        try {
            gc.playCard((int) (Math.random() * HandOfAI.size()));
        } catch (InvalidInputException ex) {
            Logger.getLogger(StrategyRandom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidActionException ex) {
            Logger.getLogger(StrategyRandom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void changeColor(Discard d, ArrayList<Card> HandOfAI, GameController gc) {

        int colorSelected = (int)(Math.random() * 4);
        try {
            gc.changeColor(colorSelected);
        } catch (InvalidInputException ex) {
            Logger.getLogger(StrategyRandom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
