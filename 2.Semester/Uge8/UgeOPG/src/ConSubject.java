import java.util.ArrayList;

public class ConSubject implements Subject {
    private int state;
    private ArrayList<Observer> observers;

    public ConSubject(int value) {
        observers = new ArrayList<Observer>();
        changeState(value);
    }

    public void changeState(int value) {
        state = value;

        fire();
    }

    public int getState() {
        return state;
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void deleteObserver(Observer obs) {
        observers.remove(obs);
    }

    private void fire() {
        for (Observer observer : observers)
            observer.update(this);
    }
}