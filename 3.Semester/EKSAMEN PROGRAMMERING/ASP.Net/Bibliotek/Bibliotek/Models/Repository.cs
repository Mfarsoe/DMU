namespace Bibliotek.Models
{
    public class Repository
    {
        private List<Bog> books;
        public Repository()
        {
            books = new List<Bog>
            {
                new Bog { Titel = "Den Lille Prins", Forfatter = "Antoine de Saint-Exupéry", Sider = 96 },
                new Bog { Titel = "1984", Forfatter = "George Orwell", Sider = 328 },
                new Bog { Titel = "Brave New World", Forfatter = "Aldous Huxley", Sider = 288 },
                new Bog { Titel = "Fahrenheit 451", Forfatter = "Ray Bradbury", Sider = 194 }
            };
        }
        public List<Bog> GetAllBooks()
        {
            return books;
        }
        public void AddBook(Bog book)
        {
            books.Add(book);
        }
        public void RemoveBook(Bog book) {
                        books.Remove(book);
        }
    }
}
