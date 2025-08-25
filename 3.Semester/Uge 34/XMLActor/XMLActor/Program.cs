using System.Xml;
using XMLActor;

class Program
{
    public static void Main(string[] args)
    {
        //finder path til projectet og bruger actors.xml
        string inputPath = Path.Combine(AppContext.BaseDirectory, "actors.xml");

        var actors = readActors(inputPath);

        Console.WriteLine("Skuespillere der optræder i filen:");
        foreach (var actor in actors)
        {
            Console.WriteLine(" - " + actor);
        }

        string outputPath = Path.Combine(AppContext.BaseDirectory, "actors_out.xml");
        WriteActors(outputPath, actors);
        Console.WriteLine($"\nSkrev {actors.Count} skuespillere til: {outputPath}");

    }



    static List<Actor> readActors(string path)
    {
        var actors = new List<Actor>();

        // autocloses when we exit method
        using var reader = XmlReader.Create(path);
        
        
        Actor? current = null;
        while (reader.Read())
        {
            if (reader.NodeType == XmlNodeType.Element)
            {
                if (reader.Name == "actor")
                {
                    current = new Actor();
                    // gets attribute nationality
                    if (reader.GetAttribute("nationality") is string nat)
                        current.nationality = nat;
                }
                // gets name
                else if (reader.Name == "name" && current != null)
                {
                    current.name = reader.ReadElementContentAsString();
                }
                // gets role
                else if (reader.Name == "role" && current != null)
                {
                    current.role = reader.ReadElementContentAsString();
                }
                // gets year
                else if (reader.Name == "year" && current != null)
                {
                    current.year = reader.ReadElementContentAsInt();
                }
            }
            else if (reader.NodeType == XmlNodeType.EndElement && reader.Name == "actor")
            {
                // when we leave </actor>, add actor object to list
                if (current != null)
                    actors.Add(current);
            }
        }

        return actors;
    }

    static void WriteActors(string path, List<Actor> actors)
    {
        var settings = new XmlWriterSettings { Indent = true, Encoding = System.Text.Encoding.UTF8 };

        using var writer = XmlWriter.Create(path, settings);

        writer.WriteStartDocument();
        writer.WriteStartElement("actors");

        foreach (var a in actors)
        {
            writer.WriteStartElement("actor");
            writer.WriteAttributeString("nationality", a.nationality);

            writer.WriteElementString("name", a.name);
            writer.WriteElementString("role", a.role);
            writer.WriteElementString("year", a.year.ToString());

            writer.WriteEndElement(); // </actor>
        }

        writer.WriteEndElement();   // </actors>
        writer.WriteEndDocument();
    }
}
