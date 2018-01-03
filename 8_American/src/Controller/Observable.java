package Controller;

import java.util.ArrayList;

import View.Observer;

public abstract class Observable {

    private ArrayList<Observer> listObservers = new ArrayList<>();

    public void addObserver(Observer obs) {
        this.listObservers.add(obs);
    }

    public void removeObserver(Observer obs) {
        this.listObservers.remove(obs);
    }

    public void notifyAllObs() {
        for (Observer obs : listObservers) {
            obs.update();
        }
    }
}
