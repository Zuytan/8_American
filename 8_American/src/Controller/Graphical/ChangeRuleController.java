/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Graphical;

import Controller.GameController;
import Exceptions.InvalidActionException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author joe
 */
public class ChangeRuleController implements MouseListener {

    private final int REAL_PLAYER_INDEX = 0;
    private GameController gc;
    private JMenuItem menuItem;
    private JFrame frame;

    public ChangeRuleController(GameController gc, JMenuItem m, JFrame fra) {
        this.gc = gc;
        this.menuItem = m;
        this.frame = fra;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    /*
    Pour une raison encore obscure un MenuItem ne reçoit pas les mouseClicked
    Mais uniquement les mousePressed o_O
     */
    @Override
    public void mousePressed(MouseEvent me) {
        if (this.gc.getCurrentPlayer() == REAL_PLAYER_INDEX) {
            String file = "";
            try {
                file = this.menuItem.getText().substring(3);
                file = file.replace(" ", "_");
                file = file.toLowerCase();
                BufferedReader br = new BufferedReader(new FileReader("rules\\" + file + ".txt"));
                file = "";
                String line;
                while ((line = br.readLine()) != null) {
                    file += line + "\n";
                }
                br.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChangeRuleController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ChangeRuleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this.frame, "The new rule is " + this.menuItem.getText().substring(3) + "\n\n" + file);
            int index = Integer.parseInt(this.menuItem.getText().substring(0, 1));
            Thread th = new Thread(new Runnable() {
                public void run() {
                    try {
                        gc.changeRule(index);
                    } catch (InvalidActionException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            th.start();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
