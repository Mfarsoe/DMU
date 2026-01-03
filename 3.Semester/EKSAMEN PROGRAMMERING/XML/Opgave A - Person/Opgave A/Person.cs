using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.IO;

namespace Opgave_A
{
    public class Person
    {
        private string Name;
        private int Age;

        public Person() { }
    
        public Person(string name, int age)
        {
            this.Name = name;
            this.Age = age;
        }

        public string ToXML() 
        {
            string xml;
            using (StringWriter stringWriter = new StringWriter())
            {
                using (XmlWriter xmlWriter = XmlWriter.Create(stringWriter))
                {
                    ToXml(xmlWriter);
                    xmlWriter.Flush();
                    xml = stringWriter.GetStringBuilder().ToString();
                }
            }
            return xml;
        }

        public void FromXML(string xml) 
        {
            using (StringReader stringReader = new StringReader(xml))
            {
                using (XmlReader xmlReader = XmlReader.Create(stringReader))
                {
                    FromXml(xmlReader);
                }
            }
        }

        public void ToXml(XmlWriter writer) 
        {
            writer.WriteStartElement("Person");
            writer.WriteElementString("Name", Name);
            writer.WriteElementString("Age", Age.ToString());
            writer.WriteEndElement();
        }

        public void FromXml(XmlReader reader) 
        {
            reader.ReadToFollowing("Person");
            reader.ReadToFollowing("Name");
            Name = reader.ReadElementContentAsString();
            reader.ReadToFollowing("Age");
            Age = reader.ReadElementContentAsInt();
        }
    } 
}
