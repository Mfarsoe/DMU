namespace Bibliotek.Models
{
    public class BookViewModel
    {
        public string Title { get; set; }
        public string Author { get; set; }
        public int Pages { get; set; }

        public List<Bog> books { get; set; }
        public int ?TotalPages { get; set; }
    }
}
