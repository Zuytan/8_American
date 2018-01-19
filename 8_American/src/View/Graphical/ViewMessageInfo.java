/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Controller.GameController;
import View.View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *	Class that show the differents messages that can be throw during the game
 * @author Raphael
 * @see JPanel
 * @see View.View
 */
@SuppressWarnings("serial")
public class ViewMessageInfo extends JPanel implements View {

	/**
	 * The game controller
	 */
    private GameController gc;
    
    /**
     * The message to show 
     */
    private JTextArea messageInfo;
    
    /**
     * The basic constructor of the View
     * @param gc the game controller
     */
    public ViewMessageInfo(GameController gc) {
        this.gc = gc;
        this.messageInfo = new JTextArea(this.gc.getMessageAlert());
        this.messageInfo.setLineWrap(true);
        this.messageInfo.setWrapStyleWord(true);
        this.messageInfo.setEditable(false);
        this.messageInfo.setPreferredSize(new Dimension(222,150));
        this.messageInfo.setForeground(Color.YELLOW);
        this.messageInfo.setBorder(BorderFactory.createLineBorder(Color.RED,5));
        this.messageInfo.setOpaque(false);
        Font font = new Font("Libre Baskerville",Font.BOLD, 16);
        this.messageInfo.setFont(font);
        this.add(messageInfo);
    }

    @Override
    public  void update() {
        this.messageInfo.setText(this.gc.getMessageAlert());
        this.revalidate();
        this.repaint();
        try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
