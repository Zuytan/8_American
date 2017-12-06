/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Menu;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author joe
 */
public class MenuView implements View {

    private Menu menu;
    private boolean continuer = true;

    public MenuView(Menu m) {
        this.menu = m;
    }

    @Override
    public void show() {
        boolean goodChoice = false;
        int choice = 0;
        while (!goodChoice) {
            System.out.println("What do you want to do ?");
            System.out.println("1. Play the game");
            System.out.println("2. Set your name (currently : "+this.menu.getPlayerName()+")");
            System.out.println("3. Set the rule (currently : "+this.menu.getListRule().get(this.menu.getRuleToApply())+")");
            System.out.println("4. Set the level of the AI (currently : level "+this.menu.getLevelOfAI()+")");
            System.out.println("5. Set the number of AI (currently : "+this.menu.getNbIA()+")");
            System.out.println("6. Leave the game");
            Scanner sc = new Scanner(System.in);
            try {
                choice = sc.nextInt();
                if (choice > 0 && choice < 7) {
                    goodChoice = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid choice !");
            }

        }
        switch (choice) {
            case 1:
                this.menu.play();
                break;
            case 2:
                this.setName();
                break;
            case 3:
                this.setRule();
                break;
            case 4:
                this.setAILevel();
                break;
            case 5:
                this.setAINumber();
                break;
            case 6:
                this.continuer = false;
                break;
        }

    }

    @Override
    public void update() {
        System.out.println("Welcome in the 8 american simulator !");
        while (continuer) {
            this.show();
        }
    }

    private void setName() {
        String name = "toto";

        System.out.println("Please insert your name : ");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        this.menu.setPlayerName(name);

    }

    private void setRule() {

        boolean goodChoice = false;
        int choice = 0;
        while (!goodChoice) {
            System.out.println("What is your choice ? ");
            for (int i = 0; i < this.menu.getListRule().size(); i++) {
                System.out.println(i + 1 + ". " + this.menu.getListRule().get(i));
            }
            Scanner sc = new Scanner(System.in);
            try {
                choice = sc.nextInt();
                if (choice > 0 && choice <= this.menu.getListRule().size()) {
                    goodChoice = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid choice !");
            }
        }
        this.menu.setRuleToApply(choice - 1);
    }

    private void setAILevel() {
        boolean goodChoice = false;
        int choice = 0;
        while (!goodChoice) {
            System.out.println("What is your choice ? ");
            for (int i = 0; i < this.menu.getListStrategy().size(); i++) {
                System.out.println(i + 1 + ". Level " + i);
            }
            Scanner sc = new Scanner(System.in);
            try {
                choice = sc.nextInt();
                if (choice > 0 && choice <= this.menu.getListStrategy().size()) {
                    goodChoice = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid choice !");
            }
        }
        this.menu.setLevelOfAI(choice - 1);
    }

    private void setAINumber() {
        boolean goodChoice = false;
        int choice = 0;
        while (!goodChoice) {
            System.out.println("How many AI do you want ? ");
            Scanner sc = new Scanner(System.in);
            try {
                choice = sc.nextInt();
                if (choice > 0) {
                    goodChoice = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid choice !");
            }
        }
        this.menu.setNbIA(choice);
    }

}
