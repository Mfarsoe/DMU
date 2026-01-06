namespace Pagination.Models
{
    public class StudentRepository : IStudentRepository
    {
        private readonly List<Student> _students;

        public StudentRepository()
        {
            // Dummy data
            _students = Enumerable.Range(1, 95)
                .Select(i => new Student
                {
                    Id = i,
                    Name = $"Student {i}"
                }).ToList();
        }

        public IEnumerable<Student> GetStudents(int page, int pageSize)
        {
            return _students
                .Skip((page - 1) * pageSize)
                .Take(pageSize)
                .ToList();
        }

        public int GetTotalCount()
        {
            return _students.Count;
        }
        public void AddStudent(Student student)
        {
            _students.Add(student);
        }
    }

}
