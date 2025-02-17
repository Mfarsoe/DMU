
public class AlarmObserver implements Observer {
    private int grænseVærdi;

    public AlarmObserver(int grænseVærdi, Subject subject) {
        this.grænseVærdi = grænseVærdi;
        subject.addObserver(this);
    }

    @Override
    public void update(Subject subject) {
        if ( ((ConSubject) subject).getState() > grænseVærdi){
            System.out.println("Alarm!");
        }
    }
}
