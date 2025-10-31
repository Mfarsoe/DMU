using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;

namespace StudentAdministrationSystem.Models
{
    public static class IdentitySeedData
    {
        private const string adminUser = "Admin";
        private const string adminPassword = "Kode1234!"; // <-- bemærk '!' for at undgå password-policy problemer

        public static async Task EnsurePopulatedAsync(IApplicationBuilder app)
        {
            using var scope = app.ApplicationServices.CreateScope();
            var services = scope.ServiceProvider;

            var context = services.GetRequiredService<AppIdentityDbContext>();
            // Kør migration hvis der er nogen
            if (context.Database.GetPendingMigrations().Any())
            {
                context.Database.Migrate();
            }

            var userManager = services.GetRequiredService<UserManager<IdentityUser>>();

            var user = await userManager.FindByNameAsync(adminUser);
            if (user == null)
            {
                user = new IdentityUser
                {
                    UserName = adminUser,
                    Email = "admin@admin.com",
                    PhoneNumber = "87654321",
                    EmailConfirmed = true
                };

                var result = await userManager.CreateAsync(user, adminPassword);

                if (!result.Succeeded)
                {
                    // Log fejl til konsol så du kan se hvad der går galt
                    Console.WriteLine("FEJL ved oprettelse af admin-bruger:");
                    foreach (var err in result.Errors)
                    {
                        Console.WriteLine($" - {err.Code}: {err.Description}");
                    }
                    throw new Exception("Kan ikke oprette admin-bruger. Se konsol for detaljer.");
                }
                else
                {
                    Console.WriteLine("Admin-bruger oprettet.");
                }
            }
            else
            {
                Console.WriteLine("Admin-bruger findes allerede.");
            }
        }
    }
}
