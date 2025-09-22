public class Rektangel extends Punkt{
    private double length, height;

    public Rektangel(Punkt punkt, double length, double height){
        super(punkt);
        this.length = length;
        this.height = height;
    }

    public double area(){
        return length * height;
    }

    public double perimeter(){
        return 2 * (length + height);
    }

    public String toString(){
        return "[" + super.toString() + ", " + length + "x" + height + "]";
    }
}
