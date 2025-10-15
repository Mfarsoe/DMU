using System.ComponentModel.DataAnnotations;

namespace StudentAdministrationSystem.Models
{
    public class Student
    {
        [Key]
        public int StudentId { set; get; }
        [Required(ErrorMessage ="First name is required")]
        public string? FirstName { set; get; }
        [Required(ErrorMessage ="Last name is required")]
        public string? LastName { set; get; }
        [Required(ErrorMessage ="Education is required")]
        public string? Education { set; get; }
        [Required(ErrorMessage ="Semester is required")]
        [Range(1, 8, ErrorMessage ="Semester must be between 1 and 8")]
        public int Semester { set; get; }
        [Required(ErrorMessage ="Email is required")]
        [EmailAddress(ErrorMessage ="Invalid email address")]
        public string? Email { set; get; }
    }
}
