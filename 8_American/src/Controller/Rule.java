package Controller;

import Model.Card;
import Model.EnumAction;

public abstract class Rule {

    protected  GameController gc;
	
	/**
	 * Method that apply the rule of the game 
	 * @param card The card the player is playing
	 */
	public abstract EnumAction apply(Card card);
        public void setGc(GameController gc){
            this.gc = gc;
        }
        
}
