using RazorPages.Models;
using RazorPages.Services;
using RazorPages.Models;
using System.Collections.Generic;

namespace RazorPages.Services
{
    public class InMemoryPersonRepository : IPersonRepository
    {
        private readonly List<Person> _people = new();

        public void Add(Person person)
        {
            _people.Add(person);
        }

        public List<Person> GetAll()
        {
            return new List<Person>(_people); // returnér kopi for sikkerhed
        }
    }
}
