namespace ElevKarakter.Models
{
    public class ElevViewModel
    {
        public string Navn { get; set; }
        public int Karakter { get; set; }

        public List<Elev> Elevlist { get; set; }

        public double ?GennemsnitKarakter { get; set; }
    }
}
