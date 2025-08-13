import java.io.*;
import java.net.*;


public class Client extends Thread {
    private DatagramSocket socket;
    @Override
    public void run() {
        try{
            socket = new DatagramSocket();

            DatagramSocket server = new DatagramSocket(8889);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("[Client] Online");

            sendLine("Hej Server");
            server.receive(packet);
            getLine(packet);
            sendLine("Test test bla bla");
            server.receive(packet);
            getLine(packet);
            sendLine("<end>");


            System.out.println("[Client] Disconnected");


        } catch (IOException e){
            System.out.println("[Client] I/O Exception: " + e.getMessage());
        }
    }

    private String getLine(DatagramPacket packet){
        String s = new String(packet.getData(), 0 , packet.getLength());
        System.out.println("[Client] received line: " + s);
        return s;
    }

    private void sendLine(String line) throws IOException {
        byte[] buffer = line.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 8888);
        System.out.println("[Client] sending: " + line);
        socket.send(packet);
    }
}
