using Microsoft.AspNetCore.Identity;

namespace Advanced.Models
{
    public class IdentitySeedData
    {

        public static void CreateAdminAccount(IServiceProvider serviceProvider,
                IConfiguration configuration)
        {
            CreateAdminAccountAsync(serviceProvider, configuration).Wait();
        }

        public static async Task CreateAdminAccountAsync(IServiceProvider
                serviceProvider, IConfiguration configuration)
        {

            serviceProvider = serviceProvider.CreateScope().ServiceProvider;

            UserManager<IdentityUser> userManager =
                serviceProvider.GetRequiredService<UserManager<IdentityUser>>();
            RoleManager<IdentityRole> roleManager =
                serviceProvider.GetRequiredService<RoleManager<IdentityRole>>();

            // Roller
            string[] roles = { "Admins", "Manager", "Support" };

            foreach (string role in roles)
            {
                if (await roleManager.FindByNameAsync(role) == null)
                {
                    await roleManager.CreateAsync(new IdentityRole(role));
                }
            }

            // Admin
            await CreateUser(userManager, "admin", "admin@example.com", "secret", "Admins");

            // Manager
            await CreateUser(userManager, "manager", "manager@example.com", "secret", "Manager");

            // Support
            await CreateUser(userManager, "support", "support@example.com", "secret", "Support");
        }

        private static async Task CreateUser(UserManager<IdentityUser> userManager,
            string username, string email, string password, string role)
        {

            if (await userManager.FindByNameAsync(username) == null)
            {

                IdentityUser user = new IdentityUser
                {
                    UserName = username,
                    Email = email
                };

                IdentityResult result = await userManager.CreateAsync(user, password);

                if (result.Succeeded)
                {
                    await userManager.AddToRoleAsync(user, role);
                }
            }
        }
    }
}