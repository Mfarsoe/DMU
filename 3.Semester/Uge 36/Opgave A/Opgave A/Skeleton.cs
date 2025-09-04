using System;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;

namespace Opgave_A
{
    public class Skeleton
    {
        private readonly int port;
        private Thread serverThread;
        private bool running = false;

        public Skeleton(int port)
        {
            this.port = port;
        }

        public void Start()
        {
            running = true;
            serverThread = new Thread(Run);
            serverThread.IsBackground = true;
            serverThread.Start();
            Console.WriteLine($"[SERVER] Skeleton kører på port {port}");
        }

        private void Run()
        {
            Socket serverSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            serverSocket.Bind(new IPEndPoint(IPAddress.Any, port));
            serverSocket.Listen(10);

            while (running)
            {
                Socket clientSocket = serverSocket.Accept();
                Console.WriteLine("[SERVER] Klient forbundet.");

                byte[] buffer = new byte[4096];
                int received = clientSocket.Receive(buffer);
                string xml = Encoding.UTF8.GetString(buffer, 0, received);
                Console.WriteLine("[SERVER] Modtog XML:\n" + xml);

                Person p = new Person();
                p.FromXML(xml);

                Console.WriteLine("[SERVER] Modtog person: " + p);

                clientSocket.Shutdown(SocketShutdown.Both);
                clientSocket.Close();
            }
        }

        public void Stop()
        {
            running = false;
            serverThread?.Join();
        }
    }
}
