using System;

namespace Opgave_B.Server
{
    public class MethodImpl : IMethodImpl
    {
        public Person Oldest(Person p1, Person p2)
        {
            Console.WriteLine($"Server: comparing {p1} and {p2}");
            return p1.Age >= p2.Age ? p1 : p2;
        }
    }
}
