namespace Pagination.Models
{
    public class StudentListViewModel
    {
        public IEnumerable<Student> Students { get; set; }
        public int CurrentPage { get; set; } = 1;
        public int TotalPages { get; set; } = 1;
    }
}
