/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Graphical;

import Controller.GameController;
import Exceptions.InvalidInputException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joe
 */
public class ColorChoiceController {

	public static void convertChoiceToInt(String choice, GameController gc) {
		try {
			switch (choice) {
			case "clubs":
				gc.changeColor(2);
				break;
			case "spades":
				gc.changeColor(3);
				break;
			case "hearts":
				gc.changeColor(1);
				break;
			case "diamonds":
				gc.changeColor(4);
				break;
			}
		} catch (InvalidInputException ex) {
			Logger.getLogger(ColorChoiceController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
