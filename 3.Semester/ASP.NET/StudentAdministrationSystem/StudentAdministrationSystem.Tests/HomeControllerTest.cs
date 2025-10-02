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
            var studentsList = new List<StudentViewModel>();
            mockRepo.Setup(r => r.Students).Returns(studentsList);
            var controller = new HomeController(mockRepo.Object);
            var newStudent = new StudentViewModel
            {
                firstName = "Jane",
                lastName = "Smith",
                education = "IT",
                semester = 2,
                email = "jane@smith.com"
            };
            controller.ModelState.Clear(); // Sikrer at ModelState er valid

            // Act
            var result = controller.CreateStudent(newStudent) as ViewResult;

            // Assert
            mockRepo.Verify(r => r.AddStudent(It.Is<StudentViewModel>(
                s => s.firstName == "Jane" && s.lastName == "Smith")), Times.Once);
            Assert.NotNull(result);
            Assert.Equal("Index", result.ViewName);
            Assert.Same(studentsList, result.Model);
        }
    }
}