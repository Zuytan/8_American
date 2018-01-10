/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Graphical;

import Controller.GameController;
import Controller.Graphical.ChangeRuleController;
import Controller.Graphical.ColorChoiceController;
import Model.Discard;
import Model.Player;
import Model.Stock;
import View.GameView;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author joe
 */
public class ViewWindow extends GameView {

    private JFrame win;
    private final int WIDTH = 1000;
    private final int HEIGHT = 690;

    public ViewWindow(GameController gc, Stock s, Discard d, ArrayList<Player> players, int realIndexPlayer) {
        super(gc, s, d, players, realIndexPlayer);
        this.win = new JFrame();
        this.win.setTitle("8 American");
        this.win.setSize(this.WIDTH, this.HEIGHT);
        this.win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.win.setResizable(false);
        // BACKGROUND
        @SuppressWarnings("serial")
        JPanel background = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(("images\\tapis.jpg").toLowerCase()));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                g.drawImage(img, 0, 0, this);
            }
        };
        this.win.setContentPane(background);
        this.win.setLayout(new BorderLayout());

        // LAST CARD COLOR
        ViewColorLastCard vclc = new ViewColorLastCard(gc);
        vclc.setSize(110, ImageObserver.HEIGHT);
        vclc.setOpaque(false);
        this.win.add(vclc, BorderLayout.EAST);
        gc.addObserver(vclc);

        // AI
        ViewAI va = new ViewAI(gc);
        va.setSize(110, ImageObserver.WIDTH);
        va.setOpaque(false);
        this.win.add(va, BorderLayout.NORTH);
        gc.addObserver(va);

        // LAST MESSAGE INFO
        ViewMessageInfo vmi = new ViewMessageInfo(gc);
        vmi.setSize(110, ImageObserver.HEIGHT);
        vmi.setOpaque(false);
        this.win.add(vmi, BorderLayout.WEST);
        gc.addObserver(vmi);

        // HAND OF PLAYER
        ViewHand vh = new ViewHand(gc);
        vh.setSize(110, ImageObserver.WIDTH);
        vh.setOpaque(false);
        this.win.add(vh, BorderLayout.SOUTH);
        gc.addObserver(vh);

        // PANEL REGROUPING STOCK AND DISCARD
        JPanel StockNDiscard = new JPanel();
        StockNDiscard.setOpaque(false);
        StockNDiscard.setLayout(new GridLayout(2, 1));
        this.win.add(StockNDiscard, BorderLayout.CENTER);

        // STOCK
        ViewStock vs = new ViewStock(gc);
        vs.setSize(100, 150);
        vs.setOpaque(false);
        StockNDiscard.add(vs);
        gc.addObserver(vs);

        // DISCARD
        ViewDiscard vd = new ViewDiscard(gc);
        vd.setSize(100, 150);
        vd.setOpaque(false);
        StockNDiscard.add(vd);
        gc.addObserver(vd);

        //MENU
        /*
         * J'ai rajout� quelques truc qui pouvaient �tre cool, apres on est pas obliger de tout faire �videmment
         * Juste la tu vois que c'est juste graphique, il y a aucun listener de creer, donc il faut en faire des sp�cifique pour chaque
         */
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem newGame = new JMenuItem("New Game...");
        //newGame.addMouseListener({The specific controller});
        menu.add(newGame);

        JMenuItem loadGame = new JMenuItem("Load Game...");
        //loadGame.addMouseListener({The specific controller});
        menu.add(loadGame);

        JMenuItem saveGame = new JMenuItem("Save the Game...");
        //saveGame.addMouseListener({The specific controller});
        menu.add(saveGame);

        JMenu changeRule = new JMenu("Change the rule");
        menuBar.add(changeRule);

        //Bon ici c'est un peu particulier, j'ai modifi� quelques truc dans le GC, 
        //Avant pour changer de regle, on passait par le playCard(), maintenant
        //j'ai trouv� �a plus propre de le faire passer par une fonction sp�cifique
        //qui s'appelle changeRule(int index) qui va changer la regle en fonction
        //de l'index pass� en param�tre. Il va donc falloir creer un controller qui 
        //appelle cette m�thode
        for (int i = 0; i < this.getGc().getListRules().size(); i++) {
            JMenuItem rule = new JMenuItem(i + ") " + this.getGc().getListRules().get(i).toString());
            rule.addMouseListener(new ChangeRuleController(this.getGc(), rule, this.win));
            changeRule.add(rule);
        }

        this.win.setJMenuBar(menuBar);
        this.win.setVisible(true);
    }

    @Override
    public void show() {
        Object[] options = {"Quit"};
        int n = JOptionPane.showOptionDialog(this.win,
                this.getGc().getVictorious() + " has won the game",
                "End of Game",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]); //default button title
        if (n == 0) {
            System.exit(0);
        }
        System.exit(0);
    }

    @Override
    public void update() {
        if (this.getGc().getVictorious() != null) {
            this.show();
        }
        switch (super.getGc().getActToDo()) {
            case none:
                break;
            case changeColor:
                if (this.getGc().getCurrentPlayer() == this.getRealIndexPlayer()) {
                    Object[] possibilities = {"spades", "hearts", "diamonds", "clubs"};
                    String s = null;
                    while (s == null) {
                        s = (String) JOptionPane.showInputDialog(
                                this.win,
                                "Choose the new color:\n",
                                "Customized Dialog",
                                JOptionPane.PLAIN_MESSAGE,
                                UIManager.getIcon("FileView.fileIcon"),
                                possibilities,
                                "spades");
                    }
                    ColorChoiceController ccc = new ColorChoiceController(this.getGc());
                    ccc.convertChoiceToInt(s);
                }
                break;
            default:
                break;
        }
    }

}
