package Main;

import java.util.ArrayList;

import Controller.GameController;
import Model.Card;
import Model.DeckCreator;
import View.VueConsole;

public class Main {

	public static void main(String[] args) {
		GameController gc = new GameController(1, 4, 0);
		VueConsole v = new VueConsole(gc, gc.getStock(), gc.getDiscard(), gc.getPlayers());
		v.afficher();
	}

}
