
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author eduar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         CountryDAO dao= new MySQLCountryDAO();
        
        ArrayList<Country> countries = dao.getCountry();
        System.out.println(countries);
      
        
        /*DAOcountryInterface ci= new countryDAOimplementation();
        
        ci.getCountry();*/
        
        
        //  System.out.println(CheckIfEmpty("String Required"));
        
        /*System.out.println(ci.getCountry());
        System.out.println(ci.findCountry("vj8"));*/
        
  
        
     
    }
    
    
    
}
