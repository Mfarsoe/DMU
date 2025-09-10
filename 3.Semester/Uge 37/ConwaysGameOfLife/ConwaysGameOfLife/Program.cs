// See https://aka.ms/new-console-template for more information
using ConwaysGameOfLife;

Console.WriteLine("Hello, World!");
var world = new World(50,50);

world.Randomize();
for (int i = 0; i < 100; i++)
{
    Thread.Sleep(1000);
    world.Print();
    world.Step();
    Console.WriteLine();

}