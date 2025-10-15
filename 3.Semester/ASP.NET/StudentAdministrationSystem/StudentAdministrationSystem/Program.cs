using Microsoft.EntityFrameworkCore;
using StudentAdministrationSystem.Models;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllersWithViews();

builder.Services.AddDbContext<StudentDbContext>(options => { 
         options.UseSqlServer(builder.Configuration["ConnectionStrings:StudentAdministrationSystemConnection"]);
});

builder.Services.AddScoped<IStudentRepository, StudentRepository>();
var app = builder.Build();
app.UseStaticFiles();
app.UseRouting();

app.MapControllerRoute(
    name: "pagination",
    pattern: "Students/Page{studentPage:int}",
    defaults: new { controller = "Home", action = "Index" }
);

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}"
);
SeedData.EnsurePopulated(app);
app.Run();