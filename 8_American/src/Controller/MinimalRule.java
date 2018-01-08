package Controller;

import Model.Card;
import Model.CardColor;
import Model.CardValue;
import Model.EnumAction;

public class MinimalRule extends Rule {

    @Override
    public EnumAction apply(Card card) {
        EnumAction action = EnumAction.none;
        if (card.getColor() == gc.getDiscard().getLastCardColor()
                || card.getValue() == gc.getDiscard().getLastCard().getValue()
                || card.getValue() == CardValue.Eight
                || card.getValue() == CardValue.Joker
                || gc.getDiscard().getLastCardColor() == CardColor.Joker) {
            switch (card.getValue()) {
                case Ten:
                    this.gc.setMessageAlert("The " + gc.getPlayers().get(gc.getCurrentPlayer()) + "'s turn is going to be replayed");
                    Action.changeDirection();
                    Action.changePlayer();
                    Action.changeDirection();
                    break;
                case Eight:
                    action = EnumAction.changeColor;
                    this.gc.setMessageAlert("The main color is going to change");
                    break;
                default:
                	break;
            }
        } else {
            this.gc.getPlayers().get(this.gc.getCurrentPlayer()).addCards(Action.draw(2));
        }
        Action.putOnDiscard(card);
        return action;
    }

    @Override
    public String toString() {
        return "Minimal Rule";
    }

}
