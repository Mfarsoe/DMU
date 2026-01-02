namespace ElevKarakter.Models
{
    public class Repository
    {
        private List<Elev> elever = new List<Elev>
        {
            new Elev("Anders", 12),
            new Elev("Bente", 10),
            new Elev("Carsten", 7),
            new Elev("Dorte", 4),
            new Elev("Erik", 02)
        };

        public List<Elev> GetStudents()
        {
            return elever;
        }

        public void AddStudent(Elev elev)
        {
            elever.Add(elev);
        }

    }
}
