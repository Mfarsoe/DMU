using Microsoft.AspNetCore.Mvc;

namespace EksamenProjekt.Controllers
{
    public class HomeController : Controller
    {

        public IActionResult Index()
        {
            return View();
        }
    }
}
