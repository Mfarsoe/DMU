using StudentAdministrationSystem.Models;

public interface IStudentRepository
{
    IQueryable<Student> Students { get; }
    void AddStudent(Student student);

    void EditStudent(Student student);

    void DeleteStudent(Student student);

    IEnumerable<Student> GetAllStudents();
}