public class Student extends Person {

    public Student(String name, int age) {
        super(name, age);
    }

    public String getStudentName() {
        return super.getName();
    }

    public int getStudentAge() {
        return super.getAge();
    }
}
