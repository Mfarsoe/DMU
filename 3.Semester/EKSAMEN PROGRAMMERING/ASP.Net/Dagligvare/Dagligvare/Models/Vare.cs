namespace Dagligvare.Models
{
    public class Vare
    {
        public string? Navn { get; set; }
        public decimal Pris { get; set; }

        public int Antal { get; set; } = 0;
        }
}
