using Moq;
using Xunit;
using StudentAdministrationSystem.Controllers;
using StudentAdministrationSystem.Models;
using Microsoft.AspNetCore.Mvc;

namespace StudentAdministrationSystem.Tests
{
    public class HomeControllerTest
    {
        [Fact]
        public void Create_Post_AddsStudentAndReturnsIndexView()
        {
            // Arrange
            var mockRepo = new Mock<IStudentRepository>();
            var studentsList = new List<Student>();
            mockRepo.Setup(r => r.Students).Returns(studentsList);
            var controller = new HomeController(mockRepo.Object);
            var newStudent = new Student
            {
                FirstName = "Jane",
                LastName = "Smith",
                Education = "IT",
                Semester = 2,
                Email = "jane@smith.com"
            };
            controller.ModelState.Clear(); // Sikrer at ModelState er valid

            // Act
            var result = controller.CreateStudent(newStudent) as ViewResult;

            // Assert
            mockRepo.Verify(r => r.AddStudent(It.Is<Student>(
                s => s.FirstName == "Jane" && s.LastName == "Smith")), Times.Once);
            Assert.NotNull(result);
            Assert.Equal("Index", result.ViewName);
            Assert.Same(studentsList, result.Model);
        }
    }
}