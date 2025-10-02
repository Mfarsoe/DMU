using StudentAdministrationSystem.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentAdministrationSystem.Tests
{
    public class FakeData : IStudentRepository
    {
        private readonly List<StudentViewModel> _students = new List<StudentViewModel>();

        public IEnumerable<StudentViewModel> Students => _students;

        public void AddStudent(StudentViewModel student)
        {
            _students.Add(student);
        }
    }
}
