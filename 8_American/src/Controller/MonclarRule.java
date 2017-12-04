/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Card;
import Model.CardColor;
import Model.CardValue;
import Model.EnumAction;
import java.util.LinkedList;

/**
 *
 * @author joe
 */
public class MonclarRule extends Rule {

    public MonclarRule(GameController gc) {
        super(gc);
    }

    @Override
    public EnumAction apply(Card card) {
        if (!this.gc.getListActionToDo().isEmpty()) {
            if (card.getValue() == CardValue.Eight) {
                this.gc.getListActionToDo().clear();
            } else if (this.gc.getListActionToDo().get(0) == EnumAction.drawCard && card.getValue() != CardValue.Ace) {
                while (!this.gc.getListActionToDo().isEmpty()) {
                    switch (this.gc.getListActionToDo().removeLast()) {
                        case drawCard:
                            this.gc.getPlayers().get(this.gc.getCurrentPlayer()).addCards(Action.draw(1));
                            break;
                    }
                }
                this.gc.getPlayers().get(this.gc.getCurrentPlayer()).getHand().addCard(card);
                card = null;
            } else if (this.gc.getListActionToDo().get(0) == EnumAction.avoidTurn) {
                this.gc.getListActionToDo().clear();
                this.gc.getPlayers().get(this.gc.getCurrentPlayer()).getHand().addCard(card);
                card = null;
            }
        }

        EnumAction action = EnumAction.none;
        if (card != null && (card.getColor() == gc.getDiscard().getLastCardColor()
                || card.getValue() == gc.getDiscard().getLastCard().getValue()
                || card.getValue() == CardValue.Eight 
                || card.getValue() == CardValue.Joker
                || gc.getDiscard().getLastCardColor() == CardColor.Joker)) {
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
                case Jack:
                    Action.changeDirection();
                    this.gc.setMessageAlert("The direction of the game has changed");
                    break;
                case Seven:
                    this.gc.getListActionToDo().add(EnumAction.avoidTurn);
                    Action.changePlayer();
                    this.gc.setMessageAlert("The " + gc.getPlayers().get(gc.getCurrentPlayer()) + "'s turn is going to be passed, play a 8 to avoid it or any other card if you can't");
                    Action.changeDirection();
                    Action.changePlayer();
                    Action.changeDirection();
                    break;
                case Nine:
                    Action.changePlayer();
                    this.gc.setMessageAlert("The " + gc.getPlayers().get(gc.getCurrentPlayer()) + "'s turn is going to be passed, and a card will be drawn");
                    this.gc.getPlayers().get(this.gc.getCurrentPlayer()).addCards(Action.draw(1));
                    break;
                case Ace:
                    this.gc.getListActionToDo().add(EnumAction.drawCard);
                    this.gc.getListActionToDo().add(EnumAction.drawCard);
                    this.gc.getListActionToDo().add(EnumAction.drawCard);
                    Action.changePlayer();
                    this.gc.setMessageAlert("The " + gc.getPlayers().get(gc.getCurrentPlayer()) + "'s turn is going to be passed, and " + this.gc.getListActionToDo().size() + " cards will be drawn,"
                            + "play a 8 to avoid it, an Ace to report it on the next player or other card if you can't");
                    Action.changeDirection();
                    Action.changePlayer();
                    Action.changeDirection();
                    break;
            }
        } else if (card != null) {
            this.gc.getPlayers().get(this.gc.getCurrentPlayer()).addCards(Action.draw(2));
        }
        Action.putOnDiscard(card);
        return action;

    }

}
