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
public class Pracownik extends Osoba{    

    public enum Stanowisko {
        DYREKTOR("Dyrektor", 1, "Szef"),
        KSIEGOWY("Księgowy", 2, "bbbb"),
        SEKRETARZ("Sekretarz", 3, "cccc");
        private final String nazwa;
        private final int hierarchia;
        private final String opis;
       
        private Stanowisko(String _nazwa, int _hierarchia, String _opis) {
            this.nazwa = _nazwa;
            this.hierarchia = _hierarchia;
            this.opis = _opis;
        }
        
        public String getFieldDescription() {
            Integer intInstance = new Integer(hierarchia);  
            String numberAsString = intInstance.toString();
            return "nazwa: " + this.nazwa + "\nhierarchia:" + this.hierarchia
                    + "\nopis" +  this.opis;
        }
    }
    
    float pensja;
    
    public Pracownik(String _name, String _surname, float _pensja) {
        super(_name, _surname);
        pensja = _pensja;
    }
   
}
