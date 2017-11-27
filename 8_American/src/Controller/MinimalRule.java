package Controller;

import Model.Card;
import Model.CardValue;
import Model.EnumAction;

public class MinimalRule extends Rule {

	@Override
	public EnumAction apply(Card card) {
		EnumAction action = EnumAction.none;
		if (card.getColor() == Action.getDiscard().getLastCardColor()
				|| card.getValue() == Action.getDiscard().getLastCard().getValue()
				|| card.getValue() == CardValue.Eight) {
			switch (card.getValue()) {
			case Ten:
				Action.changeDirection();
				Action.changePlayer();
				Action.changeDirection();
				break;
			case Eight:
				action = EnumAction.changeColor;
				break;
			}
		} else {
			Action.draw(2);
		}
		return action;
	}
}
