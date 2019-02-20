using System;
using System.Collections.Generic;
using System.Text;

namespace PP_lab_12
{
    class Supplier
    {
        readonly int id;
        string companyName;
        string city;
        string homePage;

        public Supplier(int id)
        {
            this.id = id;
        }

        public int Id => id;

        public string CompanyName { get => companyName; set => companyName = value; }
        public string City { get => city; set => city = value; }
        public string HomePage { get => homePage; set => homePage = value; }

        public override string ToString()
        {
            return "Supplier:\t" + CompanyName + ", " + City + ", " + HomePage;
        }
    }
}
