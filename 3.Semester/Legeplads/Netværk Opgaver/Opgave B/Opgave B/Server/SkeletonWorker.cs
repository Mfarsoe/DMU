using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Opgave_B.Server
{
    internal class SkeletonWorker
    {
        private SkeletonManager manager;
        private System.Net.Sockets.Socket connection;
        private System.Threading.Thread thread;
        private bool stop;
        public SkeletonWorker(SkeletonManager manager, System.Net.Sockets.Socket connection)
        {
            this.manager = manager;
            this.connection = connection;
            stop = false;
        }
        public void Start()
        {
            thread = new System.Threading.Thread(Run);
            thread.Start();
        }
        private void Run()
        {
            try
            {
                using (System.Net.Sockets.NetworkStream stream = new System.Net.Sockets.NetworkStream(connection))
                using (System.IO.StreamReader reader = new System.IO.StreamReader(stream))
                using (System.IO.StreamWriter writer = new System.IO.StreamWriter(stream))
                {
                    while (!stop)
                    {
                        if (stream.DataAvailable)
                        {
                            string xml = reader.ReadLine();
                            Person person = new Person();
                            person.FromXml(xml);
                            Console.WriteLine("Received person: " + person);
                        }
                        else
                        {
                            System.Threading.Thread.Sleep(100);
                        }
                    }
                }
            }
            catch (System.IO.IOException)
            {
                Console.WriteLine("I/O error");
            }
            finally
            {
                connection.Close();
                manager.RemoveWorker(this);
            }
        }
        public void Shutdown(bool waitForTermination)
        {
            stop = true;
            if (waitForTermination && thread != null)
                thread.Join();
        }
    }
}
