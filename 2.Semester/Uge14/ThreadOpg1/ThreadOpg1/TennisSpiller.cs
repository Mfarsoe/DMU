using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThreadOpg1 {
    class TennisSpiller {
        private string name;
        private bool harBold;
        private TennisSpiller modstander;
        Random rnd = new Random();
        private Thread spillerThread;

        public TennisSpiller(String name) {
            this.name = name;

            harBold = false;
            spillerThread = new Thread(Run);
        }

        public void Start() {
            spillerThread.Start();
        }

        public void Join() {
            spillerThread.Join();
        }

        public void Run() {
            while (true) {
                while (!harBold)
                    Thread.Sleep(1);

                Thread.Sleep(rnd.Next(0, 2000));

                if (rnd.Next(0, 100) > 70) {
                    harBold = false;

                    Console.WriteLine(name + " retunerer!");

                    modstander.ModtagBold();
                } else {
                    Console.WriteLine(name + " fumler bolden!");
                    break;

                }
            }

        }
        public void SetModstander(TennisSpiller modstander) {
            this.modstander = modstander;
        }

        public void ModtagBold() {
            harBold = true;
        }
    }
}
