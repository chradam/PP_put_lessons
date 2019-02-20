using PP.Controllers;
using System;
using System.Collections.Generic;
using System.Text;

namespace PP_lab_12
{
    class Warehouse
    {
        public Dictionary<Product, int> spis { get; set; }

        public Warehouse()
        {
            this.spis = new Dictionary<Product, int>();
        }

        public void AddProduct(Product p, int l)
        {
            this.spis.Add(p, l);
        }

        public void UpdateProduct(Product p, int amount)
        {
            this.spis[p] = amount;
        }

        public int GetAllAmount()
        {
            int sum = 0;
            foreach(var entry in this.spis)
            {
                sum += entry.Value;
            }

            return sum;
        }

        public void GestSpis()
        {
            foreach (var entry in this.spis)
            {
                Console.WriteLine("{0}\nAmount:\t\t{1}\n", entry.Key, entry.Value);
            }
        }
    }
}
