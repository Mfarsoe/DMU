import java.io.Serializable;


public class Member implements Serializable{
    private String name;
    private String ID;


    public Member(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public String toString(){
        return "[Name : " + name + "][ID : " + ID + "]";
    }
}
