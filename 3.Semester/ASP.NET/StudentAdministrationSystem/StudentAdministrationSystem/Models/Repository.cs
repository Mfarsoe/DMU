using StudentAdministrationSystem.Models;

public class StudentRepository : IStudentRepository
{
    private readonly StudentDbContext context;
    public StudentRepository(StudentDbContext context)
    {
        this.context = context;
    }

    public IQueryable<Student> Students => context.Students; // live query

    public void AddStudent(Student student)
    {
        context.Students.Add(student);
        context.SaveChanges();
    }

    public IEnumerable<Student> GetAllStudents()
    {
        return context.Students.ToList();
    }
}


