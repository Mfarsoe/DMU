using StudentAdministrationSystem.Models;

public interface IStudentRepository
{
    IQueryable<Student> Students { get; }
    void AddStudent(Student student);
    IEnumerable<Student> GetAllStudents();
}