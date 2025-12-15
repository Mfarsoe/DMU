namespace Restaurant.Models
{
    public interface IRepo
    {
        IEnumerable<Vare> GetMenuItems();
    }
}
