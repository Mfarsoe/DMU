using StudentAdministrationSystem.Models;
using Xunit;

namespace StudentAdministrationSystem.Tests
{
    public class StudentViewModelTest
    {
        [Fact]
        public void CanSetAndGetProperties()
        {
            // Arrange
            var student = new Student();

            // Act
            student.FirstName = "John";
            student.LastName = "Doe";
            student.Education = "Computer Science";
            student.Semester = 3;
            student.Email = "john.doe@example.com";

            // Assert
            Assert.Equal("John", student.FirstName);
            Assert.Equal("Doe", student.LastName);
            Assert.Equal("Computer Science", student.Education);
            Assert.Equal(3, student.Semester);
            Assert.Equal("john.doe@example.com", student.Email);
        }

        [Theory]
        [InlineData("Jane", "Smith", "IT", 2, "jane@smith.com")]
        [InlineData("Alice", "Johnson", "Math", 1, "alice@johnson.com")]
        public void CanCreateStudentWithDifferentValues(string firstName, string lastName, string education, int semester, string email)
        {
            // Arrange & Act
            var student = new Student
            {
                FirstName = firstName,
                LastName = lastName,
                Education = education,
                Semester = semester,
                Email = email
            };

            // Assert
            Assert.Equal(firstName, student.FirstName);
            Assert.Equal(lastName, student.LastName);
            Assert.Equal(education, student.Education);
            Assert.Equal(semester, student.Semester);
            Assert.Equal(email, student.Email);
        }
    }
}