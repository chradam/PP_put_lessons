using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Numerics;
using System.Linq;
using System.Text.RegularExpressions;

namespace PP_lab_12
{
    class Program
    {
        //public static BigInteger fact(BigInteger n)
        //{
        //    BigInteger result = 1;
        //    for(int i = 1; i <= n; i++)
        //    {
        //        result *= i;
        //    }
        //    return result;
        //}

        static void Main(string[] args)
        {
            /***************************************/
            Supplier s1 = new Supplier(1);
            s1.CompanyName = "Company1";
            s1.City = "City1";
            s1.HomePage = "www.homPage1.pl";

            Supplier s2 = new Supplier(2);
            s2.CompanyName = "Company2";
            s2.City = "City2";
            s2.HomePage = "www.homPage2.pl";
            /***************************************/
            Category c1 = new Category(1);
            c1.Name = "CategoryName1";
            c1.Description = "Description1";

            Category c2 = new Category(2);
            c2.Name = "CategoryName2";
            c2.Description = "Description2";
            /***************************************/
            Product p1 = new Product(1);
            p1.Name = "Pieprz";
            p1.Supplier = s1;
            p1.Category = c1;
            p1.UnitPrice = 4.81m;

            Product p2 = new Product(2);
            p2.Name = "Kukurydza";
            p2.Supplier = s2;
            p2.Category = c2;
            p2.UnitPrice = 6.13m;
            /***************************************/
            Warehouse wh = new Warehouse();
            wh.AddProduct(p1, 1);
            wh.AddProduct(p2, 2);

            wh.UpdateProduct(p1, 4);

            Console.WriteLine("Warehouse amount: " + wh.GetAllAmount());

            wh.GestSpis();


            //zad.3
            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            //fact(10000);

            stopWatch.Stop();
            TimeSpan ts = stopWatch.Elapsed;

            string elapsedTime = String.Format("{0:00}:{1:00}:{2:00}.{3:00}",
            ts.Hours, ts.Minutes, ts.Seconds, ts.Milliseconds / 10);
            Console.WriteLine("RunTime " + elapsedTime);

            //zad.4
            //IDictionary<string, int> wordsCount = new SortedDictionary<string, int>();
            //try
            //{
            //    string[] wordsREG = Regex.Matches(File.ReadAllText("holmes.txt"), @"[A-Za-z\p{L}\d]{2,}")
            //                .Cast<Match>()
            //                .Select(m => m.Value.ToLower())
            //                .ToArray();

            //    foreach (var word in wordsREG)
            //    {
            //        int count = 1;
            //        if (wordsCount.ContainsKey(word))
            //        {
            //            count = wordsCount[word] + 1;
            //        }
            //        wordsCount[word] = count;
            //    };

            //    var items = from pair in wordsCount
            //                orderby pair.Value ascending
            //                select pair;
            //    Console.WriteLine("\n20 most common words:\n");
            //    foreach (var pair in items.TakeLast(20))
            //    {
            //        Console.WriteLine("{0} -> {1}", pair.Key, pair.Value);
            //    }
            //}
            //catch(Exception e)
            //{
            //    Console.WriteLine("Could not read the file");
            //}

            

            //try
            //{
            //    using (StreamReader sr = new StreamReader("holmes.txt"))
            //    {
            //        String line = sr.ReadToEnd();
            //        line = line.ToLower();
            //        string[] words = line.Split(" []()\n\t\v„”\':;-_.,?!*".ToCharArray(), StringSplitOptions.RemoveEmptyEntries);
            //        words = words.Where(val => val.Length > 2).ToArray();
            //    }
            //}
            //catch (Exception e)
            //{
            //    Console.WriteLine("The file could not be read:");
            //    Console.WriteLine(e.Message);
            //}

        }
    }
}
