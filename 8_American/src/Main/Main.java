package Main;

import Controller.Menu;
import Controller.MinimalRule;
import Controller.MonclarRule;
import Controller.Rule;
import Model.IStrategy;
import Model.StrategyRandom;
import Model.StrategyStupid;
import View.MenuView;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<IStrategy> listStrategy = new ArrayList();
        ArrayList<Rule> listRule = new ArrayList();
        
        listStrategy.add(new StrategyRandom());
        listStrategy.add(new StrategyStupid());

        listRule.add(new MinimalRule());
        listRule.add(new MonclarRule());
        
        Menu m = new Menu(listStrategy, listRule);
        MenuView mv = new MenuView(m);
        
        m.addObserver(mv);
        m.start();
           
    }

}
