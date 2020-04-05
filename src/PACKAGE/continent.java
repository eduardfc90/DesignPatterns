/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACKAGE;

/**
 *
 * @author eduar
 */
public class continent {
    
    //enum requested for continent
    
     public enum continents {
         
        Africa("Africa"),
        Antarctica("Antarctica"),
        Asia("Asia"),
        Europe("Europe"),
        North_America("North America"),      
        Oceania("Oceania"),        
        SouthAmerica("South America");

        private final String Continent;

        continents(String Continent) {
            this.Continent = Continent;
        }
//// validation the enum
        public static continents fromString(String Continent) 
        {
            for (continents c : continents.values()) 
            {
                if (c.getContinent().equals(Continent)) {
                    return c;
                }
            }
            return Europe;
        }

        // Here we can  return the name of the continent
        
        
        public String getContinent() {
            return Continent;
        }
        
    
     }}
