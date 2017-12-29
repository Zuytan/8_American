package Controller.Graphical;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Controller.Menu;
import View.Graphical.ViewMenu;

public class MenuController implements MouseListener{
	private Menu m;
	private ViewMenu vm;
	
	public MenuController(Menu m, ViewMenu vm) {
		this.m = m;
		this.vm = vm;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.m.setLevelOfAI(this.vm.getStrategy().getSelectedIndex());
		this.m.setNbIA((int)this.vm.getNbAI().getSelectedItem());
		this.m.setPlayerName(this.vm.getName().getText());
		this.m.setRuleToApply(this.vm.getRule().getSelectedIndex());
		this.vm.getWin().setVisible(false);
		this.m.play();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
