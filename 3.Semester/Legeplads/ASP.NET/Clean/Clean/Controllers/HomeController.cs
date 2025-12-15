using Microsoft.AspNetCore.Mvc;

namespace Clean.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
