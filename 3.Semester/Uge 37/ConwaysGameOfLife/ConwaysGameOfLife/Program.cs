using ConwaysGameOfLife;

var world = new World(1000, 300);

world.Randomize();

Console.WriteLine(world.ToString());

Console.WriteLine($"Neighbours at (0,0): {world.Neighbours(0, 0)}");
Console.WriteLine($"Neighbours at (1,1): {world.Neighbours(1, 1)}");
Console.WriteLine($"Neighbours at (2,2): {world.Neighbours(2, 2)}");


for (int i = 0; true; i++)
{
    world.Iterate();
    Console.WriteLine(world);
    System.Threading.Thread.Sleep(1000/60);
    Console.Clear();
}