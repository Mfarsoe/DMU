using System.ComponentModel.DataAnnotations;

namespace Pagination.Models
{
    public class StudentCreateViewModel
    {
        [Required]
        public string Name { get; set; }

        [Required]
        [Range(1, 150)]
        public int Age { get; set; }

        public int CurrentPage { get; set; } = 1; // sender med til POST
    }

}
