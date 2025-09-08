using Opgave_B.Client;
using Opgave_B.Server;
using Opgave_B;

class Program
{
    static void Main()
    {
        int port = 9001;
        IMethodImpl methodImpl = new MethodImpl();

        // Start serveren
        var manager = new SkeletonManager(port, methodImpl);
        manager.Start();

        Thread.Sleep(200); // giv serveren tid til at starte

        // Client
        var stub = new Stub("127.0.0.1", port);

        var p1 = new Person("Balice", 25);
        var p2 = new Person("Ob", 32);

        Console.WriteLine("Client: Kalder Oldest...");
        var oldest = stub.Oldest(p1, p2);

        Console.WriteLine("Resultat: " + (oldest != null ? oldest.ToString() : "Ingen respons"));

        Console.WriteLine("Tryk en tast for at stoppe server...");
        Console.ReadKey();

        manager.Shutdown(true);
    }
}
