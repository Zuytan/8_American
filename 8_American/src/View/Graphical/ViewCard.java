/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Model.Card;
import View.View;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author joe
 */
public class ViewCard extends JPanel implements View{
    
    private Card card;
    private BufferedImage image;

    public ViewCard(Card c){
        this.card = c;
        try{
            System.out.println(("images\\playing_cards\\"+this.card.toString().replace(" ", "_")+".png").toLowerCase());
            this.image = ImageIO.read(new File(("images\\playing_cards\\"+this.card.toString().replace(" ", "_")+".png").toLowerCase()));
        } catch (IOException ex) {
            Logger.getLogger(ViewCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
    
    @Override
    public void show() {
        this.repaint();
    }

    @Override
    public void update() {
    }
    
    
    
}
