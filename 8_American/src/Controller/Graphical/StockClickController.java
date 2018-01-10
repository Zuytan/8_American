/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Graphical;

import Controller.GameController;
import Exceptions.InvalidActionException;
import View.Graphical.ViewCard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author joe
 */
public class StockClickController implements MouseListener{
    private  final int REAL_PLAYER_INDEX = 0;
    private GameController gc;
    private ViewCard p;

    public StockClickController(GameController gc, ViewCard p) {
        this.gc = gc;
        this.p = p;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        if (this.gc.getCurrentPlayer() == REAL_PLAYER_INDEX) {
        	Thread th = new Thread(new Runnable() {
				@Override
				public void run() {
					 try {
			                gc.drawCard();
			            } catch (InvalidActionException e) {
			                e.printStackTrace();
			            }
				}
        	});
        	th.start();
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if (this.gc.getCurrentPlayer() == REAL_PLAYER_INDEX) {
            p.setBounds(p.getX(), p.getY() - 7, p.getWidth(), p.getHeight());
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if (this.gc.getCurrentPlayer() == REAL_PLAYER_INDEX) {
            p.setBounds(p.getX(), p.getY() + 7, p.getWidth(), p.getHeight());
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
}
