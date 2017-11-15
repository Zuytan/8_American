package Main;

import java.util.ArrayList;

import Model.Card;
import Model.DeckCreator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Card> list = DeckCreator.create(54);
		for(Card c : list) {
			System.out.println(c);
		}
	}

}
