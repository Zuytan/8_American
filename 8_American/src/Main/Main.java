package Main;

import Controller.Menu;
import Controller.MinimalRule;
import Controller.MonclarRule;
import Controller.Rule;
import Model.Card;
import Model.CardColor;
import Model.CardValue;
import Model.IStrategy;
import Model.StrategyRandom;
import Model.StrategyStupid;
import View.Console.MenuView;
import View.Graphical.ViewMenu;

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
        ViewMenu mv = new ViewMenu(m);
        m.addObserver(mv);
        m.start();
           
    }

}
