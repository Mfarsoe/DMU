namespace EksamenProjekt.Models
{
    // Klassen Vare repræsenterer en ret på menuen
    // Den indeholder navn og normalpris
    public class Vare
    {
        public string Navn { get; set; }
        public double Pris { get; set; }
        public Vare(string navn, double pris)
        {
            Navn = navn;
            Pris = pris;
        }
    }
}
