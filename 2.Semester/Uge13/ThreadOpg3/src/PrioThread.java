public class PrioThread extends Thread {

    @Override
    public void run() {
        Sleeper.sleep(2);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "PrioThread - [" + getPriority() + "]";
    }
}
