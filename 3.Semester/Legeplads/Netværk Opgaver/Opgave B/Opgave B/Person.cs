using System;
using System.IO;
using System.Xml;

namespace Opgave_B
{
    public class Person
    {
        public string Name { get; set; }
        public int Age { get; set; }

        public Person() { }
        public Person(string name, int age) { Name = name; Age = age; }

        // Writes a <person> element (suitable for embedding in a larger document)
        public void ToXml(XmlWriter writer)
        {
            writer.WriteStartElement("person");
            writer.WriteElementString("name", Name ?? "");
            writer.WriteElementString("age", Age.ToString());
            writer.WriteEndElement();
        }

        // Reads a <person> element (expects reader positioned on <person>)
        public void FromXml(XmlReader reader)
        {
            reader.MoveToContent();
            reader.ReadStartElement("person");
            Name = reader.ReadElementContentAsString("name", "");
            Age = reader.ReadElementContentAsInt("age", "");
            reader.ReadEndElement(); // </person>
        }

        // Helper: full document string (with XML declaration)
        public string ToXml()
        {

            using (var sw = new StringWriter())
            using (var xw = XmlWriter.Create(sw))
            {
                xw.WriteStartDocument();
                ToXml(xw);
                xw.WriteEndDocument();
                xw.Flush();
                return sw.ToString();
            }
        }

        public void FromXml(string xml)
        {
            using (var sr = new StringReader(xml))
            using (var xr = XmlReader.Create(sr))
            {
                xr.MoveToContent();
                if (xr.IsStartElement("person"))
                    FromXml(xr);
                else
                    throw new InvalidOperationException($"Expected <person> but got <{xr.Name}>");
            }
        }

        public override string ToString() => $"Name: {Name}, Age: {Age}";
    }
}
