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
        switch (choice) {
            case "clubs":
        {
            try {
                gc.changeColor(1);
            } catch (InvalidInputException ex) {
                Logger.getLogger(ColorChoiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "spades":
        {
            try {
                gc.changeColor(2);
            } catch (InvalidInputException ex) {
                Logger.getLogger(ColorChoiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "hearts":
        {
            try {
                gc.changeColor(0);
            } catch (InvalidInputException ex) {
                Logger.getLogger(ColorChoiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "diamonds":
        {
            try {
                gc.changeColor(3);
            } catch (InvalidInputException ex) {
                Logger.getLogger(ColorChoiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
        }
    }
}
