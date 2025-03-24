using SecondExample;


double theX, theY;

Punkt p2 = new(12, 3);

p2.getXY(out theX, out theY);

Console.WriteLine(theX);
Console.WriteLine(theY);






Dictionary<int, string> map = new();

map.Add(8800, "Viborg");
map.Add(7400, "Herning");
map.Add(8000, "Aarhus C");
map.Add(2300, "Amager");

foreach (var item in map) {
    Console.WriteLine(item);
}

List<int> numbers = new();

numbers.Add(2);
numbers.Add(3);
numbers.Add(5);
numbers.Add(7);

foreach (int tal in numbers)
    Console.WriteLine(tal);

Console.WriteLine(numbers.Count);

Punkt p = new(5, 8);

Console.WriteLine(p);
Console.WriteLine(p[0]);
Console.WriteLine(p[1]);

p[0] = 11;

Console.WriteLine(p);
Console.WriteLine(p[0]);
Console.WriteLine(p[1]);


var b = new Book("test");

Console.WriteLine(b.Title);

b.Title = "To";

Console.WriteLine(b.Title);

