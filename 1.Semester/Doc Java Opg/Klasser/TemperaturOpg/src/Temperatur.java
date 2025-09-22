public class Temperatur {
    // DataKerne
    private double temp;

    // Default Constructor
    public Temperatur() {
        temp = 0;
    }
    // Copy Constructor
    public Temperatur(Temperatur other) {
        this.temp = other.temp;
    }

    //Celcius Get
    public double getCelcius() {
        return temp;
    }
    //Celcius Set
    public void setCelcius(double celcius) {
        temp = celcius;
    }
    //Fahrenheit Get
    //Convert to Fahrenheit
    public double getFahrenheit() {
        return temp * 9.0/5.0 + 32;
    }
    //Fahrenheit set
    public void setFahrenheit(double f) {
        temp = (5.0/9.0 * f) - (17 + 7.0/9.0);
    }

    public String toString() {
        return "["+ getCelcius() + "C, " + getFahrenheit() + "F]";
    }

    //equals - Sprøg Flemming - Hvorfor han i sin løsning laver metodekald og ikke bare bruger other.int.
    public boolean equals(Temperatur other) {
        return temp == other.temp;
    }

    //compareTo Service
    private int signum(double diff) {
        if (diff < 0.0) {
            return -1;
        } else if (diff > 0.0) {
            return 1;
        } else
            return 0;
    }
    //compareTo
    public int compareTo(Temperatur other) {
        return signum(this.temp - other.temp);
    }








}
