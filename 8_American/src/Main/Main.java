package Main;

import java.util.ArrayList;

import Controller.AI;
import Controller.GameController;
import Model.Card;
import Model.StockCreator;
import Model.Discard;
import Model.Stock;
import View.VueConsole;

public class Main {

	public static void main(String[] args) {
		Stock s = new Stock();
		Discard d = new Discard();
		GameController gc = new GameController(1, 2, s, d);
		VueConsole v = new VueConsole(gc, s, d, gc.getPlayers(),0);
		AI ai1 = new AI(gc, d, gc.getPlayers(), 1);
		gc.addObserver(v);
		gc.addObserver(ai1);
		gc.start();
	}

}
