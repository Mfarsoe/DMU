using ElevKarakter.Models;
using Microsoft.AspNetCore.Mvc;
using System.Reflection;

namespace ElevKarakter.Controllers
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
            var model = new ElevViewModel
            {
                Elevlist = repo.GetStudents()
            };
            return View(model);
        }

        [HttpPost]
        public IActionResult Index(ElevViewModel model)
        {
            if (!string.IsNullOrEmpty(model.Navn))
            {
                repo.AddStudent(new Elev(model.Navn, model.Karakter));
            }
           
            model.Elevlist = repo.GetStudents();
            return View(model);
        }
    }
}
