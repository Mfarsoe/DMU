using Microsoft.AspNetCore.Mvc;
using StudentAdministrationSystem.Models;

public class EducationFilterViewComponent : ViewComponent
{
    private readonly IStudentRepository repo;

    public EducationFilterViewComponent(IStudentRepository repo)
    {
        this.repo = repo;
    }

    public IViewComponentResult Invoke(string selectedEducation)
    {
        var educations = repo.Students
                             .Select(s => s.Education)
                             .Where(e => !string.IsNullOrEmpty(e))
                             .Distinct()
                             .OrderBy(e => e)
                             .ToList();

        var model = new EducationFilterViewModel
        {
            AvailableEducations = educations,
            SelectedEducation = selectedEducation
        };

        return View(model);
    }
}
