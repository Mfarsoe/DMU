﻿using Microsoft.EntityFrameworkCore;

namespace StudentAdministrationSystem.Models
{
    public static class SeedData
    {
        public static void EnsurePopulated(IApplicationBuilder app)
        {
            StudentDbContext context = app.ApplicationServices.CreateScope().ServiceProvider.GetRequiredService<StudentDbContext>();
            if (context.Database.GetPendingMigrations().Any())
            {
                context.Database.Migrate();
            }
            if (!context.Students.Any())
            {
                context.Students.AddRange(
                    new Student
                    {
                        FirstName = "John",
                        LastName = "Deer",
                        Education = "Datamatiker",
                        Semester = 3,
                        Email = "John@eamv.dk"
                    },
                    new Student
                    {
                        FirstName = "Maggie",
                        LastName = "Smith",
                        Education = "Finansøkonom",
                        Semester = 2,
                        Email = "Jane@eamv.dk"
                    },
                    new Student
                    {
                        FirstName = "Michael",
                        LastName = "Jackson",
                        Education = "Markedsføringsøkonom",
                        Semester = 1,
                        Email = "Michael@eamv.dk"
                    },
                    new Student { FirstName = "Emma", LastName = "Johnson", Education = "Datamatiker", Semester = 1, Email = "emma@eamv.dk" },
                    new Student { FirstName = "Oliver", LastName = "Brown", Education = "Finansøkonom", Semester = 2, Email = "oliver@eamv.dk" },
                    new Student { FirstName = "Sophia", LastName = "Davis", Education = "Markedsføringsøkonom", Semester = 3, Email = "sophia@eamv.dk" },
                    new Student { FirstName = "Liam", LastName = "Miller", Education = "Datamatiker", Semester = 4, Email = "liam@eamv.dk" },
                    new Student { FirstName = "Ava", LastName = "Wilson", Education = "Finansøkonom", Semester = 1, Email = "ava@eamv.dk" },
                    new Student { FirstName = "Noah", LastName = "Moore", Education = "Markedsføringsøkonom", Semester = 2, Email = "noah@eamv.dk" },
                    new Student { FirstName = "Isabella", LastName = "Taylor", Education = "Datamatiker", Semester = 5, Email = "isabella@eamv.dk" },
                    new Student { FirstName = "Elijah", LastName = "Anderson", Education = "Finansøkonom", Semester = 3, Email = "elijah@eamv.dk" },
                    new Student { FirstName = "Mia", LastName = "Thomas", Education = "Markedsføringsøkonom", Semester = 4, Email = "mia@eamv.dk" },
                    new Student { FirstName = "Lucas", LastName = "Jackson", Education = "Datamatiker", Semester = 2, Email = "lucas@eamv.dk" },
                    new Student { FirstName = "Charlotte", LastName = "White", Education = "Finansøkonom", Semester = 5, Email = "charlotte@eamv.dk" },
                    new Student { FirstName = "Mason", LastName = "Harris", Education = "Markedsføringsøkonom", Semester = 3, Email = "mason@eamv.dk" },
                    new Student { FirstName = "Amelia", LastName = "Martin", Education = "Datamatiker", Semester = 1, Email = "amelia@eamv.dk" },
                    new Student { FirstName = "Ethan", LastName = "Lee", Education = "Finansøkonom", Semester = 2, Email = "ethan@eamv.dk" },
                    new Student { FirstName = "Harper", LastName = "Perez", Education = "Markedsføringsøkonom", Semester = 4, Email = "harper@eamv.dk" }
                );
                context.SaveChanges();
            }
        }
    }
}
