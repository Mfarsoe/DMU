using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.IO;
using System.Text;
using System.Xml;

namespace StubSkeletonPattern {

  public class Person : IComparable<Person> {
    private string name;
    private int age;

    public Person() {
      name = string.Empty;
      age = 0;
    }

    public Person(string name, int age) {
      this.name = name;
      this.age = age;
    }

    public string ToXml() {
      using (StringWriter sw = new StringWriter()) {
        XmlWriterSettings settings = new XmlWriterSettings {
          //Indent = true,
          //IndentChars = "  ",
          Encoding = Encoding.UTF8
        };

        using (XmlWriter writer = XmlWriter.Create(sw, settings)) {
          writer.WriteStartDocument();
          {
            ToXml(writer);
          }
          writer.WriteEndDocument();
        }

        return sw.ToString();
      }
    }

    public void FromXml(string xml) {
      using (StringReader sr = new StringReader(xml)) {
        XmlReaderSettings settings = new XmlReaderSettings {
          IgnoreComments = true,
          IgnoreWhitespace = true
        };

        using (XmlReader reader = XmlReader.Create(sr, settings)) {
          reader.MoveToContent();

          if (reader.IsStartElement("person"))
            FromXml(reader);
          else
            Console.WriteLine("Unexpected start element. Expected 'Person'");
        }
      }
    }

    public void ToXml(XmlWriter writer) {
      writer.WriteStartElement("person");
      {
        writer.WriteElementString("name", name);
        writer.WriteElementString("age", age.ToString());
      }
      writer.WriteEndElement(); // </person>
    }

    public void FromXml(XmlReader reader) {
      reader.ReadStartElement();
      {
        this.name = reader.ReadElementContentAsString();
        this.age = reader.ReadElementContentAsInt();
      }
      reader.ReadEndElement();
    }

    public int CompareTo(Person other) {
      int diff = this.age - other.age;

      if (diff != 0)
        diff /= Math.Abs(diff);

      return diff;
    }

    public override string ToString() {
      return "[Person: name=\"" + name + "\", age=" + age + "]";
    }
  }
}
