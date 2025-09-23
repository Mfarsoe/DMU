using System.ComponentModel.DataAnnotations;

namespace PartyInvites.Models
{
    public class GuestResponse
    {
        [Required(ErrorMessage = "Please enter your name")]
        public string? Name { get; set; }
        [Required(ErrorMessage = "Please enter your email address")]
        public string? Email { get; set; }
        [Required(ErrorMessage = "Please enter your address")]
        public string? Address { get; set; }
        [Required(ErrorMessage = "Please enter your phone number")]
        public string? Phone { get; set; }
        [Required(ErrorMessage = "Please specify whether you will attend")]
        public bool? WillAttend { get; set; }
        [Required(ErrorMessage = "Please enter the number of participants")]
        [Range(1, 20, ErrorMessage = "Please enter a number between 1 and 20")]
        public int? Participants { get; set; }

    }
}