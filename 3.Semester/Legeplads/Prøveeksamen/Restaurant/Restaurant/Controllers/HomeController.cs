using Microsoft.AspNetCore.Mvc;
using Restaurant.Models;

namespace Restaurant.Controllers
{
    public class HomeController : Controller
    {
        private readonly IRepo repo;


        public HomeController(IRepo repo)
        {
            this.repo = repo;
        }
        [HttpGet]
        public IActionResult Index()
        {
            var menuItems = repo.GetMenuItems();
            return View(menuItems);
        }
        [HttpPost]
        public IActionResult Index(int age)
        {
            return View(age);
        }


        public IActionResult CheckAge()
        {
             return View();
        }
    }
}
