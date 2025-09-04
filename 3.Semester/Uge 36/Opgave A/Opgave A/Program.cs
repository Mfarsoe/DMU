using Opgave_A;

class Program
{
    static void Main()
    {
        int port = 6010;

        // Start server i baggrundstråd
        Skeleton skeleton = new Skeleton(port);
        skeleton.Start();

        // Simuler klient (stub)
        Thread.Sleep(500); // lille pause så server er klar

        Stub stub = new Stub("127.0.0.1", port);

        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 42);

        Console.WriteLine(p1);
        Console.WriteLine(p1.ToXML);
        stub.Send(p1);
        stub.Send(p2);

        Console.WriteLine("\nTryk ENTER for at afslutte...");
        Console.ReadLine();

        skeleton.Stop();
    }
}