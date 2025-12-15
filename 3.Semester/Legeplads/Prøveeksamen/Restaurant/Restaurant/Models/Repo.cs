
namespace Restaurant.Models
{
    public class Repo : IRepo
    {
        public IEnumerable<Vare> GetMenuItems()
        {
            return new List<Vare>
            {
                new Vare { Name = "Pasta", Price = 90.00m },
                new Vare { Name = "Pizza", Price = 70.00m },
                new Vare { Name = "Risret", Price = 50.00m }
            };
        }
    }
}
