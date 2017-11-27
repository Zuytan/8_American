package View;

import java.util.ArrayList;
import java.util.Scanner;

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
		switch(super.getGc().getActToDo()) {
		case none :
			this.afficher();
		case changeColor :
			this.askColorChange();
		default:
			break;
				
		}
		
	}

	private void askColorChange() {
		// TODO Auto-generated method stub
		System.out.println("Which Color do you want ?");
		System.out.println("Hearts : 1\n"
				+ "Clubs : 2\n"
				+ "Spades : 3\n"
				+ "Diamonds : 4");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		super.getGc().changeColor(choice);

	}

	@Override
	public void afficher() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("The stock contains "+this.getStock().getNbCard()+" cards");
		System.out.println("The first card of the discard is the |"+this.getDiscard().getLastCard()+"|");
		System.out.println("You have :");
		int currentPlayer = this.getGc().getCurrentPlayer();
		int nbCardCurrentPlayer = this.getPlayers().get(currentPlayer).getHand().getNbCard();
		for(int i = 0; i < nbCardCurrentPlayer;i++ ) {
			System.out.println(i+") "+this.getPlayers().get(currentPlayer).getHand().getListCards().get(i));
		}
		System.out.println("What do you want to play, bitch ?");
		int choice = sc.nextInt();
		super.getGc().playCard(choice);
	}

}
