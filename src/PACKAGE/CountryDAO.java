package PACKAGE;



//  interfaces

import PACKAGE.Country;
import java.util.ArrayList;
/**
 *
 * @author eduar
 */
public interface CountryDAO {
    
    
    public ArrayList<Country> getCountry();
    public Country findCountry(String Code);
    public ArrayList<Country> getName(String name);
    public boolean saveCountry(Country c);
    
}
