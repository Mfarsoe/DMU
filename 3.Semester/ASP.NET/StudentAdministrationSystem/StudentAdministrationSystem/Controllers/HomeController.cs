using Microsoft.AspNetCore.Mvc;

namespace StudentAdministrationSystem.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
