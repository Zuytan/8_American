package Main;

import Controller.Menu;
import Controller.MinimalRule;
import Controller.MonclarRule;
import Controller.Rule;
import Model.IStrategy;
import Model.StrategyEffectCard;
import Model.StrategyRandom;
import Model.StrategyStupid;
import View.Graphical.ViewMenu;

import java.util.ArrayList;

/**
 * A class which is the start point of the program. Here we indicate the
 * different Stategy and Rule who will be available for the game.
 *
 * @author Raphaël
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<IStrategy> listStrategy = new ArrayList<>();
        ArrayList<Rule> listRule = new ArrayList<>();

        listStrategy.add(new StrategyRandom());
        listStrategy.add(new StrategyStupid());
        listStrategy.add(new StrategyEffectCard());

        listRule.add(new MinimalRule());
        listRule.add(new MonclarRule());

        Menu m = new Menu(listStrategy, listRule);
        new ViewMenu(m);
        m.start();
    }

}
