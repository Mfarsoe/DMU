using System.ComponentModel.DataAnnotations;

namespace EmptyProject.Models
{
    public class EmptyViewModel
    {
        [Required(ErrorMessage = "Message is required.")]
        public string Message { get; set; } = "Hello from EmptyViewModel!";
    }
}
