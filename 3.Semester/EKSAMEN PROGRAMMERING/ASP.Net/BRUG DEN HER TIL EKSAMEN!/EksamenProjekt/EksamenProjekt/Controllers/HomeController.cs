using EksamenProjekt.Models;
using Microsoft.AspNetCore.Mvc;
using System.Text;

namespace EksamenProjekt.Controllers
{
    public class HomeController : Controller
    {
        [HttpGet]
        public IActionResult Index()
        {
            var model = new ViewModel();
            return View(model);
        }

        [HttpPost]
        public IActionResult Index(ViewModel viewModel)
        {
            if (ModelState.IsValid)
            {
                if (viewModel.LineBreaks)
                {
                         viewModel.OutputText += serviceMethod(viewModel.Count, viewModel.InputText, "\n");

                }
                else
                {
                    viewModel.OutputText = serviceMethod(viewModel.Count, viewModel.InputText, " ");
                }
            }
            return View(viewModel);
        }

        private string serviceMethod(int count, string input, string d)
        {
            StringBuilder strB = new StringBuilder();
            for (int i = 0; i < count; i++)
            {
                strB.Append(input);
                strB.Append(d);
            }
            return strB.ToString();
        }
    }
}
