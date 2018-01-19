package Controller;

import Model.Card;
import Model.CardValue;
import Model.EnumAction;
import java.util.ArrayList;

public abstract class Rule {

    protected GameController gc;

    /**
     * Method that apply the rule of the game
     *
     * @param card The card the player is playing
     * @return The action to apply
     */
    public abstract EnumAction apply(Card card);

    public void setGc(GameController gc) {
        this.gc = gc;
    }

    /**
     * Method that return a list of the card with effect for this rule. It is
     * usefull for a specific AI strategy.
     *
     * @return The list of the card
     * @see Model.StrategyEffectCard
     */
    public abstract ArrayList<CardValue> getListCardEffect();

}
