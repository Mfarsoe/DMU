using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace RazorPagesDemo.Pages
{
    public class IndexModel : PageModel
    {
        public double? BeregnetPris;
        
        [BindProperty]
        public int Age { get; set; }

        [BindProperty]
        public string ValgtRet { get; set; }




        public IEnumerable<Models.Vare> Vareliste = new List<Models.Vare>
        {
            new Models.Vare { Navn = "Vare 1", Pris = 100.0 },
            new Models.Vare { Navn = "Vare 2", Pris = 200.0 },
            new Models.Vare { Navn = "Vare 3", Pris = 300.0 }
        };

        public void OnGet()
        {

        }

        public void OnPost() 
        {
            var valgtVare = Vareliste.FirstOrDefault(v => v.Navn == ValgtRet);
           
            if (valgtVare !=null)
            {
                double pris = valgtVare.Pris;
                if (Age < 18)
                {
                    pris *= 0.8; // 20% rabat for under 18 år
                }
                else if (Age >= 65)
                {
                    pris *= 0.9; // 10% rabat for 65 år og derover
                }
                BeregnetPris = pris;
            }
        }
    }
}
