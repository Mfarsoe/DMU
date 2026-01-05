using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using RazorPages.Models;
using RazorPages.Services;
using RazorPages.Models;
using RazorPages.Services;
using System.Collections.Generic;

namespace RazorPagesDemo.Pages
{
    public class PeopleModel : PageModel
    {
        private readonly IPersonRepository _repository;

        public PeopleModel(IPersonRepository repository)
        {
            _repository = repository;
        }

        [BindProperty]
        public string Name { get; set; }

        [BindProperty]
        public int Age { get; set; }

        public List<Person> PeopleList { get; set; }

        public void OnGet()
        {
            PeopleList = _repository.GetAll();
        }

        public IActionResult OnPost()
        {
            if (!string.IsNullOrWhiteSpace(Name) && Age > 0)
            {
                _repository.Add(new Person { Name = Name, Age = Age });
            }

            PeopleList = _repository.GetAll(); // opdater listen til visning
            return Page(); // ingen redirect, vi vil se listen
        }
    }
}
