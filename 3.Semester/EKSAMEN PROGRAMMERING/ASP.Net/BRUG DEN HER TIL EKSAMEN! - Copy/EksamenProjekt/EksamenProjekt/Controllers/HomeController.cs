using EksamenProjekt.Models;
using Microsoft.AspNetCore.Mvc;

namespace EksamenProjekt.Controllers
{
    public class HomeController : Controller
    {
        private readonly Repository _repository;

        public HomeController(Repository repo)
        {
            _repository = repo;
        }

        [HttpGet]
        public IActionResult Index()
        {
            var model = new DrikkevareViewModel
            {
                Drikkevarer = _repository.HentDrikkevarer()
            };

            return View(model);
        }

        [HttpPost]
        public IActionResult Index(DrikkevareViewModel model)
        {
            model.Drikkevarer = _repository.HentDrikkevarer();

            var valgtDrik = model.Drikkevarer.FirstOrDefault(d => d.Navn == model.ValgtDrik);

            if (valgtDrik != null)
            {
                var pris = valgtDrik.Pris;
                model.TotalPris = pris * model.Antal;

            }
            return View(model);
        }


    }
}
