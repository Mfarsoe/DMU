using Microsoft.EntityFrameworkCore;

namespace StudentAdministrationSystem.Models
{
    public class StudentDbContext : DbContext
    {
        public StudentDbContext(DbContextOptions<StudentDbContext> options) : base(options)
        {
        }
        public DbSet<Student> Students => Set<Student>();
    }
}
