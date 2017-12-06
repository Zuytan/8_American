package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.GameController;
import Exceptions.InvalidActionException;
import Exceptions.InvalidInputException;
import Model.Discard;
import Model.Player;
import Model.Stock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleView extends GameView {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public ConsoleView(GameController gc, Stock s, Discard d, ArrayList<Player> players, int realIndexPlayer) {
        super(gc, s, d, players, realIndexPlayer);
    }

    @Override
    public void update() {
        if (this.getGc().getVictorious() != null) {
            System.out.println(ANSI_GREEN + "The winner is : " + this.getGc().getVictorious() + ANSI_RESET);
        } else {
            this.show();
            if (this.getGc().getCurrentPlayer() == this.getRealIndexPlayer()) {
                switch (super.getGc().getActToDo()) {
                    case none:
                        this.askCardToPlay();
                        break;
                    case changeColor:
                        this.askColorChange();
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("It's the turn of " + ANSI_CYAN + this.getGc().getPlayers().get(this.getGc().getCurrentPlayer()) + ANSI_RESET);
            }
            System.out.println();
        }
    }

    private void askColorChange() {
        // TODO Auto-generated method stub
        System.out.println("Which Color do you want ?");
        System.out.println("Hearts : 1\n"
                + "Clubs : 2\n"
                + "Spades : 3\n"
                + "Diamonds : 4");
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        try {
            choice = sc.nextInt();
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Invalid input" + ANSI_RESET);
            this.askColorChange();
        }
        try {
            super.getGc().changeColor(choice);
        } catch (InvalidInputException e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
            this.askColorChange();
        }

    }

    public void askCardToPlay() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("You have :");
        System.out.println("0) Draw a card");
        System.out.println("-----------------");
        int currentPlayer = this.getGc().getCurrentPlayer();
        int nbCardCurrentPlayer = this.getPlayers().get(currentPlayer).getHand().getNbCard();
        int choice = 0;
        for (int i = 1; i <= nbCardCurrentPlayer; i++) {
            System.out.println(i + ") " + this.getPlayers().get(currentPlayer).getHand().getListCards().get(i - 1));
        }
        System.out.println("-----------------");
        System.out.println(ANSI_PURPLE+(nbCardCurrentPlayer+1)+") Change the current rule"+ANSI_RESET);
        System.out.println("What do you want to play, " + this.getGc().getPlayers().get(this.getGc().getCurrentPlayer()) + "?");
        try {
            choice = sc.nextInt();
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Invalid input" + ANSI_RESET);
            this.askCardToPlay();
        }
        if (choice == 0) {
            try {
                super.getGc().drawCard();
            } catch (InvalidActionException e) {
                System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
                this.askCardToPlay();
            }

        } else {
            try {
                super.getGc().playCard(choice - 1);
            } catch (InvalidInputException e) {
                System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
                this.askCardToPlay();
            } catch (InvalidActionException ex) {
                System.out.println(ANSI_RED + ex.getMessage() + ANSI_RESET);
                this.askCardToPlay();
            }
        }
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        System.out.println("--------------------------------");
        System.out.println("The stock contains " + this.getStock().getNbCard() + " cards");
        System.out.println("The discard contains " + this.getDiscard().getNbCard() + " cards");
        for (int i = 0; i < this.getGc().getPlayers().size(); i++) {
            Player tmp = this.getGc().getPlayers().get(i);
            System.out.println(tmp + " has " + tmp.getHand().getListCards().size() + " cards");
        }
        System.out.println("The first card of the discard is the " + ANSI_CYAN + "|" + this.getDiscard().getLastCard() + "|" + ANSI_RESET);
        System.out.println("The color is " + ANSI_CYAN + this.getDiscard().getLastCardColor() + ANSI_RESET);

        System.out.println(ANSI_RED + this.getGc().getMessageAlert() + ANSI_RESET);
        this.getGc().setMessageAlert("");

    }

}
