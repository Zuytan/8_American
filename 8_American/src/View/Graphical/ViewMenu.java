package View.Graphical;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Menu;
import Controller.Graphical.MenuController;
import View.View;

public class ViewMenu implements View{
	private JFrame win;
	private Menu m;
	private JComboBox nbAI;
	private JComboBox strategy;
	private JComboBox rule;
	private JTextField name;
	
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
		this.nbAI = new JComboBox(numberAI);
		this.nbAI.setSelectedItem(this.m.getNbIA());
		optionPane.add(this.nbAI);
		
		JLabel strategyLabel = new JLabel("Select Strategy :");
		optionPane.add(strategyLabel);
		this.strategy = new JComboBox(this.m.getListStrategy().toArray());
		this.strategy.setSelectedIndex(this.m.getLevelOfAI());
		optionPane.add(this.strategy);
		
		JLabel ruleLabel = new JLabel("Select Rule :");
		optionPane.add(ruleLabel);
		this.rule = new JComboBox(this.m.getListRule().toArray());
		this.rule.setSelectedIndex(this.m.getRuleToApply());
		optionPane.add(this.rule);
		
		JPanel playNClosePane = new JPanel(new GridLayout(1,2));
		this.win.add(playNClosePane, BorderLayout.SOUTH);
		
		JButton playButton = new JButton("Play");
		playNClosePane.add(playButton);
		playButton.addMouseListener(new MenuController(this.m, this));
		
		JButton CloseButton = new JButton("Close");
		playNClosePane.add(CloseButton);
		
		this.win.setVisible(true);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	public JComboBox getNbAI() {
		return nbAI;
	}

	public JComboBox getStrategy() {
		return strategy;
	}

	public JComboBox getRule() {
		return rule;
	}

	public JTextField getName() {
		return name;
	}

	public JFrame getWin() {
		return win;
	}
	
}
