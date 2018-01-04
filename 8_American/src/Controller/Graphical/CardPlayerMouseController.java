package Controller.Graphical;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Controller.GameController;
import Exceptions.InvalidActionException;
import Exceptions.InvalidInputException;
import View.Graphical.ViewCard;



public class CardPlayerMouseController implements MouseListener {

    private  final int REAL_PLAYER_INDEX = 0;
    private GameController gc;
    private ViewCard p;

    public CardPlayerMouseController(GameController gc, ViewCard p) {
        this.gc = gc;
        this.p = p;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        if (this.gc.getCurrentPlayer() == REAL_PLAYER_INDEX) {
            int index = this.gc.getPlayers().get(this.gc.getCurrentPlayer()).getHand().getListCards().indexOf(this.p.getCard());
            Thread th = new Thread(new Runnable() {
            	public void run() {
            		try {
                        gc.playCard(index);
                    } catch (InvalidInputException | InvalidActionException e) {
                        // TODO Auto-generated catch block
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
