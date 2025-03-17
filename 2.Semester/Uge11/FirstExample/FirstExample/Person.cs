using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FirstExample {
    public class Person {
        private string name;
        private int age;

        public Person() {
            this.name = string.Empty;
            this.age = 0;
        }

        public Person(string name, int age) {
            this.name = name;
            this.age = age;
        }

        public override string ToString() {
            return "[Person: name=" + name + ", age=" + age + "]";
        }
    }
}

