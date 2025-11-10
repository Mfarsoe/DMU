using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;

namespace StudentAdministrationSystem.Models
{
    public static class IdentitySeedData
    {
        private const string adminUser = "Admin";
        private const string adminPassword = "Kode1234!"; 

        public static async 
        Task
EnsurePopulatedAsync(IApplicationBuilder app)
        {
            using var scope = app.ApplicationServices.CreateScope();
            var services = scope.ServiceProvider;

            var context = app.ApplicationServices.CreateScope().ServiceProvider.GetRequiredService<AppIdentityDbContext>();
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

                await userManager.CreateAsync(user, adminPassword);
            }
            else
            {
                Console.WriteLine("Admin-bruger findes allerede.");
            }
        }
    }
}
