/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Console;

import Controller.Menu;
import View.View;
import java.util.Scanner;

/**
 * A class which represent the menu of the game in the console.
 *
 * @author Raphaël
 */
public class MenuView implements View {
	
	/**
	 * Attribute that represents the menu of the game
	 */
	private Menu menu;
	
	/**
	 * Attribute that allow to leave the game
	 */
	private boolean leave = false;

	/**
	 * Basic constructor of the view menu
	 * @param m the menu of the game 
	 */
	public MenuView(Menu m) {
		this.menu = m;
	}

	/**
	 * This method show the actual setting of the game and ask the player to change
	 * these settings or the run the game. If the informations entered are not valid
	 * the menu will continues to ask the player to change the settings
	 */
	@Override
	public void show() {
		boolean goodChoice = false;
		int choice = 0;
		while (!goodChoice) {
			System.out.println("What do you want to do ?");
			System.out.println("1. Play the game");
			System.out.println("2. Set your name (currently : " + this.menu.getPlayerName() + ")");
			System.out.println(
					"3. Set the rule (currently : " + this.menu.getListRule().get(this.menu.getRuleToApply()) + ")");
			System.out.println("4. Set the level of the AI (currently : level " + this.menu.getLevelOfAI() + ")");
			System.out.println("5. Set the number of AI (currently : " + this.menu.getNbIA() + ")");
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
			} finally {
				sc.close();
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
			this.leave = true;
			break;
		}

	}

	@Override
	public void update() {
		System.out.println("Welcome in the 8 american simulator !");
		while (!leave) {
			this.show();
		}
	}
	
	/**
	 * Method that ask the user to select the name
	 */
	private void setName() {
		String name = "toto";

		System.out.println("Please insert your name : ");
		Scanner sc = new Scanner(System.in);
		name = sc.nextLine();
		sc.close();
		this.menu.setPlayerName(name);

	}
	
	/**
	 * Method to select the rule of the game
	 */
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
			} finally {
				sc.close();
			}
		}
		this.menu.setRuleToApply(choice - 1);
	}
	
	/**
	 * Method to select the level of the game 
	 */
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
			} finally {
				sc.close();
			}
		}
		this.menu.setLevelOfAI(choice - 1);
	}

	/**
	 * Method to select the number of AI
	 */
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
			} finally {
				sc.close();
			}
		}
		this.menu.setNbIA(choice);
	}

}
