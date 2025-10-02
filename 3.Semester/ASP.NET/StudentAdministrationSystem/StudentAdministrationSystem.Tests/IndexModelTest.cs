using StudentAdministrationSystem.Models;
namespace StudentAdministrationSystem.Tests
{
    public class IndexModelTest
    {
        [Fact]
        public void ModelTest()
        {
            // Arrange

            var fakeData = new FakeData();
            fakeData.AddStudent(new StudentViewModel
            {
                firstName = "John",
                lastName = "Doe",
                semester = 3,
                education = "Computer Science",
                email = "a@a"
            });

            // Act

            // Assert
        }
    }
}