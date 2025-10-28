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

        public IActionResult Index(string educationFilter, int studentPage = 1)
        {
            const int PageSize = 9;

            var query = repo.Students.AsQueryable();

            if (!string.IsNullOrEmpty(educationFilter))
                query = query.Where(s => s.Education == educationFilter);

            query = query.OrderBy(s => s.LastName);

            var studentsForPage = query
                                  .Skip((studentPage - 1) * PageSize)
                                  .Take(PageSize)
                                  .ToList();

            var model = new StudentListViewModel
            {
                Students = studentsForPage,
                CurrentPage = studentPage,
                TotalPages = (int)Math.Ceiling(query.Count() / (double)PageSize),
                EducationFilter = educationFilter
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
