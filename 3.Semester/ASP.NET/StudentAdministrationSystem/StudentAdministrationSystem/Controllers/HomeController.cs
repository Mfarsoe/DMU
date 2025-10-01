using Microsoft.AspNetCore.Mvc;
using StudentAdministrationSystem.Models;

namespace StudentAdministrationSystem.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View(Repository.Students);
        }


        [HttpGet]
        public IActionResult CreateStudent()
        {
            return View();
        }

        [HttpPost]
        public IActionResult CreateStudent(StudentViewModel student)
        {
            if (ModelState.IsValid)
            {
                Repository.AddStudent(student);
                return View("Index", Repository.Students);
            }
            return View(student);
        }

        /*
        public IActionResult ListStudents()
        {
            return View(Repository.Students);
        }
        */
    }
}
