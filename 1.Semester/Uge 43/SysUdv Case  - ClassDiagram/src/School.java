import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private List<Teacher> teachers = new ArrayList<Teacher>();

    public School(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void addTeacher(Teacher t) {
        teachers.add(t);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
}
