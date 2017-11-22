package Main;

import java.util.ArrayList;

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
		GameController gc = new GameController(1, 4, 0, s, d);
		VueConsole v = new VueConsole(gc, s, d, gc.getPlayers());
		v.afficher();
	}

}
