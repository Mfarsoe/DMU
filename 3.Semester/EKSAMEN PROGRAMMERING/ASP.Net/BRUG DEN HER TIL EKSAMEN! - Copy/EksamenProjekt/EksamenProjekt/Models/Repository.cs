namespace EksamenProjekt.Models
{
    public class Repository : IRepository
    {
        private List<Drikkevare> drikkevarer = new List<Drikkevare>
        {
            new Drikkevare { Navn = "Sodavand", Pris = 25.0 },
            new Drikkevare { Navn = "Juice", Pris = 30.0 },
            new Drikkevare { Navn = "Vand", Pris = 15 }
        };

        public List<Drikkevare> HentDrikkevarer()
        {
            return drikkevarer;
        }
    }
}
