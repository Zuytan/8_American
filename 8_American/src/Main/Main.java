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
        System.out.println("miaou"+Thread.currentThread().getName());
        ArrayList<IStrategy> listStrategy = new ArrayList();
        ArrayList<Rule> listRule = new ArrayList();
        
        listStrategy.add(new StrategyRandom());
        listStrategy.add(new StrategyStupid());

        listRule.add(new MinimalRule());
        listRule.add(new MonclarRule());
        
        Menu m = new Menu(listStrategy, listRule);
        System.out.println("1 "+Thread.currentThread().getName());
        ViewMenu mv = new ViewMenu(m);
        System.out.println("2 "+Thread.currentThread().getName());
        m.addObserver(mv);
        System.out.println("3 "+Thread.currentThread().getName());
        m.start();
        System.out.println("4 "+Thread.currentThread().getName());
           
    }

}
