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
public class Osoba {
    String imie;
    String nazwisko;
        
    Osoba(String _imie, String _nazwisko){
        imie = _imie;
        nazwisko = _nazwisko;
    }
    
    public String toString() {
        return "imie: " + this.imie + "\n" + "nazwisko: " + this.nazwisko;
    }
}
