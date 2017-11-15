package View;

import java.util.ArrayList;

import Controller.GameController;
import Model.Discard;
import Model.Player;
import Model.Stock;
import Model.Card;

public class VueConsole extends Vue{

	public VueConsole(GameController gc, Stock s, Discard d, ArrayList<Player> players) {
		super(gc, s, d, players);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.afficher();
	}

	@Override
	public void afficher() {
		// TODO Auto-generated method stub
		System.out.println("The stock contains "+this.getStock().getNbCard()+" cards");
		System.out.println("The first card of the discard is the "+this.getDiscard().getLastCard());
		System.out.println("You have :");
		int currentPlayer = this.getGc().getCurrentPlayer();
		int nbCardCurrentPlayer = this.getPlayers().get(currentPlayer).getHand().getNbCard();
		for(int i = 0; i < nbCardCurrentPlayer;i++ ) {
			System.out.println(i+") "+this.getPlayers().get(currentPlayer).getHand().getListCards().get(i));
		}
	}

}
