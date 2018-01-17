/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 * A class which describe the message to show when the exception is catched
 *
 * @author Raphaël
 */
@SuppressWarnings("serial")
public final class InvalidActionException extends Exception{

	public InvalidActionException(){
        super("Error : you can't realize this action now ! try again");
    }
}
