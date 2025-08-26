using System.Xml;
using XMLActor;

class Program
{
    public static void Main(string[] args)
    {
        //find basepath actors.xml
        string inputPath = Path.Combine(AppContext.BaseDirectory, "actors.xml");

        //gets list of actors from xml file
        var actors = readActors(inputPath);

        //print actors to console
        Console.WriteLine("Skuespillere der optræder i filen:");

        foreach (var actor in actors)
        {
            Console.WriteLine(" - " + actor);
        }

        //write actors to new xml file
        string outputPath = Path.Combine(AppContext.BaseDirectory, "actors_out.xml");

        WriteActors(outputPath, actors);

        //confirm to console
        Console.WriteLine($"\nSkrev {actors.Count} skuespillere til: {outputPath}");

    }


    // reads actors from xml file
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
            // when we reach </actor>
            else if (reader.NodeType == XmlNodeType.EndElement && reader.Name == "actor")
            {
                // add current actor to list
                if (current != null)
                    actors.Add(current);
            }
        }

        return actors;
    }

    // writes list of actors to xml file
    static void WriteActors(string path, List<Actor> actors)
    {
        // settings for xml writer
        var settings = new XmlWriterSettings { Indent = true, Encoding = System.Text.Encoding.UTF8 };

        //creates writer
        using var writer = XmlWriter.Create(path, settings);

        writer.WriteStartDocument(); // <?xml version="1.0" encoding="utf-8"?>
        writer.WriteStartElement("actors"); // <actors>

        // writes each <actor>
        foreach (var a in actors)
        {
            writer.WriteStartElement("actor"); // <actor>
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
