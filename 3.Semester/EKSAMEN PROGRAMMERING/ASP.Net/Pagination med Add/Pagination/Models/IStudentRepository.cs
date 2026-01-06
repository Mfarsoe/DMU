namespace Pagination.Models
{
    public interface IStudentRepository
    {
        IEnumerable<Student> GetStudents(int page, int pageSize);

        void AddStudent(Student student);
        int GetTotalCount();
    }
}
