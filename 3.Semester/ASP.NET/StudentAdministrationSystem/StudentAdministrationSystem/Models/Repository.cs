namespace StudentAdministrationSystem.Models
{
    public class Repository
    {
        private static List<StudentViewModel> students = new List<StudentViewModel>();
        public static IEnumerable<StudentViewModel> Students => students;

        public static void AddStudent(StudentViewModel student)
        {
            students.Add(student);
        }
        public static List<StudentViewModel> GetAllStudents()
        {
            return students;
        }
    }
}
