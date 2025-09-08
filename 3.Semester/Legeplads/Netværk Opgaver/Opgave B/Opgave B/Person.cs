using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;


namespace Opgave_B
{
    public class Person
    {
        private string name;
        private int age;

        public Person() { }

        public Person(string name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public void ToXml(XmlWriter writer)
        {
            writer.WriteStartElement("Person");
            writer.WriteElementString("Name", name);
            writer.WriteElementString("Age", age.ToString());
            writer.WriteEndElement();
        }

        public void FromXml(XmlReader reader)
        {
            reader.ReadStartElement("Person");
            name = reader.ReadElementContentAsString();
            age = reader.ReadElementContentAsInt();
            reader.ReadEndElement();
        }

        public string ToXml()
        {
            using (StringWriter sw = new StringWriter())
            {
                using (XmlWriter writer = XmlWriter.Create(sw))
                {
                    writer.WriteStartDocument();
                    ToXml(writer);
                    writer.WriteEndDocument();
                }
                return sw.ToString();
            }
        }

        public void FromXml(string xml)
        {
            using (StringReader sr = new StringReader(xml))
            {
                using (XmlReader reader = XmlReader.Create(sr))
                {
                    reader.MoveToContent();
                    if (reader.IsStartElement("Person"))
                        FromXml(reader);
                    else
                        Console.WriteLine("Unexpected start element. Expected \"Person\"");
                }
            }
        }


        public override string ToString()
        {
            return $"Name: {name}, Age: {age}";
        }
    }
}
