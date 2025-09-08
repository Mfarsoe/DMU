using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Opgave_B.Server
{
    public class SkeletonManager
    {
        private List<SkeletonWorker> workers;
        private int port;
        private bool stop;

        private bool waitForTermination;
        private System.Threading.Thread thread;
        public SkeletonManager(int port)
        {
            this.port = port;
            workers = new List<SkeletonWorker>();
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
                System.Net.Sockets.TcpListener server = new System.Net.Sockets.TcpListener(System.Net.IPAddress.Any, port);
                server.Start();
                Console.WriteLine("Server online");
                while (!stop)
                {
                    if (server.Pending())
                    {
                        System.Net.Sockets.Socket connection = server.AcceptSocket();
                        SkeletonWorker worker = new SkeletonWorker(this, connection);
                        workers.Add(worker);
                        worker.Start();
                    }
                    else
                    {
                        System.Threading.Thread.Sleep(100);
                    }
                }
                foreach (SkeletonWorker worker in workers)
                {
                    worker.Shutdown(waitForTermination);
                }
                Console.WriteLine("Server offline");
            }
            catch (System.IO.IOException)
            {
                Console.WriteLine("I/O error");
            }
        }
        public void Shutdown(bool waitForTermination)
        {
            this.waitForTermination = waitForTermination;
            stop = true;
            if (thread != null)
                thread.Join();
        }
        internal void RemoveWorker(SkeletonWorker worker)
        {
            workers.Remove(worker);
        }

    }
}
