package Controller.Graphical;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Controller.Menu;
import View.Graphical.ViewMenu;

/**
 * A class which catch the mouse click on the button validate of the menu.
 *
 * @author Raphaël
 * @see java.awt.event.MouseListener
 * @see Controller.GameController
 */
public class MenuController implements MouseListener {

    private Menu m;
    private ViewMenu vm;

    public MenuController(Menu m, ViewMenu vm) {
        this.m = m;
        this.vm = vm;
    }

    /**
     * Set all the important parameter of the game and then run the game
     *
     * @param arg0 The event occured in the window
     */
    @Override
    public void mouseClicked(MouseEvent arg0) {
        this.m.setLevelOfAI(this.vm.getStrategy().getSelectedIndex());
        this.m.setNbIA((int) this.vm.getNbAI().getSelectedItem());
        this.m.setPlayerName(this.vm.getName().getText());
        this.m.setRuleToApply(this.vm.getRule().getSelectedIndex());
        this.vm.getWin().setVisible(false);
        this.m.play();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }
}
