using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace Opgave_B.Client
{
    public class Stub : IMethodImpl
    {
        private string host;
        private int port;
        private StreamReader reader;
        private StreamWriter writer;
        public Stub(string host, int port)
        {
            this.host = host;
            this.port = port;
        }



        public void send(Person person)
        {
            try
            {
                using (Socket connection = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
                {
                    connection.Connect(new IPEndPoint(IPAddress.Parse(host), port));
                    using (NetworkStream stream = new NetworkStream(connection))
                    using (reader = new StreamReader(stream))
                    using (writer = new StreamWriter(stream))
                    {
                        string xml = person.ToXml();
                        SendLine(xml);
                    }
                }
            }
            catch
            {
                Console.WriteLine("Could not connect to server");
            }
        }

        public Person Oldest(Person p1, Person p2)
        {
            using(Socket connection = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))
            {
                connection.Connect(new IPEndPoint(IPAddress.Parse(host), port));
                using (NetworkStream stream = new NetworkStream(connection))
                using (reader = new StreamReader(stream))
                using (writer = new StreamWriter(stream))
                {
                    string requestXml = BuildOldestXml(p1, p2);
                    SendLine(requestXml);
                    string responseXml = reader.ReadLine();
                    Person oldest = new Person();
                    oldest.FromXml(responseXml);
                    return oldest;
                }
            }
        }

        private string BuildOldestXml(Person p1, Person p2)
        {
            using(StringWriter sw = new StringWriter())
            {
                using (XmlWriter writer = XmlWriter.Create(sw))
                {
                    writer.WriteStartElement("oldest");
                    p1.ToXml(writer);
                    p2.ToXml(writer);
                    writer.WriteEndElement();
                    writer.Flush();
                    return sw.ToString();
                }
            }
        }

        public void SendLine(string line)
        {
            Console.WriteLine("Sending line: " + line);
            writer.WriteLine(line);
            writer.Flush();
        }
    } 
}
