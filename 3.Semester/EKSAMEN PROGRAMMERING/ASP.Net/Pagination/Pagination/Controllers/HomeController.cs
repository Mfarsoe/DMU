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

        public IActionResult Index(int page = 1)
        {
            var students = _studentRepository.GetStudents(page, PageSize);
            int totalStudents = _studentRepository.GetTotalCount();

            ViewBag.CurrentPage = page;
            ViewBag.TotalPages = (int)Math.Ceiling(totalStudents / (double)PageSize);

            return View(students);
        }
    }

}
