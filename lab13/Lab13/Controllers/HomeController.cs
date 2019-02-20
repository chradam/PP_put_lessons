using Lab13.Models;
using PP_lab_12;
using Lab13.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity.Core;
using System.Data.Entity.Infrastructure;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace PP.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            //ViewBag.Message = "Your application description page.";

            String xx = "";

            // 1. Instantiate the connection
            SqlConnection conn = new SqlConnection("data source=HOME_STATION;initial catalog=NORTHWND;user id=AC;password=123;");

            SqlDataReader rdr = null;

            try
            {
                // 2. Open the connection
                conn.Open();

                string city = "Berlin";
                string category = "Seafood";
                // 3. Pass the connection to a command object
                SqlCommand cmd = new SqlCommand("select ProductName, UnitsInStock " +
                    "from Products p " +
                    "join Suppliers s " +
                    "on p.SupplierID=s.SupplierID " +
                    "join Categories c " +
                    "on  p.CategoryID=c.CategoryID " +
                    "where s.City='" + city + "' or c.CategoryName='" + category + "';", conn);

                //
                // 4. Use the connection
                //

                // get query results
                rdr = cmd.ExecuteReader();
                Warehouse w = new Warehouse();
                Dictionary<Product, int> dict = new Dictionary<Product, int>();
                w.spis = dict;
                // print the CustomerID of each record
                while (rdr.Read())
                {
                    //xx += "1. ";
                    xx += rdr[0].ToString();
                    xx += ":";
                    xx += rdr[1].ToString();
                    xx += "\n";
                    Category a = new Category(1);
                    //a.id = 1;
                    a.Name = category;
                    a.Description = "abcd";
                    Supplier s = new Supplier(1);
                    s.CompanyName = "Nazwa";
                    s.City = "Miasto";
                    s.HomePage = "www.pl";
                    Product p = new Product(1);
                    p.Name = rdr[0].ToString();
                    p.Category = a;
                    p.Supplier = s;
                    p.UnitPrice = 14;
                    w.AddProduct(p, 1);
                }

            }
            finally
            {
                // close the reader
                if (rdr != null)
                {
                    rdr.Close();
                }

                // 5. Close the connection
                if (conn != null)
                {
                    conn.Close();
                }
            }

            //ViewBag.Message(xx);
            ViewBag.Message = xx;

            return View();
        }

        public ActionResult Contact()
        {
            //ViewBag.Message = "Your application description page.";

            String xx = "";

            // 1. Instantiate the connection
            SqlConnection conn = new SqlConnection("Server=tcp:pp20190123113805dbserver.database.windows.net,1433;Initial Catalog=PP20190123113805_db;Persist Security Info=False;User ID=bmarcin;Password=Maraszynko123;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;");


            string queryString = "SELECT * from Employees";
            SqlDataAdapter adapter = new SqlDataAdapter(queryString, conn);

            DataSet employees = new DataSet();
            adapter.Fill(employees, "Employees");

            foreach (DataRow pRow in employees.Tables["Employees"].Rows)
            {
                xx += pRow["FirstName"];
                xx += "";
                xx += pRow["LastName"];
                xx += ", \n";
            }

            ViewBag.Message = xx;

            //foreach(var item in employees)
            //{

            //}

            return View();
        }

        [HttpGet]
        public ActionResult Zad3()
        {
            using (NORTHWNDEntities dbModel = new NORTHWNDEntities())
            {
                return View(new Customers());
            }
        }

        [HttpPost]
        public ActionResult Zad3(Customers cr)
        {
            using (NORTHWNDEntities dbModel = new NORTHWNDEntities())
            {
                try
                {
                    dbModel.Customers.Add(cr);
                    dbModel.SaveChanges();

                    ViewBag.success = "Dodano klienta";

                    return View(new Customers());
                }
                catch (DbUpdateException sqlex)
                {
                    var x1 = (UpdateException)sqlex.InnerException;
                    var x2 = (SqlException)x1.InnerException;

                    String err = "";

                    if (x2 != null)
                    {
                        ViewBag.sqlerror = "SQL:" + x2.Message;
                        err = x2.Message;
                    }
                    else
                    {
                        ViewBag.sqlerror = "SQL:" + x1.Message;
                        err = x1.Message;
                    }

                    return View(cr);
                }
                catch (Exception e)
                {
                    ViewBag.sqlerror = "Nieznany:" + e.Message;

                    return View(cr);
                }
            }
        }

        [HttpGet]
        public ActionResult Zad3_2()
        {
            using (NORTHWNDEntities dbModel = new NORTHWNDEntities())
            {
                List<Customers> klienci = new List<Customers>();

                var q = (from c in dbModel.Customers select c).ToList();

                foreach (var item in q)
                {
                    klienci.Add(new Lab13.Models.Customers
                    {
                        CustomerID = item.CustomerID,
                        Address = item.Address,
                        City = item.City,
                        CompanyName = item.CompanyName,
                        ContactName = item.ContactName,
                        ContactTitle = item.ContactTitle,
                        Country = item.Country,
                        CustomerDemographics = item.CustomerDemographics,
                        Fax = item.Fax,
                        Orders = item.Orders,
                        Phone = item.Phone,
                        PostalCode = item.PostalCode,
                        Region = item.Region
                    });
                }

                return View(klienci);
            }
        }
    }
}