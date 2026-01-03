using Dagligvare.Models;
using Microsoft.AspNetCore.Mvc;

namespace Dagligvare.Controllers
{
    public class HomeController : Controller
    {
        [HttpGet]
        public IActionResult Index()
        {
            var model = new ViewModel();
            model.Varer.Add(new Vare { Navn = "Brød", Pris = 20.5m });
            model.Varer.Add(new Vare { Navn = "Mælk", Pris = 15.0m });
            model.Varer.Add(new Vare { Navn = "Ost", Pris = 35.75m });
            return View(model);
        }
        [HttpPost]
        public IActionResult Index(ViewModel model)
        {
            decimal totalPris = 0;

            foreach (var vare in model.Varer)
            {
                totalPris += vare.Pris * vare.Antal;
            }

            model.TotalPris = (double?)totalPris;

            return View(model);
        }
    }
}
