public class Main {
    public static void main(String[] args) {
        School s = new School("EAMV");
        Student a = new Student("John", 10);
        Student b = new Student("Jane", 20);
        Student c = new Student("Bob", 30);
        Teacher d = new Teacher("Dan", 30);

        d.addStudent(a);
        d.addStudent(b);
        d.addStudent(c);
        System.out.println(d.getStudents());
        d.removeStudent(a);
        System.out.println(d.getStudents());
        s.addTeacher(d);
        System.out.println(s.getTeachers());

        System.out.println("På skolen " + s.getName() + " underviser " + d.getName() + " Og har eleverne " + d.getStudents());




    }
}
