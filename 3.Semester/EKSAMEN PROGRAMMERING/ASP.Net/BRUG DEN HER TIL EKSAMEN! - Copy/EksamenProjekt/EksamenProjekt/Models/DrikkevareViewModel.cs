namespace EksamenProjekt.Models
{
    public class DrikkevareViewModel
    {
        public List<Drikkevare> Drikkevarer { get; set; }

        public string? ValgtDrik { get; set; }

        public int Antal { get; set; }

        public double? TotalPris { get; set; }
    }
}
