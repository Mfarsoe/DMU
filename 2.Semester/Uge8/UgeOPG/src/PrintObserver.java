public class PrintObserver implements Observer {

    @Override
    public void update(Subject subject) {
        System.out.println("State changed to: " + ((ConSubject) subject).getState());
    }

    public PrintObserver(Subject subject) {
        subject.addObserver(this);
    }
}
