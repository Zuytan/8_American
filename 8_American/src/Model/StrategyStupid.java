package Model;

import java.util.ArrayList;
import java.util.Iterator;

import Controller.GameController;


public class StrategyStupid implements IStrategy{

	@Override
	public void execute(Discard d, ArrayList<Card> HandOfAI, GameController gc) {
		int cardToPlay = -1;
		Iterator<Card> it = HandOfAI.iterator();
		while(cardToPlay == -1 && it.hasNext()) {
			Card current = it.next();
			if(current.getColor() == d.getLastCardColor() || current.getValue() == d.getLastCard().getValue()) {
				cardToPlay = HandOfAI.indexOf(current);
			}
		}
		if(cardToPlay == -1) {
			gc.drawCard();
		}else {
			gc.playCard(cardToPlay);
		}
	}

	@Override
	public void changeColor(Discard d, ArrayList<Card> HandOfAI, GameController gc) {
		int colorSelected = HandOfAI.get(0).getColor().ordinal();
		gc.changeColor(colorSelected);
	}

}
