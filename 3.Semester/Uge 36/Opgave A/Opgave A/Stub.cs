using System;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace Opgave_A
{
    public class Stub
    {
        private readonly string host;
        private readonly int port;

        public Stub(string host, int port)
        {
            this.host = host;
            this.port = port;
        }

        public void Send(Person p)
        {
            Socket clientSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            clientSocket.Connect(new IPEndPoint(IPAddress.Parse(host), port));

            string xml = p.ToXML();
            Console.WriteLine(p.ToXML());
            byte[] data = Encoding.UTF8.GetBytes(xml);
            clientSocket.Send(data);
            
            Console.WriteLine("[CLIENT] Sendte person til server: " + p);

            clientSocket.Shutdown(SocketShutdown.Both);
            clientSocket.Close();
        }
    }
}
