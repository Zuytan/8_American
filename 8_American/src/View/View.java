/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *	Interface for a view in general
 * @author joe
 * @see View.Observer
 */
public interface View extends Observer {
    
	public abstract void show();
}
