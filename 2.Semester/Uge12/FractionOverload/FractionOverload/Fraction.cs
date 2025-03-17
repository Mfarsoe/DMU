using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FractionOverload {
    public class Fraction {

        private int numerator;
        private int denominator;

        //Constructor
        public Fraction(int numerator, int denominator) {
            //Throw exception da nævner ikke må være 0
            if (denominator == 0)
                throw new DivideByZeroException("Nævneren må ikke være 0");

            this.numerator = numerator;
            this.denominator = denominator;

            //
            simplify();
        }

        //Operator Overloading
        public static Fraction operator +(Fraction a, Fraction b) {
            //Finder lcm og udregner nye numerators ud fra lcm.
            int lcm = a.LCM(a.denominator, b.denominator);
            int newNumeratorA = a.numerator * (lcm / a.denominator);
            int newNumeratorB = b.numerator * (lcm / b.denominator);
            //Laver udregningen ud fra operator og retunere Fraction med resultat og lcm
            int resultNumerator = newNumeratorA + newNumeratorB;
            return new Fraction(resultNumerator, lcm);
        }

        public static Fraction operator -(Fraction a, Fraction b) {
            //Finder lcm og udregner nye numerators ud fra lcm.
            int lcm = a.LCM(a.denominator, b.denominator);
            int newNumeratorA = a.numerator * (lcm / a.denominator);
            int newNumeratorB = b.numerator * (lcm / b.denominator);
            //Laver udregningen ud fra operator og retunere Fraction med resultat og lcm
            int resultNumerator = newNumeratorA - newNumeratorB;
            return new Fraction(resultNumerator, lcm);
        }

        public static Fraction operator *(Fraction a, Fraction b) {
            //Udregner nye numerator og denominator udfra operator
            int newNumerator = a.numerator * b.numerator;
            int newDenominator = a.denominator * b.denominator;

            return new Fraction(newNumerator, newDenominator);
        }

        public static Fraction operator /(Fraction a, Fraction b) {
            //Throw exeception hvis man dividere med 0
            if (b.numerator == 0)
                throw new DivideByZeroException("Du kan ikke dividere med 0!");
            //For at dividere "vender man den bagerste brøk på hovedet" og ganger dem derefter.
            int newNumerator = a.numerator * b.denominator;
            int newDenominator = a.denominator * b.numerator;

            return new Fraction(newNumerator, newDenominator);
        }

        //Service

        //Finder Greatest Common Denominator
        private int GCD(int a, int b) {
            // Euklids algoritme der gentager sig selv indtil b = 0. Når det sker er {a} vores gcd og den retuneres.
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return Math.Abs(a);
        }

        //Finder Least Common Multiple
        //Mindste tal som begge tal kan divideres med uden at efterlade en rest. dvs laveste fællesnævner
        private int LCM(int a, int b) {
            return Math.Abs(a * b) / GCD(a, b);
        }

        // Forkorter brøken ved at dividere tæller og nævner med deres GCD
        private void simplify() {
            int gcd = GCD(Math.Abs(numerator), Math.Abs(denominator));
            numerator /= gcd;
            denominator /= gcd;

            // Håndterer fortegn
            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
        }



        //ToString override
        public override string ToString() {
            return $"{numerator}/{denominator}";
        }
    }
}
