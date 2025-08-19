public class ClientTest {
    public static void main(String[] args) throws Exception {
        //Starts server
        ClientManager manager = new ClientManager(12345);
        manager.start();
        System.out.println("Server started on port 12345");

        //makes clients that connects to server
        ChatClient alice = new ChatClient("localhost", 12345);
        ChatClient bob   = new ChatClient("localhost", 12345);

        //Alice logs in
        alice.send("LOGIN Alice");
        System.out.println("Alice -> " + alice.receive());

        //Bob logs in
        bob.send("LOGIN Bob");
        System.out.println("Bob -> " + bob.receive());

        //Alice sends a message to Bob
        alice.send("MESSAGE Bob Hej Bob!");
        System.out.println("Alice -> " + alice.receive());

        //Bob gets message
        bob.send("GET");
        System.out.println("Bob -> " + bob.receive());

        //Bob sends a message to Alice
        bob.send("MESSAGE Alice Hej Alice, jeg har fået din besked!");
        System.out.println("Bob -> " + bob.receive());

        //Alice gets message
        alice.send("GET");
        System.out.println("Alice -> " + alice.receive());

        //Alice gets message (expected no messages)
        alice.send("GET");
        System.out.println("Alice -> " + alice.receive());

        //Both logs out - Closes threads
        alice.send("LOGOUT");
        System.out.println("Alice -> " + alice.receive());

        bob.send("LOGOUT");
        System.out.println("Bob -> " + bob.receive());


        //Close Server
        manager.shutdown();
    }
}
