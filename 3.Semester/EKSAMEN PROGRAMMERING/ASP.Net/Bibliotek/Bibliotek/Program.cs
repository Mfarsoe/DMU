using Bibliotek.Models;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllersWithViews();
builder.Services.AddSingleton<Repository>(); //AddScoped betyder: nyt Repository pr. HTTP-request // singleton betyder: én instans deles af alle
var app = builder.Build();
app.UseStaticFiles();
app.UseRouting();
app.MapControllerRoute(
  name: "default",
  pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();