public class Main {
    public static void main(String[] args) {
        TennisSpiller t1 = new TennisSpiller("John John");
        TennisSpiller t2 = new TennisSpiller("Karl Karl");

        t1.setModstander(t2);
        t2.setModstander(t1);

        t1.start();
        t2.start();

        t1.modtagBold();
    }
}
