using Microsoft.AspNetCore.Mvc;
using StudentAdministrationSystem.Models;

namespace StudentAdministrationSystem.Controllers
{
    public class HomeController : Controller
    {
        //repository field
        private readonly IStudentRepository repo;
        

        //constructor
        public HomeController(IStudentRepository repo)
        {
            this.repo = repo; 
        }

        public IActionResult Index(int studentPage = 1)
        {
            const int PageSize = 9;

            // EF query (IQueryable)
            var query = repo.Students.OrderBy(s => s.LastName);

            // Pagineret del
            var studentsForPage = query
                                  .Skip((studentPage - 1) * PageSize)
                                  .Take(PageSize)
                                  .ToList(); // materialize som IEnumerable

            var model = new StudentListViewModel
            {
                Students = studentsForPage,   // IEnumerable<Student> passer perfekt
                CurrentPage = studentPage,
                TotalPages = (int)Math.Ceiling(repo.Students.Count() / (double)PageSize)
            };

            return View(model);
        }


        [HttpGet]
        public IActionResult CreateStudent()
        {
            return View();
        }

        [HttpPost]
        public IActionResult CreateStudent(Student student)
        {
            if (ModelState.IsValid)
            {
                repo.AddStudent(student);
                return RedirectToAction("Index");
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
