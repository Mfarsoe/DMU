import java.io.Serializable;


public class Member implements Serializable{
    private String name;
    private String ID;
    private String password;


    public Member(String name, String ID, String password) {
        this.name = name;
        this.ID = ID;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public String toString(){
        return "[Name : " + name + "][ID : " + ID + "][Password : " + password + "]";
    }
}
