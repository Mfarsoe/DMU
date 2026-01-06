using Microsoft.AspNetCore.Mvc;

namespace Pagination.Controllers
{
    using Microsoft.AspNetCore.Mvc;
    using Pagination.Models;

    public class HomeController : Controller
    {
        private readonly IStudentRepository _studentRepository;
        private const int PageSize = 10;

        public HomeController(IStudentRepository studentRepository)
        {
            _studentRepository = studentRepository;
        }


        [HttpGet]
        public IActionResult Index(int page = 1)
        {
            int totalStudents = _studentRepository.GetTotalCount();
            int totalPages = (int)Math.Ceiling(totalStudents / (double)PageSize);

            var model = new HomeIndexViewModel
            {
                List = new StudentListViewModel
                {
                    Students = _studentRepository.GetStudents(page, PageSize),
                    CurrentPage = page,
                    TotalPages = totalPages
                },
                NewStudent = new StudentCreateViewModel()
            };

            return View(model);
        }


        [HttpPost]
        public IActionResult AddStudent(StudentCreateViewModel newStudent)
        {
            if (ModelState.IsValid)
            {
                // Tilføj ny student
                var student = new Student
                {
                    Id = _studentRepository.GetTotalCount() + 1,
                    Name = newStudent.Name,
                    Age = newStudent.Age
                };
                _studentRepository.AddStudent(student);
            }

            // Beregn total sider efter ny student
            int totalStudents = _studentRepository.GetTotalCount();
            int totalPages = (int)Math.Ceiling(totalStudents / (double)PageSize);
            int pageToShow = totalPages; // vi viser den side hvor den nye student ligger

            // Hent studerende til denne side
            var students = _studentRepository.GetStudents(pageToShow, PageSize);

            // Lav model til view
            var model = new HomeIndexViewModel
            {
                List = new StudentListViewModel
                {
                    Students = students,
                    CurrentPage = pageToShow,
                    TotalPages = totalPages
                },
                NewStudent = new StudentCreateViewModel() // nulstil form
            };

            return View("Index", model);
        }



    }
}
