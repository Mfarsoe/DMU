public class EvenOddTest {
    public static void main(String[] args) throws Exception {
        //Starts server
        ClientManager manager = new ClientManager(12345);
        manager.start();
        System.out.println("Server started on port 12345");
        Thread.sleep(200);
        //makes clients that connects to server

        EOClient c = new EOClient("Alice");
        EOClient c2 = new EOClient("Bob");

        c.start();
        c2.start();

        Thread.sleep(200);
        manager.shutdown();
    }
}
