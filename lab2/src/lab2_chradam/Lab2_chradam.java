/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_chradam;

/**
 *
 * @author s0163731
 */
public class Lab2_chradam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Firma firma = new Firma();
        firma.setPracownik("Adam", "Chrzanowski");
        firma.setPracownik("Łukasz", "Dawydzik");
        
        System.out.println(firma.getAmountPracownik());
       
        firma.getSpisPracownik();
    }
}


