




import java.sql.ResultSet;
import java.sql.SQLException;
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
public class MySQLCountryDAO implements CountryDAO {
    
     DataSource db = new DataSource();

    @Override
    public ArrayList<Country> getCountry() {
     ArrayList<Country> countries= new ArrayList<Country>();
        
        String query= "SELECT * FROM country ORDER BY Continent ASC";
        
        ResultSet rs= db.select(query);
        try{
       while(rs.next()){
       
           String code=rs.getString(1);
           String name=rs.getString(2);
           String continent=rs.getString(3);
           float surfaceArea=rs.getFloat(4);
           String HeadOfState=rs.getString(5);
           
           Country Country=null;
           
           
           
           Country= new Country(code, name, continent, surfaceArea, HeadOfState);
          
           countries.add(Country);
           
           
       }
        } catch (SQLException e) {
               e.printStackTrace();
        }
        
        
       return countries;  
    }

    @Override
    public Country findCountry(String countrycode) {
        
        
        String query= "SELECT * FROM country where id="+countrycode+";";
        ResultSet rs= db.select(query);
       
        String code="";
        String name="";
       String continent="";
       float surface=0;
       String head="";
        Country c=null;
        
        try {
            if(rs.next()){
                
                code=rs.getString(1);
                name=rs.getString(2);
                continent=rs.getString(3);
                surface=rs.getFloat(4);
                head=rs.getString(5);
                
                
                c = new Country(code,name,continent,surface,head);
                return c;
            }
            return null;
        } catch (SQLException e) {
              e.printStackTrace();
        }
        
        
       
        
        
       return null;
    }

    @Override
    public ArrayList<Country> getName(String name) {
       
        
        ArrayList<Country> samename= new ArrayList<Country>();
        
        String query= "SELECT * FROM country where Name="+name+";";
        ResultSet rs= db.select(query);
       
        String code="";
        String Name="";
       String continent="";
       float surface=0;
       String head="";
        Country c=null;
        
        try {
            if(rs.next()){
                
                code=rs.getString(1);
                Name=rs.getString(2);
                continent=rs.getString(3);
                surface=rs.getFloat(4);
                head=rs.getString(5);
                
                
                c = new Country(code,Name,continent,surface,head);
                samename.add(c);
                
                return samename;
            }
            return null;
        } catch (SQLException e) {
              e.printStackTrace();
        }
        
        
       
        
        
       return null;
    }

    @Override
    public boolean saveCountry(Country c) {
        
        //
           String Code=c.getCode();
           String Name=c.getName();
           String Continent=c.getContinent();
           Float SurfaceArea=c.getSurfaceArea();
           String HeadOfState=c.getHeadOfState();
           
           String query="Insert into country(Code,Name,Continent,SurfaceArea,HeadOfState) Values('"+Code+"'"
                   + ",'"+Name+"','"+Continent+"',"+SurfaceArea+",'"+HeadOfState+"')";
           
          return  db.save(query);  
    
    
    }
    
  
        
      
    
   
}
