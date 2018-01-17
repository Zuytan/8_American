/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 * A class which describe the message to show when the exception occured
 *
 * @author Raphaël
 */
@SuppressWarnings("serial")
public class InvalidInputException extends Exception{

		public InvalidInputException(){
            super("Error : this input is not recognized ! try again");
    }
}
