public class Farve {
    private int Red;
    private int Green;
    private int Blue;

    //Default-Constructor
    public Farve() {
        this(0,0,0);
    }
    //Set-Constructor
    public Farve(int red, int green, int blue) {
        set(red, green, blue);
    }
    //Copy-Constructor
    public Farve(Farve other) {
        this(other.Red, other.Green, other.Blue);
        }
    //toString
    public String toString() {
        if (Red==255 && Green==0 && Blue==0) {
            return "[Rød]";
        } else if (Red==0 && Green==255 && Blue==0) {
            return "[Green]";
        } else if (Red==0 && Green==0 && Blue==255) {
            return "[Blue]";
        } else if (Red==0 && Green==0 && Blue==0) {
            return "[Sort]";
        } else {
            return "[" + Red + ", " + Green + ", " + Blue + "]";
        }
    }

    //SetMethod
    public void set(int red, int green, int blue) {

        this.Red = normalize(red);
        this.Green = normalize(green);
        this.Blue = normalize(blue);
    }
    //Normalize Number to be between 0 and 255
    private int normalize(int normNumber) {
        if (normNumber > 255)
            return 255;
        else if (normNumber < 0)
            return 0;
        else
            return normNumber;
    }
    //Equal
    public boolean equals(Farve other) {
        return (this.Red==other.Red &&
                this.Green==other.Green &&
                this.Blue==other.Blue);
        }
}

