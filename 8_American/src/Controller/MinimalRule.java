package Controller;

import Model.Card;
import Model.CardValue;
import Model.EnumAction;

public class MinimalRule extends Rule {

    public MinimalRule(GameController gc) {
        super(gc);
    }

    @Override
    public EnumAction apply(Card card) {
        EnumAction action = EnumAction.none;
        if (card.getColor() == gc.getDiscard().getLastCardColor()
                || card.getValue() == gc.getDiscard().getLastCard().getValue()
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
