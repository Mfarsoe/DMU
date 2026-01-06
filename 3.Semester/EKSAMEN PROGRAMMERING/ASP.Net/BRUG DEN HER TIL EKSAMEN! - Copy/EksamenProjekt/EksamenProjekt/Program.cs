using EksamenProjekt.Models;

var builder = WebApplication.CreateBuilder(args); //Ansvarlig for konfig og oprettelse af webapplikationen
builder.Services.AddSingleton<Repository>(); //Registrerer Repository som en singleton service for afhængighedsinjektion
builder.Services.AddControllersWithViews(); //supper til MVC-mønsteret
var app = builder.Build(); //Bygger applikationen
app.UseStaticFiles(); //Aktiverer brug af statiske filer som CSS, JS, billeder osv. Uden vil den ikke kunne hente statiske filer
app.UseRouting(); //Aktiverer routing-middleware til at dirigere HTTP-anmodninger til de korrekte controller-handlinger
app.MapControllerRoute( 
  name: "default",
  pattern: "{controller=Home}/{action=Index}/{id?}"); //Definerer standardruten for controller-action-id mønsteret
app.Run(); //Kører applikationen og begynder at lytte efter HTTP-anmodninger