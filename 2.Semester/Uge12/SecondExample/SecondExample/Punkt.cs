using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SecondExample {
    class Punkt {
        private double x, y;

        public Punkt(double x, double y) {
            this.x = x;
            this.y = y;
        }


        public void getXY(out double xx, out double yy) {
            xx = this.x;
            yy = this.y;
        }

        public double this[int i] {
            get {
                if (i == 0)
                    return x;
                else if (i == 1)
                    return y;
                else
                    throw new IndexOutOfRangeException();
            }
            set {
                if (i == 0)
                    x = value;
                else if (i == 1)
                    y = value;
                else
                    throw new IndexOutOfRangeException();
            }
        }

        public override string ToString() {
            return $"({x}, {y})";
        }
    }
}
