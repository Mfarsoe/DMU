using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace XMLActor
{
    public sealed class Actor
    {
        public string name { get; set; }
        public string role { get; set; }
        public int year { get; set; }
        public string nationality { get; set; }

        public override string ToString()
        {
            return $"{name}, {role}, {year}, {nationality}";
        }
    }
}
