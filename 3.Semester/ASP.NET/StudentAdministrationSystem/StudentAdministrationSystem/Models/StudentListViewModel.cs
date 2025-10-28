using System.Collections.Generic;

namespace StudentAdministrationSystem.Models
{
    public class StudentListViewModel
    {
        public IEnumerable<Student> Students { get; set; } = new List<Student>();
        public int CurrentPage { get; set; }
        public int TotalPages { get; set; }
        public string? EducationFilter { get; set; }
        public List<string>? AvailableEducations { get; set; }
    }
}
