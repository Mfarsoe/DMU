using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using NamePrint.Models;

namespace NamePrint.Controllers;

public class HomeController : Controller
{

    [HttpGet]
    public IActionResult Index()
    {
        return View();
    }

    [HttpPost]
    public IActionResult Index(Name name)
    {
        return View("ShowName",name);
    }

}
