package pl.poznan.put.cie.coffee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CoffeeMain {

	/**
	 * @param args the command line arguments
	 */
    
        private static void zad1() {
            System.out.println("Coffee");
		while (true) {
                    System.out.println("\n"
                                      + "Choose an action\n"
                                      + "(a) select coffee,\n"
                                      + "(b) list all,\n"
                                      + "(c) create new coffee,\n"
                                      + "(d) update coffee,\n"
                                      + "(e) delete coffee,\n"
                                      + "(any other key) exit.\n");

                    CoffeeDao dao = new CoffeeDao();
                    Scanner in = new Scanner(System.in);
                    switch (in.nextLine()) {
                        case "a": {
                            System.out.println("Please enter coffee name : ");
                            String name = in.nextLine();
                            System.out.println(dao.get(name));
                            break;
                        }
                        case "b": {
                            List<Coffee> coffeeList = dao.getAll();
                            for (Coffee c : coffeeList) {
                                    System.out.println(c.toString());
                            }
                            break;
                        }
                        case "c": {
                            System.out.print("Please enter coffee name : ");
                            String name = in.nextLine();
                            System.out.print("Please enter coffee supplier ID : ");
                            int supId = Integer.parseInt(in.nextLine());
                            System.out.print("Please enter coffee price: ");
                            BigDecimal price = new BigDecimal(in.nextLine());
                            System.out.print("Please enter coffee sales : ");
                            int sales = Integer.parseInt(in.nextLine());
                            System.out.print("Please enter coffee total : ");
                            int total = Integer.parseInt(in.nextLine());
                            dao.create(new Coffee(name, supId, price, sales, total));
                            break;
                        }
                        case "d": {
                            System.out.print("Please enter coffee name : ");
                            String name = in.nextLine();
                            System.out.print("Please enter coffee supplier ID : ");
                            int supId = Integer.parseInt(in.nextLine());
                            System.out.print("Please enter coffee price: ");
                            BigDecimal price = new BigDecimal(in.nextLine());
                            System.out.print("Please enter coffee sales : ");
                            int sales = Integer.parseInt(in.nextLine());
                            System.out.print("Please enter coffee total : ");
                            int total = Integer.parseInt(in.nextLine());
                            dao.update(new Coffee(name, supId, price, sales, total));
                            break;
                        }
                        case "e": {
                            System.out.print("Please enter coffee name : ");
                            String name = in.nextLine();
                            System.out.print("Please enter coffee suppplier ID : ");
                            int supId = Integer.parseInt(in.nextLine());
                            dao.delete(name, supId);
                            break;
                        }
                        default:
                            return;
                    }
		}
        }
        
        private static void zad2() {
            while (true) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("CoffeePU");
                EntityManager em = emf.createEntityManager();
                System.out.println("\n"
                                  + "Choose an action\n"
                                  + "(a) select coffee,\n"      // DONE  
//                                  + "(b) list all,\n"
                                  + "(c) create new coffee,\n"  // DONE
                                  + "(d) update coffee,\n"      // DONE
                                  + "(e) delete coffee,\n"      // DONE
                                  + "(any other key) exit.\n");

                CoffeeDao dao = new CoffeeDao();
                Scanner in = new Scanner(System.in);
                switch (in.nextLine()) {
                    case "a": {
                        em.getTransaction().begin();
                        //Coffees c1 = new Coffees();
                        System.out.println("Please enter coffee name : ");
                        
                        String name = in.nextLine();
                        //c1.getCofName();
                        Coffees c1 = em.find( Coffees.class, name);
                        //CoffeeDescriptions xd = new CoffeeDescriptions(name);
                        //System.out.println(c1.getCoffeeDescriptions());
                        System.out.println(c1);
//                        System.out.println(c1.getSupId());
//                        System.out.println(c1.getPrice());
//                        System.out.println(c1.getSales());
//                        System.out.println(c1.getTotal());
                        
                        em.getTransaction().commit();

                        em.close();
                        emf.close();
                        break;
                    }
//                    case "b": {
//                        List<Coffee> coffeeList = dao.getAll();
//                        for (Coffee c : coffeeList) {
//                                System.out.println(c.toString());
//                        }
//                        break;
//                    }
                    case "c": {
                        em.getTransaction().begin();
            
                        Coffees c1 = new Coffees();
                        
                        System.out.print("Please enter coffee name : ");
                        String name = in.nextLine();
                        c1.setCofName(name);
                        
                        System.out.print("Please enter coffee supplier ID : ");
                        int supId = Integer.parseInt(in.nextLine());
                        c1.setSupId(new Suppliers(supId));
                        
                        System.out.print("Please enter coffee price: ");
                        BigDecimal price = new BigDecimal(in.nextLine());
                        c1.setPrice(price);
                        
                        System.out.print("Please enter coffee sales : ");
                        int sales = Integer.parseInt(in.nextLine());
                        c1.setSales(sales);
                        
                        System.out.print("Please enter coffee total : ");
                        int total = Integer.parseInt(in.nextLine());
                        c1.setTotal(total);
                        
                        em.persist(c1);
                        em.getTransaction().commit();

                        em.close();
                        emf.close();
                        break;
                    }
                    case "d": {
                        em.getTransaction().begin();
                        
                        System.out.print("Please enter coffee name : ");
                        String name = in.nextLine();
                        
//                        System.out.print("Please enter coffee supplier ID : ");
//                        int supId = Integer.parseInt(in.nextLine());
//                        c1.setSupId(new Suppliers(supId));
                        
                        Coffees c1 = em.find( Coffees.class, name);
                        
                        System.out.print("Please enter coffee price: ");
                        BigDecimal price = new BigDecimal(in.nextLine());
                        c1.setPrice(price);

                        System.out.print("Please enter coffee sales : ");
                        int sales = Integer.parseInt(in.nextLine());
                        c1.setSales(sales);

                        System.out.print("Please enter coffee total : ");
                        int total = Integer.parseInt(in.nextLine());
                        c1.setTotal(total);

//                        em.persist(c1);
                        em.getTransaction().commit();

                        em.close();
                        emf.close();
                        break;
                    }
                    case "e": {    
                        em.getTransaction().begin();
                        
                        System.out.print("Please enter coffee name : ");
                        String name = in.nextLine();
                        
                        Coffees c1 = em.find( Coffees.class, name);
                        
//                        System.out.print("Please enter coffee supplier ID : ");
//                        int supId = Integer.parseInt(in.nextLine());
//                        c1.setSupId(new Suppliers(supId));
                        
                        em.remove(c1);
                        em.getTransaction().commit();

                        em.close();
                        emf.close();
                        break;
                    }
                    default:
                        return;
                }
            }
        }
        
	public static void main(String[] args) {
		//zad1();
                zad2();
	}

}
