public class EvenOddTest {
    public static void main(String[] args) throws Exception {
        //Starts server
        ClientManager manager = new ClientManager(12345);
        manager.start();
        System.out.println("Server started on port 12345");
        Thread.sleep(200);

        int[] test1 = {1,2,3,4,5,6};
        int[] test2 = {2,3,4,5,6,7};
        //makes clients that connects to server
        EOClient c = new EOClient("Alice", test1);
        EOClient c2 = new EOClient("Bob", test2);

        c.start();
        c2.start();

        Thread.sleep(200);
        manager.shutdown();
    }
}
