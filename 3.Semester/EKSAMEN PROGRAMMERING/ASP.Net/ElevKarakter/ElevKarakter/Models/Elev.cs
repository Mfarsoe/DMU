namespace ElevKarakter.Models
{
    public class Elev
    {
        public string Navn { get; set; }
        public int Karakter { get; set; }

        public Elev(string navn, int karakter)
        {
            Navn = navn;
            Karakter = karakter;
        }
    }
}
