using System;
using System.Collections.Generic;
using System.Text;

namespace PP_lab_12
{
    class Category
    {
        readonly int id;
        string name;
        string description;

        public Category(int id)
        {
            this.id = id;
        }

        public string Name { get => name; set => name = value; }
        public string Description { get => description; set => description = value; }

        public override string ToString()
        {
            return "Category:\t" + Name + ", " + Description;
        }
    }
}
