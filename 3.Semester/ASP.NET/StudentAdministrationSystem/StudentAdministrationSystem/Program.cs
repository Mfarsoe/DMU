using Microsoft.EntityFrameworkCore;
using StudentAdministrationSystem.Models;
using Microsoft.AspNetCore.Identity;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllersWithViews();

builder.Services.AddDbContext<StudentDbContext>(options => { 
         options.UseSqlServer(builder.Configuration["ConnectionStrings:StudentAdministrationSystemConnection"]);
});

builder.Services.AddScoped<IStudentRepository, StudentRepository>();


builder.Services.AddDbContext<AppIdentityDbContext>(options =>
options.UseSqlServer(
builder.Configuration["ConnectionStrings:IdentityConnection"]));
builder.Services.AddIdentity<IdentityUser, IdentityRole>()
.AddEntityFrameworkStores<AppIdentityDbContext>();

var app = builder.Build();
app.UseStaticFiles();
app.UseRouting();
app.MapDefaultControllerRoute();

app.UseAuthentication();  
app.UseAuthorization();

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
IdentitySeedData.EnsurePopulatedAsync(app);


app.Run();