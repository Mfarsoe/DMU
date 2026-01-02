using Bibliotek.Models;
using Microsoft.AspNetCore.Mvc;

namespace Bibliotek.Controllers
{


    public class HomeController : Controller
    {
        private Repository repo;
        public HomeController(Repository repos)
        {
            repo = repos;
        }


        [HttpGet]
        public IActionResult Index()
        {
            var model = new BookViewModel
            {
                books = repo.GetAllBooks()
            };
            return View(model);
        }

        [HttpPost]
        public IActionResult Index(BookViewModel model)
        {
            if (!string.IsNullOrEmpty(model.Title))
            {
                repo.AddBook(new Bog
                {
                    Titel = model.Title,
                    Forfatter = model.Author,
                    Sider = model.Pages
                });
            }
            model.books = repo.GetAllBooks();
            model.TotalPages = model.books.Sum(b => b.Sider);

            return View(model);
        }
    }
}
