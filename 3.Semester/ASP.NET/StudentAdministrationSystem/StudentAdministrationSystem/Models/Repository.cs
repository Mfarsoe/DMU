namespace StudentAdministrationSystem.Models
{
    public class StudentRepository : IStudentRepository
    {
        private readonly List<StudentViewModel> _students = new List<StudentViewModel>();

        public IEnumerable<StudentViewModel> Students => _students;

        public void AddStudent(StudentViewModel student)
        {
            _students.Add(student);
        }
    }
}
