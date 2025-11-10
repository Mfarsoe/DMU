using Microsoft.EntityFrameworkCore;
using StudentAdministrationSystem.Models;
using Microsoft.AspNetCore.Identity;

var builder = WebApplication.CreateBuilder(args);

// --- Force binding to all interfaces ---
builder.WebHost.UseUrls("http://0.0.0.0:5000");

// --- Logging ---
builder.Logging.ClearProviders();
builder.Logging.AddConsole();

// --- Services ---
builder.Services.AddControllersWithViews();

builder.Services.AddDbContext<StudentDbContext>(options =>
{
    options.UseSqlServer(builder.Configuration["ConnectionStrings:StudentAdministrationSystemConnection"]);
});

builder.Services.AddScoped<IStudentRepository, StudentRepository>();

builder.Services.AddDbContext<AppIdentityDbContext>(options =>
    options.UseSqlServer(builder.Configuration["ConnectionStrings:IdentityConnection"]));

builder.Services.AddIdentity<IdentityUser, IdentityRole>()
    .AddEntityFrameworkStores<AppIdentityDbContext>();

var app = builder.Build();

// --- Middleware ---
app.UseStaticFiles();
app.UseRouting();
app.UseAuthentication();
app.UseAuthorization();

// --- Routing ---
app.MapControllerRoute(
    name: "pagination",
    pattern: "Students/Page{studentPage:int}",
    defaults: new { controller = "Home", action = "Index" }
);

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}"
);

// --- Seed Data with Logging ---
try
{
    Console.WriteLine("Starting StudentDbContext seeding...");
    SeedData.EnsurePopulated(app);
    Console.WriteLine("StudentDbContext seeding completed.");

    Console.WriteLine("Starting Identity seeding...");
    await IdentitySeedData.EnsurePopulatedAsync(app);
    Console.WriteLine("Identity seeding completed.");
}
catch (Exception ex)
{
    Console.WriteLine($"Seeding failed: {ex.Message}");
}

// --- Run app ---
Console.WriteLine("Starting ASP.NET application...");
await app.RunAsync();
