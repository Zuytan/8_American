package Model;

import java.util.ArrayList;

import Controller.GameController;

public class StrategyRandom implements IStrategy {
    
    @Override
    public void execute(Discard d, ArrayList<Card> HandOfAI, GameController gc) {
        gc.playCard((int)(Math.random() * HandOfAI.size()));
    }
    
    @Override
    public void changeColor(Discard d, ArrayList<Card> HandOfAI, GameController gc) {
        int colorSelected = HandOfAI.get(0).getColor().ordinal();
        gc.changeColor(colorSelected);
    }
    
}
