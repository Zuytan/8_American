package View.Graphical;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Menu;
import Controller.Graphical.MenuController;

/**
 * The class that represent the view of the menu
 * @author Alexandre
 * @see Controller.Menu
 * @see JFrame
 *
 */
public class ViewMenu{
	/**
	 * The windows of the menu
	 */
	private JFrame win;
	
	/*
	 * The menu of the game 
	 */
	private Menu m;
	
	/**
	 * The combo box of the number of AI
	 */
	private JComboBox<Integer> nbAI;
	
	/**
	 * The combo box of the different strategy of the AI 
	 */
	private JComboBox<Object> strategy;
	
	/**
	 * The combo box of the differents rules
	 */
	private JComboBox<Object> rule;
	
	/**
	 * The field for the name of the player
	 */
	private JTextField name;
	
	/**
	 * The basic constructor of the menu
	 * @param m The menu 
	 */
	public ViewMenu(Menu m) {
		this.m = m;
		this.win = new JFrame("8 american Simulator");
		this.win.setMinimumSize(new Dimension(300,400));
		this.win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.win.setResizable(false);
		this.win.setLayout(new BorderLayout());
		
		JPanel optionPane = new JPanel(new GridLayout(4,2));
		this.win.add(optionPane, BorderLayout.CENTER);
		
		JLabel nameLabel = new JLabel("Name :");
		optionPane.add(nameLabel);
		this.name = new JTextField(this.m.getPlayerName());
		optionPane.add(this.name);
		
		JLabel nbAILabel = new JLabel("Number of AI :");
		optionPane.add(nbAILabel);
		Integer[] numberAI = {2,3,4};
		this.nbAI = new JComboBox<>(numberAI);
		this.nbAI.setSelectedItem(this.m.getNbIA());
		optionPane.add(this.nbAI);
		
		JLabel strategyLabel = new JLabel("Select Strategy :");
		optionPane.add(strategyLabel);
		this.strategy = new JComboBox<>(this.m.getListStrategy().toArray());
		this.strategy.setSelectedIndex(this.m.getLevelOfAI());
		optionPane.add(this.strategy);
		
		JLabel ruleLabel = new JLabel("Select Rule :");
		optionPane.add(ruleLabel);
		this.rule = new JComboBox<>(this.m.getListRule().toArray());
		this.rule.setSelectedIndex(this.m.getRuleToApply());
		optionPane.add(this.rule);
		
		JPanel playNClosePane = new JPanel(new GridLayout(1,2));
		this.win.add(playNClosePane, BorderLayout.SOUTH);
		
		JButton playButton = new JButton("Play");
		playNClosePane.add(playButton);
		playButton.addMouseListener(new MenuController(this.m, this));
		
		JButton closeButton = new JButton("Close");
		playNClosePane.add(closeButton);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}	
		});
		
		this.win.setVisible(true);
	}

	/**
	 * Getter of the number of AI
	 * @return the number of AI
	 */
	public JComboBox<Integer> getNbAI() {
		return nbAI;
	}

	/**
	 * Getter of the strategy
	 * @return the strategy
	 */
	public JComboBox<Object> getStrategy() {
		return strategy;
	}

	/**
	 * Getter of the rule
	 * @return the rule
	 */
	public JComboBox<Object> getRule() {
		return rule;
	}

	/**
	 * Getter of the name
	 * @return the name of the player
	 */
	public JTextField getName() {
		return name;
	}

	/**
	 * Getter of the window
	 * @return the window of the game
	 */
	public JFrame getWin() {
		return win;
	}
	
}
