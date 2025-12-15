using EmptyProject.Models;
using Microsoft.AspNetCore.Mvc;

namespace EmptyProject.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
