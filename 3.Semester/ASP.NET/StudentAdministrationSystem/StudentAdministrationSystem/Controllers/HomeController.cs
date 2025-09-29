using Microsoft.AspNetCore.Mvc;
using StudentAdministrationSystem.Models;

namespace StudentAdministrationSystem.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
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
                return View("Confirmation", student);
            }
            return View(student);
        }

        public IActionResult ListStudents()
        {
            return View(Repository.Students);
        }
    }
}
