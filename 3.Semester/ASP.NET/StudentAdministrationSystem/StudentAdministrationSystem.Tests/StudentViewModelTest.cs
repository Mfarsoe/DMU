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
            var student = new StudentViewModel();

            // Act
            student.firstName = "John";
            student.lastName = "Doe";
            student.education = "Computer Science";
            student.semester = 3;
            student.email = "john.doe@example.com";

            // Assert
            Assert.Equal("John", student.firstName);
            Assert.Equal("Doe", student.lastName);
            Assert.Equal("Computer Science", student.education);
            Assert.Equal(3, student.semester);
            Assert.Equal("john.doe@example.com", student.email);
        }

        [Theory]
        [InlineData("Jane", "Smith", "IT", 2, "jane@smith.com")]
        [InlineData("Alice", "Johnson", "Math", 1, "alice@johnson.com")]
        public void CanCreateStudentWithDifferentValues(string firstName, string lastName, string education, int semester, string email)
        {
            // Arrange & Act
            var student = new StudentViewModel
            {
                firstName = firstName,
                lastName = lastName,
                education = education,
                semester = semester,
                email = email
            };

            // Assert
            Assert.Equal(firstName, student.firstName);
            Assert.Equal(lastName, student.lastName);
            Assert.Equal(education, student.education);
            Assert.Equal(semester, student.semester);
            Assert.Equal(email, student.email);
        }
    }
}