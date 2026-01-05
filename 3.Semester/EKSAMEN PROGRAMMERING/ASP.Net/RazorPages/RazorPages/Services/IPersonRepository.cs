using RazorPages.Models;

namespace RazorPages.Services
{
    public interface IPersonRepository
    {
        void Add(Person person);
        List<Person> GetAll();
    }
}
