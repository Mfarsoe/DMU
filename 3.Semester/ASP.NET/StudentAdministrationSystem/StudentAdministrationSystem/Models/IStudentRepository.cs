namespace StudentAdministrationSystem.Models
{
    public interface IStudentRepository
    {
        IEnumerable<StudentViewModel> Students { get; }
        void AddStudent(StudentViewModel student);

        IEnumerable<StudentViewModel> GetAllStudents()
        {
            return Students;
        }
    }
}
