namespace Pagination.Models
{
    public interface IStudentRepository
    {
        IEnumerable<Student> GetStudents(int page, int pageSize);
        int GetTotalCount();
    }
}
