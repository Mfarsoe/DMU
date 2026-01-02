using EksamenProjekt.Models;
using Microsoft.AspNetCore.Mvc;

namespace EksamenProjekt.Controllers
{
    public class HomeController : Controller
    {

        private List<Vare> HentMenu()
        {
            return new List<Vare>
            {
                new Vare("Pasta", 90),
                new Vare("Pizza", 70),
                new Vare("Ris", 50)
            };
        }

        // GET: Viser siden første gang
        [HttpGet]
        public IActionResult Index()
        {
            var model = new BestillingViewModel
            {
                Menu = HentMenu()
            };
            return View(model);
        }

        // POST: Kaldes når brugeren sender formularen
        [HttpPost]
        public IActionResult Index(BestillingViewModel model)
        {
            // Menuen skal genoprettes ved postback
            model.Menu = HentMenu(); //HTTP er stateless, så data eksisterer ikke automatisk efter et postback. Derfor skal menuen genoprettes, før den vises igen.

            // Finder den valgte ret i menuen
            var valgtVare = model.Menu.FirstOrDefault(v => v.Navn == model.ValgtRet);

            // Beregner prisen med eventuelle rabatter
            if (valgtVare != null)
            {
                double pris = valgtVare.Pris;
                if (model.Alder < 12)
                {
                    pris *= 0.5;
                }
                else if (model.Alder >= 65)
                {
                    pris *= 0.8;
                }
                // Sætter den beregnede pris i ViewModel
                model.BeregnetPris = pris;
            }
            return View(model);
        }
    }
}
