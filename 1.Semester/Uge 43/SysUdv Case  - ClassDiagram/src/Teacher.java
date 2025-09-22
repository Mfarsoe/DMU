import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private List<Student> Students = new ArrayList<>();

    public Teacher(String name, int age) {
        super(name, age);
    }

    public void addStudent(Student student) {
        Students.add(student);
    }

    public void removeStudent(Student student) {
        Students.remove(student);
    }

    public List<Student> getStudents() {
        return Students;
    }
}