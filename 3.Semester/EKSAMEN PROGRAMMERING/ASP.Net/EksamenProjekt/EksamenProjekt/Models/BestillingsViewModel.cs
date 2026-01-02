using System.Collections.Generic;

namespace EksamenProjekt.Models
{

    // ViewModel bruges til at samle alle data,
    // som Viewet skal bruge
    public class BestillingViewModel
    {
        public int Alder { get; set; }
        public string ValgtRet { get; set; }

        public List<Vare> Menu { get; set; }

        public double? BeregnetPris { get; set; }
    }
}
