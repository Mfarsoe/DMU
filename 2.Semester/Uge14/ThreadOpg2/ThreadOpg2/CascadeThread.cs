using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace ThreadOpg2 {
    class CascadeThread {
        private string navn;
        private bool myTurn;
        private CascadeThread nextC;
        private Thread cascadeThread;



        public CascadeThread(string navn, CascadeThread c) {
            this.navn = navn;
            this.nextC = c;

            this.myTurn = false;
            cascadeThread = new Thread(run);
        }

        public void isMyTurn() {
            myTurn = true;
        }

        public void Start() { cascadeThread.Start(); }

        public void run() {
            while (!myTurn)
                Thread.Sleep(2);
            Console.WriteLine(navn);
            if (nextC != null) {
                nextC.isMyTurn();
            }
        }
    }
}
