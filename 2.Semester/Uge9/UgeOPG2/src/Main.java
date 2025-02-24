public class Main {
    public static void main(String[] args) {
        TextFil.getInstance().register("Test");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TextFil.getInstance().register("Test 2");
        TextFil.getInstance().close();
        TextFil.getInstance().register("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }
}
