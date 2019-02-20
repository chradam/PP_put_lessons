/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_chradam;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;

/**
 *
 * @author s0163731
 */
public class Firma {
 public ArrayList<Pracownik> spis;
    public Firma(){
        this.spis = new ArrayList<Pracownik>();
    }
    
    public void setPracownik(String _imie, String _nazwisko) {
        Pracownik p = new Pracownik(_imie, _nazwisko);
        spis.add(p);
    }
    
    public int getAmountPracownik() {
       return spis.size();
    }
    
    public void getSpisPracownik() {
        Iterator<Pracownik> it = spis.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    
    
}
