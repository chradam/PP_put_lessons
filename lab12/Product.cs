using System;
using System.Collections.Generic;
using System.Text;

namespace PP_lab_12
{
    class Product
    {
        readonly int id;
        string name;
        Category category;
        Supplier supplier;
        decimal unitPrice;

        public Product(int id)
        {
            this.id = id;
        }

        public string Name { get => name; set => name = value; }
        public decimal UnitPrice { get => unitPrice; set => unitPrice = value; }
        internal Category Category { get => category; set => category = value; }
        internal Supplier Supplier { get => supplier; set => supplier = value; }

        public override string ToString()
        {
            return "\nProduct:\t" + Name + "\n"  + Category + "\n" + Supplier + "\nUnitPrice:\t" + UnitPrice;
        }  
    }
}
