using Opgave_B.Client;
using Opgave_B.Server;
using Opgave_B;

class Program
{
    static void Main()
    {
        int port = 9001;

        // Start serveren
        var manager = new SkeletonManager(port);
        manager.Start();

        Thread.Sleep(200); // giv serveren tid til at starte

        // Client
        Stub stub = new Stub("127.0.0.1", port);

        Person p1 = new Person("Balice", 25);
        Person p2 = new Person("Ob", 32);

        Console.WriteLine("Client: Kalder Oldest...");
        Person oldest = stub.Oldest(p1, p2);

        Console.WriteLine("Resultat: " + (oldest != null ? oldest.ToString() : "Ingen respons"));

        Console.WriteLine("Tryk en tast for at stoppe server...");
        Console.ReadKey();

        manager.Shutdown(true);
    }
}
