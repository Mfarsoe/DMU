using System.ComponentModel.DataAnnotations;

namespace EksamenProjekt.Models
{
    public class ViewModel
    {
        [Required(ErrorMessage = "Indtast en tekst")]
        public string? InputText { get; set; }

        [Range(1,100,ErrorMessage = "Vælg et tal mellem 1-100")]
        public int Count { get; set; }

        public string? OutputText { get; set; }
        public bool LineBreaks { get; set; }
        }
}
