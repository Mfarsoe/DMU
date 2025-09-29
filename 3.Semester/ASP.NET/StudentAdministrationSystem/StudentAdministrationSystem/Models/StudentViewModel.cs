using System.ComponentModel.DataAnnotations;

namespace StudentAdministrationSystem.Models
{
    public class StudentViewModel
    {
        [Required(ErrorMessage ="First name is required")]
        public string firstName { set; get; }
        [Required(ErrorMessage ="Last name is required")]
        public string lastName { set; get; }
        [Required(ErrorMessage ="Education is required")]
        public string education { set; get; }
        [Required(ErrorMessage ="Semester is required")]
        [Range(1, 8, ErrorMessage ="Semester must be between 1 and 8")]
        public int semester { set; get; }
        [Required(ErrorMessage ="Email is required")]
        [EmailAddress(ErrorMessage ="Invalid email address")]
        public string email { set; get; }
    }
}
