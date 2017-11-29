package Main;


import Controller.AI;
import Controller.GameController;
import Model.Discard;
import Model.Player;
import Model.Stock;
import View.VueConsole;

public class Main {

	public static void main(String[] args) {
		Stock s = new Stock();
		Discard d = new Discard();
                Player moi = new Player("toto");
		GameController gc = new GameController(moi,1, 3, s, d);
		VueConsole v = new VueConsole(gc, s, d, gc.getPlayers(),0);
		AI ai1 = new AI(gc, d, gc.getPlayers(), 1);
                AI ai2 = new AI(gc, d, gc.getPlayers(), 2);
		gc.addObserver(v);
		gc.addObserver(ai1);
                gc.addObserver(ai2);
		gc.start();
	}

}
