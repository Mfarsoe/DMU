using Microsoft.AspNetCore.Mvc;
using StudentAdministrationSystem.Models;

namespace StudentAdministrationSystem.Controllers
{
    public class HomeController : Controller
    {
        //repository field
        private readonly IStudentRepository _repo;

        //constructor
        public HomeController(IStudentRepository repo = null)
        {
            _repo = repo ?? new StudentRepository(); // fallback to new instance
        }

        public IActionResult Index()
        {
            return View(_repo.Students);
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
                _repo.AddStudent(student);
                return View("Index", _repo.Students);
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
