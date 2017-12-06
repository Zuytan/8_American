/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author joe
 */
public class InvalidInputException extends Exception{
        public InvalidInputException(){
            super("Error : this input is not recognized ! try again");
    }
}
